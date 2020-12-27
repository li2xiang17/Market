package com.example.mylibrary.utils;

public interface HomeCallBack<T> {
    void onSuccess(T t);
    void onFail(String error);
}
