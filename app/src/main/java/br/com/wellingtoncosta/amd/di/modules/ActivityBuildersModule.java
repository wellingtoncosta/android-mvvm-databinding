package br.com.wellingtoncosta.amd.di.modules;

import br.com.wellingtoncosta.amd.ui.MainActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * @author Wellington Costa on 25/12/2017.
 */
@Module
public interface ActivityBuildersModule {

    @ContributesAndroidInjector(modules = {FragmentBuildersModule.class})
    MainActivity contributeMainActivity();

}
