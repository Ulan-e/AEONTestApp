package com.ulanapp.aeon.utils

import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

// удаление повторяющихся слов в предложении
fun String.removeDuplicates() : String{
    val words: List<String> = this.split("\\s+".toRegex())
    val setOfWords: LinkedHashSet<String> = LinkedHashSet<String>(words)

    val result = StringBuilder()
    val index = 0

    for (s in setOfWords) {
        if (index > 0) result.append(" ")
        result.append("$s ")
        index.inc()
    }

    return result.toString()
}

// конвертация суммы в десятичный формат
fun Double.convertAmountToDecimalFormat() : String{
    val decimalFormat = DecimalFormat("###.#")
    return decimalFormat.format(this)
}

// проверка не пуста ли валюта
fun String?.checkCurrency() : String {
    return if (this == "" || this == null) {
        "(Unknown currency)"
    } else {
        this
    }
}

// вставка время когда операция была выполнена
fun Long.setCreatedTime(): String {
    return if (this == 0L) {
        " - - - - - - "
    } else {
        this.convertLongToTime()
    }
}

// конвертируем Long в время
private fun Long.convertLongToTime(): String {
    val date = Date(this)
    val timeFormat = SimpleDateFormat("yyyy.MM.dd HH:mm")
    return timeFormat.format(date)
}