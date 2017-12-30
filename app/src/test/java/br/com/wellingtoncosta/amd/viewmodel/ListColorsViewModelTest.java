package br.com.wellingtoncosta.amd.viewmodel;

import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.lifecycle.Observer;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import br.com.wellingtoncosta.amd.data.remote.response.ApiListResponse;
import br.com.wellingtoncosta.amd.data.remote.response.Response;
import br.com.wellingtoncosta.amd.domain.model.Color;
import br.com.wellingtoncosta.amd.domain.repository.ColorRepository;
import br.com.wellingtoncosta.amd.ui.colors.ListColorsViewModel;
import br.com.wellingtoncosta.amd.util.schedulers.TestSchedulerProvider;
import io.reactivex.schedulers.TestScheduler;

import static br.com.wellingtoncosta.amd.mock.Mocks.createColors;
import static io.reactivex.Observable.just;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

/**
 * @author Wellington Costa on 30/12/2017.
 */
@RunWith(JUnit4.class)
public class ListColorsViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantExecutor = new InstantTaskExecutorRule();

    private ColorRepository colorRepository;

    private ListColorsViewModel listColorsViewModel;

    @Before
    public void setUp(){
        colorRepository = mock(ColorRepository.class);
        listColorsViewModel = new ListColorsViewModel(colorRepository, new TestSchedulerProvider(new TestScheduler()));
        when(colorRepository.getColors()).thenReturn(just(new ApiListResponse<>(createColors())));
    }

    @Test
    @SuppressWarnings("unchecked")
    public void empty() {
        Observer<Response<List<Color>>> result = mock(Observer.class);
        listColorsViewModel.getResponse().observeForever(result);
        verifyNoMoreInteractions(colorRepository);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void loadColorsWithSuccess() {
        Observer<Response<List<Color>>> result = mock(Observer.class);
        listColorsViewModel.getResponse().observeForever(result);
        listColorsViewModel.loadData();
        verify(colorRepository).getColors();
    }

}