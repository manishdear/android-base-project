package com.mindorks.bootcamp.learndagger.ui.main

import android.os.Bundle
import android.widget.TextView

import com.mindorks.bootcamp.learndagger.MyApplication
import com.mindorks.bootcamp.learndagger.R
import com.mindorks.bootcamp.learndagger.di.component.DaggerActivityComponent
import com.mindorks.bootcamp.learndagger.di.module.ActivityModule
import com.mindorks.bootcamp.learndagger.ui.home.HomeFragment

import javax.inject.Inject

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.mindorks.bootcamp.learndagger.di.component.ActivityComponent
import com.mindorks.bootcamp.learndagger.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainViewModel>() {


    override fun provideLayoutId(): Int = R.layout.activity_main

    override fun setupView(savedInstanceState: Bundle?) {
        addHomeFragment()
    }

    override fun setupObserver() {
        super.setupObserver()
        viewModel.data.observe(this, Observer {
            tv_message.text = it;
        })
    }

    override fun injectDependencies(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    private fun addHomeFragment() {
        if (supportFragmentManager.findFragmentByTag(HomeFragment.TAG) == null) {
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.container_fragment, HomeFragment.newInstance(), HomeFragment.TAG)
                    .commit()
        }
    }

}
