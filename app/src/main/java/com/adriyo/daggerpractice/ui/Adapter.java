package com.adriyo.daggerpractice.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.adriyo.daggerpractice.R;
import com.adriyo.daggerpractice.network.PeopleData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by adriyo on 13/06/17.
 * adriyo.github.io
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<PeopleData> mList;

    public Adapter() {
        mList = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.people_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    void addItem(List<PeopleData> datas) {
        mList.clear();
        mList.addAll(datas);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.people_name_tv)
        TextView name;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void onBind(int position) {
            name.setText(mList.get(position).getName());
        }
    }

}
