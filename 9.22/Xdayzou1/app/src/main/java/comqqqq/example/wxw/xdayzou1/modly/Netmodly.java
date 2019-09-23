package comqqqq.example.wxw.xdayzou1.modly;

import java.util.ArrayList;
import java.util.List;

import comqqqq.example.wxw.xdayzou1.Bean.Aaas;
import comqqqq.example.wxw.xdayzou1.Bean.DatasBean;
import comqqqq.example.wxw.xdayzou1.Bean.Stu;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wxw on 2019/9/20.
 */

public class Netmodly {

    public void initData(final NetCall netCall){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Aaas.gank)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Aaas aaas = retrofit.create(Aaas.class);
        Observable<Stu> getfui = aaas.getfui();
        getfui.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Stu>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext  (Stu stu) {
                        if(stu!=null&&stu.getDatas()!=null){
                            List<DatasBean> datas = stu.getDatas();
                            netCall.onsert((ArrayList<DatasBean>) datas);
                        }
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
        void onsert(ArrayList<DatasBean> rs);
    }
}
