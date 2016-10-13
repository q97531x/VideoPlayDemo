package com.example.videoplaydemo.Common;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by XmacZone on 16/10/11.
 */

@Component(modules = {RetrofitClient.class})
public interface AppComponent {
    Retrofit retrofit();
}
