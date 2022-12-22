package ar.com.mufato.rabbobank.rockpaperscissor.config

import ar.com.mufato.rabbobank.rockpaperscissor.core.services.RandomComputerHandService
import ar.com.mufato.rabbobank.rockpaperscissor.core.actions.PlayHandAgainstComputer
import ar.com.mufato.rabbobank.rockpaperscissor.core.services.ComputerHandService
import ar.com.mufato.rabbobank.rockpaperscissor.delivery.rest.PlayHandAgainstComputerRest
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Suppress("unused") //used by spring
@Configuration
class Configuration {

    // ------------ Core   --------------
    @Bean
    fun computerHandServiceImpl(): ComputerHandService = RandomComputerHandService()

    @Bean
    fun playHandAgainstComputer(computerHandService: ComputerHandService): PlayHandAgainstComputer {
        return PlayHandAgainstComputer(
            computerHandService
        )
    }

    // ------------ Delivery   --------------
    @Bean
    fun playHandAgainstComputerRest(playHandAgainstComputer : PlayHandAgainstComputer): PlayHandAgainstComputerRest {
        return PlayHandAgainstComputerRest(playHandAgainstComputer)
    }

}