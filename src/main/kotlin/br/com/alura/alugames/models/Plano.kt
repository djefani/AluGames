package br.com.alura.alugames.models

abstract class Plano(val tipo:String) {
    open fun obterValor(rent: Rent): Double {
        return rent.jogo.preco * rent.period.inDays
    }
}