package comqqqq.example.wxw.xdayzou2.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by wxw on 2019/9/22.
 */

public class MyVp extends FragmentPagerAdapter{
    private List<Fragment> list1;

    public MyVp(FragmentManager fm, List<Fragment> list1) {
        super(fm);
        this.list1 = list1;
    }

    @Override
    public Fragment getItem(int position) {
        return list1.get(position);
    }

    @Override
    public int getCount() {
        return list1.size();
    }
}
