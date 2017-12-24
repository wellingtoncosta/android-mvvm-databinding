package br.com.wellingtoncosta.amd.di;

import br.com.wellingtoncosta.amd.App;
import br.com.wellingtoncosta.amd.di.component.ApplicationComponent;
import br.com.wellingtoncosta.amd.di.component.DaggerApplicationComponent;
import br.com.wellingtoncosta.amd.di.module.NetworkModule;

/**
 * @author Wellington Costa on 24/12/2017.
 */
public class AppInjector {

    private AppInjector() { };

    private static ApplicationComponent applicationComponent;

    public static void initialize(App app) {
        applicationComponent = DaggerApplicationComponent.builder()
                .networkModule(new NetworkModule())
                .build();
    }

    public static ApplicationComponent applicationComponent() {
        return applicationComponent;
    }

}
