package com.lighterletter.www.jsonpractice;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lighterletter.www.jsonpractice.model.Fellow;

/**
 * Created by john on 12/9/17.
 */

class FellowViewHolder extends RecyclerView.ViewHolder {

    public FellowViewHolder(ViewGroup parent) {
        super(inflateLayout(parent));
    }

    private static View inflateLayout(ViewGroup parent) {
        return LayoutInflater.from(parent.getContext()).inflate(R.layout.fellow_layout, parent, false);
    }

    public void bind(Fellow fellow) {
        ((TextView) itemView.findViewById(R.id.fellow_name)).setText(fellow.getName());

        switch (fellow.getCohort()) {
            case "android":
                itemView.setBackgroundColor(Color.GREEN);
                break;
            case "ios":
                itemView.setBackgroundColor(Color.GRAY);
                break;
            case "web":
                itemView.setBackgroundColor(Color.CYAN);
                break;
        }
    }

}
