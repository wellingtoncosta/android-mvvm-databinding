package br.com.wellingtoncosta.amd;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import br.com.wellingtoncosta.amd.di.DependencyInjector;

/**
 * @author Wellington Costa on 22/12/2017.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        DependencyInjector.initialize(this);
    }

}