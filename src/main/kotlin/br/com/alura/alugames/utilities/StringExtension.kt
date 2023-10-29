import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

fun String.tranformarEmIdade(): Int {
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    var idade = 0
    val calcDateBirth = LocalDate.parse(this, formatter)
    val today = LocalDate.now()
    idade = Period.between(calcDateBirth, today).years

    return idade
}