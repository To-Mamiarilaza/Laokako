package mg.tomamiarilaza.laokako.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import mg.tomamiarilaza.laokako.R;
import mg.tomamiarilaza.laokako.menu.IngredientQuantity;

public class IngredientListAdapter extends RecyclerView.Adapter<IngredientListAdapter.ViewHolder> {
    private List<IngredientQuantity> ingredients;
    private Context context;

    // constructor
    public IngredientListAdapter(List<IngredientQuantity> ingredients, Context context) {
        this.ingredients = ingredients;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ingredient_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        IngredientQuantity ingredient = ingredients.get(position);

        // resource icon
        int resId = context.getResources().getIdentifier(ingredient.getIngredient().getIcon().getIconName(), "drawable", context.getPackageName());
        holder.iconImageView.setImageResource(resId);

        holder.ingredientName.setText(ingredient.getIngredient().getName());

        holder.ingredientPrice.setText("Ar  " + String.valueOf(ingredient.getPrice()));

        if (ingredient.isPrincipal()) holder.bottomLine.setBackgroundColor(context.getResources().getColor(R.color.principal_color, context.getTheme()));

    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iconImageView;
        TextView ingredientName;
        TextView ingredientPrice;
        View bottomLine;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iconImageView = itemView.findViewById(R.id.ingredient_icon);
            ingredientName = itemView.findViewById(R.id.ingredient_name);
            ingredientPrice = itemView.findViewById(R.id.ingredient_price);
            bottomLine = itemView.findViewById(R.id.bottom_line);
        }
    }

}
