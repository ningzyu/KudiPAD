package com.nzy.zkyt.kudipad.network;

import com.nzy.zkyt.kudipad.model.GoodItem;
import com.nzy.zkyt.kudipad.model.ResultQuery;
import com.nzy.zkyt.kudipad.model.Setting;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 作者：宁震宇on 2017/11/15.
 * 邮箱：348723352@qq.com
 * 本类作用：
 */

public interface Api {
    public static final String BASE_URL = "http://" + Setting.getIP() + ":" + Setting.getPort() + "/JWebService/";;
    @GET("JService")
    //创建一个上游 Observable：
    Observable<GoodItem> getAllCity(@Query("methodCode") String methodCode,@Query("language") String language);

    @POST("JService")
    Observable<GoodItem> checkPhoneAvailable(@Body RequestBody body);

    @POST("JService")
    Observable<ResultQuery> getResultQuery(@Body RequestBody body);


    @FormUrlEncoded
    @POST("WebService")
    Observable<GoodItem> getUserInfo(@Field("methodCode")String methodCode, @Field("language")String language);
}
