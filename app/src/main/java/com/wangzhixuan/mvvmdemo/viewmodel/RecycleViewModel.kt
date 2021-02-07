package com.wangzhixuan.mvvmdemo.viewmodel

import android.content.Context
import android.util.Log
import android.widget.AdapterView
import android.widget.Toast
import androidx.databinding.ObservableArrayList
import com.wangzhixuan.mvvmdemo.R
import com.wangzhixuan.mvvmdemo.model.OnItemClickListener
import me.tatarka.bindingcollectionadapter2.ItemBinding
import me.tatarka.bindingcollectionadapter2.OnItemBind
import me.tatarka.bindingcollectionadapter2.collections.MergeObservableList

/**
 *
 *
 * @author WangZhixuan 50536
 * @date 2020-03-13
 */
class RecycleViewModel(var context: Context) {

    var items = ObservableArrayList<RecycleItemViewModel>()

    var headFooterItems = MergeObservableList<Any>()
        .insertItem(RecycleItemViewModel("Header" ))
        .insertList(items)
        .insertItem(RecycleItemViewModel("Footer" ))

//    var itemBinding: ItemBinding<RecycleItemViewModel> = ItemBinding.of(com.wangzhixuan.mvvmdemo.BR.itemViewModel,
////        R.layout.item)

    var onItemClickListener: OnItemClickListener = object : OnItemClickListener {
        override fun onItemClickListener(text: String) {
            Toast.makeText(context,text,Toast.LENGTH_SHORT).show()
        }

    }

    var itemBinding: OnItemBind<Any> = OnItemBind{ itemBinding, position, item ->
        Log.v("50536 positon", position.toString())
        if(position == 0){
            itemBinding.set(ItemBinding.VAR_NONE, R.layout.headfoot)
//                .bindExtra(com.wangzhixuan.mvvmdemo.BR.onItemClck,onItemClickListener)

        }else if(position == 16){
            itemBinding.set(ItemBinding.VAR_NONE, R.layout.footer)
//                .bindExtra(com.wangzhixuan.mvvmdemo.BR.onItemClck,onItemClickListener)
        }else {
            itemBinding.set(com.wangzhixuan.mvvmdemo.BR.itemViewModel, R.layout.item)
                .bindExtra(com.wangzhixuan.mvvmdemo.BR.onItemClck,onItemClickListener)
        }
    }

    init {
        for (index in 0 until 15){
            items.add(RecycleItemViewModel("item"+index ))
        }
    }

}