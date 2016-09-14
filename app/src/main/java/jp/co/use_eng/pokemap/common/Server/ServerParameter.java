package jp.co.use_eng.pokemap.common.Server;

import android.graphics.Bitmap;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import jp.co.useeng.uselib.util.UtilBitmap;
import jp.co.useeng.uselib.util.UtilDate;

/**
 * パラメータクラス
 * Created by K.Mizuno on 2016/08/02.
 */
public class ServerParameter  extends JSONObject {
    public void addParam(String key, String value) {
        try {
            super.put(key, value);
        } catch (Exception e) {
        }
    }
    public void addParam(String key, int value) {
        try {
            super.put(key, value);
        } catch (Exception e) {
        }
    }
    public void addParam(String key, float value) {
        try {
            super.put(key, value);
        } catch (Exception e) {
        }
    }
    public void addParam(String key, double value) {
        try {
            super.put(key, value);
        } catch (Exception e) {
        }
    }
    public void addParam(String key, Date value) {
        addParam(key, value, "yyyy-MM-dd HH:mm:ss");
    }
    public void addParam(String key, Date value, String format) {
        try {
            if (value == null) {
                if (format.length() == 10) {
                    super.put(key, "1970-01-01");
                } else {
                    super.put(key, "1970-01-01 00:00:00");
                }
            } else {
                super.put(key, UtilDate.getDate2String(value, format));
            }
        } catch (Exception e) {
        }
    }
    public void addParam(String key, JSONArray array) {
        try {
            super.put(key, array);
        } catch (Exception e) {
        }
    }
    public void addParam(String key, Bitmap bitmap) {
        try {
            String param = UtilBitmap.encodeBase64(bitmap);
            super.put(key, param);
        } catch (Exception e) {
        }
    }
}
