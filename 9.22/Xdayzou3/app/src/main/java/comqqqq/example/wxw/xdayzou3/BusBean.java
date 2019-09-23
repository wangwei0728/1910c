package comqqqq.example.wxw.xdayzou3;

import java.util.ArrayList;

import comqqqq.example.wxw.xdayzou3.Bean.Stu;

/**
 * Created by wxw on 2019/9/22.
 */

public class BusBean {
   private ArrayList<Stu.ResultsBean> list;
    private int con;

    public BusBean(ArrayList<Stu.ResultsBean> list, int con) {
        this.list = list;
        this.con = con;
    }

    public ArrayList<Stu.ResultsBean> getList() {
        return list;
    }

    public void setList(ArrayList<Stu.ResultsBean> list) {
        this.list = list;
    }

    public int getCon() {
        return con;
    }

    public void setCon(int con) {
        this.con = con;
    }
}
