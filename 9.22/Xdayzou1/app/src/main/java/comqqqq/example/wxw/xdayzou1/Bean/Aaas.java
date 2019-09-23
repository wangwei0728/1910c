package comqqqq.example.wxw.xdayzou1.Bean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by wxw on 2019/9/20.
 */

public interface Aaas {
    String gank="http://static.owspace.com/";

    @GET("?c=api&a=getList&page_id=0")
    Observable<Stu> getfui();
}
