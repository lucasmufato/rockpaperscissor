package ar.com.mufato.rabbobank.rockpaperscissor.config

import ar.com.mufato.rabbobank.rockpaperscissor.core.services.ComputerHandServiceImpl
import ar.com.mufato.rabbobank.rockpaperscissor.core.actions.PlayHandAgainstComputer
import ar.com.mufato.rabbobank.rockpaperscissor.core.services.ComputerHandService
import ar.com.mufato.rabbobank.rockpaperscissor.delivery.rest.PlayHandAgainstComputerRest
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Configuration {

    // ------------ Core   --------------
    @Bean
    public fun computerHandServiceImpl(): ComputerHandService = ComputerHandServiceImpl()

    @Bean
    public fun playHandAgainstComputer(computerHandService: ComputerHandService): PlayHandAgainstComputer {
        return PlayHandAgainstComputer(
            computerHandService
        )
    }


    // ------------ Delivery   --------------
    @Bean
    public fun playHandAgainstComputerRest(playHandAgainstComputer : PlayHandAgainstComputer): PlayHandAgainstComputerRest {
        return PlayHandAgainstComputerRest(playHandAgainstComputer)
    }

}