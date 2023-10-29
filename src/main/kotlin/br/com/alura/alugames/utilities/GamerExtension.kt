package br.com.alura.alugames.utilities
import br.com.alura.alugames.models.Gamer
import br.com.alura.alugames.models.InfoGamerJson

fun InfoGamerJson.criarGamer(): Gamer {
    return Gamer(
        this.nome,
        this.email,
        this.dataNascimento,
        this.usuario
    )
}