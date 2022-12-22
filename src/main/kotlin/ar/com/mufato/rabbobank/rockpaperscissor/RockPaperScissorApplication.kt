package ar.com.mufato.rabbobank.rockpaperscissor

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@ComponentScan(excludeFilters = [ComponentScan.Filter(RestController::class)])
class RockPaperScissorApplication

fun main(args: Array<String>) {
	runApplication<RockPaperScissorApplication>(*args)
}
