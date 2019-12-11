package com.mindorks.bootcamp.learndagger.ui.home

import androidx.lifecycle.MutableLiveData
import com.mindorks.bootcamp.learndagger.data.local.DatabaseService
import com.mindorks.bootcamp.learndagger.data.remote.NetworkService
import com.mindorks.bootcamp.learndagger.di.FragmentScope
import com.mindorks.bootcamp.learndagger.ui.base.BaseViewModel
import com.mindorks.bootcamp.learndagger.utils.NetworkHelper
import io.reactivex.disposables.CompositeDisposable

import javax.inject.Inject

@FragmentScope
class HomeViewModel (
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        private val databaseService: DatabaseService,
        private val networkService: NetworkService
        ) :
        BaseViewModel(compositeDisposable, networkHelper){

    val data = MutableLiveData<String>()

    override fun onCreate(){
        data.postValue("HomeViewModel")
    }
}
