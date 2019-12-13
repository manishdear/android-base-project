package com.mindorks.bootcamp.learndagger.ui.base

import android.os.Bundle
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.mindorks.bootcamp.learndagger.MyApplication
import com.mindorks.bootcamp.learndagger.di.component.DaggerFragmentComponent
import com.mindorks.bootcamp.learndagger.di.component.FragmentComponent
import com.mindorks.bootcamp.learndagger.di.module.FragmentModule
import javax.inject.Inject

abstract class BaseFragment<VM: BaseViewModel> : Fragment() {

    @Inject
    lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies(buildFragmentComponent())
        super.onCreate(savedInstanceState)
        setupObservers()
        viewModel.onCreate()
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {

    }

    private fun buildFragmentComponent() =
            DaggerFragmentComponent
                    .builder()
                    .applicationComponent((context!!.applicationContext as MyApplication).applicationComponent)
                    .fragmentModule(FragmentModule(this))
                    .build()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(provideLayoutId(), container , false)

    protected open fun setupObservers(){
        viewModel.messageStringId.observe(this, Observer {
            showMessage(it)
        })

        viewModel.messageString.observe(this, Observer {
            showMessage(it)
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView(view)
    }

    fun showMessage(message: String) = Toast.makeText(context, message, Toast.LENGTH_SHORT).show()

    fun showMessage(@StringRes resId: Int) = showMessage(getString(resId))

    @LayoutRes
    protected abstract fun provideLayoutId(): Int

    protected abstract fun injectDependencies(fragmentComponent: FragmentComponent)

    protected abstract fun setupView(view: View)
}
