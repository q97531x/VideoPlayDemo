package com.example.videoplaydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;

import com.example.videoplaydemo.Adapter.VideoAdapter;
import com.example.videoplaydemo.Base.NewsContract;
import com.example.videoplaydemo.Bean.VideoData;
import com.example.videoplaydemo.Presenter.videoPresenter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NewsContract.View{
    private videoPresenter videoPresenter;
    VideoAdapter adapter = new VideoAdapter(this);
    @Bind(R.id.recycleList)
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        videoPresenter = new videoPresenter(this);
        videoPresenter.start();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showError(String s) {

    }

    @Override
    public void showData(List<VideoData> videoBean) {
        adapter.setData(videoBean);

    }

    @Override
    public void setPresenter(NewsContract.Presenter presenter) {

    }
}
