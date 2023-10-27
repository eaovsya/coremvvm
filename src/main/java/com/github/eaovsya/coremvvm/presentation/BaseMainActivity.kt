package com.github.eaovsya.coremvvm.presentation

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.github.eaovsya.coremvvm.di.CoreComponentProvider
import com.github.eaovsya.coremvvm.di.ViewModelsFactory
import javax.inject.Inject

/**@SelfDocumented*/
abstract class BaseMainActivity(private val layoutResId: Int) : AppCompatActivity() {

    @Inject
    internal lateinit var viewModelFactory: ViewModelsFactory<BaseMainViewModel>
    private val viewModel: BaseMainViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[BaseMainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as CoreComponentProvider).provideCoreComponent().mainActivityComponent()
            .create().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(layoutResId)

        viewModel.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }
}