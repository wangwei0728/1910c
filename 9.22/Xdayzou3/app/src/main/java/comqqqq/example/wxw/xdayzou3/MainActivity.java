package comqqqq.example.wxw.xdayzou3;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;

import java.util.ArrayList;

import comqqqq.example.wxw.xdayzou3.Bean.Stu;
import comqqqq.example.wxw.xdayzou3.adapter.Myadapter;

public class MainActivity extends AppCompatActivity {

    private FrameLayout mFl;
    private Flag1 flag1;
    private Flag2 flag2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        mFl = findViewById(R.id.fl);
        flag1 = new Flag1();
        flag2 = new Flag2();
        final FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().add(R.id.fl,flag2).add(R.id.fl,flag1).show(flag2).hide(flag1).commit();
        flag2.setFragOnClick(new Flag2.FragOnClick() {
            @Override
            public void fragOnClick(int pos) {
           manager.beginTransaction().show(flag1).hide(flag2).commit();
            }
        });

    }


}
