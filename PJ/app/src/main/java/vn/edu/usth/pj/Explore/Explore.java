package vn.edu.usth.pj.Explore;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.edu.usth.pj.Article_Activity.Article_Page;
import vn.edu.usth.pj.Explore.Adapter.News_Adapter;
import vn.edu.usth.pj.Explore.Adapter.TopRead_Adapter;
import vn.edu.usth.pj.R;
import vn.edu.usth.pj.SearchActivity.Searching_Activity;
import vn.edu.usth.pj.testingAPI.Explore.Example;
import vn.edu.usth.pj.testingAPI.REST_BASE;
import vn.edu.usth.pj.testingAPI.Service2;

import android.text.format.DateFormat;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Explore#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Explore extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private RecyclerView rnews;
    private RecyclerView rmostread;

    private News_Adapter newAP;
    private TopRead_Adapter topAP;

    private TextView tfa_title, tfa_desc, tfa_extract;
    private ImageView tfa_thumb;
    private CardView cardView;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Explore() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Explore.
     */
    // TODO: Rename and change types and number of parameters
    public static Explore newInstance(String param1, String param2) {
        Explore fragment = new Explore();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_explore, container, false);

        //Get Date
        Integer y = Calendar.getInstance().get(Calendar.YEAR);
        String yyyy = Integer.toString(y);

        Integer m = Calendar.getInstance().get(Calendar.MONTH);
        String mm = Integer.toString(m+1);

        Integer d = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

        String dd;
        if (d<10){
            dd = "0"+Integer.toString(d);
        } else{
            dd = Integer.toString(d);
        }

        tfa_title = rootView.findViewById(R.id.tfa_title);
        tfa_desc = rootView.findViewById(R.id.tfa_desc);
        tfa_thumb = rootView.findViewById(R.id.tfa_img);
        tfa_extract = rootView.findViewById(R.id.tfa_extract);
        cardView = rootView.findViewById(R.id.tfa);

        rmostread = rootView.findViewById(R.id.topread_recycle);
        rmostread.setLayoutManager(new LinearLayoutManager(getContext()));

        rnews = rootView.findViewById(R.id.news_recycle);
        rnews.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, true));


        REST_BASE restapi = Service2.createService2(REST_BASE.class);
        Call<Example> call = restapi.getExplore(yyyy, mm, dd);

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                if (response.isSuccessful()){
                    Example explore = response.body();
                    tfa_title.setText(explore.getTfa().getTitles().getDisplay());
                    tfa_desc.setText(explore.getTfa().getDescription());
                    tfa_extract.setText(explore.getTfa().getExtract());

                    try{
                        Picasso.get().load(explore.getTfa().getOriginalimage().getSource()).into(tfa_thumb);
                    } catch (Exception e){
                        Log.e("Thumb", e.getMessage());
                    }

                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent i = new Intent(getContext(), Article_Page.class);
                            i.putExtra("pageid", explore.getTfa().getPageid());
                            getContext().startActivity(i);
                        }
                    });

                    topAP = new TopRead_Adapter(explore.getMostread().getArticles() ,getContext());
                    rmostread.setAdapter(topAP);
                    topAP.notifyDataSetChanged();

                    newAP = new News_Adapter(explore.getNews() ,getContext());
                    rnews.setAdapter(newAP);
                    newAP.notifyDataSetChanged();
                }
                else{
                    Toast.makeText(getContext(), "Failed", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Toast.makeText(getContext(), "Failed to load", Toast.LENGTH_SHORT).show();
                Log.e("ThrowableExplore", t.toString());
            }
        });

        //Open search act
        ImageButton button = (ImageButton) rootView.findViewById(R.id.searchview_home);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), Searching_Activity.class);
                startActivity(i);
            }
        });




        return rootView;
    }
}