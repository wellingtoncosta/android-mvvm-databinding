package br.com.wellingtoncosta.amd.domain.repository;

import javax.inject.Inject;

import br.com.wellingtoncosta.amd.data.remote.Api;
import br.com.wellingtoncosta.amd.data.remote.response.ApiListResponse;
import br.com.wellingtoncosta.amd.domain.model.User;
import io.reactivex.Observable;

/**
 * @author Wellington Costa on 29/12/2017.
 */
public class UserRepository {

    private Api api;

    @Inject
    public UserRepository(Api api) {
        this.api = api;
    }

    public Observable<ApiListResponse<User>> getUsers() {
        return api.fetchUsers();
    }

}