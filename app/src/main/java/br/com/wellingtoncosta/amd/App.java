package br.com.wellingtoncosta.amd;

import com.facebook.drawee.backends.pipeline.Fresco;

import br.com.wellingtoncosta.amd.di.components.DaggerAppComponent;
import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

/**
 * @author Wellington Costa on 22/12/2017.
 */
public class App extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }

    @Override
    protected AndroidInjector<? extends App> applicationInjector() {
        return DaggerAppComponent.builder().create(this);
    }

}