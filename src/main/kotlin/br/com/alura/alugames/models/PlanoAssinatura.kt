package br.com.alura.alugames.models

class PlanoAssinatura(
    tipo: String,
    val mensalidade: Double,
    val jogosIncluidos: Int,
    val percentualDescontoReputacao: Double,
) : Plano(tipo) {
    override fun obterValor(rent: Rent): Double {
        val totalJogosMes = rent.gamer.jogosDoMes(rent.period.dataInicial.monthValue).size+1

        return if (totalJogosMes <= jogosIncluidos){
            0.0
        }else {
            var valorOriginal = super.obterValor(rent)

            if(rent.gamer.media > 8) {
                valorOriginal -= valorOriginal * percentualDescontoReputacao
            }
            return valorOriginal
        }
    }
}
