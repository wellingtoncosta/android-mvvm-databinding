package br.com.wellingtoncosta.amd.ui.users;

import java.util.List;

import javax.inject.Inject;

import br.com.wellingtoncosta.amd.data.remote.response.Response;
import br.com.wellingtoncosta.amd.domain.model.User;
import br.com.wellingtoncosta.amd.domain.repository.UserRepository;
import br.com.wellingtoncosta.amd.ui.base.BaseViewModel;
import br.com.wellingtoncosta.amd.util.schedulers.BaseScheduler;

/**
 * @author Wellington Costa on 22/12/2017.
 */
public class ListUsersViewModel extends BaseViewModel<List<User>> {

    private UserRepository userRepository;

    private BaseScheduler scheduler;

    @Inject
    public ListUsersViewModel(UserRepository userRepository, BaseScheduler scheduler) {
       this.userRepository = userRepository;
       this.scheduler = scheduler;
   }

    @Override
    public void loadData() {
       userRepository.getUsers()
                .subscribeOn(scheduler.io())
                .observeOn(scheduler.ui())
                .doOnSubscribe(s -> loadingStatus.setValue(true))
                .doAfterTerminate(() -> loadingStatus.setValue(false))
                .subscribe(
                        usersResponse -> response.setValue(Response.success(usersResponse.getData())),
                        throwable -> response.setValue(Response.error(throwable))
                );
    }

}
