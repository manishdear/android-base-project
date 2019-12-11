package com.mindorks.bootcamp.learndagger.di.module

import android.app.Activity
import android.content.Context
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.mindorks.bootcamp.learndagger.data.local.DatabaseService
import com.mindorks.bootcamp.learndagger.data.remote.NetworkService

import com.mindorks.bootcamp.learndagger.di.ActivityContext
import com.mindorks.bootcamp.learndagger.ui.base.BaseActivity
import com.mindorks.bootcamp.learndagger.ui.main.MainViewModel
import com.mindorks.bootcamp.learndagger.utils.NetworkHelper
import com.mindorks.bootcamp.learndagger.utils.ViewModelProviderFactory

import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class ActivityModule(private val activity: BaseActivity<*>) {

    @ActivityContext
    @Provides
    fun provideContext(): Context = activity

    @Provides
    fun provideMainViewModel(
            compositeDisposable: CompositeDisposable,
            networkHelper: NetworkHelper,
            databaseService: DatabaseService,
            networkService: NetworkService
    ): MainViewModel =
            ViewModelProviders.of(activity,
                    ViewModelProviderFactory(MainViewModel::class) {
                        MainViewModel(compositeDisposable,
                                networkHelper,
                                databaseService,
                                networkService
                        )
                    }).get(MainViewModel::class.java)
}

