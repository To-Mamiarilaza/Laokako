package mg.tomamiarilaza.laokako;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import mg.tomamiarilaza.laokako.menu.Ingredient;
import mg.tomamiarilaza.laokako.menu.Menu;
import mg.tomamiarilaza.laokako.parameter.Parameter;
import mg.tomamiarilaza.laokako.utils.AllergicFoodListAdapter;
import mg.tomamiarilaza.laokako.utils.IngredientListAdapter;
import mg.tomamiarilaza.laokako.utils.MenuListAdapter;

public class MenuListActivity extends AppCompatActivity {
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_list);
        context = this;

        Parameter.nbPerson = 1;
        Parameter.inflation = 0;

        configureRecyclerView();
        activateMenu();
        configureMenuIngredientSwitcher();

    }

    // give the menu and ingredient switcher button their listener and action
    private void configureMenuIngredientSwitcher() {
        Button menuListButton = findViewById(R.id.menu_list_button);
        menuListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(context, MenuListActivity.class);
                //startActivity(intent);
            }
        });

        Button ingredientListButton = findViewById(R.id.ingredient_list_button);
        ingredientListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, IngredientListActivity.class);
                startActivity(intent);
            }
        });

        Button addNewMenuButton = findViewById(R.id.add_new_menu_button);
        addNewMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MenuInsertionActivity.class);
                startActivity(intent);
            }
        });

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

    // Prepare the recyclerView
    private void configureRecyclerView() {
        RecyclerView recycler = findViewById(R.id.menu_list_display);

        // Brute data
        List<Menu> menus = Menu.getAllMenu();

        MenuListAdapter adapter = new MenuListAdapter(menus, this);
        recycler.setLayoutManager(new GridLayoutManager(this, 2));
        recycler.setAdapter(adapter);
    }

}
