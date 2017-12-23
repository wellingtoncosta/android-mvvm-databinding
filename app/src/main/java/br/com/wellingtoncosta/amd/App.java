package br.com.wellingtoncosta.amd;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import br.com.wellingtoncosta.amd.di.component.ApplicationComponent;
import br.com.wellingtoncosta.amd.di.component.DaggerApplicationComponent;
import br.com.wellingtoncosta.amd.di.module.NetworkModule;

/**
 * @author Wellington Costa on 22/12/2017.
 */
public class App extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this);

        this.applicationComponent = DaggerApplicationComponent
                .builder()
                .networkModule(new NetworkModule())
                .build();
    }

    public ApplicationComponent component() {
        return applicationComponent;
    }

}