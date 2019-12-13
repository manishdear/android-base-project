package com.mindorks.bootcamp.learndagger.ui.base

import androidx.lifecycle.MutableLiveData
import com.mindorks.bootcamp.learndagger.utils.NetworkHelper
import io.reactivex.disposables.CompositeDisposable

abstract class BaseItemViewModel<T: Any>(
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper
) : BaseViewModel(compositeDisposable, networkHelper) {

    val data =  MutableLiveData<T>()

    fun onManualCleared() = onCleared()

    fun updateData(data: T){
        this.data.postValue(data)
    }

}