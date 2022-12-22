package ar.com.mufato.rabbobank.rockpaperscissor.core.actions

import ar.com.mufato.rabbobank.rockpaperscissor.core.domain.HandShape
import ar.com.mufato.rabbobank.rockpaperscissor.core.domain.GameResult
import ar.com.mufato.rabbobank.rockpaperscissor.core.services.ComputerHandService

class PlayHandAgainstComputer(
    private val computerHandService: ComputerHandService
) {
    operator fun invoke(playerShape: HandShape): GameResult {
        val computerShape = computerHandService.obtainRandomHand()
        return GameResult(playerShape.contest(computerShape), computerShape)
    }
}

