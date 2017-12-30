package br.com.wellingtoncosta.amd.ui.colors;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import java.util.List;

import br.com.wellingtoncosta.amd.domain.model.Color;

/**
 * @author Wellington Costa on 23/12/2017.
 */
public class ListColorsBindings {

    @BindingAdapter("load_colors")
    public static void loadColors(RecyclerView recyclerView, List<Color> colors) {
        ListColorsAdapter adapter = new ListColorsAdapter(colors);
        recyclerView.setAdapter(adapter);
    }

    @BindingAdapter("load_color_value")
    public static void loadColorValue(ImageView imageView, Color color) {
        imageView.setBackgroundColor(android.graphics.Color.parseColor(color.getColor()));
    }

}