package com.example.dell.caseone.model;

import com.example.dell.caseone.bean.WanBeah;
import com.example.dell.caseone.callback.WanCallback;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class WanModelimpel implements WanModel {


    @Override
    public void getData(final WanCallback wanCallback) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        Request build = new Request.Builder()
                .url("https://www.wanandroid.com/project/list/1/json?cid=294")
                .build();
        Call call = okHttpClient.newCall(build);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                WanBeah wanBeah = new GsonBuilder().serializeNulls().create().fromJson(string, WanBeah.class);
                wanCallback.Sueecss(wanBeah);
            }
        });

    }
}
