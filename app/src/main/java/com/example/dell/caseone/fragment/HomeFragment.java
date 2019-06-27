package com.example.dell.caseone.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.caseone.R;
import com.example.dell.caseone.adapter.HomeAdapter;
import com.example.dell.caseone.bean.WanBeah;
import com.example.dell.caseone.model.WanModelimpel;
import com.example.dell.caseone.presnenter.WanPresenterimpel;
import com.example.dell.caseone.view.WanView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements WanView {


    private ArrayList<WanBeah.DataBean.DatasBean> list;
    private RecyclerView rv;
    private HomeAdapter adapter;

    public HomeFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        WanPresenterimpel presenterimpel = new WanPresenterimpel(new WanModelimpel(), this);
        presenterimpel.getData();
        initView(view);
        return view;
    }

    private void initView(View view) {
        rv = (RecyclerView) view.findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        adapter = new HomeAdapter(list, getContext());
        rv.setAdapter(adapter);

    }

    @Override
    public void Sueecss(WanBeah wanBeah) {
        final List<WanBeah.DataBean.DatasBean> datas = wanBeah.getData().getDatas();
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                list.addAll(datas);
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void Fail(String s) {

    }
}
