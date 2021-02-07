package com.wangzhixuan.mvvmdemo.viewmodel

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import androidx.databinding.ObservableField
import com.wangzhixuan.mvvmdemo.command.ReplyCommand
import com.wangzhixuan.mvvmdemo.model.Onclick
import com.wangzhixuan.mvvmdemo.view.ListViewActivity
import com.wangzhixuan.mvvmdemo.view.MainActivity
import com.wangzhixuan.mvvmdemo.view.OnLoadActivity
import com.wangzhixuan.mvvmdemo.view.RecycleVIewActivity

/**
 *
 *
 * @author WangZhixuan 50536
 * @date 2020-02-27
 */
class OnclickViewModel(
    val onlick: Onclick,
    val applicationContext: Context,
    val mainActivity: MainActivity

) {

    val info = ObservableField<String>("${onlick.who}点击了${onlick.count}次")

    val textView = ObservableField<String>()

    val count = ObservableField<String>("\"${onlick.count}\"")

    fun click(){
        onlick.count++
        info.set("${onlick.who}点击了${onlick.count}次")
        count.set("${onlick.count}")
    }

    val editTextCommand = ReplyCommand<String>{t ->
        textView.set("正在输入：${t}")
    }

    fun onLoadClick(){
//        startActivity(applicationContext, OnLoadActivity::class.java)
        mainActivity.startActivity(Intent(applicationContext, OnLoadActivity::class.java))
    }

    fun onListViewClick(){
        mainActivity.startActivity(Intent(applicationContext,RecycleVIewActivity::class.java))
    }

    fun onListViewClick2(){
        mainActivity.startActivity(Intent(applicationContext,ListViewActivity::class.java))
    }
}