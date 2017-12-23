package br.com.wellingtoncosta.amd.ui.colors;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.wellingtoncosta.amd.R;

/**
 * @author Wellington Costa on 23/12/2017.
 */
public class ListColorsFragment extends Fragment {

    private ListColorsViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(ListColorsViewModel.class);

        observeLoadingStatus();
        observeResponse();

        viewModel.loadData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_colors, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public void observeLoadingStatus() {
        viewModel.getLoadingStatus().observe(this, isLoading  -> Log.d("isLoading ", String.valueOf(isLoading )));
    }

    public void observeResponse() {
        viewModel.getResponse().observe(this, response -> {
            if(response != null) {
                Log.d("response", response.status.toString());
            }
        });
    }

}