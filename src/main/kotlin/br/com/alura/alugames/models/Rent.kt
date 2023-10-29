package br.com.alura.alugames.models

import java.text.DecimalFormat

data class Rent(
    val gamer: Gamer,
    val jogo: Jogo,
    val period: Period) {
    val rentPrice: Double = gamer.plano.obterValor(this)

    override fun toString(): String {
        return "Aluguel do ${jogo.titulo} por ${gamer.name} " +
                "no valor de ${String.format("%.2f",rentPrice).replace(".", ",")}"
    }
}
