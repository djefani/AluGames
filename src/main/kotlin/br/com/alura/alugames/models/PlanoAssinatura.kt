package br.com.alura.alugames.models

class PlanoAssinatura(
    tipo: String,
    val mensalidade: Double,
    val jogosIncluidos: Int,
) : Plano(tipo) {
    override fun obterValor(rent: Rent): Double {
        val totalJogosMes = rent.gamer.jogosDoMes(rent.period.dataInicial.monthValue).size+1

        return if (totalJogosMes <= jogosIncluidos){
            0.0
        }else {
            super.obterValor(rent)
        }
    }
}
