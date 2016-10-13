package com.example.videoplaydemo.Presenter;

import android.util.Log;


import com.alibaba.fastjson.TypeReference;
import com.example.videoplaydemo.Api.NetEasyVideoApi;
import com.example.videoplaydemo.Base.ArrayResponse;
import com.example.videoplaydemo.Base.NewsContract;
import com.example.videoplaydemo.Bean.VideoData;
import com.example.videoplaydemo.Common.AppComponent;
import com.example.videoplaydemo.Common.DaggerAppComponent;
import com.example.videoplaydemo.Common.RetrofitClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by XmacZone on 16/10/11.
 */

public class videoPresenter implements NewsContract.Presenter{
    private NewsContract.View view;
    private Retrofit retrofit;
    private AppComponent appComponent;
    private int pageSize = 12;
    public videoPresenter(NewsContract.View view) {
        this.view = view;
        view.setPresenter(this);
        appComponent = DaggerAppComponent.builder().retrofitClient(new RetrofitClient()).build();
    }

    @Override
    public void load(int curPage) {
        retrofit = appComponent.retrofit();
        NetEasyVideoApi videoApi = retrofit.create(NetEasyVideoApi.class);
        Log.e("load","load");
        videoApi.getVideos(pageSize,curPage*pageSize)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Subscriber<String>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onNext(String s) {
//                    Log.e("response", s);
                    try {
                        JSONObject jsonObject = new JSONObject(s);
                        JSONArray value = jsonObject.getJSONArray("视频");
                        ArrayList<VideoData> videoDatas = new ArrayList<>();
                        JSONObject item;
                        for (int i = 0; i < value.length(); i++) {
                            item = value.getJSONObject(i);
                            VideoData data = new VideoData();
                            data.setCover(item.optString("cover"));
                            data.setDescription(item.optString("description"));
                            data.setTitle(item.optString("title"));
                            data.setMp4_url(item.optString("mp4_url"));
                            videoDatas.add(data);
                        }
                        view.showData(videoDatas);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });

    }

    @Override
    public void start() {
        load(0);
    }
}
