package com.example.adekunleoluwafemi.javadevelopers;

import com.example.adekunleoluwafemi.javadevelopers.view.MainActivity;

import dagger.Component;

@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(MainActivity target);
}
