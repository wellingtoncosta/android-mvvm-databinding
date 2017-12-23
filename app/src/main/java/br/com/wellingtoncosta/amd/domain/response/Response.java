package br.com.wellingtoncosta.amd.domain.response;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.Collections;
import java.util.List;

import static br.com.wellingtoncosta.amd.domain.response.Status.ERROR;
import static br.com.wellingtoncosta.amd.domain.response.Status.SUCCESS;

/**
 * @author Wellington Costa on 22/12/2017.
 */
public class Response<T> {

    @NonNull
    public final Status status;

    @NonNull
    public final List<T> data;

    @Nullable
    public final Throwable error;

    private Response(@NonNull Status status, @NonNull List<T> data, @Nullable Throwable error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }

    public static <T> Response<T> success(List<T> data) {
        return new Response<>(SUCCESS, data, null);
    }

    public static <T> Response<T> error(Throwable error) {
        return new Response<>(ERROR, Collections.emptyList(), error);
    }

}
