package br.com.desafioandroidclaudiomonteoliva.utils

import java.io.UnsupportedEncodingException
import java.security.MessageDigest

object Utils {
    fun authorization(): String {
        val timestamp: String = UtilsDate.getDate("time")
        val result: String    = timestamp + Constantes.privateKey + Constantes.publicKey

        return "?ts=$timestamp&apikey=${Constantes.publicKey}&hash=${result.md5()}"
    }

    private fun String.md5(): String? {
        try {
            val md = MessageDigest.getInstance("MD5")
            val array = md.digest(this.toByteArray())
            val sb = StringBuffer()
            for (i in array.indices) {
                sb.append(Integer.toHexString(array[i].toInt() and 0xFF or 0x100).substring(1, 3))
            }
            return sb.toString()
        }
        catch (e: java.security.NoSuchAlgorithmException) {}
        catch (ex: UnsupportedEncodingException) {}
        return null
    }
}