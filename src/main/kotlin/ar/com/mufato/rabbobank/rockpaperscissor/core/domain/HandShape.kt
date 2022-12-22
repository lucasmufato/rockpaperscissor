package ar.com.mufato.rabbobank.rockpaperscissor.core.domain

enum class HandShape {
    ROCK, PAPER, SCISSOR;

    fun contest(opponentShape: HandShape): ContestResult {
        if (this == opponentShape) return ContestResult.DRAW
        if (this == ROCK && opponentShape == SCISSOR) return ContestResult.WIN
        if (this == PAPER && opponentShape == ROCK) return ContestResult.WIN
        if (this == SCISSOR && opponentShape == PAPER) return ContestResult.WIN
        return ContestResult.LOSE
    }

}