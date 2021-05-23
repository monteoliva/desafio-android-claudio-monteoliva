package br.com.monteoliva.desafioandroidclaudiomonteoliva.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.core.RepositoryServer
import br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.model.characters.Characters

class MainViewModel(private val repository: RepositoryServer) : ViewModel() {
    var listResult: MutableLiveData<Characters> = MutableLiveData()

    fun getRepository() {
        repository.getCharacters { listResult.postValue(it) }
    }
}