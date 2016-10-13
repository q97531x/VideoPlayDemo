package com.example.videoplaydemo.Base;

import com.example.videoplaydemo.Bean.VideoData;

import java.util.List;

/**
 * Created by XmacZone on 16/9/27.
 */

public interface NewsContract {
    interface View extends BaseView<Presenter> {
        void showError(String s);

        void showData(List<VideoData> newsListBean);
    }

    interface Presenter extends BasePresenter{
        void load(int curPage);
    }
}
