package br.com.alura.alugames.models

import com.google.gson.annotations.Expose

data class Jogo(@Expose val titulo:String,
                @Expose val capa:String): Recomendavel {
    var descricao:String? = null
    var preco = 0.0
    private val listaNotas = mutableListOf<Int>()

    override val media: Double
        get() = listaNotas.average()

    override fun recomendar(nota: Int) {
        listaNotas.add(nota)
    }
    constructor(titulo: String, capa: String, preco: Double, descricao: String): this(titulo, capa){
        this.preco = preco
        this.descricao = descricao

    }



    override fun toString(): String {
        return "Meu br.com.alura.alugames.modelo.Jogo: \n" +
                "Titulo: $titulo \n" +
                "Capa: $capa \n" +
                "Descricao: $descricao \n" +
                "Preço: R$${String.format("%.2f",preco)} \n" +
                "Reputação: ${String.format("%.2f",media).replace(",", ".")}"

                }

}