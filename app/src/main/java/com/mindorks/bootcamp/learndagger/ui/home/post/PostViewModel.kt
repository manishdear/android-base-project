package com.mindorks.bootcamp.learndagger.ui.home.post

import com.mindorks.bootcamp.learndagger.data.local.DatabaseService
import com.mindorks.bootcamp.learndagger.data.remote.NetworkService
import com.mindorks.bootcamp.learndagger.ui.base.BaseItemViewModel
import com.mindorks.bootcamp.learndagger.utils.NetworkHelper
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class PostViewModel @Inject constructor(
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        private val databaseService: DatabaseService,
        private val networkService: NetworkService
) : BaseItemViewModel<Post>(compositeDisposable, networkHelper) {

    override fun onCreate() {

    }
}