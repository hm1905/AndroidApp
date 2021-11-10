package vn.edu.usth.pj.MainActivity;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import vn.edu.usth.pj.R;
import vn.edu.usth.pj.SettingsActivity;
import vn.edu.usth.pj.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    FloatingActionButton floatAct;
    ViewPager2 viewPager2;
    ViewPagerAdapter adapter;



    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(android.R.color.transparent)));
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"black\">" + getString(R.string.app_name) + "</font>"));


        viewPager2 = (ViewPager2) findViewById(R.id.reFrame);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomnavigationbar);

        adapter = new ViewPagerAdapter(this);
        viewPager2.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position){
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.home).setChecked(true);
                        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"black\">" + getString(R.string.app_name) + "</font>"));
                        adapter.notifyDataSetChanged();
                        break;
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.search).setChecked(true);
                        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"black\">" + "Search" + "</font>"));
                        adapter.notifyDataSetChanged();
                        break;
                    case 2:
                        bottomNavigationView.getMenu().findItem(R.id.personal).setChecked(true);
                        break;
                    case 3:
                        bottomNavigationView.getMenu().findItem(R.id.saved).setChecked(true);
                        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"black\">" + "Saved"+ "</font>"));
                        adapter.notifyDataSetChanged();
                        break;
                }
            }
        });



        bottomNavigationView.setBackground(null);
        bottomNavigationView.getMenu().getItem(2).setEnabled(false);

        //getSupportFragmentManager().beginTransaction().replace(R.id.reFrame,new Home()).commit();

        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.home :
                        viewPager2.setCurrentItem(0);
                        item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem menuItem) {
                                recreate();
                                return false;
                            }
                        });
//                        getSupportFragmentManager().beginTransaction().replace(R.id.reFrame,new Home()).commit();
                       break;
                    case R.id.search :
                        viewPager2.setCurrentItem(1);
                        //getSupportFragmentManager().beginTransaction().replace(R.id.reFrame,new Search()).commit();
                        break;
                    case R.id.saved :
                        viewPager2.setCurrentItem(3);
                        //getSupportFragmentManager().beginTransaction().replace(R.id.reFrame,new Saved()).commit();
                        break;
                    case R.id.setting :
                         Intent pref = new Intent(getApplicationContext(), SettingsActivity.class);
                         startActivity(pref);
                         break;
                }
                return true;
            }
        });

        floatAct = (FloatingActionButton) findViewById(R.id.person);
        floatAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager2.setCurrentItem(2);
                //getSupportFragmentManager().beginTransaction().replace(R.id.reFrame,new Account()).commit();
            }
        });


    }

    @Override
    public void onRestart() {
        super.onRestart();
        recreate();

    }
}