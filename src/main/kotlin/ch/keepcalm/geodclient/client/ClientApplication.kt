package ch.keepcalm.geodclient.client

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.gemfire.config.annotation.CacheServerApplication

@CacheServerApplication(locators = "localhost[10334]")
@SpringBootApplication
class ClientApplication

fun main(args: Array<String>) {
    runApplication<ClientApplication>(*args)
}