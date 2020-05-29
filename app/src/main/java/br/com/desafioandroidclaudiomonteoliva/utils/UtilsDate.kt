package br.com.desafioandroidclaudiomonteoliva.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object UtilsDate {
    private val locale: Locale = Locale("pt", "BR")

    /**
     * Metodo que retorna data do dispositivo conforme o formato passado
     *
     * @param ff
     * @return
     *
     * -----------------------------------------------------
     * [dma]   - DD/MM/AAAA
     * [dmah]  - DD/MM/AAAA HH:MM
     * [dmahs] - DD/MM/AAAA HH:MM:SS
     * [amdh]  - AAAA-MM-DD HH:MM:SS
     * [amd]   - AAAA-MM-DD
     * [time]   - AAAAMMDDHHMMSS
     */
    fun getDate(ff: String): String {
        val formato = when (ff) {
            "dma"   -> "dd/MM/yyyy"
            "dmah"  -> "dd/MM/yyyy HH:mm"
            "dmahs" -> "dd/MM/yyyy HH:mm:ss"
            "amdh"  -> "yyyy-MM-dd HH:mm:ss"
            "amd"   -> "yyyy-MM-dd"
            "time"  -> "yyyyMMddHHmmss"
            else    -> "yyyyMMddHHmmss"
        }
        val formatacao = SimpleDateFormat(formato, locale)
        val mCalendario = GregorianCalendar(locale)

        mCalendario.timeInMillis = System.currentTimeMillis()

        return formatacao.format(mCalendario.time)
    }

    fun getAddMinutes(minutes: Int): String {
        // seta a Formatacao
        val formatacao =
            SimpleDateFormat("dd/MM/yyyy HH:mm", locale)
        val mCalendario = GregorianCalendar(locale)
        mCalendario.timeInMillis = System.currentTimeMillis()
        mCalendario.add(Calendar.MINUTE, minutes)
        return formatacao.format(mCalendario.time)
    }

    /**
     * Metodo que retorna o formato de uma data
     * --------------------------------------------------------------
     * @param data (no formato YYYY-MM-DD HH:MM:SS)
     * @param ff (o formato)
     * [dma]      - DD/MM/AAAA
     * [amd]      - AAAAMMDD
     * [dmah]     - DD/MM/AAAA HH:MM
     * [dmahs]    - DD/MM/AAAA HHhMM:SS
     * [hms]      - HH:MM:SS
     * [hm]       - HH:MM
     * --------------------------------------------------------------
     * @return <String> return (a data com o formtado escolhido)
     * --------------------------------------------------------------
     */
     fun getDate(data: String, ff: String): String {
        val dataO =
            if (data.trim { it <= ' ' }.length > 10) "yyyy-MM-dd HH:mm:ss" else "yyyy-MM-dd"

        val dataH = when (ff) {
            "dma"   -> "dd/MM/yyyy"
            "amd"   -> "yyyyMMdd"
            "dmah"  -> "dd/MM/yyyy HH:mm"
            "dmahs" -> "dd/MM/yyyy HH:mm:ss"
            "hms"   -> "HH:mm:ss"
            "hm"    -> "HH:mm"
            else    -> "dd/MM/yyyy HH:mm"
            }

        val f0 = SimpleDateFormat(dataO, locale)
        val f1 = SimpleDateFormat(dataH, locale)
        try {
            val c = GregorianCalendar(locale)
            c.time = f0.parse(data)
            return f1.format(c.time)
        }
        catch (pe: ParseException) {
        }
        return ""
     }
}