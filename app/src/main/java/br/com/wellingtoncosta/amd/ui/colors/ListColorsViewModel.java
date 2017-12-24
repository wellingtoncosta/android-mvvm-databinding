package br.com.wellingtoncosta.amd.ui.colors;

import javax.inject.Inject;

import br.com.wellingtoncosta.amd.base.BaseViewModel;
import br.com.wellingtoncosta.amd.data.Api;
import br.com.wellingtoncosta.amd.di.AppInjector;
import br.com.wellingtoncosta.amd.domain.Color;
import br.com.wellingtoncosta.amd.domain.response.Response;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Wellington Costa on 23/12/2017.
 */
public class ListColorsViewModel extends BaseViewModel<Color> {

    @Inject
    Api api;

    public ListColorsViewModel() {
        AppInjector.applicationComponent().inject(this);
    }

    @Override
    public void loadData() {
        api.fetchColors(1)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(s -> loadingStatus.setValue(true))
                .doAfterTerminate(() -> loadingStatus.setValue(false))
                .subscribe(
                        colorsResponse -> response.setValue(Response.success(colorsResponse.getData())),
                        throwable -> response.setValue(Response.error(throwable))
                );
    }

}