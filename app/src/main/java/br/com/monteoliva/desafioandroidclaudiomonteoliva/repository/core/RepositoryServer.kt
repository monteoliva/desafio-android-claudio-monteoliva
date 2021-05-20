package br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.core

import br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.api.ApiService
import br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.core.extensions.charactersWrapper
import br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.core.extensions.comicsWrapper
import br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.model.characters.Characters
import br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.model.hq.Comics

class RepositoryServer(private val apiService: ApiService) {

    fun getCharacters(callback: (Characters) -> Unit) {
        apiService.getCharacters().charactersWrapper { callback.invoke(it) }
    }

    fun getComics(characterId: Int, callback: (Comics) -> Unit) {
        apiService.getComics(characterId).comicsWrapper { callback.invoke(it) }
    }
}