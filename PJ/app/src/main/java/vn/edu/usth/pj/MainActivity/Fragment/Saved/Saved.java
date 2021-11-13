package vn.edu.usth.pj.MainActivity.Fragment.Saved;

import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import vn.edu.usth.pj.R;
import vn.edu.usth.pj.Database.Saved.SavedDatabase;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Saved#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Saved extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private RecyclerView rview;
    private SavedAdapter view_save;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Saved() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment History.
     */
    // TODO: Rename and change types and number of parameters
    public static Saved newInstance(String param1, String param2) {
        Saved fragment = new Saved();
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

        setHasOptionsMenu(true);
    }


    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.save_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
        Drawable yourdrawable = menu.getItem(0).getIcon();
        yourdrawable.mutate();
        yourdrawable.setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.SRC_IN);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_saved, container, false);
        List<vn.edu.usth.pj.Database.Saved.Saved> list = new ArrayList<>();
        list = SavedDatabase.getInstance(getContext()).saveDAO().getAll();

        rview = (RecyclerView) rootView.findViewById(R.id.save_home);
        rview.setLayoutManager(new LinearLayoutManager(getContext()));
        view_save = new SavedAdapter(list, getContext());
        rview.setAdapter(view_save);

        return rootView;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.delete:
                new AlertDialog.Builder(getContext()).setTitle("Confirm to delete Saved")
                        .setNegativeButton("No", null)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                SavedDatabase.getInstance(getContext()).saveDAO().deleteAll();
                                Toast.makeText(getContext(), "Delete Successful", Toast.LENGTH_LONG).show();
                                getActivity().recreate();
                            }
                        })
                        .show();
                break;
        }
        return true;
    }
}