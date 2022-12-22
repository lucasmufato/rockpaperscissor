package ar.com.mufato.rabbobank.rockpaperscissor.core.services

import ar.com.mufato.rabbobank.rockpaperscissor.core.domain.HandShape

interface ComputerHandService{
    fun obtainRandomHand(): HandShape
}