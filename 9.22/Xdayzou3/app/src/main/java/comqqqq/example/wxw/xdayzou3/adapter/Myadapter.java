package comqqqq.example.wxw.xdayzou3.adapter;

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

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import comqqqq.example.wxw.xdayzou3.Bean.Stu;

import comqqqq.example.wxw.xdayzou3.BusBean;
import comqqqq.example.wxw.xdayzou3.R;


/**
 * Created by wxw on 2019/9/22.
 */

public class Myadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private ArrayList<Stu.ResultsBean> list;
    private Context context;

    public Myadapter(ArrayList<Stu.ResultsBean> list, Context context) {
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
        Glide.with(context).load(list.get(position).getUrl()).into(holder1.im1);

        holder1.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onclik.onclik(position);
                EventBus.getDefault().postSticky(new BusBean(list,position));
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

        public ViewHolder1(View itemView) {
            super(itemView);
             im1 = itemView.findViewById(R.id.im1);

        }
    }
}
