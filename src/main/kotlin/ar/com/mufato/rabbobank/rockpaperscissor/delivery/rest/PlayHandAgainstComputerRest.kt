package ar.com.mufato.rabbobank.rockpaperscissor.delivery.rest

import ar.com.mufato.rabbobank.rockpaperscissor.core.actions.PlayHandAgainstComputer
import ar.com.mufato.rabbobank.rockpaperscissor.core.domain.GameResult
import ar.com.mufato.rabbobank.rockpaperscissor.core.domain.HandShape
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class PlayHandAgainstComputerRest(private val playHand: PlayHandAgainstComputer) {

    @CrossOrigin
    @PostMapping("computer/play-hand")
    fun playHandPost(@RequestBody handJson: HandJson?): ResponseEntity<Any> {
        val playerShape = getHandShape(handJson) ?: return badRequest()

        val result = this.playHand(playerShape)
        return ResponseEntity.ok(GameResultJson(result))
    }

    private fun badRequest(): ResponseEntity<Any> =
        ResponseEntity.status(400).body("invalid hand shape")

    private fun getHandShape(handJson: HandJson?): HandShape?{
        if (handJson == null) return null
        if (handJson.handShape == null) return null
        var handShape: HandShape? =null
        kotlin.runCatching { handShape = HandShape.valueOf(handJson.handShape.trim().uppercase()) }
        return handShape
    }

}

data class HandJson(@JsonProperty("hand_shape") val handShape: String?)

data class GameResultJson(
    val result: String,
    @JsonProperty("opposing_hand") val opposingHand: String
) {
    constructor(result: GameResult) : this(result.contestResult.name, result.handShape.name)
}
