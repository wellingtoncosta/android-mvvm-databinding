package br.com.wellingtoncosta.amd.ui.users;

import java.util.List;

import javax.inject.Inject;

import br.com.wellingtoncosta.amd.data.remote.response.Response;
import br.com.wellingtoncosta.amd.domain.model.User;
import br.com.wellingtoncosta.amd.domain.repository.UserRepository;
import br.com.wellingtoncosta.amd.ui.base.BaseViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Wellington Costa on 22/12/2017.
 */
public class ListUsersViewModel extends BaseViewModel<List<User>> {

   private UserRepository userRepository;

    @Inject
    ListUsersViewModel(UserRepository userRepository) {
       this.userRepository = userRepository;
   }

   @Override
    public void loadData() {
       userRepository.getUsers()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(s -> loadingStatus.setValue(true))
                .doAfterTerminate(() -> loadingStatus.setValue(false))
                .subscribe(
                        usersResponse -> response.setValue(Response.success(usersResponse.getData())),
                        throwable -> response.setValue(Response.error(throwable))
                );
    }

}
