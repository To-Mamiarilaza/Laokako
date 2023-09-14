package mg.tomamiarilaza.laokako.utils;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import mg.tomamiarilaza.laokako.R;
import mg.tomamiarilaza.laokako.menu.Ingredient;

public class IngredientParameterListAdapter extends RecyclerView.Adapter<IngredientParameterListAdapter.ViewHolder> {

    List<Ingredient> ingredients;
    Context context;


    // constructor
    public IngredientParameterListAdapter(List<Ingredient> ingredients, Context context) {
        this.ingredients = ingredients;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ingredient_parameter_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Ingredient ingredient = ingredients.get(position);

        int resId = context.getResources().getIdentifier(ingredient.getIcon().getIconName(), "drawable", context.getPackageName());
        holder.ingredientIcon.setImageResource(resId);

        holder.ingredientName.setText(ingredient.getName());
    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ingredientIcon;
        TextView ingredientName;
        ImageView editButton;
        ImageView deleteButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ingredientIcon = itemView.findViewById(R.id.ingredient_icon);
            ingredientName = itemView.findViewById(R.id.ingredient_name);
            editButton = itemView.findViewById(R.id.edit_button);
            deleteButton = itemView.findViewById(R.id.delete_button);
        }
    }
}
