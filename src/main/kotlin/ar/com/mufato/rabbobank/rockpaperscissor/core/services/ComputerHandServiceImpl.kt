package ar.com.mufato.rabbobank.rockpaperscissor.core.services

import ar.com.mufato.rabbobank.rockpaperscissor.core.domain.HandShape

class ComputerHandServiceImpl: ComputerHandService {
    override fun obtainRandomHand(): HandShape {
        return HandShape.values().random()
    }
}