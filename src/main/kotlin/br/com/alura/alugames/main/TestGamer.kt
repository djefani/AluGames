import br.com.alura.alugames.models.Gamer

fun main() {
    val gamer1 = Gamer(
        "Djéfani",
        "djefani.eveeleen@gmail.com")

    val gamer2 = Gamer(
        "Idzy",
        "idzyemily@gmail.com",
        "26/05/2002",
        "idzyemily")

    println(gamer2)

    gamer1.let {
        it.dateBirth = "01/08/1992"
        it.user = "djefani"
    }.also {
        println(gamer1)
    }

    println(gamer1)
    gamer1.user= "djefani"
    println(gamer1)



}