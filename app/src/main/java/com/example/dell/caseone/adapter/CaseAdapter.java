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
import com.bumptech.glide.request.RequestOptions;
import com.example.dell.caseone.R;
import com.example.dell.caseone.bean.WanBeah;

import java.util.ArrayList;

public class CaseAdapter extends RecyclerView.Adapter<CaseAdapter.ViewHolder> {

    private ArrayList<WanBeah.DataBean.DatasBean> list;
    private Context context;

    public CaseAdapter(ArrayList<WanBeah.DataBean.DatasBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.case_item, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        RequestOptions requestOptions = new RequestOptions().circleCrop();
        WanBeah.DataBean.DatasBean bean = list.get(i);
        viewHolder.dtv.setText(bean.getChapterName());
        Glide.with(context).load(bean.getEnvelopePic()).apply(requestOptions).into(viewHolder.dimg);
        viewHolder.tv.setText(bean.getTitle());
        Glide.with(context).load(bean.getEnvelopePic()).into(viewHolder.img);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (click!=null){
                    click.click(i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView dimg;
        private final TextView dtv;
        private final TextView tv;
        private final ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dimg = itemView.findViewById(R.id.ca_d_img);
            dtv = itemView.findViewById(R.id.ca_d_tv);
            tv = itemView.findViewById(R.id.ca_tv);
            img = itemView.findViewById(R.id.ca_img);
        }
    }
    public interface Click{
        void click(int i);
    }
    private Click click;

    public void setClick(Click click) {
        this.click = click;
    }
}
