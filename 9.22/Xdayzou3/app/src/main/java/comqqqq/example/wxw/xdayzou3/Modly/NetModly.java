package comqqqq.example.wxw.xdayzou3.Modly;

import java.util.ArrayList;
import java.util.List;


import comqqqq.example.wxw.xdayzou3.Bean.Stu;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wxw on 2019/9/22.
 */

public class NetModly {
    public void initData(final NetCall netCall){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Aadsdas.gank)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        Aadsdas aadsdas = retrofit.create(Aadsdas.class);
        Observable<Stu> getfui = aadsdas.getfui();
        getfui.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Stu>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Stu stu) {
                        List<Stu.ResultsBean> results = stu.getResults();
                        netCall.onsert((ArrayList<Stu.ResultsBean>) results);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }


    public interface NetCall{
        void onsert(ArrayList<Stu.ResultsBean> rs);
    }
}
