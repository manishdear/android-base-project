package com.mindorks.bootcamp.learndagger.ui.home

import androidx.lifecycle.MutableLiveData
import com.mindorks.bootcamp.learndagger.data.local.DatabaseService
import com.mindorks.bootcamp.learndagger.data.remote.NetworkService
import com.mindorks.bootcamp.learndagger.di.FragmentScope
import com.mindorks.bootcamp.learndagger.ui.base.BaseViewModel
import com.mindorks.bootcamp.learndagger.ui.home.post.Post
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

    val data = MutableLiveData<List<Post>>()

    override fun onCreate(){
        data.postValue(listOf(
                Post("test 1"),
                Post("test 2"),
                Post("test 3"),
                Post("test 4"),
                Post("test 5"),
                Post("test 6"),
                Post("test 7"),
                Post("test 8"),
                Post("test 9"),
                Post("test 10"),
                Post("test 11"),
                Post("test 12"),
                Post("test 13"),
                Post("test 14"),
                Post("test 15"),
                Post("test 16"),
                Post("test 17"),
                Post("test 18"),
                Post("test 19"),
                Post("test 20"),
                Post("test 21")
        ))
    }
}
