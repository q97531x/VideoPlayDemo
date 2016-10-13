package com.example.videoplaydemo.Bean;

import java.io.Serializable;

/**
 * Created by XmacZone on 16/10/12.
 */

public class VideoData implements Serializable {
    private String cover;
    private String description;
    private String mp4_url;
    private String title;

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMp4_url() {
        return mp4_url;
    }

    public void setMp4_url(String mp4_url) {
        this.mp4_url = mp4_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
