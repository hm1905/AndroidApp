package vn.edu.usth.pj.SearchActivity;

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


public class Search_Adapter extends RecyclerView.Adapter<Search_Adapter.ViewHolder> {
    private List<Page> Search_AdapterArraylist;
    private Context context;

    public Search_Adapter(List<Page> Search_AdapterArraylist, Context context) {
        this.Search_AdapterArraylist = Search_AdapterArraylist;
        this.context = context;
    }
    @NonNull
    @Override
    public Search_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        android.view.View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.searchresult_layout, parent, false);
        return new Search_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Page page = Search_AdapterArraylist.get(position);
        holder.search_title.setText(page.getTitle());
        holder.search_desc.setText(page.getDescription());

        if (page.getThumbnail() != null){
            Picasso.get().load(page.getThumbnail().getSource()).into(holder.search_img);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, Article.class);
                i.putExtra("pageid", Search_AdapterArraylist.get(holder.getAdapterPosition()).getPageid());
                i.putExtra("title", Search_AdapterArraylist.get(holder.getAdapterPosition()).getTitle());
                i.putExtra("desc", Search_AdapterArraylist.get(holder.getAdapterPosition()).getDescription());
                if (page.getThumbnail() != null){
                    i.putExtra("thumbnail", Search_AdapterArraylist.get(holder.getAdapterPosition()).getThumbnail().getSource());
                }
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return Search_AdapterArraylist == null ? 0 : Search_AdapterArraylist.size();
        //return Search_AdapterArraylist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView search_title, search_desc;
        private ImageView search_img;
        public ViewHolder(android.view.View itemView) {
            super(itemView);
            search_title = itemView.findViewById(R.id.Rtitle);
            search_desc = itemView.findViewById(R.id.Rdesc);
            search_img = itemView.findViewById(R.id.Rimg);
        }
    }
}
