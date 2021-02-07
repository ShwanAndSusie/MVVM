package com.wangzhixuan.mvvmdemo.base

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

import java.lang.reflect.Field

/**
 * @author WangZhixuan 50536
 * @date 2021-02-07
 */
abstract class BaseFragment : Fragment() {
    protected val isUseBrocast: Boolean
        get() = false


    lateinit var mFragment: Fragment
    protected abstract fun initView(inflater: LayoutInflater, container: ViewGroup?): View
    protected abstract fun initData()
    protected abstract fun initListener()
    /**
     * onDestroy()中资源释放，正常使用时子类重写该方法
     */
    protected fun releaseOnDestroy() {}

    /**
     * onStop()中资源释放，正常使用时子类重写该方法
     */
    protected fun releaseOnStop() {}

    /**
     * onPause()中资源释放，正常使用时子类重写该方法
     */
    protected fun releaseOnPause() {}

    protected abstract fun initViewModel()


    /**
     * rootFragment统一采用此方法进行hide/show
     */
    fun setHide(isHide: Boolean, transaction: FragmentTransaction) {}

    override fun onResume() {
        super.onResume()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initListener()
        initData()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFragment = this
        initViewModel()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = initView(inflater, container)
        initObserver(view)
        return view
    }

    fun onBackPressed(): Boolean {
        return false
    }

    override fun onDetach() {
        super.onDetach()
        try {
            val childFragment = Fragment::class.java.getDeclaredField("mChildFragmentManager")
            childFragment.isAccessible = true
            childFragment.set(this, null)
        } catch (e: NoSuchFieldException) {
            throw RuntimeException(e)
        } catch (e: IllegalAccessException) {
            throw RuntimeException(e)
        }

    }

    override fun onPause() {
        super.onPause()
        releaseOnPause()
    }

    override fun onStop() {
        super.onStop()
        releaseOnStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        releaseOnDestroy()
    }

    protected fun createBroadCast(): IntentFilter? {
        return null
    }

    protected fun onReceive(context: Context, intent: Intent) {

    }

    abstract fun initObserver(view: View?)
}
