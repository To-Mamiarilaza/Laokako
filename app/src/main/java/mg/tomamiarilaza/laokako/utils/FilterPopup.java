package mg.tomamiarilaza.laokako.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;

import mg.tomamiarilaza.laokako.R;

public class FilterPopup extends Dialog {

    public FilterPopup(@NonNull Activity activity) {
        super(activity, androidx.appcompat.R.style.Theme_AppCompat_DayNight_Dialog);
        setContentView(R.layout.filter_popup);

        getWindow().setBackgroundDrawableResource(R.drawable.filter_popup_background);

        // Compare Spinner parameter
        Spinner price_spinner = findViewById(R.id.price_choice);
        Spinner duration_spinner = findViewById(R.id.duration_choice);
        Spinner score_spinner = findViewById(R.id.score_choice);

        String[] choices = {"   <   ", "   >   "};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(activity, android.R.layout.simple_dropdown_item_1line, choices);

        score_spinner.setAdapter(adapter);
        duration_spinner.setAdapter(adapter);
        price_spinner.setAdapter(adapter);

        // Ingredient Spinner parameter
        Spinner inner_ingredient_spinner = findViewById(R.id.inner_ingredient_choice);
        Spinner outer_ingredient_spinner = findViewById(R.id.outer_ingredient_choice);

        String[] ingredients = {"Percil", "Hena Kisoa", "Voatabia"};
        ArrayAdapter<String> ingredients_adapter = new ArrayAdapter<>(activity, android.R.layout.simple_dropdown_item_1line, ingredients);

        inner_ingredient_spinner.setAdapter(ingredients_adapter);
        outer_ingredient_spinner.setAdapter(ingredients_adapter);
    }
}
