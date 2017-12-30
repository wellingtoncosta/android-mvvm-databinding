package br.com.wellingtoncosta.amd.util.schedulers;

import android.support.annotation.NonNull;

import io.reactivex.Scheduler;

/**
 * @author Wellington Costa on 30/12/2017.
 */
public interface BaseScheduler {

    @NonNull
    Scheduler io();

    @NonNull
    Scheduler ui();

}