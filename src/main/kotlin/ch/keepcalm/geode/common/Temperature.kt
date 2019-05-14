package ch.keepcalm.geode.common

import org.springframework.data.annotation.Id
import org.springframework.data.gemfire.mapping.annotation.Region

@Region(value = "temps")
data class Temperature(@Id val id: java.lang.Long, val temparature: Double, val city: String)