package br.com.alura.alugames.models

data class Rent(
    val gamer: Gamer,
    val jogo: Jogo) {

    override fun toString(): String {
        return "Aluguel do ${jogo.titulo} por ${gamer.name}"
    }
}
