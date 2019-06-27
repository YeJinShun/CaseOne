package com.example.dell.caseone.presnenter;

import com.example.dell.caseone.bean.WanBeah;
import com.example.dell.caseone.callback.WanCallback;
import com.example.dell.caseone.model.WanModel;
import com.example.dell.caseone.view.WanView;

public class WanPresenterimpel implements WanPresenter,WanCallback{
    private WanModel wanModel;
    private WanView wanView;

    public WanPresenterimpel(WanModel wanModel, WanView wanView) {
        this.wanModel = wanModel;
        this.wanView = wanView;
    }

    @Override
    public void Sueecss(WanBeah wanBeah) {
        wanView.Sueecss(wanBeah);

    }

    @Override
    public void Fail(String s) {
        wanView.Fail(s);
    }

    @Override
    public void getData() {
        wanModel.getData(this);
    }
}
