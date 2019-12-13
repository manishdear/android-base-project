package com.mindorks.bootcamp.learndagger.ui.home.post

import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.mindorks.bootcamp.learndagger.R
import com.mindorks.bootcamp.learndagger.di.component.ViewHolderComponent
import com.mindorks.bootcamp.learndagger.ui.base.BaseItemViewHolder
import kotlinx.android.synthetic.main.item_view_post.view.*

class PostViewHolder(parent:ViewGroup
) : BaseItemViewHolder<Post, PostViewModel>(
        R.layout.item_view_post , parent
) {

    override fun setupView(view: View) {
        // later
    }

    override fun injectDependencies(viewHolderComponent: ViewHolderComponent) {
        viewHolderComponent.inject(this)
    }

    override fun setupObservers() {
        super.setupObservers()
        viewModel.data.observe(this, Observer {
            itemView.tv_message.text = it.text
        })

        itemView.setOnClickListener{
            showMessage("$adapterPosition clicked")
        }
    }
}