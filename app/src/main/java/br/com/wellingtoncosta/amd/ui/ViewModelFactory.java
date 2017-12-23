package br.com.wellingtoncosta.amd.ui;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import br.com.wellingtoncosta.amd.ui.colors.ListColorsViewModel;
import br.com.wellingtoncosta.amd.ui.users.ListUsersViewModel;

/**
 * @author Wellington Costa on 23/12/2017.
 */
public class ViewModelFactory implements ViewModelProvider.Factory {

    private final Map<Class<? extends ViewModel>, ViewModel> creators;

    @Inject
    ViewModelFactory(ListUsersViewModel usersViewModel, ListColorsViewModel colorsViewModel) {
        this.creators = new HashMap<>();

        creators.put(ListUsersViewModel.class, usersViewModel);
        creators.put(ListColorsViewModel.class, colorsViewModel);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        ViewModel creator = creators.get(modelClass);
        if (creator == null) {
            for (Map.Entry<Class<? extends ViewModel>, ViewModel> entry : creators.entrySet()) {
                if (modelClass.isAssignableFrom(entry.getKey())) {
                    creator = entry.getValue();
                    break;
                }
            }
        }
        if (creator == null) {
            throw new IllegalArgumentException("Unknown model class " + modelClass);
        }
        try {
            return (T) creator;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /*private ListUsersViewModel usersViewModel;
    private ListColorsViewModel colorsViewModel;

    @Inject
    public ViewModelFactory(ListUsersViewModel usersViewModel, ListColorsViewModel colorsViewModel) {
        this.usersViewModel = usersViewModel;
        this.colorsViewModel = colorsViewModel;
    }*/

    /*@Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ListUsersViewModel.class)) {
            return (T) usersViewModel;
        }

        if (modelClass.isAssignableFrom(ListColorsViewModel.class)) {
            return (T) colorsViewModel;
        }

        throw new IllegalArgumentException("Unknown class name");
    }*/
}
