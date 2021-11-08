package vn.edu.usth.pj;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import vn.edu.usth.pj.Explore.Explore;
import vn.edu.usth.pj.MainActivity.Fragment.Account;
import vn.edu.usth.pj.MainActivity.Fragment.Home;
import vn.edu.usth.pj.MainActivity.Fragment.Saved;
import vn.edu.usth.pj.MainActivity.Fragment.Search;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0: return new Explore();
            case 1: return new Search();
            case 2: return new Account();
            case 3: return new Saved();
        }
        return new Home();
    }

    @Override
    public int getItemCount() {
        return 4;
    }


}
