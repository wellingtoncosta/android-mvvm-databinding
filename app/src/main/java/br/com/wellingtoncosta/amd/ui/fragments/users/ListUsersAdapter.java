package br.com.wellingtoncosta.amd.ui.fragments.users;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import br.com.wellingtoncosta.amd.R;
import br.com.wellingtoncosta.amd.ui.base.BaseAdapter;
import br.com.wellingtoncosta.amd.databinding.ListUsersItemBinding;
import br.com.wellingtoncosta.amd.domain.User;

/**
 * @author Wellington Costa on 23/12/2017.
 */
public class ListUsersAdapter extends BaseAdapter<User> {

    ListUsersAdapter(List<User> users) {
        this.list = users;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolderBase(ViewGroup parent, int viewType) {
        return new ListUsersViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.list_users_item, parent, false));
    }

    @Override
    public void onBindViewHolderBase(RecyclerView.ViewHolder holder, int position) {
        ListUsersItemBinding binding = ((ListUsersViewHolder)holder).getBinding();
        User user = list.get(position);
        binding.setUser(user);
    }

}