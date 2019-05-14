package ch.keepcalm.geode.server

import ch.keepcalm.geode.common.Temperature
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Profile
import org.springframework.data.gemfire.config.annotation.CacheServerApplication

@SpringBootApplication
@CacheServerApplication(locators = "localhost[10334]")
@ComponentScan( basePackageClasses=[Temperature::class, ServerApplication::class])
@Profile(value = ["server"])
class ServerApplication

fun main(args: Array<String>) {
    runApplication<ServerApplication>(*args)
}