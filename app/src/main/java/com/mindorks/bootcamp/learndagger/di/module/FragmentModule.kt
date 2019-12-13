package com.mindorks.bootcamp.learndagger.di.module

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.mindorks.bootcamp.learndagger.data.local.DatabaseService
import com.mindorks.bootcamp.learndagger.data.remote.NetworkService
import com.mindorks.bootcamp.learndagger.di.ActivityContext
import com.mindorks.bootcamp.learndagger.di.FragmentScope
import com.mindorks.bootcamp.learndagger.ui.base.BaseFragment
import com.mindorks.bootcamp.learndagger.ui.home.HomeViewModel
import com.mindorks.bootcamp.learndagger.ui.home.post.PostAdapter
import com.mindorks.bootcamp.learndagger.ui.main.MainViewModel
import com.mindorks.bootcamp.learndagger.utils.NetworkHelper
import com.mindorks.bootcamp.learndagger.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class FragmentModule(private val fragment: BaseFragment<*>) {

    @ActivityContext
    @Provides
    fun provideContext(): Context = fragment.context!!

    @Provides
    fun provideLinearLayoutManager() = LinearLayoutManager(fragment.context)

    @Provides
    @FragmentScope
    fun providePostAdapter() = PostAdapter(fragment.lifecycle, ArrayList())

    @Provides
    fun provideHomeViewModel(
            compositeDisposable: CompositeDisposable,
            networkHelper: NetworkHelper,
            databaseService: DatabaseService,
            networkService: NetworkService
    ): HomeViewModel =
            ViewModelProviders.of(fragment,
                    ViewModelProviderFactory(HomeViewModel::class){
                        HomeViewModel(compositeDisposable,
                                networkHelper,
                                databaseService,
                                networkService
                        )
                    }).get(HomeViewModel::class.java)



}
