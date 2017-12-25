package br.com.wellingtoncosta.amd.ui.fragments.colors;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import br.com.wellingtoncosta.amd.R;
import br.com.wellingtoncosta.amd.ui.base.BaseAdapter;
import br.com.wellingtoncosta.amd.databinding.ListColorsItemBinding;
import br.com.wellingtoncosta.amd.domain.Color;

/**
 * @author Wellington Costa on 24/12/2017.
 */
public class ListColorsAdapter extends BaseAdapter<Color> {

    ListColorsAdapter(List<Color> colors) {
        this.list = colors;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolderBase(ViewGroup parent, int viewType) {
        return new ListColorsViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.list_colors_item, parent, false));
    }

    @Override
    public void onBindViewHolderBase(RecyclerView.ViewHolder holder, int position) {
        ListColorsItemBinding binding = ((ListColorsViewHolder)holder).getBinding();
        Color color= list.get(position);
        binding.setColor(color);
    }

}