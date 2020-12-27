package com.example.mylibrary.base;

public abstract class BasePresenter<V extends BaseView,M extends BaseModel> {
    public V iView;
    public M iModel;
    public void attachView(V v){
        iView = v;
        iModel = getModel();
    }

    public abstract M getModel();

    public void detachView(){
        iView = null;
        iModel = null;
    }
}