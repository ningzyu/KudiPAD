package com.nzy.zkyt.kudipad.network;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nzy.zkyt.kudipad.model.ResultQuery;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者：宁震宇on 2017/11/15.
 * 邮箱：348723352@qq.com
 * 本类作用：
 */

public class ApiRetrofit {
    private static final int DEFAULT_TIME = 10;    //默认超时时间
    public Api mApi;
    public static ApiRetrofit mInstance;
    public static ApiRetrofit getInstance() {
        if (mInstance == null) {
            synchronized (ApiRetrofit.class) {
                if (mInstance == null) {
                    mInstance = new ApiRetrofit();
                }
            }
        }
        return mInstance;
    }

    private ApiRetrofit() {
        super();
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        //在构造方法中完成对Retrofit接口的初始化
        mApi = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .client(getClient())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(Api.class);
    }

    public OkHttpClient getClient() {
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder.readTimeout(DEFAULT_TIME, TimeUnit.SECONDS);
        builder.connectTimeout(DEFAULT_TIME, TimeUnit.SECONDS);
        //设置拦截器
//        builder.addInterceptor(new BasicParamsInterceptor.Builder().addParamsMap(getCommonMap()).build());
//        builder.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
        OkHttpClient okHttpClient = builder.build();
        return okHttpClient;
    }
    //登录    请求
//    public Observable<GoodItem> login(String methodCode, String language) {
//        return mApi.getUserInfo(methodCode,language);
//    }

    /**
     *
     * @return
     */
    public Observable<ResultQuery> Request(Map<String, String> map) {
//        Map<String, String> map=new HashMap<>();
//        String appid="O2OAPP";
//        String format="json";
//        String exeinfo="{SHOPID=" + Setting.getShop_Id() + ",USERID=" + "用户ID" + "}";//TODO
//        String timestamp=getDate("yyyy-MM-dd HH:mm:ss");
//        String sign= Md5.md5Capital("UYTGH098E68" + appid + apiid + format + exeinfo + para + compression + timestamp);
//        map.put("sign", sign);
//        map.put("appid", appid);
//        map.put("apiid", apiid);
//        map.put("format", format);
//        map.put("exeinfo", exeinfo);
//        map.put("para", para);
//        map.put("compression", compression);
//        map.put("timestamp", timestamp);
        return mApi.getResultQuery(getBody(map));
    }

    //获取post携带的参数
    private static RequestBody getBody(Map<String, String> params) {
        FormBody.Builder fb = new FormBody.Builder();
        for (Param param : getParams(params)) {
            Log.i("paramkey", "请求的键：" + param.key + "，对应的值：" + param.value);
            fb.add(param.key, param.value);
        }
        return fb.build();
    }
    /**
     * 参数类
     */
    private static class Param {
        public Param() {
        }
        public Param(String key, String value) {
            this.key = key;
            this.value = value;
        }
        String key;
        String value;
    }

    /**
     * 将map集合转换成参数实体
     *
     * @param params
     * @return
     */
    private static Param[] getParams(Map<String, String> params) {
        if (params == null) return new Param[0];
        int size = params.size();
        Param[] res = new Param[size];
        Set<Map.Entry<String, String>> entries = params.entrySet();
        int i = 0;
        for (Map.Entry<String, String> entry : entries) {
            res[i++] = new Param(entry.getKey(), entry.getValue());
        }
        return res;
    }

}
