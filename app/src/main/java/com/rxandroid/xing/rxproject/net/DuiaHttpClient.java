package com.rxandroid.xing.rxproject.net;

import android.net.Uri;

import com.http.request.utils.DevLog;
import com.rxandroid.xing.rxproject.BuildConfig;
import com.rxandroid.xing.rxproject.net.interceptor.DuiaLogInterceptor;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.MultipartBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.File;
import java.io.IOException;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class DuiaHttpClient {

    public static String METHOD_GET = "GET";
    public static String METHOD_POST = "POST";

    private static final DuiaHttpClient mClient = new DuiaHttpClient();
    private static final OkHttpClient mOkHttpClient = new OkHttpClient();

    private static final String BASE_URL = "http://api.duia.com/duiaApp/";

    static {
        mOkHttpClient.setConnectTimeout(5000, TimeUnit.MILLISECONDS);
        //添加日志过滤器
        DuiaLogInterceptor logInterceptor = new DuiaLogInterceptor(new DuiaLogInterceptor.Logger() {
            @Override
            public void log(String message) {
                DevLog.d(message);
            }
        });
        logInterceptor.setLevel(DuiaLogInterceptor.Level.BODY);
        mOkHttpClient.interceptors().add(logInterceptor);
    }

    public static DuiaHttpClient getClient() {
        return mClient;
    }

    /**
     * 同步模式
     *
     * @param request
     * @return String(json)
     */
    public String execute2String(Request request) {

        String result = null;
        try {
            Response response = mOkHttpClient.newCall(request).execute();
            if (response != null && response.isSuccessful()) {
                result = response.body().string();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 异步CallBack模式
     *
     * @param request
     * @param responseCallback
     */
    public void enqueue(Request request, Callback responseCallback) {
        mOkHttpClient.newCall(request).enqueue(responseCallback);
    }

    /**
     * 通过http请求的基本信息，创建一个Request对象
     */
    public Request getRequest(String url, String method, Map<String, Object> params) {

        if (params == null) {
            params = new TreeMap<>();
        }

        Request.Builder builder = new Request.Builder();

        if (DuiaHttpClient.METHOD_GET.equalsIgnoreCase(method)) {
            //GET
            builder.url(initGetRequest(url, params)).get();
        } else if (DuiaHttpClient.METHOD_POST.equalsIgnoreCase(method)) {
            //POST
            builder.url(url).post(initRequestBody(params));
        }
        return builder.build();
    }

    /**
     * 初始化Body类型请求参数
     * init Body type params
     */
    private RequestBody initRequestBody(Map<String, Object> params) {
        MultipartBuilder bodyBuilder = new MultipartBuilder().type(MultipartBuilder.FORM);
        Set<Map.Entry<String, Object>> entries = params.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if (value instanceof File) {
                File file = (File) value;
                try {
                    FileNameMap fileNameMap = URLConnection.getFileNameMap();
                    String mimeType = fileNameMap.getContentTypeFor(file.getAbsolutePath());
                    DevLog.w("mimeType::" + mimeType);
                    bodyBuilder.addFormDataPart(key, file.getName(), RequestBody.create(MediaType.parse(mimeType), file));
                } catch (Exception e) {
                    e.printStackTrace();
                    DevLog.e("mimeType is Error !");
                }
            } else {
                DevLog.w(key + "::" + value);
                bodyBuilder.addFormDataPart(key, value.toString());
            }
        }
        return bodyBuilder.build();
    }

    /**
     * 初始化Get请求参数
     * init Get type params
     */
    private String initGetRequest(String url, Map<String, Object> params) {
        StringBuilder sb = new StringBuilder(url);
        //has params ?
        if (params.size() > 0) {
            sb.append('?');
            Set<Map.Entry<String, Object>> entries = params.entrySet();
            int count = 0;
            for (Map.Entry entry : entries) {
                count++;
                sb.append(entry.getKey()).append('=').append(Uri.encode(entry.getValue().toString()));
                if (count == params.size()) {
                    break;
                }
                sb.append('&');
            }
            url = new String(sb);
        }
        return url;
    }

    /**
     * set timeout
     */
    public void setConnectTimeout(long time) {
        if (mOkHttpClient != null) {
            mOkHttpClient.setConnectTimeout(time, TimeUnit.MILLISECONDS);
        }
    }

    public String getBaseUrl(){

        if (BuildConfig.api_env.equalsIgnoreCase("release")) {
            return BASE_URL;
        } else if (BuildConfig.api_env.equalsIgnoreCase("test")) {
            return BASE_URL;
        } else if (BuildConfig.api_env.equalsIgnoreCase("beta")) {
            return BASE_URL;
        } else if (BuildConfig.api_env.equalsIgnoreCase("other")) {
            return BASE_URL;
        }

        return BASE_URL;
    }
}
