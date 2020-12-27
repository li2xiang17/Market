package com.example.market.contract;

import com.example.market.bean.HomeBean;
import com.example.mylibrary.utils.HomeCallBack;

public class HomeContract {
    public interface iHomeView{
        void onHomeSuccess(HomeBean.DataBean data);
        void onHomeFail(String error);
    }
    public interface iHomePresenter{
        void getData();
    }
    public interface iHomeModel{
        <T> void getHomeData(String url, HomeCallBack<T> netCallBack);
    }
}
