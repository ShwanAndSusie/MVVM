package com.wangzhixuan.mvvmdemo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.wangzhixuan.mvvmdemo.R
import com.wangzhixuan.mvvmdemo.databinding.ActivityRecycleViewBinding
import com.wangzhixuan.mvvmdemo.viewmodel.RecycleViewModel

class RecycleVIewActivity : AppCompatActivity() {
    private lateinit var recycleVIewActivityBinding: ActivityRecycleViewBinding
    private lateinit var recycleViewModel: RecycleViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recycleVIewActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_recycle_view)
        recycleViewModel = RecycleViewModel(this)
        recycleVIewActivityBinding.viewModel = recycleViewModel

    }
}
