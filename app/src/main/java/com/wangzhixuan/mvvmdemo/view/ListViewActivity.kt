package com.wangzhixuan.mvvmdemo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.wangzhixuan.mvvmdemo.R
import com.wangzhixuan.mvvmdemo.adapter.BaseRecycleAdapter
import com.wangzhixuan.mvvmdemo.databinding.ActivityListViewBinding
import com.wangzhixuan.mvvmdemo.model.data.MailType
import com.wangzhixuan.mvvmdemo.viewmodel.ListViewModel
import java.util.ArrayList

class ListViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val get = ViewModelProviders.of(this).get(ListViewModel::class.java)
        val mainBinding = DataBindingUtil.setContentView<ActivityListViewBinding>(this,R.layout.activity_list_view)
//        mainBinding.rvData = get.getMailTypes().value as MailType?
//        get.getMailTypes().observe(this,object : Observer<ArrayList<MailType>>{
//            override fun onChanged(t: ArrayList<MailType>?) {
//                if (mainBinding.recyclerView.adapter != null) {
//                    mainBinding.recyclerView.adapter!!.notifyDataSetChanged()
//                }
//            }
//
//        })
//        get.getFalseData()
//        val recycleView = mainBinding.recyclerView
//        val arrayList = ArrayList<MailType>()
//        for (index in 0..10) {
//            val mailType = MailType()
//            mailType.text = "邮箱=$index"
//            arrayList.add(mailType)
//        }
//
//        val adapter = BaseRecycleAdapter(arrayList)
//        recycleView.adapter = adapter
//        adapter.notifyDataSetChanged()


    }
}
