package comqqqq.example.wxw.xdayzou1;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import comqqqq.example.wxw.xdayzou1.Bean.DatasBean;
import comqqqq.example.wxw.xdayzou1.NetView.NetView;
import comqqqq.example.wxw.xdayzou1.adapter.Myadapter;
import comqqqq.example.wxw.xdayzou1.person.NetPersonsql;
import comqqqq.example.wxw.xdayzou1.person.Netpersom;

public class MainActivity extends AppCompatActivity implements NetView{
    private NetPersonsql netPersonsql;
    private RecyclerView mRe;
    private Toolbar mTb;
    private int xon;
    private ArrayList<DatasBean> list;
    private Myadapter myadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        Netpersom netpersom = new Netpersom( this);
        netpersom.initData();
         netPersonsql = new NetPersonsql(this);

    }



    private void initView() {

        mRe = findViewById(R.id.re);
        mTb = findViewById(R.id.tb);

        mTb.setTitle("列表");
        mTb.setTitleTextColor(Color.WHITE);
        setSupportActionBar(mTb);

        mRe.setLayoutManager(new LinearLayoutManager(this));
        mRe.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        list = new ArrayList<>();
         myadapter = new Myadapter(list, this);
         mRe.setAdapter(myadapter);

      myadapter.setOnclik(new Myadapter.onclik() {
          @Override
          public void onclik(View v, int position) {
              DatasBean datasBean = list.get(position);
              netPersonsql.inster1(datasBean);
              xon=position;

          }

          @Override
          public void onclike(View v, int position) {
              DatasBean datasBean = list.get(position);
              netPersonsql.delsew(datasBean);

          }
      });
    }
    private void initData(View v, final int position) {
        final Button bt1 = v.findViewById(R.id.bt1);


    }
    @Override
    public void onsert(ArrayList<DatasBean> rs) {
        list.addAll(rs);

        myadapter.notifyDataSetChanged();
    }
}
