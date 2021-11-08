package vn.edu.usth.pj.SearchActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.edu.usth.pj.R;
import vn.edu.usth.pj.RestAPI.RetrofitAPI;
import vn.edu.usth.pj.RestAPI.Service;
import vn.edu.usth.pj.testingAPI.Service2;


public class Searching_Activity extends AppCompatActivity {

    private RecyclerView rview;
    private Search_Adapter S_adapter;
    private Query query;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        rview = (RecyclerView) findViewById(R.id.search_result);
        rview.setLayoutManager(new LinearLayoutManager(this));


        SearchView searchView = (SearchView) findViewById(R.id.search_act);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (query.length() > 1){
                    fetchSearch(query);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText.length() > 1){
                    fetchSearch(newText);
                }
                return false;
            }
        });
    }

    public void fetchSearch(String gsrsearch){
        RetrofitAPI wikiApi = Service.createService(RetrofitAPI.class);
        Call<Example> call = wikiApi.getQuery(gsrsearch);

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Example example = response.body();

                S_adapter = new Search_Adapter(example.getQuery().getPages(),Searching_Activity.this);
                rview.setAdapter(S_adapter);

                S_adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Toast.makeText(Searching_Activity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

}