package mg.tomamiarilaza.laokako;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import mg.tomamiarilaza.laokako.utils.FilterPopup;

public class MainActivity extends AppCompatActivity {
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.proposition_activity);

        // Show popup when clicking filter button
        ImageView filterButton = findViewById(R.id.filter_button);
        filterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FilterPopup filterPopup = new FilterPopup(MainActivity.this);
                filterPopup.show();
            }
        });

        activateMenu();
        activateMenuDetailSwitcher();

    }

    private void activateMenuDetailSwitcher() {
        Button menuDetailButton = findViewById(R.id.menu_detail_button);
        menuDetailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToMenuDetail();
            }
        });

        ImageView validateMenuButton = findViewById(R.id.validate_menu_icon);
        validateMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToMenuDetail();
            }
        });
    }

    private void switchToMenuDetail() {
        Intent intent = new Intent(context, MenuDetailActivity.class);
        startActivity(intent);
    }

    // give the menu their listener and action
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
                //Intent intent = new Intent(context, ParameterActivity.class);
                //startActivity(intent);
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
}