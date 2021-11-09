package vn.edu.usth.pj.Article_Activity;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.lang.reflect.Method;

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
    androidx.appcompat.widget.SearchView search;
    private AppCompatImageButton nextButton, prevButton, closeButton;
    private WebView webView;
    private RelativeLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        search = findViewById(R.id.search_in_page);
        nextButton = findViewById(R.id.nextButton);
        prevButton = findViewById(R.id.prevButton);
        closeButton = findViewById(R.id.end);
        container = findViewById(R.id.searchtx);

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
                    case R.id.search_in:
                        getSupportActionBar().hide();
                        container.setVisibility(VISIBLE);
                        searchtx();
                }
                return true;
            }
        });

    }

    public void searchtx() {

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.findNext(true);
            }
        });


        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                container.removeAllViews();
                container.setVisibility(INVISIBLE);
                getSupportActionBar().show();

            }
        });

//        search.setMinEms(30);
//        search.setSingleLine(true);
//
//
//        search.setOnKeyListener(new View.OnKeyListener() {
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if ((event.getAction() == KeyEvent.ACTION_DOWN) && ((keyCode == KeyEvent.KEYCODE_ENTER))) {
//                    webView.findAllAsync(search.getText().toString());
//                    try {
//                        Method m = WebView.class.getMethod("setFindIsUp", Boolean.TYPE);
//                        m.invoke(webView, true);
//                    } catch (Exception ignored) {
//                    }
//                }
//                return false;
//            }
//        });

        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                webView.findAllAsync(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                webView.findAllAsync(newText);
                return false;
            }
        });

        //container.addView(webView);
    }

    private void setPageContent(Integer pageid) {
        webView = (WebView) findViewById(R.id.pageview);
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        setTitle("");
        inflater.inflate(R.menu.toolbar, menu);
        return true;
    }
}