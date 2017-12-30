package br.com.wellingtoncosta.amd.ui.colors;

import java.util.List;

import javax.inject.Inject;

import br.com.wellingtoncosta.amd.data.remote.response.Response;
import br.com.wellingtoncosta.amd.domain.model.Color;
import br.com.wellingtoncosta.amd.domain.repository.ColorRepository;
import br.com.wellingtoncosta.amd.ui.base.BaseViewModel;
import br.com.wellingtoncosta.amd.util.schedulers.BaseScheduler;

/**
 * @author Wellington Costa on 23/12/2017.
 */
public class ListColorsViewModel extends BaseViewModel<List<Color>> {

    private ColorRepository colorRepository;

    private BaseScheduler scheduler;

    @Inject
    public ListColorsViewModel(ColorRepository colorRepository, BaseScheduler scheduler) {
        this.colorRepository = colorRepository;
        this.scheduler = scheduler;
    }

    @Override
    public void loadData() {
        colorRepository.getColors()
                .subscribeOn(scheduler.io())
                .observeOn(scheduler.ui())
                .doOnSubscribe(s -> loadingStatus.setValue(true))
                .doAfterTerminate(() -> loadingStatus.setValue(false))
                .subscribe(
                        colorsResponse -> response.setValue(Response.success(colorsResponse.getData())),
                        throwable -> response.setValue(Response.error(throwable))
                );
    }

}