package br.com.alura.alugames.models

data class InfoJogo(val info: InfoApiShark) {
    override fun toString(): String {
        return info.toString()
    }

}