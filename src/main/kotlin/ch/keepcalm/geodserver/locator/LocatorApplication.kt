package ch.keepcalm.geodserver.locator

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.data.gemfire.config.annotation.CacheServerApplication
import org.springframework.data.gemfire.config.annotation.EnableLocator
import org.springframework.data.gemfire.config.annotation.EnableManager

@CacheServerApplication(locators = "localhost[10334]")
@SpringBootApplication
class LocatorApplication

@Configuration
@EnableLocator
@EnableManager(start = true)
@Profile("!clustered")
internal class LonerConfiguration

fun main(args: Array<String>) {
    runApplication<LocatorApplication>(*args)
}