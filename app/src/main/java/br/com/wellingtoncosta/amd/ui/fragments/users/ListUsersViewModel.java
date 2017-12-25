package br.com.wellingtoncosta.amd.ui.fragments.users;

import javax.inject.Inject;

import br.com.wellingtoncosta.amd.ui.base.BaseViewModel;
import br.com.wellingtoncosta.amd.data.Api;
import br.com.wellingtoncosta.amd.domain.User;
import br.com.wellingtoncosta.amd.domain.response.Response;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Wellington Costa on 22/12/2017.
 */
public class ListUsersViewModel extends BaseViewModel<User> {

   private Api api;

    @Inject
    ListUsersViewModel(Api api) {
       this.api = api;
   }

   @Override
    public void loadData() {
        api.fetchUsers(1)
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
