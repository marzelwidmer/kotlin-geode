package ch.keepcalm.geodserver.server

import ch.keepcalm.common.Temperature
import org.apache.geode.cache.asyncqueue.internal.AsyncEventQueueStats.type
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.SecurityProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.FilterType
import org.springframework.data.gemfire.config.annotation.CacheServerApplication

@SpringBootApplication
@CacheServerApplication(locators = "localhost[10334]")
@ComponentScan( basePackageClasses=[Temperature::class, ServerApplication::class])
class ServerApplication

fun main(args: Array<String>) {
    runApplication<ServerApplication>(*args)
}