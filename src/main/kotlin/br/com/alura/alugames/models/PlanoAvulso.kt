package br.com.alura.alugames.models

class PlanoAvulso(
    tipo: String):Plano(tipo){

    override fun obterValor(rent: Rent): Double {
        var valorOriginal = super.obterValor(rent)
        if(rent.gamer.media > 8) {
            valorOriginal -= valorOriginal * 0.1

        }
        return valorOriginal
    }

}
