package br.com.wellingtoncosta.amd.di.modules;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import br.com.wellingtoncosta.amd.di.keys.ViewModelKey;
import br.com.wellingtoncosta.amd.ui.ViewModelFactory;
import br.com.wellingtoncosta.amd.ui.fragments.colors.ListColorsViewModel;
import br.com.wellingtoncosta.amd.ui.fragments.users.ListUsersViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * @author Wellington Costa on 25/12/2017.
 */
@Module
public interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ListUsersViewModel.class)
    ViewModel bindListUsersViewModel(ListUsersViewModel listUsersViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(ListColorsViewModel.class)
    ViewModel bindListColorsViewModel(ListColorsViewModel listColorsViewModel);

    @Binds
    ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);

}