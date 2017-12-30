package br.com.wellingtoncosta.amd.domain.repository;

import br.com.wellingtoncosta.amd.data.remote.Api;
import br.com.wellingtoncosta.amd.data.remote.response.ApiListResponse;
import br.com.wellingtoncosta.amd.domain.model.Color;
import io.reactivex.Observable;

/**
 * @author Wellington Costa on 30/12/2017.
 */
public class ColorRepository {

    private Api api;

    public ColorRepository(Api api) {
        this.api = api;
    }

    public Observable<ApiListResponse<Color>> getColors() {
        return api.fetchColors();
    }

}
