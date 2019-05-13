package ch.keepcalm.common

import org.springframework.data.annotation.Id

data class Temperature(@Id val id: Long, val temparature: Double, val city: String)