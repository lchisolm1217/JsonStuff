package com.lighterletter.www.jsonpractice;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lighterletter.www.jsonpractice.model.Fellow;

import java.util.List;

/**
 * Created by john on 12/9/17.
 */

class FellowAdapter extends RecyclerView.Adapter {
    private final List<Fellow> fellowList;

    public FellowAdapter(List<Fellow> fellowList) {
        this.fellowList = fellowList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FellowViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((FellowViewHolder) holder).bind(fellowList.get(position));
    }

    @Override
    public int getItemCount() {
        return fellowList.size();
    }

}
