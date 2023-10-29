package br.com.alura.alugames.models

import java.time.LocalDate
import java.time.Period

data class Period(
    val dataInicial: LocalDate,
    val dataFinal: LocalDate){
    val inDays: Int = Period.between(dataInicial, dataFinal).days
}
