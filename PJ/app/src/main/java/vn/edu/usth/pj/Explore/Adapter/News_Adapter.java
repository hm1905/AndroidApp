package vn.edu.usth.pj.Explore.Adapter;

import android.content.Context;
import android.text.Html;
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
import vn.edu.usth.pj.testingAPI.Explore.news.Link;
import vn.edu.usth.pj.testingAPI.Explore.news.News;


public class News_Adapter extends RecyclerView.Adapter<News_Adapter.ViewHolder>{
    private List<News> News_AdapterArrayList;
    private Context context;
    private final int limit = 5;

    public News_Adapter(List<News> News_AdapterArrayList, Context context) {
        this.News_AdapterArrayList = News_AdapterArrayList;
        this.context = context;
    }
    @NonNull
    @Override
    public News_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        android.view.View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_layout, parent, false);
        return new News_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull News_Adapter.ViewHolder holder, int position) {
        News news = News_AdapterArrayList.get(position);
        holder.news_title.setText(Html.fromHtml(news.getStory()));

        List<Link> link = news.getLinks();
//        for (Link i:link){
//            if (i.getThumbnail().getSource() != null){
//                Picasso.get().load(i.getThumbnail().getSource()).into(holder.news_thumb);
//            }
//        }

    }

    @Override
    public int getItemCount() {
        if(News_AdapterArrayList.size()>limit){
            return limit;
        }
        else{
            return News_AdapterArrayList == null ? 0 : News_AdapterArrayList.size();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView news_title;
        private ImageView news_thumb;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            news_title = itemView.findViewById(R.id.news_story);
            news_thumb = itemView.findViewById(R.id.news_thumb);
        }
    }
}
