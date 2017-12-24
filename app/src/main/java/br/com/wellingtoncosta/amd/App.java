package br.com.wellingtoncosta.amd;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import br.com.wellingtoncosta.amd.di.AppInjector;

/**
 * @author Wellington Costa on 22/12/2017.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        AppInjector.initialize(this);
    }

}