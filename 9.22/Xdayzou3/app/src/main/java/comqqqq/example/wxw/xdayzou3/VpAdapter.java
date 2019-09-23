package comqqqq.example.wxw.xdayzou3;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import comqqqq.example.wxw.xdayzou3.Bean.Stu;

/**
 * Created by wxw on 2019/9/22.
 */

public class VpAdapter extends PagerAdapter {
    private ArrayList<Stu.ResultsBean> beans;

    public VpAdapter(ArrayList<Stu.ResultsBean> beans) {
        this.beans = beans;
    }

    @Override
    public int getCount() {
        return beans.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = View.inflate(container.getContext(), R.layout.layout_item1, null);
        ImageView viewById = view.findViewById(R.id.im1);
        Glide.with(container.getContext()).load(beans.get(position).getUrl()).into(viewById);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}

