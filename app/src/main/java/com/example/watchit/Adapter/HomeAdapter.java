package com.example.watchit.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.watchit.Model.HomeData;
import com.example.watchit.R;

public class HomeAdapter extends RecyclerView.Adapter {
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.homeitem,viewGroup,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((ListViewHolder) viewHolder).bindView(i);
    }

    @Override
    public int getItemCount() {
        return HomeData.title.length;
    }

    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView mItemText;
        private ImageView mItemImage;
        private TextView mItemTitle;
        private TextView mItemContent;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            mItemText =  (TextView) itemView.findViewById(R.id.tvUsernameHome);
            mItemImage = (ImageView) itemView.findViewById(R.id.ivProfileHome);
            mItemTitle = (TextView) itemView.findViewById(R.id.tvTitleHome);
            mItemContent = (TextView) itemView.findViewById(R.id.tvContentHome);
            itemView.setOnClickListener(this);
        }

        public void bindView(int position){
            mItemText.setText(HomeData.title[position]);
            mItemImage.setImageResource(HomeData.picturePath[position]);
            mItemTitle.setText(HomeData.titleStat[position]);
            mItemContent.setText(HomeData.titleC[position]);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
