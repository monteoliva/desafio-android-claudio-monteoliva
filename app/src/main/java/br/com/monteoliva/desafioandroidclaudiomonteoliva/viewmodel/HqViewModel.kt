package br.com.monteoliva.desafioandroidclaudiomonteoliva.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.core.RepositoryServer
import br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.model.hq.Comics

class HqViewModel(private val repository: RepositoryServer) : ViewModel() {
    var comicsResult: MutableLiveData<Comics> = MutableLiveData()

    fun getRepository(characterId: Int) {
        repository.getComics(characterId) { comicsResult.postValue(it) }
    }
}