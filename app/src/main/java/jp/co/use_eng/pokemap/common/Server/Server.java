package jp.co.use_eng.pokemap.common.Server;

import android.support.annotation.Nullable;
import android.webkit.WebView;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.apache.http.HttpResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.useeng.uselib.base.App;
import jp.co.useeng.uselib.util.UtilBitmap;
import jp.co.useeng.uselib.util.UtilDate;
import jp.co.useeng.uselib.util.UtilNet;

/**
 * Created by K.Mizuno on 2016/07/28.
 */
@SuppressWarnings("unchecked")
public class Server {

    private static RequestQueue mRequestQueue;

    private static CookieManager cookieManager;
    private static List<HttpCookie> cookies;

    static {
        try {
            mRequestQueue = Volley.newRequestQueue(App.getAppContext(), new HurlStack() {
                @Override
                public HttpResponse performRequest(Request<?> request, Map<String, String> additionalHeaders) throws IOException, AuthFailureError {
                    Map newHeaders = new HashMap();
                    newHeaders.putAll(additionalHeaders);
                    try {

                        if(CookieHandler.getDefault() == null) {
                            CookieHandler.setDefault(new CookieManager());
                        }
                        CookieHandler cookieHandler = CookieHandler.getDefault();
                        cookieManager = (CookieManager) cookieHandler;
                        CookieStore cookieStore = cookieManager.getCookieStore();
                        URI uri = URI.create(URL_DOMAIN);
                        List<HttpCookie> httpCookies = cookieStore.get(uri);
                        if (httpCookies != null && httpCookies.size() > 0) {
                            HttpCookie httpCookie = httpCookies.get(0);
                            httpCookie.setVersion(0);
                        }

                        // responseを待ってCookieを回収する
                        DefaultRetryPolicy policy = new DefaultRetryPolicy(30000, 1, 1);
                        request.setRetryPolicy(policy);
                        HttpResponse response = super.performRequest(request, newHeaders);
                        // cookieの回収
                        cookies = cookieStore.getCookies();
                        if (cookies.size() > 0) {
                            // あればクッキーを保存
                            // cookies.get(0)とかをどうにかこうにか保存します
                        }

                        return response;
                    } catch (OutOfMemoryError oome) {
                        oome.getStackTrace();
                        return super.performRequest(request, newHeaders);
                    } catch (Exception e) {
                        e.getStackTrace();
                        return super.performRequest(request, newHeaders);
                    }
                }
            });
        } catch (OutOfMemoryError oome) {
            oome.getStackTrace();
        } catch (Exception e) {
            e.getStackTrace();
        }

    }

    static final String URL_DOMAIN     = "http://smart-app.use-eng.co.jp/poke/html/index.php";
    private static final String DEBUG_SESSION  = "?XDEBUG_SESSION_START=netbeans-xdebug";
    private static final String METHOD_AUTHORIZATION_ISSUE          = "authorization/issue";

    private static final String METHOD_GET_LOCATION      = "Poke_Location/getLocation";          //位置情報取得
    private static final String METHOD_LOCATION_INSERT   = "Poke_Location/location_insert";      //位置情報の登録
    private static final String METHOD_UPDATE_SINPYOU    = "Poke_Location/updateSinpyou";        //信憑性更新
    private static final String METHOD_DELETE_LOCATION   = "Poke_Location/deleteLocation";       //位置情報削除


    private static final String MESSAGE_NO_NET              = "ネットに接続できません。通信環境のよい所で再度実行してください";
    private static final String MESSAGE_ERROR_LOCAL         = "サーバー処理中にローカル側の処理に失敗しました";
    private static final String MESSAGE_ERROR               = "サーバー側の処理に失敗しました";
    private static final String MESSAGE_SERVER_ERROR        = "サーバーにアクセスできません";

    private static String makeUrl(String method) {
        return URL_DOMAIN + "/" + method;
    }

    public interface OnFinishListener {
        public <T extends ServerResponce.BaseResponce> void onFinish(@Nullable T responce);
        public void onError(String message);
    }

    // 位置情報取得
    public void getServerLocation(final String updateDate, final OnFinishListener onFin) {
        // リクエスト時に送信するパラメータです。
        ServerParameter parameter = new ServerParameter();
        // 最終更新日時
        parameter.addParam("update_date" , updateDate);

        post(METHOD_GET_LOCATION, parameter, onFin,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        //通信成功
                        ServerResponce.getResponceLocation responce = new ServerResponce.getResponceLocation(jsonObject);
                        onFin.onFinish(responce);
                    }
                }, getPostErrorListener(onFin)
        );
    }


//    // 利用者情報登録
//    public void register_personal(final PersonalData personal, final OnFinishListener onFin) {
//        // リクエスト時に送信するパラメータです。
//        ServerParameter parameter = new ServerParameter();
//        parameter.addParam("nick_name"   , personal.nick_name);
//        parameter.addParam("sex_kb"      , personal.sex_kb );
//        parameter.addParam("birth_date"  , UtilDate.getDate2String(personal.birth_date, "yyyy/MM"));
//        parameter.addParam("area_id"     , personal.area_id);
//        parameter.addParam("comment"     , personal.comment);
//        parameter.addParam("height"      , personal.height);
//        parameter.addParam("length"      , personal.length);
//        parameter.addParam("weight"      , personal.weight);
//        parameter.addParam("icon"        , personal.icon);
//
//        String method_;
//        if(personal.personal_id > 0) {
//            // 更新
//            parameter.addParam("personal_id" , personal.personal_id);
//            method_ =  METHOD_PERSONAL_UPDATE;
//        } else {
//            // 新規
//            parameter.addParam("personal_id" , "");
//            method_ = METHOD_PERSONAL_REGISTER;
//        }
//        final String method = method_;
//
//        post(method, parameter, onFin,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject jsonObject) {
//                        //通信成功
//                        ServerResponce.BaseResponce responce = new ServerResponce.BaseResponce(jsonObject);
//                        if (method.equals(METHOD_PERSONAL_REGISTER)) {
//                            try {
//                                // 新規登録時、利用者ID保存
//                                UserPref.setPersonalID(responce.data.getLong("personal_id"));
//                            } catch (Exception e) {
//                            }
//                        }
//
//
//
//                        UserPref.setHeight(personal.height);
//                        UserPref.setWeight(personal.weight);
//                        UserPref.setLength(personal.length);
//
//                        onFin.onFinish(responce);
//                    }
//                }, getPostErrorListener(onFin)
//        );
//    }


    // POST送信
    private void post(final String method, final OnFinishListener onFin, final Response.Listener<JSONObject> listener, final Response.ErrorListener errorListener) {
        post(method, new ServerParameter(), onFin, listener, errorListener);
    }
    // POST送信
    private void post(final String method, ServerParameter mParameter, final OnFinishListener onFin, final Response.Listener<JSONObject> listener, final Response.ErrorListener errorListener) {

        try {

            // ネット接続確認
            if (!UtilNet.isConnected(App.getAppContext())) {
                onFin.onError(MESSAGE_NO_NET);
                return;
            }

            if (mParameter == null) {
                mParameter = new ServerParameter();
            }
            final ServerParameter parameter = mParameter;

            // サーバアクセス
            mRequestQueue.add(
                    new JsonObjectRequest(Request.Method.POST, makeUrl(method), (JSONObject) parameter,
                            new Response.Listener<JSONObject>() {
                                @Override
                                public void onResponse(JSONObject jsonObject) {
                                    //通信成功
                                    try {
                                        ServerResponce.BaseResponce responce = new ServerResponce.BaseResponce(jsonObject);
                                        if(responce.isReturnOK()) {
                                            // 成功時、成功処理へ
                                            listener.onResponse(responce.data);
                                        } else if (responce.data.isAccessToken()) {
                                            // トークン切れ時、再実行
                                            post(method, parameter, onFin, listener, errorListener);
                                        } else if(responce.isReturnNOTFOUND()) {
                                            // NOTFOUND時、一旦成功処理とし、呼び出し先で処理をする
                                            listener.onResponse(responce.data);
                                        }  else {
                                            // エラー時
                                            onFin.onError(responce.message);
                                        }
                                    } catch (Exception e) {
                                        onFin.onError(MESSAGE_ERROR_LOCAL);
                                    }
                                }
                            }
                            , errorListener)
            );

//            // トークン取得
//            JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, makeUrl(METHOD_AUTHORIZATION_ISSUE), null,
//                    new Response.Listener<JSONObject>() {
//                        @Override
//                        public void onResponse(JSONObject jsonObject) {
//                            try {
//                                // サーバアクセス
//                                mRequestQueue.add(
//                                        new JsonObjectRequest(Request.Method.POST, makeUrl(method), (JSONObject) parameter,
//                                                new Response.Listener<JSONObject>() {
//                                                    @Override
//                                                    public void onResponse(JSONObject jsonObject) {
//                                                        //通信成功
//                                                        try {
//                                                            ServerResponce.BaseResponce responce = new ServerResponce.BaseResponce(jsonObject);
//                                                            if(responce.isReturnOK()) {
//                                                                // 成功時、成功処理へ
//                                                                listener.onResponse(responce.data);
//                                                            } else if (responce.data.isAccessToken()) {
//                                                                // トークン切れ時、再実行
//                                                                post(method, parameter, onFin, listener, errorListener);
//                                                            } else if(responce.isReturnNOTFOUND()) {
//                                                                // NOTFOUND時、一旦成功処理とし、呼び出し先で処理をする
//                                                                listener.onResponse(responce.data);
//                                                            }  else {
//                                                                // エラー時
//                                                                onFin.onError(responce.message);
//                                                            }
//                                                        } catch (Exception e) {
//                                                            onFin.onError(MESSAGE_ERROR_LOCAL);
//                                                        }
//                                                    }
//                                                }
//                                                , errorListener)
//                                );
//
//
//                            } catch(Exception e) {
//                                onFin.onError(MESSAGE_ERROR_LOCAL);
//                            }
//                        }
//                    }, errorListener);

//            DefaultRetryPolicy policy = new DefaultRetryPolicy(30000, 1, 1);
//            request.setRetryPolicy(policy);
//            mRequestQueue.add(request);


        } catch(Exception e) {
            onFin.onError(MESSAGE_ERROR_LOCAL);
        }
    }

    // エラー処理取得
    private Response.ErrorListener getPostErrorListener(final OnFinishListener onFin) {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                //通信失敗
                onFin.onError(MESSAGE_ERROR);
            }
        };
    }

}
