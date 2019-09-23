package comqqqq.example.wxw.xdayzou1.modly;

import java.util.ArrayList;
import java.util.List;

import comqqqq.example.wxw.xdayzou1.Bean.BaseApp;
import comqqqq.example.wxw.xdayzou1.Bean.DatasBean;
import comqqqq.example.wxw.xdayzou1.db.DatasBeanDao;

/**
 * Created by wxw on 2019/9/20.
 */

public class NetmodlySQl {

public void insert(NetCallsql netCallsql,DatasBean datasBean){
    DatasBeanDao beanDao = BaseApp.getInstance().getDaoSession().getDatasBeanDao();
    beanDao.insertOrReplaceInTx(datasBean);

}
    public void load(NetCallsql netCallSQl) {
        DatasBeanDao beanDao = BaseApp.getInstance().getDaoSession().getDatasBeanDao();
        List<DatasBean> datasBeans = beanDao.loadAll();
        if (datasBeans != null) {
            netCallSQl.onsert((ArrayList<DatasBean>) datasBeans);
        }
    }
    public void dalset(NetCallsql netCallSQl,DatasBean datasBean){
        DatasBeanDao beanDao = BaseApp.getInstance().getDaoSession().getDatasBeanDao();
        beanDao.delete(datasBean);

    }
    public interface NetCallsql{
        void onsert(ArrayList<DatasBean> rs);
    }
}
