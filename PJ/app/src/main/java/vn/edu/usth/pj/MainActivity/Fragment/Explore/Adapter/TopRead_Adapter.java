package vn.edu.usth.pj.MainActivity.Fragment.Explore.Adapter;

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

import vn.edu.usth.pj.ArticleActivity.Article;
import vn.edu.usth.pj.R;

public class TopRead_Adapter extends RecyclerView.Adapter<TopRead_Adapter.ViewHolder> {
    private List<vn.edu.usth.pj.RestAPI.Explore.mostread.Article> TopreadArrayList;
    private Context context;
    private final int limit = 5;

    public TopRead_Adapter(List<vn.edu.usth.pj.RestAPI.Explore.mostread.Article> TopreadArrayList, Context context) {
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
        vn.edu.usth.pj.RestAPI.Explore.mostread.Article article = TopreadArrayList.get(position);
        holder.topread_title.setText(article.getTitle());
        holder.topread_desc.setText(article.getDescription());

        if (article.getThumbnail() != null){
            Picasso.get().load(article.getThumbnail().getSource()).into(holder.topread_thumb);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, Article.class);
                i.putExtra("pageid", TopreadArrayList.get(holder.getAdapterPosition()).getPageid());
                i.putExtra("title", TopreadArrayList.get(holder.getAdapterPosition()).getTitle());
                i.putExtra("desc", TopreadArrayList.get(holder.getAdapterPosition()).getDescription());
                if (article.getThumbnail().getSource() != null){
                    i.putExtra("thumbnail", TopreadArrayList.get(holder.getAdapterPosition()).getThumbnail().getSource());
                }
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        if (TopreadArrayList != null) {
            if (TopreadArrayList.size() > limit) {
                return limit;
            } else {
                return TopreadArrayList == null ? 0 : TopreadArrayList.size();
            }
        } else {
            return 0;
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
