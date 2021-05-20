package br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.core.extensions

import java.text.ParseException
import java.text.SimpleDateFormat
import java.text.DecimalFormat
import java.util.*
import android.view.View

fun View.visible()   { this.visibility = View.VISIBLE   }
fun View.invisible() { this.visibility = View.INVISIBLE }
fun View.gone()      { this.visibility = View.GONE      }

fun View.visibility(show: Boolean) {
    if (show) { this.visible() } else { this.gone() }
}

fun View.isVisible():   Boolean = this.visibility == View.VISIBLE
fun View.isInvisible(): Boolean = this.visibility == View.INVISIBLE
fun View.isGone():      Boolean = this.visibility == View.GONE

fun String.getDate(ff: String) : String {
    val dataO  = if (this.trim().length > 10) "yyyy-MM-dd HH:mm:ss" else "yyyy-MM-dd"
    val dataH  = when(ff) {
        "ext"   -> "MMMM dd',' yyyy 'às' HH:mm"
        "dma"   -> "dd/MM/yyyy"
        "amd"   -> "yyyyMMdd"
        "dmah"  -> "dd/MM/yyyy HH:mm"
        "dmahs" -> "dd/MM/yyyy HH:mm:ss"
        "hms"   -> "HH:mm:ss"
        "hm"    -> "HH:mm"
        else    -> "dd/MM/yyyy"
    }

    val f0 = SimpleDateFormat(dataO, Locale.getDefault())
    val f1 = SimpleDateFormat(dataH, Locale.getDefault())

    try {
        val c = GregorianCalendar(Locale.getDefault())
        f0.parse(this)?.let { c.time = it }
        return f1.format(c.time)
    }
    catch (pe: ParseException) {}

    return ""
}

fun Long?.formatNumber() : String = DecimalFormat("###,##0").format(this)
