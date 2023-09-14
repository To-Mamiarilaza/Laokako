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
import mg.tomamiarilaza.laokako.menu.Menu;

public class MenuListAdapter extends RecyclerView.Adapter<MenuListAdapter.ViewHolder> {

    List<Menu> menus;
    Context context;


    // constructor
    public MenuListAdapter(List<Menu> menus, Context context) {
        this.menus = menus;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_card_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Menu menu = menus.get(position);

        int resId = context.getResources().getIdentifier(menu.getBackPicture(), "drawable", context.getPackageName());
        holder.menuPicture.setImageResource(resId);

        holder.menuName.setText(menu.getName());

        holder.menuDuration.setText(String.valueOf(menu.getDuration()) + " min");

        holder.menuPrice.setText("Ar " + String.valueOf((int) menu.getPrice()));
    }

    @Override
    public int getItemCount() {
        return menus.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView menuPicture;
        TextView menuName;
        TextView menuPrice;
        TextView menuDuration;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            menuPicture = itemView.findViewById(R.id.menu_picture);
            menuName = itemView.findViewById(R.id.menu_name);
            menuPrice = itemView.findViewById(R.id.menu_price);
            menuDuration = itemView.findViewById(R.id.menu_duration);
        }
    }
}
