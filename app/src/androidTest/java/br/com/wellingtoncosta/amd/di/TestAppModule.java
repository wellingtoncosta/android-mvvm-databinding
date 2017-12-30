package br.com.wellingtoncosta.amd.di;

import javax.inject.Singleton;

import br.com.wellingtoncosta.amd.data.remote.Api;
import br.com.wellingtoncosta.amd.data.remote.response.ApiListResponse;
import br.com.wellingtoncosta.amd.di.modules.ViewModelModule;
import br.com.wellingtoncosta.amd.domain.repository.ColorRepository;
import br.com.wellingtoncosta.amd.domain.repository.UserRepository;
import br.com.wellingtoncosta.amd.util.schedulers.BaseScheduler;
import br.com.wellingtoncosta.amd.util.schedulers.SchedulerProvider;
import dagger.Module;
import dagger.Provides;

import static br.com.wellingtoncosta.amd.mock.Mocks.createColors;
import static br.com.wellingtoncosta.amd.mock.Mocks.createUsers;
import static io.reactivex.Observable.just;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Wellington Costa on 30/12/2017.
 */
@Module(includes = ViewModelModule.class)
class TestAppModule {

    @Provides
    @Singleton
    Api provideApi() {
        Api api = mock(Api.class);
        when(api.fetchUsers()).thenReturn(just(new ApiListResponse<>(createUsers())));
        when(api.fetchColors()).thenReturn(just(new ApiListResponse<>(createColors())));
        return api;
    }

    @Provides
    @Singleton
    UserRepository provideUserRepository(Api api) {
        return new UserRepository(api);
    }

    @Provides
    @Singleton
    ColorRepository provideRepoRepository(Api api) {
        return new ColorRepository(api);
    }

    @Provides
    @Singleton
    BaseScheduler provideScheduler() {
        return new SchedulerProvider();
    }

}