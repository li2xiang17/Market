package com.example.mylibrary.utils;

public interface HomeInterface {
    <T> void get(String url,HomeCallBack<T> netCallBack);
}
