package com.mindorks.bootcamp.learndagger.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.mindorks.bootcamp.learndagger.MyApplication
import com.mindorks.bootcamp.learndagger.R
import com.mindorks.bootcamp.learndagger.di.component.DaggerFragmentComponent
import com.mindorks.bootcamp.learndagger.di.component.FragmentComponent
import com.mindorks.bootcamp.learndagger.di.module.FragmentModule
import com.mindorks.bootcamp.learndagger.ui.base.BaseFragment
import com.mindorks.bootcamp.learndagger.ui.home.post.PostAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

class HomeFragment : BaseFragment<HomeViewModel>() {

    companion object {

        val TAG = "HomeFragment"

        fun newInstance(): HomeFragment {
            val args = Bundle()
            val fragment = HomeFragment()
            fragment.arguments = args
            return fragment
        }
    }

    @Inject
    lateinit var linearLayoutManager: LinearLayoutManager

    @Inject
    lateinit var postAdapter: PostAdapter


    override fun provideLayoutId(): Int = R.layout.fragment_home

//    override fun setupView(view: View) {
//        rv_posts.apply{
//            adapter = postAdapter
//            layoutManger = linearLayoutManger
//        }
//    }

    override fun injectDependencies(fragmentComponent: FragmentComponent) = fragmentComponent.inject(this)

    override fun setupView(view: View) {
        rv_post.apply {
            adapter = postAdapter
            layoutManager = linearLayoutManager
        }
    }


    override fun setupObservers() {
        super.setupObservers()
        viewModel.data.observe(this, Observer {
            postAdapter.appendData(it)
        })
    }

}

