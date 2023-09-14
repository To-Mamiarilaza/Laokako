package mg.tomamiarilaza.laokako.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import mg.tomamiarilaza.laokako.R;
import mg.tomamiarilaza.laokako.history.History;

public class HistoryListAdapter extends RecyclerView.Adapter<HistoryListAdapter.ViewHolder> {

    List<History> histories;
    Context context;

    // constructor
    public HistoryListAdapter(List<History> histories, Context context) {
        this.histories = histories;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_menu_list_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        History history = histories.get(position);

        int resId = context.getResources().getIdentifier(history.getMenu().getBackPicture(), "drawable", context.getPackageName());
        holder.menuPicture.setImageResource(resId);

        holder.menuName.setText(history.getMenu().getName());
        holder.historyDate.setText(history.getDate());
    }

    @Override
    public int getItemCount() {
        return histories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView menuPicture;
        TextView menuName;
        TextView historyDate;
        Button deleteButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            menuPicture = itemView.findViewById(R.id.menu_picture);
            menuName = itemView.findViewById(R.id.menu_name);
            historyDate = itemView.findViewById(R.id.history_date);
            deleteButton = itemView.findViewById(R.id.history_delete_button);
        }
    }
}
