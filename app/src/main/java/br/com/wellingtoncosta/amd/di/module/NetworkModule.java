package br.com.wellingtoncosta.amd.di.module;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import br.com.wellingtoncosta.amd.BuildConfig;
import br.com.wellingtoncosta.amd.data.Api;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Wellington Costa on 22/12/2017.
 */
@Module
public class NetworkModule {

    private static final int CONNECT_TIMEOUT = 30000;

    @Provides
    @Singleton
    OkHttpClient providesOkHttpClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
                .build();
    }

    @Provides
    @Singleton
    Retrofit providesRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    Api providesApi(Retrofit retrofit) {
        return retrofit.create(Api.class);
    }

}