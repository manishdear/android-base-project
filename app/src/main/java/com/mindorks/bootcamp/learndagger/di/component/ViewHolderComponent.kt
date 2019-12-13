package com.mindorks.bootcamp.learndagger.di.component

import com.mindorks.bootcamp.learndagger.di.module.FragmentModule
import com.mindorks.bootcamp.learndagger.di.FragmentScope
import com.mindorks.bootcamp.learndagger.di.ViewHolderScope
import com.mindorks.bootcamp.learndagger.di.module.ViewHolderModule
import com.mindorks.bootcamp.learndagger.ui.home.HomeFragment
import com.mindorks.bootcamp.learndagger.ui.home.post.PostViewHolder

import dagger.Component

@ViewHolderScope
@Component(dependencies = [ApplicationComponent::class], modules = [ViewHolderModule::class])
interface ViewHolderComponent {

    fun inject(viewHolder: PostViewHolder)
}
