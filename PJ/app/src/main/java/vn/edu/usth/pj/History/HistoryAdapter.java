package vn.edu.usth.pj.History;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import vn.edu.usth.pj.Article_Activity.Article_Page;
import vn.edu.usth.pj.R;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {
    private List<History> HistoryAdapterArrayList;
    private Context context;

    public HistoryAdapter(List<History> HistoryAdapterArrayList, Context context){
        this.HistoryAdapterArrayList = HistoryAdapterArrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public HistoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        android.view.View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_layout, parent, false);
        return new HistoryAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull HistoryAdapter.ViewHolder holder, int position) {
        History history = HistoryAdapterArrayList.get(position);
        holder.history_title.setText(history.getTitle());

        if (history.getThumbnail() != null){
            Picasso.get().load(history.getThumbnail()).into(holder.history_thumb);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, Article_Page.class);
                i.putExtra("pageid", HistoryAdapterArrayList.get(holder.getAdapterPosition()).getPageid());
                i.putExtra("title", HistoryAdapterArrayList.get(holder.getAdapterPosition()).getTitle());

                if (history.getThumbnail() != null){
                    i.putExtra("thumbnail", HistoryAdapterArrayList.get(holder.getAdapterPosition()).getThumbnail());
                }
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return HistoryAdapterArrayList == null ? 0 : HistoryAdapterArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView history_title;
        private ImageView history_thumb;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            history_title = itemView.findViewById(R.id.history_title);
            history_thumb = itemView.findViewById(R.id.history_img);
        }
    }
}
