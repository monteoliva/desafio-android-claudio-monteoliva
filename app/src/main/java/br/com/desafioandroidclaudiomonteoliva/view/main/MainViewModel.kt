package br.com.desafioandroidclaudiomonteoliva.view.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import br.com.desafioandroidclaudiomonteoliva.model.contracts.character.Result

class MainViewModel : ViewModel() {
    val characters: MutableLiveData<MutableList<Result>> = MutableLiveData()

    fun setList(list: MutableList<Result>?) {
        if (characters.value == null) {
            characters.postValue(list)
        }
    }

    val list: MutableList<Result>? get() = characters.value
}