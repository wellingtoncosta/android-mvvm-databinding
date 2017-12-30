package br.com.wellingtoncosta.amd;

import br.com.wellingtoncosta.amd.di.DaggerTestAppComponent;
import dagger.android.AndroidInjector;

/**
 * @author Wellington Costa on 30/12/2017.
 */
public class TestApp extends App {

    @Override
    protected AndroidInjector<? extends TestApp> applicationInjector() {
        return DaggerTestAppComponent.builder().create(this);
    }
}