package com.example.firstclassbnccacademy.data

object UtilityHelper {
    const val BASE_URL = "https://api.kawalcorona.com/"

    fun String.removeComma(): String = this.replace(",".toRegex(),"")

}