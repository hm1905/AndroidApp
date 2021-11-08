package vn.edu.usth.pj.Explore.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import vn.edu.usth.pj.R;
import vn.edu.usth.pj.SearchActivity.Page;
import vn.edu.usth.pj.testingAPI.Explore.mostread.Article;

public class TopRead_Adapter extends RecyclerView.Adapter<TopRead_Adapter.ViewHolder> {
    private List<Article> TopreadArrayList;
    private Context context;
    private final int limit = 5;

    public TopRead_Adapter(List<Article> TopreadArrayList, Context context) {
        this.TopreadArrayList = TopreadArrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public TopRead_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        android.view.View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.topread_layout, parent, false);
        return new TopRead_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopRead_Adapter.ViewHolder holder, int position) {
        Article article = TopreadArrayList.get(position);
        holder.topread_title.setText(article.getTitle());
        holder.topread_desc.setText(article.getDescription());

        if (article.getThumbnail() != null){
            Picasso.get().load(article.getThumbnail().getSource()).into(holder.topread_thumb);
        }

    }

    @Override
    public int getItemCount() {
        if (TopreadArrayList.size() > limit){
            return limit;
        }
        else{
            return TopreadArrayList == null ? 0 : TopreadArrayList.size();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView topread_title, topread_desc;
        private ImageView topread_thumb;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            topread_title = itemView.findViewById(R.id.topread_title);
            topread_desc = itemView.findViewById(R.id.topread_desc);
            topread_thumb = itemView.findViewById(R.id.topread_thumb);
        }
    }
}
