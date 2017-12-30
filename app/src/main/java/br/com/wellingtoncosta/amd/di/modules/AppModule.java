package br.com.wellingtoncosta.amd.di.modules;

import javax.inject.Singleton;

import br.com.wellingtoncosta.amd.data.remote.Api;
import br.com.wellingtoncosta.amd.domain.repository.ColorRepository;
import br.com.wellingtoncosta.amd.domain.repository.UserRepository;
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

    @Provides
    @Singleton
    UserRepository provideUserRepository(Api api) {
        return new UserRepository(api);
    }

    @Provides
    @Singleton
    ColorRepository provideColorRepository(Api api) {
        return new ColorRepository(api);
    }

}