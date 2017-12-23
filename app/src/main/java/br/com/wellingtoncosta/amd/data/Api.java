package br.com.wellingtoncosta.amd.data;

import java.util.List;

import br.com.wellingtoncosta.amd.domain.Color;
import br.com.wellingtoncosta.amd.domain.User;
import br.com.wellingtoncosta.amd.domain.response.ApiListResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author Wellington Costa on 22/12/2017.
 */
public interface Api {

    @GET("users")
    Observable<ApiListResponse<User>> fetchUsers(@Query("page") int page);

    @GET("unknown")
    Observable<ApiListResponse<Color>> fetchColors(@Query("page") int page);

}