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
import mg.tomamiarilaza.laokako.menu.Ingredient;

public class IconDisplayAdapter extends RecyclerView.Adapter<IconDisplayAdapter.ViewHolder> {

    private List<Ingredient> ingredients;
    private Context context;

    // constructor
    public IconDisplayAdapter(List<Ingredient> ingredients, Context context) {
        this.ingredients = ingredients;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.allergic_food_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Ingredient ingredient = ingredients.get(position);

        int resId = context.getResources().getIdentifier(ingredient.getIcon().getIconName(), "drawable", context.getPackageName());
        holder.iconImageView.setImageResource(resId);

        holder.ingredientName.setText(ingredient.getName());
    }

    @Override
    public int getItemCount() {
        return this.ingredients.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iconImageView;
        TextView ingredientName;
        TextView deleteButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iconImageView = itemView.findViewById(R.id.allergic_food_icon);
            ingredientName = itemView.findViewById(R.id.allergic_food_name);
            deleteButton = itemView.findViewById(R.id.delete_allergic_food_button);
        }
    }
}
