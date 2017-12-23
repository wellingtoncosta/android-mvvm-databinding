package br.com.wellingtoncosta.amd.ui.users;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.wellingtoncosta.amd.R;
import br.com.wellingtoncosta.amd.databinding.FragmentListUsersBinding;
import br.com.wellingtoncosta.amd.domain.response.Status;

/**
 * @author Wellington Costa on 22/12/2017.
 */
public class ListUsersFragment extends Fragment {

    private FragmentListUsersBinding binding;

    private ListUsersViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(ListUsersViewModel.class);

        observeLoadingStatus();
        observeResponse();

        viewModel.loadData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list_users, container, false);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.swipeContainer.setOnRefreshListener(viewModel::loadData);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public void observeLoadingStatus() {
        viewModel.getLoadingStatus().observe(
                this,
                isLoading  -> binding.swipeContainer.setRefreshing(isLoading == null ? false : isLoading)
        );
    }

    public void observeResponse() {
        viewModel.getResponse().observe(this, response -> {
            if(response != null && response.status == Status.SUCCESS) {
                binding.setUsers(response.data);
                binding.executePendingBindings();
            }
        });
    }

}