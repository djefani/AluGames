package br.com.alura.alugames.models

import java.util.*
import kotlin.random.Random

data class Gamer(var name:String, var email:String): Recomendavel {
    var dateBirth: String? = null
    var user: String? = null
        set(value) {
            field = value
            if(userId.isNullOrBlank()) {
                createUserId()
            }
        }
    var userId: String? = null
        private set
    var plano: Plano = PlanoAvulso ("BRONZE")
    val jogosBuscados = mutableListOf<Jogo?>()
    val jogosAlugados = mutableListOf<Rent>()
    private val listaNotas = mutableListOf<Int>()
    val jogosRecomendados = mutableListOf<Jogo>()

    override val media: Double
        get() = listaNotas.average()

    override fun recomendar(nota: Int) {
        listaNotas.add(nota)
    }

    fun recomendarJogo(jogo: Jogo, nota: Int) {
        jogo.recomendar(nota)
        jogosRecomendados.add(jogo)
    }

    constructor(name: String, email: String, dateBirth: String, user: String) :
            this(name, email) {
                this.dateBirth = dateBirth
                this.user = user
                createUserId()
    }
    init {
        if(name.isNullOrBlank()){
            throw IllegalArgumentException("Nome está em branco.")
        }
        this.email = emailValidate()
    }

    override fun toString(): String {
        return "Gamer:\n" +
                "name=$name\n " +
                "email=$email\n " +
                "dateBirth=$dateBirth\n " +
                "user=$user\n " +
                "userId=$userId\n" +
                "Reputação: ${String.format("%.2f",media)}"
    }

    fun createUserId() {
        val numero = Random.nextInt(10000)
        val tag = String.format("%04d", numero)

        userId = "$user#$tag"
    }

    fun emailValidate():String {
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if(regex.matches(email)) {
            return email
        }else {
            throw IllegalArgumentException("Email inválido.")
        }

    }

    fun rentGame(jogo: Jogo, period: Period): Rent {
        val rent = Rent(this, jogo, period)
        jogosAlugados.add(rent)

        return rent
    }

    fun jogosDoMes(mes:Int): List<Jogo> {
        return jogosAlugados
            .filter { aluguel ->  aluguel.period.dataInicial.monthValue == mes}
            .map { aluguel ->  aluguel.jogo}
    }

    companion object{
        fun createGamer(leitura: Scanner): Gamer {
            println("Boas vindas ao AluGames! Vamos fazer seu cadastro. Digite seu nome:")
            val name = leitura.nextLine()
            println("Digite seu e-mail:")
            val email = leitura.nextLine()
            println("Deseja completar seu cadastro com usuário e data de nascimento? (S/N)")
            val opcao = leitura.nextLine()

            if (opcao.equals("s", true)) {
                println("Digite sua data de nascimento(DD/MM/AAAA):")
                val dateBirth = leitura.nextLine()
                println("Digite seu nome de usuário:")
                val user = leitura.nextLine()

                return Gamer(name, email, dateBirth,user)
            }else {
                return Gamer (name, email)
            }
        }

    }

}
