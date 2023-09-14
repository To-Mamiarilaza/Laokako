package mg.tomamiarilaza.laokako.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import mg.tomamiarilaza.laokako.R;
import mg.tomamiarilaza.laokako.menu.Ingredient;
import mg.tomamiarilaza.laokako.menu.IngredientQuantity;

public class NewIngredientAdapter extends RecyclerView.Adapter<NewIngredientAdapter.ViewHolder> {

    List<IngredientQuantity> ingredients;
    Context context;

    public NewIngredientAdapter(List<IngredientQuantity> ingredients, Context context) {
        this.ingredients = ingredients;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.add_ingredient_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        IngredientQuantity ingredient = ingredients.get(position);

        int resId = context.getResources().getIdentifier(ingredient.getIngredient().getIcon().getIconName(), "drawable", context.getPackageName());
        holder.ingredientIcon.setImageResource(resId);

        holder.ingredientName.setText(ingredient.getIngredient().getName());

        holder.ingredientPrice.setText(String.valueOf((int) ingredient.getPrice()) + " Ar");
    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ingredientIcon;
        TextView ingredientName;
        TextView ingredientPrice;
        CheckBox isPrimary;
        ImageView reject;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ingredientIcon = itemView.findViewById(R.id.ingredient_icon);
            ingredientName = itemView.findViewById(R.id.ingredient_name);
            ingredientPrice = itemView.findViewById(R.id.ingredient_price);
            isPrimary = itemView.findViewById(R.id.is_primary_ingredient);
            reject = itemView.findViewById(R.id.reject_new_ingredient);
        }
    }
}
