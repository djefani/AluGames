package br.com.alura.alugames.utilities
import br.com.alura.alugames.models.InfoJogoJson
import br.com.alura.alugames.models.Jogo

fun InfoJogoJson.criaJogo(): Jogo {
    return Jogo(this.titulo, this.capa, this.preco, this.descricao)
}