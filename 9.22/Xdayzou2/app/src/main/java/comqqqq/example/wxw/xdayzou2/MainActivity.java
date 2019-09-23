package comqqqq.example.wxw.xdayzou2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import comqqqq.example.wxw.xdayzou2.Bean.Stu;
import comqqqq.example.wxw.xdayzou2.Person.Netperson;
import comqqqq.example.wxw.xdayzou2.View.NetView;
import comqqqq.example.wxw.xdayzou2.adapter.Myadapter;

public class MainActivity extends AppCompatActivity implements NetView{
    private int con;
    private Toolbar mTb;
    private RecyclerView mRe;
    private   ArrayList<Stu.BodyBean.ResultBean> list;
    private Myadapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        Netperson netperson = new Netperson(this);
        netperson.initData();
    }

    private void initView() {
        mTb = findViewById(R.id.tb);
        mRe = findViewById(R.id.re);

        mTb.setTitle("名师推荐");
        setSupportActionBar(mTb);

        mRe.setLayoutManager(new LinearLayoutManager(this));
        mRe.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
       list = new ArrayList<>();

        myadapter = new Myadapter(list, this);
        mRe.setAdapter(myadapter);
        myadapter.setOnclik(new Myadapter.onclik() {
            @Override
            public void onclik(int position) {
                Stu.BodyBean.ResultBean resultBean = list.get(position);
                EventBus.getDefault().postSticky(resultBean);
                startActivity(new Intent(MainActivity.this,Main2Activity.class));
            }
        });
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem as = menu.add(1, 1, 1, "as");
        as.setIcon(R.drawable.login_phone_icon);
        as.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void onsert(ArrayList<Stu.BodyBean.ResultBean> rs) {
        list.addAll(rs);
        myadapter.notifyDataSetChanged();
    }
}
