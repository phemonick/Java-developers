package com.example.adekunleoluwafemi.javadevelopers;

import android.app.Application;

public class MvpApplication extends Application {
    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerAppComponent.builder().appModule(new AppModule()).build();

    }

    public AppComponent getComponent() {
        return component;
    }
}
