package com.wangzhixuan.mvvmdemo.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.wangzhixuan.mvvmdemo.R;
import com.wangzhixuan.mvvmdemo.databinding.ItemListViewBinding;
import com.wangzhixuan.mvvmdemo.holder.BaseViewHolder;
import com.wangzhixuan.mvvmdemo.model.data.MailType;

import java.util.List;

/**
 * @author WangZhixuan 50536
 * @date 2020-11-30
 */
public class BaseRecycleAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private List<MailType> itemDatas;

    public BaseRecycleAdapter(List<MailType> itemDatas) {
        this.itemDatas = itemDatas;
    }
    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        ItemListViewBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.item_list_view,parent,false);
        return new BaseViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {

        ItemListViewBinding binding = DataBindingUtil.bind(holder.itemView);
        binding.setMailType(itemDatas.get(position));
        binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return itemDatas.size();
    }
}
