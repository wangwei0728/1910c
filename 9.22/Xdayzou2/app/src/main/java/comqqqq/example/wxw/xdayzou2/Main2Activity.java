package comqqqq.example.wxw.xdayzou2;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import comqqqq.example.wxw.xdayzou2.Bean.Stu;
import comqqqq.example.wxw.xdayzou2.adapter.MyVp;
import comqqqq.example.wxw.xdayzou2.adapter.Myadapter;

public class Main2Activity extends AppCompatActivity {

    private ArrayList<Stu.BodyBean.ResultBean> list;
    private Myadapter myadapter;
    private RecyclerView mTre;
    private TabLayout mTab;
    private ViewPager mVp;
    private MyVp myVp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initView();
        EventBus.getDefault().register(this);

    }

    private void initView() {
        mTre = findViewById(R.id.tre);
        mTab = findViewById(R.id.tab);
        mVp = findViewById(R.id.vp);
        mTre.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        myadapter = new Myadapter(list, this);
        mTre.setAdapter(myadapter);




        List<Fragment> list1=initData();
        myVp = new MyVp(getSupportFragmentManager(), list1);
        mVp.setAdapter(myVp);
        mTab.setupWithViewPager(mVp);
        mTab.getTabAt(0).setText("介绍");
        mTab.getTabAt(1).setText("课程");
        mTab.getTabAt(2).setText("专题");
    }

    private List<Fragment> initData() {
        ArrayList<Fragment> list3 = new ArrayList<>();
        list3.add(new Flag1());
        list3.add(new Flag2());
        list3.add(new Flag3());
        return list3;
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void initD(Stu.BodyBean.ResultBean resultBean) {
        if (resultBean != null) {
            list.add(resultBean);
            myadapter.notifyDataSetChanged();
    }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
