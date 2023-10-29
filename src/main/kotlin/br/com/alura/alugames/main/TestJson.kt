package br.com.alura.alugames.main

import br.com.alura.alugames.services.ConsumoApi

fun main(){
    val consumo = ConsumoApi()
    val listaGamers = consumo.buscaGamers()
    val listaJogosJson = consumo.buscaJogosJson()

    //println(listaGamers)
    //prinln(listaJogoJson)

    val gamerCaroline = listaGamers.get(3)
    val jogoResidentVillage = listaJogosJson.get(10)

    println(gamerCaroline)
    println(jogoResidentVillage)

    val rent = gamerCaroline.rentGame(jogoResidentVillage)
    println(rent)
}