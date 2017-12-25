package br.com.wellingtoncosta.amd.ui.fragments.colors;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import br.com.wellingtoncosta.amd.databinding.ListColorsItemBinding;

/**
 * @author Wellington Costa on 24/12/2017.
 */
class ListColorsViewHolder extends RecyclerView.ViewHolder {

    private final ListColorsItemBinding binding;

    ListColorsViewHolder(View view) {
        super(view);
        this.binding = DataBindingUtil.bind(view);
    }

    ListColorsItemBinding getBinding() {
        return binding;
    }

}
