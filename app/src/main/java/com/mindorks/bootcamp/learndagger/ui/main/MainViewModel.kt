package com.mindorks.bootcamp.learndagger.ui.main

import androidx.lifecycle.MutableLiveData
import com.mindorks.bootcamp.learndagger.data.local.DatabaseService
import com.mindorks.bootcamp.learndagger.data.remote.NetworkService
import com.mindorks.bootcamp.learndagger.di.ActivityScope
import com.mindorks.bootcamp.learndagger.ui.base.BaseViewModel
import com.mindorks.bootcamp.learndagger.utils.NetworkHelper
import io.reactivex.disposables.CompositeDisposable

import javax.inject.Inject


class MainViewModel(
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        private val databaseService: DatabaseService,
        private val networkService: NetworkService) :
        BaseViewModel(compositeDisposable, networkHelper){

    val data = MutableLiveData<String>()

    override fun onCreate() {
        data.postValue("MainViewModel")

        if(! checkNetworkConnection())  messageString.postValue("No Internet Connection")

    }
}
