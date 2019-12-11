package com.mindorks.bootcamp.learndagger.ui.base

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.mindorks.bootcamp.learndagger.MyApplication
import com.mindorks.bootcamp.learndagger.di.component.ActivityComponent
import com.mindorks.bootcamp.learndagger.di.component.DaggerActivityComponent
import com.mindorks.bootcamp.learndagger.di.module.ActivityModule
import javax.inject.Inject

abstract class BaseActivity<VM : BaseViewModel> : AppCompatActivity() {

    @Inject
    lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies(buildActivityComponent())
        super.onCreate(savedInstanceState)
        setContentView(provideLayoutId())
        viewModel.onCreate()
        setupObserver()
        setupView(savedInstanceState)
    }

    protected open fun setupObserver(){
            viewModel.messageStringId.observe(this, Observer {
                showMessage(it)
            })

        viewModel.messageString.observe(this, Observer {
            showMessage(it)
        })
    }

    private fun buildActivityComponent() =
            DaggerActivityComponent
                    .builder()
                    .applicationComponent((application as MyApplication).applicationComponent)
                    .activityModule(ActivityModule(this))
                    .build()

    fun showMessage(message: String) = Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()

    fun showMessage(@StringRes resId: Int) = showMessage(getString(resId))

    @LayoutRes
    protected abstract fun provideLayoutId(): Int

    protected abstract fun setupView(savedInstanceState: Bundle?)

    protected abstract fun injectDependencies(activityComponent: ActivityComponent)
}