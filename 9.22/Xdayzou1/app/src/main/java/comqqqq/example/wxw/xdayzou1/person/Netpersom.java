package comqqqq.example.wxw.xdayzou1.person;

import java.util.ArrayList;

import comqqqq.example.wxw.xdayzou1.Bean.DatasBean;
import comqqqq.example.wxw.xdayzou1.Bean.Stu;
import comqqqq.example.wxw.xdayzou1.NetView.NetView;
import comqqqq.example.wxw.xdayzou1.modly.Netmodly;

/**
 * Created by wxw on 2019/9/20.
 */

public class Netpersom implements Netmodly.NetCall{
    private Netmodly netmodly;
    private NetView netView;

    public Netpersom(NetView netView) {
        this.netmodly = new Netmodly();
        this.netView = netView;
    }
    public void initData(){
        netmodly.initData(this);
    }
    @Override
    public void onsert(ArrayList<DatasBean> rs) {
        netView.onsert(rs);
    }
}
