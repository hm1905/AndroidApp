package vn.edu.usth.pj;

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

public class View_Save extends RecyclerView.Adapter<View_Save.ViewHolder> {
    private List<Save_Page> Save_pageArraylist;
    private Context context;

    public View_Save(List<Save_Page> Save_pageArraylist, Context context) {
        this.Save_pageArraylist = Save_pageArraylist;
        this.context = context;
    }
    @NonNull
    @Override
    public View_Save.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        android.view.View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.saved_layout, parent, false);
        return new View_Save.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Save_Page save_page = Save_pageArraylist.get(position);

        holder.save_title.setText(save_page.getTitle());
        holder.save_desc.setText(save_page.getDesc());

        if (!save_page.getThumbnail().equals("none")){
            Picasso.get().load(save_page.getThumbnail()).into(holder.save_thumbnail);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, Article_Page.class);
                i.putExtra("pageid", Save_pageArraylist.get(holder.getAdapterPosition()).getPageid());
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

    public void getSave(List<Save_Page> list){
        this.Save_pageArraylist = list;
        notifyDataSetChanged();
    }
}
