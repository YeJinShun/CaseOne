package com.example.dell.caseone.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dell.caseone.R;
import com.example.dell.caseone.bean.WanBeah;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter {

    private ArrayList<WanBeah.DataBean.DatasBean> list;
    private Context context;

    public HomeAdapter(ArrayList<WanBeah.DataBean.DatasBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i==1){
            View v1 = LayoutInflater.from(context).inflate(R.layout.one_item, null);
            return new  OneHolder(v1);
        }else if (i==2){
            View v2 = LayoutInflater.from(context).inflate(R.layout.two_item, null);
            return new  TwoHolder(v2);
        }else if(i==3){
            View v3 = LayoutInflater.from(context).inflate(R.layout.three_item, null);
            return new  ThreeHolder(v3);
        }else {
            View v4 = LayoutInflater.from(context).inflate(R.layout.four_item, null);
            return new  FourHolder(v4);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        WanBeah.DataBean.DatasBean bean = list.get(i);
        int type = getItemViewType(i);
        if (type == 1){
            OneHolder on = (OneHolder) viewHolder;
            on.one_tv.setText(bean.getTitle());
            Glide.with(context).load(bean.getEnvelopePic()).into(on.one_img);
        }else if (type == 2){
            TwoHolder tw = (TwoHolder) viewHolder;
            tw.two_1_tv.setText(bean.getTitle());
            Glide.with(context).load(bean.getEnvelopePic()).into(tw.two_1_img);
            tw.two_2_tv.setText(bean.getTitle());
            Glide.with(context).load(bean.getEnvelopePic()).into(tw.two_2_img);
        }else if (type == 3){
            ThreeHolder th = (ThreeHolder) viewHolder;
            th.three_name.setText(bean.getChapterName());
            th.three_title.setText(bean.getTitle());
            Glide.with(context).load(bean.getEnvelopePic()).into(th.three_img);

        }else {
            FourHolder fu = (FourHolder) viewHolder;
            fu.four_name.setText(bean.getChapterName());
            fu.four_title.setText(bean.getTitle());
            Glide.with(context).load(bean.getEnvelopePic()).into(fu.four_img);

        }
    }

    @Override
    public int getItemViewType(int position) {

        if (position%4==0){
            return 1;
        }else if (position%3==0){
            return 2;
        }else if (position%2==0){
            return 3;
        }else {
            return 4;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class OneHolder extends RecyclerView.ViewHolder {

        private final TextView one_tv;
        private final ImageView one_img;

        public OneHolder(@NonNull View itemView) {
            super(itemView);
            one_img = itemView.findViewById(R.id.one_img);
            one_tv = itemView.findViewById(R.id.one_tv);
        }
    }
    class TwoHolder extends RecyclerView.ViewHolder {

        private final ImageView two_1_img;
        private final TextView two_1_tv;
        private final ImageView two_2_img;
        private final TextView two_2_tv;

        public TwoHolder(@NonNull View itemView) {
            super(itemView);
            two_1_img = itemView.findViewById(R.id.two_1_img);
            two_1_tv = itemView.findViewById(R.id.two_1_tv);
            two_2_img = itemView.findViewById(R.id.two_2_img);
            two_2_tv = itemView.findViewById(R.id.two_2_tv);
        }
    }
    class ThreeHolder extends RecyclerView.ViewHolder {

        private final ImageView three_img;
        private final TextView three_name;
        private final TextView three_title;

        public ThreeHolder(@NonNull View itemView) {
            super(itemView);
            three_img = itemView.findViewById(R.id.three_img);
            three_name = itemView.findViewById(R.id.three_name);
            three_title = itemView.findViewById(R.id.three_title);
        }
    }
    class FourHolder extends RecyclerView.ViewHolder {

        private final ImageView four_img;
        private final TextView four_name;
        private final TextView four_title;

        public FourHolder(@NonNull View itemView) {
            super(itemView);
            four_img = itemView.findViewById(R.id.four_img);
            four_name = itemView.findViewById(R.id.four_name);
            four_title = itemView.findViewById(R.id.four_title);
        }
    }
}
