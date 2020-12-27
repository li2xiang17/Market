package com.example.market.presenter;

import com.example.market.bean.HomeBean;
import com.example.market.contract.HomeContract;
import com.example.market.fragment.HomeFragment;
import com.example.market.model.HomeModelImp;
import com.example.mylibrary.base.BasePresenter;
import com.example.mylibrary.utils.HomeCallBack;
import com.example.mylibrary.utils.HomeConstant;

public class HomePresenterImp extends BasePresenter<HomeFragment, HomeModelImp> implements HomeContract.iHomePresenter {
    @Override
    public void getData() {
        getModel().getHomeData(HomeConstant.homeAllUrl, new HomeCallBack<HomeBean>() {
            @Override
            public void onSuccess(HomeBean homeBean) {
                HomeBean.DataBean data = homeBean.getData();
                iView.onHomeSuccess(data);
            }

            @Override
            public void onFail(String error) {
                iView.onHomeFail(error);
            }
        });
    }

    @Override
    public HomeModelImp getModel() {
        return new HomeModelImp(this);
    }
}
