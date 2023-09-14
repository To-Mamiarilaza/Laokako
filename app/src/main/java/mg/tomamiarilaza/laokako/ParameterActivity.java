package mg.tomamiarilaza.laokako;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import mg.tomamiarilaza.laokako.menu.Ingredient;
import mg.tomamiarilaza.laokako.menu.Menu;
import mg.tomamiarilaza.laokako.utils.AllergicFoodListAdapter;
import mg.tomamiarilaza.laokako.utils.IngredientListAdapter;

public class ParameterActivity extends AppCompatActivity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parameter);
        context = this;

        configureSpinner();     // Give the spinner his component
        configureRecyclerView();

        activateMenu();

    }

    private void activateMenu() {
        ImageView appInfoButton = findViewById(R.id.app_info_menu_button);
        appInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, AboutAppActivity.class);
                startActivity(intent);
            }
        });

        ImageView parameterButton = findViewById(R.id.parameter_menu_button);
        parameterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(context, ParameterActivity.class);
                //startActivity(intent);
            }
        });

        ImageView propositionButton = findViewById(R.id.proposition_menu_button);
        propositionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
            }
        });

        ImageView historyButton = findViewById(R.id.history_menu_button);
        historyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, HistoryActivity.class);
                startActivity(intent);
            }
        });

        ImageView menuButton = findViewById(R.id.menu_menu_button);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MenuListActivity.class);
                startActivity(intent);
            }
        });
    }

    // Prepare the recyclerView
    private void configureRecyclerView() {
        RecyclerView recycler = findViewById(R.id.allergic_food_list);

        // Brute data
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(Ingredient.findByName("Totokena"));
        ingredients.add(Ingredient.findByName("Anana"));
        ingredients.add(Ingredient.findByName("Voatabia"));


        AllergicFoodListAdapter adapter = new AllergicFoodListAdapter(ingredients, this);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(adapter);
    }

    // Configure the spinner
    private void configureSpinner() {
        Spinner allergicFood = findViewById(R.id.allergic_food_selection);

        String[] ingredients = {"Percil", "Hena Kisoa", "Voatabia"};
        ArrayAdapter<String> ingredients_adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, ingredients);
        allergicFood.setAdapter(ingredients_adapter);
    }
}