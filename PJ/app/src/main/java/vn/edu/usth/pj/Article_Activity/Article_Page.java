package vn.edu.usth.pj.Article_Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.edu.usth.pj.History.History;
import vn.edu.usth.pj.R;
import vn.edu.usth.pj.RestAPI.RetrofitAPI;
import vn.edu.usth.pj.RestAPI.Service;
import vn.edu.usth.pj.Save_Page;
import vn.edu.usth.pj.SearchActivity.Searching_Activity;
import vn.edu.usth.pj.database.History.HistoryDatabase;
import vn.edu.usth.pj.database.SavedDatabase;



public class Article_Page extends AppCompatActivity {
    String title, desc, thumbnail;
    Integer pageid;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_page);
        pageid = getIntent().getIntExtra("pageid", 0);
        title = getIntent().getStringExtra("title");
        desc = getIntent().getStringExtra("desc");
        if (getIntent().getStringExtra("thumbnail") != null){
            thumbnail = getIntent().getStringExtra("thumbnail");
        } else {
            thumbnail = "none";
        }
        setPageContent(pageid);

        History history = new History(pageid, title ,thumbnail);
        HistoryDatabase.getInstance(getApplicationContext()).historyDAO().insertAll(history);


        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView_page);
        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.save:
                        Save_Page save_page = new Save_Page(title, desc, pageid, thumbnail);
                        SavedDatabase.getInstance(getApplicationContext()).saveDAO().insertAll(save_page);
                        Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
                }
                return true;
            }
        });

    }

    private void setPageContent(Integer pageid) {
        WebView webView = (WebView) findViewById(R.id.pageview);
        RetrofitAPI wikiApi = Service.createService(RetrofitAPI.class);
        Call<Article_FM> call = wikiApi.getArticle_Page(pageid);

        call.enqueue(new Callback<Article_FM>() {
            @Override
            public void onResponse(Call<Article_FM> call, Response<Article_FM> response) {
                Article_FM fm = response.body();

                webView.loadData(fm.getParse().getText(), "text/html; charset=UTF-8", null);
            }

            @Override
            public void onFailure(Call<Article_FM> call, Throwable t) {
                Toast.makeText(Article_Page.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });

    }
}