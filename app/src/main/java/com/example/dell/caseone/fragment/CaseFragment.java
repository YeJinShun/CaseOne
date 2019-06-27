package com.example.dell.caseone.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.caseone.R;
import com.example.dell.caseone.WebActivity;
import com.example.dell.caseone.adapter.CaseAdapter;
import com.example.dell.caseone.bean.WanBeah;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class CaseFragment extends Fragment {


    private RecyclerView caRv;
    private ArrayList<WanBeah.DataBean.DatasBean> list;
    private CaseAdapter adapter;

    public CaseFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_case, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        caRv = (RecyclerView) view.findViewById(R.id.ca_rv);
        caRv.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        adapter = new CaseAdapter(list, getContext());
        caRv.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        caRv.setAdapter(adapter);
        adapter.setClick(new CaseAdapter.Click() {
            @Override
            public void click(int i) {
                Intent intent = new Intent(getActivity(), WebActivity.class);
                intent.putExtra("intent",list.get(i).getLink());
                startActivity(intent);
            }
        });
        initData();

    }

    private void initData() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        Request request = new Request.Builder()
                .url("https://www.wanandroid.com/project/list/1/json?cid=294")
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                final WanBeah wanBeah = new GsonBuilder().serializeNulls().create().fromJson(string, WanBeah.class);
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        List<WanBeah.DataBean.DatasBean> datas = wanBeah.getData().getDatas();
                        list.addAll(datas);
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        });

    }

}
