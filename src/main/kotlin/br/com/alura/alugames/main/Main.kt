package br.com.alura.alugames.main

import br.com.alura.alugames.models.Gamer
import br.com.alura.alugames.models.Jogo
import br.com.alura.alugames.services.consumoApi
import tranformarEmIdade
import java.util.*

fun main() {
    val leitura = Scanner(System.`in`)
    val gamer = Gamer.createGamer(leitura)
    println("Cadastro concluído com sucesso. Dados do Gamer:")
    println(Gamer)
    println("Idade do Gamer: "+ gamer.dateBirth?.tranformarEmIdade())

    do {
        println("Digite um código de jogo para buscar:")
        val busca = leitura.nextLine()

        val buscaApi = consumoApi()
        val informacaoJogo = buscaApi.buscaJogo(busca)

        var meuJogo: Jogo? = null

        val resultadoBusca = runCatching {
            meuJogo = Jogo(
                informacaoJogo.info.title,
                informacaoJogo.info.thumb
            )
        }
        resultadoBusca.onFailure {
            println("Codigo Inválido. Tente outro id.")
        }

        resultadoBusca.onSuccess {
            println("Deseja inserir uma descrição? S/N")
            val opcao = leitura.nextLine()
            if (opcao.equals("s", true)) {
                println("Insira a descrição personalizada para o jogo:")
                val descricaoPersonalizada = leitura.nextLine()
                meuJogo?.descricao = descricaoPersonalizada
            } else {
                meuJogo?.descricao = meuJogo?.titulo

            }
            gamer.jogosBuscados.add(meuJogo)
        }
        println("Deseja buscar um novo jogo? S/N")
        val resposta = leitura.nextLine()

    } while (resposta.equals("s", true))

    println("Jogosbuscados:")
    println(gamer.jogosBuscados)
    println("\nJogos ordenados por titulo: ")
    gamer.jogosBuscados.sortBy {
        it?.titulo
    }
    gamer.jogosBuscados.forEach {
        println("Titulo: " + it?.titulo)
    }

    val filterGame = gamer.jogosBuscados.filter {
        it?.titulo?.contains("batman", true) ?: false
    }
    println("\nJogos filtrado:")
    println(filterGame)

    println("\nDeseja excluir algum jogo da lista original? S/N")
    val opcao = leitura.nextLine()
    if (opcao.equals("s", true)){
        println("\nInforme a posição do jogo que deseja exluir: ")
        val position = leitura.nextInt()
        gamer.jogosBuscados.removeAt(position)
    }

    println("\n Lista atualizada:")
    println(gamer.jogosBuscados)

    println("Busca finalizada com sucesso.")

}
