package comqqqq.example.wxw.xdayzou1.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import comqqqq.example.wxw.xdayzou1.Bean.BaseApp;
import comqqqq.example.wxw.xdayzou1.Bean.DatasBean;
import comqqqq.example.wxw.xdayzou1.R;
import comqqqq.example.wxw.xdayzou1.db.DatasBeanDao;

/**
 * Created by wxw on 2019/9/20.
 */

public class Myadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private ArrayList<DatasBean> list;
    private Context context;
    private final DatasBeanDao datasBeanDao;

    public Myadapter(ArrayList<DatasBean> list, Context context) {
        this.list = list;
        this.context = context;
        datasBeanDao = BaseApp.getInstance().getDaoSession().getDatasBeanDao();

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item1, parent, false);
        return new ViewHolder1(view);
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final ViewHolder1 holder1 = (ViewHolder1) holder;

        RequestOptions options = new RequestOptions()
                .circleCrop();
        Glide.with(context).load(list.get(position).getAvatar()).apply(options).into(holder1.im1);
        holder1.tv1.setText(list.get(position).getTitle());
        holder1.tv2.setText(list.get(position).getAuthor());
        holder1.bt1.setText("关注");
        holder1.bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = holder1.bt1.getText().toString();
                if(s.equals("关注")){

                    holder1.bt1.setText("取消");
                    onclik.onclik(v,position);
                }else{

                    holder1.bt1.setText("关注");
                    onclik.onclike(v,position);
                }
            }
        });
        List<DatasBean> datasBeans = datasBeanDao.loadAll();
        for (int i = 0; i <datasBeans.size() ; i++) {
            if(list.get(position).getId().equals(datasBeans.get(i).getId())){
                holder1.bt1.setText("取消");
            }
        }

    }
   public interface onclik{
        void onclik(View v, int position);
       void onclike(View v, int position);
    }

   public onclik onclik;

    public void setOnclik(Myadapter.onclik onclik) {
        this.onclik = onclik;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class ViewHolder1 extends RecyclerView.ViewHolder {
        ImageView im1;
        TextView tv1;
        TextView tv2;
        Button bt1;
        public ViewHolder1(View itemView) {
            super(itemView);
             im1 = itemView.findViewById(R.id.im1);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
            bt1 = itemView.findViewById(R.id.bt1);
        }
    }


}
