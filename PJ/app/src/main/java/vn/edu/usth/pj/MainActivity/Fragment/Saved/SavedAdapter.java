package vn.edu.usth.pj.MainActivity.Fragment.Saved;

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
import vn.edu.usth.pj.Database.Saved.Saved;
import vn.edu.usth.pj.R;

public class SavedAdapter extends RecyclerView.Adapter<SavedAdapter.ViewHolder> {
    private List<Saved> Save_pageArraylist;
    private Context context;

    public SavedAdapter(List<Saved> Save_pageArraylist, Context context) {
        this.Save_pageArraylist = Save_pageArraylist;
        this.context = context;
    }
    @NonNull
    @Override
    public SavedAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        android.view.View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.saved_layout, parent, false);
        return new SavedAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Saved save_page = Save_pageArraylist.get(position);

        holder.save_title.setText(save_page.getTitle());
        holder.save_desc.setText(save_page.getDesc());

        if (!save_page.getThumbnail().equals("none")){
            Picasso.get().load(save_page.getThumbnail()).into(holder.save_thumbnail);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, Article.class);
                i.putExtra("pageid", Save_pageArraylist.get(holder.getAdapterPosition()).getPageid());
                i.putExtra("title", Save_pageArraylist.get(holder.getAdapterPosition()).getTitle());

                if (save_page.getThumbnail() != null){
                    i.putExtra("thumbnail", Save_pageArraylist.get(holder.getAdapterPosition()).getThumbnail());
                }
                context.startActivity(i);

                context.startActivity(i);
            }
        });

    }


    @Override
    public int getItemCount() {
        return Save_pageArraylist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView save_title, save_desc;
        private ImageView save_thumbnail;
        public ViewHolder(android.view.View itemView) {
            super(itemView);
            save_title = itemView.findViewById(R.id.topread_title);
            save_desc = itemView.findViewById(R.id.topread_desc);
            save_thumbnail = itemView.findViewById(R.id.topread_thumb);
        }
    }

    public void getSave(List<Saved> list){
        this.Save_pageArraylist = list;
        notifyDataSetChanged();
    }
}
