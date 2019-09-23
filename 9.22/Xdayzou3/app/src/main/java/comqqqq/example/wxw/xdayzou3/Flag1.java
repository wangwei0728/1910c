package comqqqq.example.wxw.xdayzou3;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

import comqqqq.example.wxw.xdayzou3.Bean.Stu;

/**
 * Created by wxw on 2019/9/22.
 */

public class Flag1 extends Fragment {
    private ViewPager mVp;
    private TextView mTv1;
    private VpAdapter vpAdapter;
    private ArrayList<Stu.ResultsBean> list;
    private int con;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout3, container, false);
        initView(view);
        EventBus.getDefault().register(this);
        return view;
    }

    @Subscribe
    public void getBus(BusBean busBean) {
        if (busBean != null) {
            list.addAll(busBean.getList());
            vpAdapter.notifyDataSetChanged();
            con = busBean.getCon();
            Log.i("ssdsd",con+"");
            mVp.setCurrentItem(con);
            mTv1.setText(con + 1 + "/" + list.size());
        }
    }

    private void initView(View inflate) {
        mVp = inflate.findViewById(R.id.vp);
        mTv1 = inflate.findViewById(R.id.tv1);
        list = new ArrayList<>();
        vpAdapter = new VpAdapter(list);
        mVp.setAdapter(vpAdapter);
        mVp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mTv1.setText(position + 1 + "/" + list.size());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

}
