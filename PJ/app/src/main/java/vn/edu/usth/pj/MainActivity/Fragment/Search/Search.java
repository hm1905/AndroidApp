package vn.edu.usth.pj.MainActivity.Fragment.Search;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import vn.edu.usth.pj.Database.History.History;
import vn.edu.usth.pj.MainActivity.Fragment.Search.History.HistoryAdapter;
import vn.edu.usth.pj.R;
import vn.edu.usth.pj.SearchActivity.Searching_Activity;
import vn.edu.usth.pj.Database.History.HistoryDatabase;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Search#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Search extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";



    private RecyclerView rview;
    private HistoryAdapter history;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Search() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Search.
     */
    // TODO: Rename and change types and number of parameters
    public static Search newInstance(String param1, String param2) {
        Search fragment = new Search();
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
        View rootView = inflater.inflate(R.layout.fragment_search, container, false);
        ImageButton button = (ImageButton) rootView.findViewById(R.id.searchview);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), Searching_Activity.class);
                startActivity(i);
            }
        });

        List<History> list = new ArrayList<>();
        list = HistoryDatabase.getInstance(getContext()).historyDAO().getAll();
        rview = (RecyclerView) rootView.findViewById(R.id.search_history);
        rview.setLayoutManager(new LinearLayoutManager(getContext()));
        history = new HistoryAdapter(list, getContext());
        rview.setAdapter(history);

        Button delete = (Button) rootView.findViewById(R.id.delete_history);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(getContext()).setTitle("Clear browsing history")
                        .setNegativeButton("No", null)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                HistoryDatabase.getInstance(getContext()).historyDAO().deleteAll();
                                Toast.makeText(getContext(), "Delete Successful", Toast.LENGTH_LONG).show();
                                getActivity().recreate();
                            }
                        })
                        .show();
            }
        });

        return  rootView;
    }
}