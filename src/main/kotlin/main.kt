fun main() {
    agoToText(7600)

}

fun agoToText(seconds: Int) {
    val minute = 60
    val hour = 60 * 60
    val day = 24 * 60 * 60
    val twoDays = 2 * day
    val threeDays = 3 * day

    when {
        seconds in 1..minute -> println("«был(а) только что»")

        seconds in (minute + 1)..hour -> {
            val minutesAgo = seconds / minute
            if (minutesAgo == 60) {
                println("«был(а) 1 час назад»")
            } else {
                println("«был(а) ${minutesAgo} ${correctFormatMinute(minutesAgo)} назад»")
            }
        }

        seconds in (hour + 1)..day -> {
            val hoursAgo = seconds / hour
            println("«был(а) ${hoursAgo} ${correctFormatHour(hoursAgo)} назад»")
        }

        seconds in (day + 1)..twoDays -> println("«был(а) вчера»")

        seconds in (twoDays + 1)..threeDays -> println("«был(а) позавчера»")
        else -> println("«был(а) давно»")
    }
}

fun correctFormatMinute(number: Int): String {
    return when {
        number % 10 == 1 && number != 11 -> "минуту"
        number % 10 in 2..4 && number !in 12..14 -> "минуты"
        else -> "минут"
    }
}

fun correctFormatHour(digit: Int): String {
    return when {
        digit % 10 == 1 && digit != 11 -> "час"
        digit % 10 in 2..4 && digit !in 12..14 -> "часа"
        else -> "часов"
    }
}