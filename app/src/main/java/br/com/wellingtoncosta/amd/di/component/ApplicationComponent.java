package br.com.wellingtoncosta.amd.di.component;

import javax.inject.Singleton;

import br.com.wellingtoncosta.amd.di.module.NetworkModule;
import br.com.wellingtoncosta.amd.ui.colors.ListColorsViewModel;
import br.com.wellingtoncosta.amd.ui.users.ListUsersViewModel;
import dagger.Component;

/**
 * @author Wellington Costa on 22/12/2017.
 */
@Singleton
@Component(modules = {NetworkModule.class})
public interface ApplicationComponent {

    void inject(ListUsersViewModel listUsersViewModel);
    void inject(ListColorsViewModel listColorsViewModel);

}