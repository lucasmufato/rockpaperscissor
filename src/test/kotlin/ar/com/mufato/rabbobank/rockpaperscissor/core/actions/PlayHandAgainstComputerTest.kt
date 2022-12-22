package ar.com.mufato.rabbobank.rockpaperscissor.core.actions

import ar.com.mufato.rabbobank.rockpaperscissor.core.domain.ContestResult
import ar.com.mufato.rabbobank.rockpaperscissor.core.domain.GameResult
import ar.com.mufato.rabbobank.rockpaperscissor.core.domain.HandShape
import ar.com.mufato.rabbobank.rockpaperscissor.core.services.ComputerHandService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever


class PlayHandAgainstComputerTest{
    private lateinit var result: GameResult
    private val computerHandService: ComputerHandService = mock()
    private val playHandAgainstComputer = PlayHandAgainstComputer(computerHandService)

    @Test
    fun `Returns the result of a game against the computer`() {
        givenAComputerHandReturning(HandShape.ROCK)

        whenUserPlaysWith(HandShape.PAPER)

        thenResultIsThatPlayer(GameResult(ContestResult.WIN, HandShape.ROCK))
    }

    private fun givenAComputerHandReturning(handShape: HandShape) {
        whenever(computerHandService.obtainRandomHand()).thenReturn(handShape)
    }

    private fun whenUserPlaysWith(handShape: HandShape) {
        result = playHandAgainstComputer(handShape)
    }

    private fun thenResultIsThatPlayer(expectedResult: GameResult) {
        Assertions.assertEquals(expectedResult, result)
    }
}