package ch.keepcalm.geode.client

import ch.keepcalm.geode.common.Temperature
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationListener
import org.springframework.context.annotation.Profile
import org.springframework.data.gemfire.config.annotation.EnableClusterConfiguration
import org.springframework.data.gemfire.config.annotation.EnableEntityDefinedRegions
import org.springframework.data.repository.CrudRepository

@EnableClusterConfiguration
@EnableEntityDefinedRegions(basePackageClasses = [Temperature::class])
@SpringBootApplication
@Profile(value = ["client"])
class ClientApplication

fun main(args: Array<String>) {
    runApplication<ClientApplication>(*args)
}

interface TemperatureRepository: CrudRepository<Temperature, Long>

class Runner(private val temperatureRepository: TemperatureRepository) : ApplicationListener<ApplicationReadyEvent> {
    override fun onApplicationEvent(p0: ApplicationReadyEvent) {
        this.temperatureRepository.findAll().forEach(this.temperatureRepository::delete)
    }
}