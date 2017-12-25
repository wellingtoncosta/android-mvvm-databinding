package br.com.wellingtoncosta.amd.di.modules;

import javax.inject.Singleton;

import br.com.wellingtoncosta.amd.data.Api;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * @author Wellington Costa on 25/12/2017.
 */
@Module(includes = ViewModelModule.class)
public class AppModule {

    @Provides
    @Singleton
    Api provideApi(Retrofit retrofit) {
        return retrofit.create(Api.class);
    }

}