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
import br.com.wellingtoncosta.amd.domain.model.User;
import br.com.wellingtoncosta.amd.domain.repository.UserRepository;
import br.com.wellingtoncosta.amd.ui.users.ListUsersViewModel;
import br.com.wellingtoncosta.amd.util.schedulers.TestSchedulerProvider;
import io.reactivex.schedulers.TestScheduler;

import static br.com.wellingtoncosta.amd.mock.Mocks.createUsers;
import static io.reactivex.Observable.just;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

/**
 * @author Wellington Costa on 30/12/2017.
 */
@RunWith(JUnit4.class)
public class ListUsersViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantExecutor = new InstantTaskExecutorRule();

    private UserRepository userRepository;

    private ListUsersViewModel listUsersViewModel;

    @Before
    public void setUp(){
        userRepository = mock(UserRepository.class);
        listUsersViewModel = new ListUsersViewModel(userRepository, new TestSchedulerProvider(new TestScheduler()));
        when(userRepository.getUsers()).thenReturn(just(new ApiListResponse<>(createUsers())));
    }

    @Test
    @SuppressWarnings("unchecked")
    public void empty() {
        Observer<Response<List<User>>> result = mock(Observer.class);
        listUsersViewModel.getResponse().observeForever(result);
        verifyNoMoreInteractions(userRepository);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void loadUsersWithSuccess() {
        Observer<Response<List<User>>> result = mock(Observer.class);
        listUsersViewModel.getResponse().observeForever(result);
        listUsersViewModel.loadData();
        verify(userRepository).getUsers();
    }

}