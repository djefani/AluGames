package br.com.alura.alugames.main

import br.com.alura.alugames.services.consumoApi

fun main(){
    val consumo = consumoApi()
    val listaGamers = consumo.buscaGamers()
    val jogoApi = consumo.buscaJogo("151")
    //val listaJogosJson = consumo.buscaJogosJson()

    println(listaGamers)
}