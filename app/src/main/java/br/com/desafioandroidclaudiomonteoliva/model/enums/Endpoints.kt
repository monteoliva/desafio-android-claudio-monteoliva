package br.com.desafioandroidclaudiomonteoliva.model.enums

enum class Endpoints(private val endpoint: String) {
    LIST_CHARACTERS("/v1/public/characters"),
    HQ_CHARACTERS("/v1/public/characters/{0}/comics");

    fun endpoint(): String = endpoint
}