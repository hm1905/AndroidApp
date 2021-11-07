package vn.edu.usth.pj.MainActivity;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import vn.edu.usth.pj.R;
import vn.edu.usth.pj.SettingsActivity;
import vn.edu.usth.pj.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {
//831ec66c83c84a2792b943a37e1e3e56
    BottomNavigationView bottomNavigationView;
    FloatingActionButton floatAct;
    ViewPager2 viewPager2;



    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager2 = (ViewPager2) findViewById(R.id.reFrame);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomnavigationbar);

        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        viewPager2.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position){
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.home).setChecked(true);
                        setTitle("WikipediA");
                        break;
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.search).setChecked(true);
                        setTitle("Search");
                        break;
                    case 2:
                        bottomNavigationView.getMenu().findItem(R.id.personal).setChecked(true);
                        break;
                    case 3:
                        bottomNavigationView.getMenu().findItem(R.id.saved).setChecked(true);
                        setTitle("Saved");
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
}