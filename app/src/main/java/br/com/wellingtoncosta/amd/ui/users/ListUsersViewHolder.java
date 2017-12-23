package br.com.wellingtoncosta.amd.ui.users;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import br.com.wellingtoncosta.amd.databinding.ListUsersItemBinding;

/**
 * @author Wellington Costa on 23/12/2017.
 */
class ListUsersViewHolder extends RecyclerView.ViewHolder {

    private final ListUsersItemBinding binding;

    ListUsersViewHolder(View view) {
        super(view);
        this.binding = DataBindingUtil.bind(view);
    }

    ListUsersItemBinding getBinding() {
        return binding;
    }

}
