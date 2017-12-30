package br.com.wellingtoncosta.amd.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.wellingtoncosta.amd.data.remote.Api;
import br.com.wellingtoncosta.amd.data.remote.response.ApiListResponse;
import br.com.wellingtoncosta.amd.domain.repository.ColorRepository;

import static br.com.wellingtoncosta.amd.mock.Mocks.createColors;
import static io.reactivex.Observable.just;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Wellington Costa on 30/12/2017.
 */
@RunWith(JUnit4.class)
public class ColorRepositoryTesst {

    @Mock
    private Api api;

    @InjectMocks
    private ColorRepository colorRepository;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        when(colorRepository.getColors()).thenReturn(just(new ApiListResponse<>(createColors())));
    }

    @Test
    public void getUsersWithSuccess() {
        colorRepository.getColors();
        verify(api).fetchColors();
    }

}