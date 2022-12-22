package ar.com.mufato.rabbobank.rockpaperscissor.core.services

import ar.com.mufato.rabbobank.rockpaperscissor.core.domain.HandShape

class RandomComputerHandService: ComputerHandService {
    override fun obtainHand(): HandShape {
        return HandShape.values().random()
    }
}