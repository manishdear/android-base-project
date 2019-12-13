package com.mindorks.bootcamp.learndagger.di.module

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.ViewModelProviders
import com.mindorks.bootcamp.learndagger.data.local.DatabaseService
import com.mindorks.bootcamp.learndagger.data.remote.NetworkService
import com.mindorks.bootcamp.learndagger.di.ActivityContext
import com.mindorks.bootcamp.learndagger.di.ViewHolderScope
import com.mindorks.bootcamp.learndagger.ui.base.BaseFragment
import com.mindorks.bootcamp.learndagger.ui.base.BaseItemViewHolder
import com.mindorks.bootcamp.learndagger.ui.home.HomeViewModel
import com.mindorks.bootcamp.learndagger.ui.main.MainViewModel
import com.mindorks.bootcamp.learndagger.utils.NetworkHelper
import com.mindorks.bootcamp.learndagger.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class ViewHolderModule(private val viewHolder: BaseItemViewHolder<*,*>) {

    @Provides
    @ViewHolderScope
    fun provideLifecycleRegistry(): LifecycleRegistry =
            LifecycleRegistry(viewHolder)
}
