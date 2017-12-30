package br.com.wellingtoncosta.amd.ui.colors;

import java.util.List;

import javax.inject.Inject;

import br.com.wellingtoncosta.amd.data.remote.response.Response;
import br.com.wellingtoncosta.amd.domain.model.Color;
import br.com.wellingtoncosta.amd.domain.repository.ColorRepository;
import br.com.wellingtoncosta.amd.ui.base.BaseViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Wellington Costa on 23/12/2017.
 */
public class ListColorsViewModel extends BaseViewModel<List<Color>> {

    private ColorRepository colorRepository;

    @Inject
    ListColorsViewModel(ColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }

    @Override
    public void loadData() {
        colorRepository.getColors()
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