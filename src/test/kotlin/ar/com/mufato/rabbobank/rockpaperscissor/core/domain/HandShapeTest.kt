package ar.com.mufato.rabbobank.rockpaperscissor.core.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class HandShapeTest{

    @Test
    fun `ROCK beats SCISSORS`() {
        assertEquals(ContestResult.WIN, HandShape.ROCK.contest(HandShape.SCISSOR))
    }

    @Test
    fun `ROCK loses against PAPER`() {
        assertEquals(ContestResult.LOSE, HandShape.ROCK.contest(HandShape.PAPER))
    }

    @Test
    fun `ROCK draws ROCK`() {
        assertEquals(ContestResult.DRAW, HandShape.ROCK.contest(HandShape.ROCK))
    }

    @Test
    fun `PAPER beats ROCK`() {
        assertEquals(ContestResult.WIN, HandShape.PAPER.contest(HandShape.ROCK))
    }

    @Test
    fun `PAPER loses against SCISSOR`() {
        assertEquals(ContestResult.LOSE, HandShape.PAPER.contest(HandShape.SCISSOR))
    }

    @Test
    fun `PAPER draws PAPER`() {
        assertEquals(ContestResult.DRAW, HandShape.PAPER.contest(HandShape.PAPER))
    }

    @Test
    fun `SCISSOR beats PAPER`() {
        assertEquals(ContestResult.WIN, HandShape.SCISSOR.contest(HandShape.PAPER))
    }

    @Test
    fun `SCISSOR loses against ROCK`() {
        assertEquals(ContestResult.LOSE, HandShape.SCISSOR.contest(HandShape.ROCK))
    }

    @Test
    fun `SCISSOR draws SCISSOR`() {
        assertEquals(ContestResult.DRAW, HandShape.SCISSOR.contest(HandShape.SCISSOR))
    }

}