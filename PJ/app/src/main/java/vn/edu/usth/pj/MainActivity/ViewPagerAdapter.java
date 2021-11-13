package vn.edu.usth.pj.MainActivity;

import static androidx.viewpager.widget.PagerAdapter.POSITION_NONE;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import vn.edu.usth.pj.MainActivity.Fragment.Explore.Explore;
import vn.edu.usth.pj.MainActivity.Fragment.Account;
import vn.edu.usth.pj.MainActivity.Fragment.Saved.Saved;
import vn.edu.usth.pj.MainActivity.Fragment.Search.Search;

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
        return new Explore();
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }


}
