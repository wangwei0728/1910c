package comqqqq.example.wxw.xdayzou1.person;

import java.util.ArrayList;

import comqqqq.example.wxw.xdayzou1.Bean.DatasBean;
import comqqqq.example.wxw.xdayzou1.NetView.NetView;
import comqqqq.example.wxw.xdayzou1.modly.NetmodlySQl;

/**
 * Created by wxw on 2019/9/20.
 */

public class NetPersonsql implements NetmodlySQl.NetCallsql{
    private NetView netView;
    private NetmodlySQl netModlySQL;

    public NetPersonsql(NetView netView) {
        this.netView = netView;
        this.netModlySQL = new NetmodlySQl();
    }
    public void inster1(DatasBean datasBean){
        netModlySQL.insert(this,datasBean);
    }
    public void loadAll(){
        netModlySQL.load(this);
    }
    public void delsew(DatasBean datasBean){
        netModlySQL.dalset(this,datasBean);
    }
    @Override
    public void onsert(ArrayList<DatasBean> rs) {
        netView.onsert(rs);
    }
}
