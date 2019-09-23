package comqqqq.example.wxw.xdayzou2.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
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

import comqqqq.example.wxw.xdayzou2.Bean.Stu;
import comqqqq.example.wxw.xdayzou2.R;

/**
 * Created by wxw on 2019/9/22.
 */

public class Myadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private ArrayList<Stu.BodyBean.ResultBean> list;
    private Context context;

    public Myadapter(ArrayList<Stu.BodyBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item1, parent, false);
        return new ViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
     final ViewHolder1 holder1 = (ViewHolder1) holder;
        RequestOptions options = new RequestOptions()
                .circleCrop();
        Glide.with(context).load(list.get(position).getTeacherPic()).apply(options).into(holder1.im1);
        holder1.tv1.setText(list.get(position).getTeacherName());
        holder1.tv2.setText(list.get(position).getTitle());

        holder1.bt1.setText("关注");
        holder1.bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = holder1.bt1.getText().toString();
                if(s.equals("关注")){
                    holder1.bt1.setText("取消");
                }else{
                    holder1.bt1.setText("关注");
                }
            }
        });
        holder1.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclik.onclik(position);
            }
        });
    }
    public interface onclik{
        void onclik(int position);
    }
    onclik onclik;

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
        TextView tv3;
        Button bt1;
        public ViewHolder1(View itemView) {
            super(itemView);
             im1 = itemView.findViewById(R.id.im1);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
            tv3 = itemView.findViewById(R.id.tv3);
            bt1 = itemView.findViewById(R.id.bt1);
        }
    }
}
