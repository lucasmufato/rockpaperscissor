package ar.com.mufato.rabbobank.rockpaperscissor.core.domain

enum class HandShape {
    ROCK, PAPER, SCISSOR;
    fun contest(opponentShape: HandShape): ContestResult =
        if (this == opponentShape) ContestResult.DRAW
        else if (this == ROCK && opponentShape == SCISSOR) ContestResult.WIN
        else if (this == PAPER && opponentShape == ROCK) ContestResult.WIN
        else if (this == SCISSOR && opponentShape == PAPER) ContestResult.WIN
        else ContestResult.LOSE

}