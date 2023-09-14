package mg.tomamiarilaza.laokako;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import mg.tomamiarilaza.laokako.history.History;
import mg.tomamiarilaza.laokako.menu.Menu;
import mg.tomamiarilaza.laokako.utils.HistoryListAdapter;
import mg.tomamiarilaza.laokako.utils.IngredientListAdapter;

public class HistoryActivity extends AppCompatActivity {
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_layout);
        context = this;
        configureHistoryList();

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
                //Intent intent = new Intent(context, HistoryActivity.class);
                //startActivity(intent);
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


    // Configure the recyclerView of the history
    private void configureHistoryList() {
        RecyclerView recyclerView = findViewById(R.id.history_list);

        List<History> histories = History.getLastHistories();
        HistoryListAdapter adapter = new HistoryListAdapter(histories, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

}
