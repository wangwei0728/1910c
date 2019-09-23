package comqqqq.example.wxw.xdayzou3;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import comqqqq.example.wxw.xdayzou3.Bean.Stu;
import comqqqq.example.wxw.xdayzou3.Person.Netperson;
import comqqqq.example.wxw.xdayzou3.View.NetView;
import comqqqq.example.wxw.xdayzou3.adapter.Myadapter;

/**
 * Created by wxw on 2019/9/22.
 */

public class Flag2 extends Fragment implements NetView{
    private RecyclerView mRe;
    private int pos;
    private ArrayList<Stu.ResultsBean> list;
    private Myadapter myadapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.layout1, container, false);
        initView(inflate);
        Netperson netperson = new Netperson(this);
        netperson.initData();
        return inflate;
    }

    private void initView(View view) {
        mRe = view.findViewById(R.id.re);
        mRe.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayout.VERTICAL));
        mRe.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        list = new ArrayList<>();
        myadapter = new Myadapter(list, getActivity());
        mRe.setAdapter(myadapter);
        myadapter.setOnclik(new Myadapter.onclik() {
            @Override
            public void onclik(int position) {
                fragOnClick.fragOnClick(pos);
            }
        });

    }

    @Override
    public void onsert(ArrayList<Stu.ResultsBean> rs) {
        list.addAll(rs);
        myadapter.notifyDataSetChanged();
    }
    interface FragOnClick{
        void fragOnClick(int pos);
    }
    FragOnClick fragOnClick;

    public void setFragOnClick(FragOnClick fragOnClick) {
        this.fragOnClick = fragOnClick;
    }
}
