package com.example.mylibrary.utils;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class RetrofigUtils implements HomeInterface {
    private static volatile RetrofigUtils retrofigUtils;
    private final ApiService apiService;

    public RetrofigUtils() {
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().build();
        apiService = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(HomeConstant.homeUrl)
                .build().create(ApiService.class);
    }

    public static RetrofigUtils getNetUtil() {
        if (retrofigUtils == null) {
            synchronized (RetrofigUtils.class) {
                if (retrofigUtils == null) {
                    retrofigUtils = new RetrofigUtils();
                }
            }
        }
        return retrofigUtils;
    }

    @Override
    public <T> void get(String url, HomeCallBack<T> netCallBack) {
        apiService.get(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            Type[] genericInterfaces = netCallBack.getClass().getGenericInterfaces();
                            Type[] types = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                            Type type = types[0];
                            netCallBack.onSuccess(new Gson().fromJson(string, type));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        netCallBack.onFail("网络异常：" + e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


}
