package vn.edu.usth.pj;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vn.edu.usth.pj.MainPage.Articles;

public class View_Page extends RecyclerView.Adapter<View_Page.ViewHolder> implements Filterable {
    private List<Articles> articlesArrayList;
    private List<Articles> articlesArrayList_search;
    private Context context;

    public View_Page(List<Articles> articlesArrayList, Context context) {
        this.articlesArrayList = articlesArrayList;
        this.articlesArrayList_search = articlesArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public View_Page.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        android.view.View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_layout, parent, false);
        return new View_Page.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull View_Page.ViewHolder holder,int position) {
        Articles articles = articlesArrayList.get(position);
        holder.textV.setText(articles.getParse().getText());

    }

    @Override
    public int getItemCount() {
        return articlesArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textV;
        public ViewHolder(@NonNull android.view.View itemView) {
            super(itemView);
            textV = itemView.findViewById(R.id.tfa_title);
        }
    }

    @Override
    public Filter getFilter() {
        return new Filter(){

            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String search = charSequence.toString();
                if (search.isEmpty()){
                    articlesArrayList = articlesArrayList_search;
                }
                else{
                    List<Articles> list = new ArrayList<>();
                    for (Articles i: articlesArrayList_search){
                        if (i.getParse().getText().toLowerCase().contains(search.toLowerCase())){
                            list.add(i);
                        }
                    }
                    articlesArrayList = list;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = articlesArrayList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                articlesArrayList = (List<Articles>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
}
