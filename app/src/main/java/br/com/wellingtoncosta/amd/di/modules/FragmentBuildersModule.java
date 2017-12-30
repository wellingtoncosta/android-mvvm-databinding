package br.com.wellingtoncosta.amd.di.modules;

import br.com.wellingtoncosta.amd.ui.colors.ListColorsFragment;
import br.com.wellingtoncosta.amd.ui.users.ListUsersFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * @author Wellington Costa on 25/12/2017.
 */
@Module
public interface FragmentBuildersModule {

    @ContributesAndroidInjector
    ListUsersFragment contributeListUsersFragment();

    @ContributesAndroidInjector
    ListColorsFragment contributeListColorsFragment();

}