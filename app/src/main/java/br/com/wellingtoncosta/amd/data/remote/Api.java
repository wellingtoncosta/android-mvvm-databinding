package br.com.wellingtoncosta.amd.data.remote;

import br.com.wellingtoncosta.amd.domain.model.Color;
import br.com.wellingtoncosta.amd.domain.model.User;
import br.com.wellingtoncosta.amd.data.remote.response.ApiListResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * @author Wellington Costa on 22/12/2017.
 */
public interface Api {

    @GET("users")
    Observable<ApiListResponse<User>> fetchUsers();

    @GET("unknown")
    Observable<ApiListResponse<Color>> fetchColors();

}