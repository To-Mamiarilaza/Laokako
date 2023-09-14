package mg.tomamiarilaza.laokako.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import mg.tomamiarilaza.laokako.R;
import mg.tomamiarilaza.laokako.icon.Icon;

public class IconChoiceAdapter extends RecyclerView.Adapter<IconChoiceAdapter.ViewHolder> {

    // field
    List<Icon> icons;
    Context context;

    // constructor

    public IconChoiceAdapter(List<Icon> icons, Context context) {
        this.icons = icons;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.icon_container, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Icon icon = icons.get(position);

        int resId = context.getResources().getIdentifier(icon.getIconName(), "drawable", context.getPackageName());
        holder.iconPicture.setImageResource(resId);
    }

    @Override
    public int getItemCount() {
        return icons.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iconPicture;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            iconPicture = itemView.findViewById(R.id.icon_picture);
        }
    }
}
