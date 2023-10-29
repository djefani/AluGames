package br.com.alura.alugames.main

import br.com.alura.alugames.models.Period
import br.com.alura.alugames.models.PlanoAssinatura
import br.com.alura.alugames.services.ConsumoApi
import java.time.LocalDate

fun main(){
    val consumo = ConsumoApi()
    val listaGamers = consumo.buscaGamers()
    val listaJogosJson = consumo.buscaJogosJson()

    //println(listaGamers)
    //prinln(listaJogoJson)

    val gamerCaroline = listaGamers.get(3)
    val jogoResidentVillage = listaJogosJson.get(10)
    val jogoSpider = listaJogosJson.get(13)
    val jogoLastofUs = listaJogosJson.get(2)

//    println(gamerCaroline)
//    println(jogoResidentVillage)

    val period = Period(LocalDate.now(), LocalDate.now().plusDays(7))
    val period2 = Period(LocalDate.now(), LocalDate.now().plusDays(10))
    val period3 = Period(LocalDate.now(), LocalDate.now().plusDays(15))

    gamerCaroline.rentGame(jogoResidentVillage, period)
    gamerCaroline.rentGame(jogoSpider, period2)
    gamerCaroline.rentGame(jogoLastofUs, period3)

    println(gamerCaroline.jogosAlugados)

    val gamerCamila = listaGamers.get(5)
    gamerCamila.plano = PlanoAssinatura("PRATA", 9.90, 3)

    gamerCamila.rentGame(jogoResidentVillage, period)
    gamerCamila.rentGame(jogoSpider, period2)
    gamerCamila.rentGame(jogoLastofUs, period3)

    println(gamerCamila.jogosAlugados)
 }