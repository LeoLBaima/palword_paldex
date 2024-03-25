package com.byteforge.paldex.home.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.byteforge.paldex.home.domain.model.Pal
import com.byteforge.paldex.home.domain.repository.PalRepository
import javax.inject.Inject
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

sealed class UIState {
    object Loading : UIState()
    data class Loaded(val pals: List<Pal>) : UIState()
    data class Error(val message: String) : UIState()
}

class HomeViewModel @Inject constructor(private val palRepository: PalRepository) : ViewModel() {

    val uiState: MutableLiveData<UIState> = MutableLiveData()
    private val compositeDisposable = CompositeDisposable()
    fun fetchPals() {
        uiState.value = UIState.Loading
        //Using RxJava to simulate a network call just to see the loading state
        val disposable = Observable.fromCallable { palRepository.getPals() }
            .delay(5, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { palList -> uiState.value = UIState.Loaded(palList) },
                { error -> uiState.value = UIState.Error(error.message ?: "Unknown error") }
            )
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}