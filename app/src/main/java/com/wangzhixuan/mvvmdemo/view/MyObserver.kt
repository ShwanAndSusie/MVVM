package com.wangzhixuan.mvvmdemo.view

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import org.jetbrains.annotations.NotNull

/**
 *
 *
 * @author WangZhixuan 50536
 * @date 2020-11-27
 */
class MyObserver : IPresenter {
    val TAG = "MyObserver"

    override fun onCreate(owner: LifecycleOwner) {
        Log.v(TAG,"onCreate")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        Log.v(TAG,"onDestroy")
    }
}