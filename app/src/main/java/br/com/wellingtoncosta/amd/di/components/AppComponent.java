package br.com.wellingtoncosta.amd.di.components;

import javax.inject.Singleton;

import br.com.wellingtoncosta.amd.App;
import br.com.wellingtoncosta.amd.di.modules.ActivityBuildersModule;
import br.com.wellingtoncosta.amd.di.modules.AppModule;
import br.com.wellingtoncosta.amd.di.modules.NetworkModule;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * @author Wellington Costa on 25/12/2017.
 */
@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ActivityBuildersModule.class,
        AppModule.class,
        NetworkModule.class})
interface AppComponent extends AndroidInjector<App> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<App> {}

}