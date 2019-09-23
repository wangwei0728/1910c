package comqqqq.example.wxw.xdayzou3.Person;

import java.util.ArrayList;

import comqqqq.example.wxw.xdayzou3.Bean.Stu;
import comqqqq.example.wxw.xdayzou3.Modly.NetModly;
import comqqqq.example.wxw.xdayzou3.View.NetView;


/**
 * Created by wxw on 2019/9/22.
 */

public class Netperson implements NetModly.NetCall{
    private NetModly netModly;
    private NetView netView;

    public Netperson(NetView netView) {
        this.netModly =new NetModly();
        this.netView = netView;
    }
    public void initData(){
        netModly.initData(this);
    }
    @Override
    public void onsert(ArrayList<Stu.ResultsBean> rs) {
        netView.onsert(rs);
    }
}
