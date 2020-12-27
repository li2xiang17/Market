package com.example.market.model;

import com.example.market.contract.HomeContract;
import com.example.market.presenter.HomePresenterImp;
import com.example.mylibrary.base.BaseModel;
import com.example.mylibrary.utils.HomeCallBack;
import com.example.mylibrary.utils.RetrofigUtils;

public class HomeModelImp extends BaseModel implements HomeContract.iHomeModel {
    private HomePresenterImp homePresenterImp;

    public HomeModelImp(HomePresenterImp homePresenterImp) {
        this.homePresenterImp = homePresenterImp;
    }


    @Override
    public <T> void getHomeData(String url, HomeCallBack<T> homeCallBack) {
        RetrofigUtils.getNetUtil().get(url,homeCallBack);
    }
}
