package mg.tomamiarilaza.laokako.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ListPopupWindow;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import mg.tomamiarilaza.laokako.R;
import mg.tomamiarilaza.laokako.icon.Icon;

public class IconChoicePopup extends Dialog {

    Context context;

    public IconChoicePopup(@NonNull Activity activity) {
        super(activity, androidx.appcompat.R.style.Theme_AppCompat_DayNight_Dialog);
        this.context = activity;
        setContentView(R.layout.icon_choice_popup);

        getWindow().setBackgroundDrawableResource(R.drawable.filter_popup_background);

        configureRecyclerView();
    }

    private void configureRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.icon_display_grid);

        List<Icon> icons = new ArrayList<>();
        icons.add(Icon.findByName("tomato_ico"));
        icons.add(Icon.findByName("green_parsley"));
        icons.add(Icon.findByName("tomato_ico"));
        icons.add(Icon.findByName("green_parsley"));
        icons.add(Icon.findByName("tomato_ico"));
        icons.add(Icon.findByName("green_parsley"));

        IconChoiceAdapter adapter = new IconChoiceAdapter(icons, context);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 4));
        recyclerView.setAdapter(adapter);
    }
}
