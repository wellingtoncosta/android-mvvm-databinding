package br.com.wellingtoncosta.amd.util.schedulers;

import android.support.annotation.NonNull;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.TestScheduler;

/**
 * @author Wellington Costa on 28/12/2017.
 */
public class TestSchedulerProvider implements BaseScheduler {

    private final TestScheduler testScheduler;

    public TestSchedulerProvider(TestScheduler testScheduler) {
        this.testScheduler = testScheduler;
    }

    @NonNull
    @Override
    public Scheduler io() {
        return testScheduler;
    }

    @NonNull
    @Override
    public Scheduler ui() {
        return testScheduler;
    }

}