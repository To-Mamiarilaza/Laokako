package mg.tomamiarilaza.laokako;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import mg.tomamiarilaza.laokako.menu.Ingredient;
import mg.tomamiarilaza.laokako.menu.Menu;
import mg.tomamiarilaza.laokako.utils.NewIngredientAdapter;

public class MenuInsertionActivity extends AppCompatActivity {
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_add_layout);
        context = this;
        configureIngredientChoiceSpinner();

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
                Intent intent = new Intent(context, ParameterActivity.class);
                startActivity(intent);
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
                //Intent intent = new Intent(context, MenuListActivity.class);
                //startActivity(intent);
            }
        });
    }

    private void configureRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.required_ingredient_list);

        Menu menu = Menu.findByName("Ravimbomanga");
        NewIngredientAdapter adapter = new NewIngredientAdapter(menu.getIngredients(), MenuInsertionActivity.this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void configureIngredientChoiceSpinner() {
        Spinner ingredientChoice = findViewById(R.id.ingredient_choice_spinner);

        String[] ingredients = {"Percil", "Hena kisoa", "Voatabia"};
        ArrayAdapter<String> ingredients_adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, ingredients);
        ingredientChoice.setAdapter(ingredients_adapter);
    }
}
