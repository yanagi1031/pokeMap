package jp.co.use_eng.pokemap.common.Server;

import android.graphics.Bitmap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

import jp.co.use_eng.pokemap.Data.LocationData;
import jp.co.use_eng.pokemap.Data.LocationDataList;
import jp.co.useeng.uselib.util.UtilBitmap;
import jp.co.useeng.uselib.util.UtilDate;

/**
 * Created by K.Mizuno on 2016/07/28.
 */
public class ServerResponce {

    private static final String ACCESS_TOKEN                = "access_token";

    private static final String RETURN_CD                   = "return_cd";
    private static final String RETURN_MESSAGE              = "message";
    private static final String RETURN_DATA                 = "data";

    private static final int RETURN_CD_OK                = 0;
    private static final int RETURN_CD_NG                = -1;
    private static final int RETURN_CD_NOTFOUND          = 9;

    /**
     * 基盤
     */
    public static class BaseResponce {
        public BaseJSONObject data;
        public int return_cd;
        public String message;

        public BaseResponce(JSONObject json) {
            try {
                this.data       = new BaseJSONObject(json);
            } catch (Exception e) {
                e.getStackTrace();
            }
            try {
                this.return_cd  = data.getInt(RETURN_CD);
                this.message    = data.getString(RETURN_MESSAGE);
            } catch (Exception e) {
            }
        }

        public boolean isReturnOK() {
            try {
                return this.return_cd == RETURN_CD_OK;
            } catch (Exception e) {
                return false;
            }
        }

        public boolean isReturnNG() {
            try {
                return this.return_cd == RETURN_CD_NG;
            } catch (Exception e) {
                return false;
            }
        }

        public boolean isReturnNOTFOUND() {
            try {
                return this.return_cd == RETURN_CD_NOTFOUND;
            } catch (Exception e) {
                return false;
            }
        }
    }

    /**
     * 基盤JSONObject
     */
    static class BaseJSONObject extends JSONObject {

        public BaseJSONObject(JSONObject json) throws JSONException {
            super(json.toString());
            // メモリ節約の為元データを破棄
            JSONArray names =json.names();
            for (int i = 0; i < names.length();i++) {
                json.remove((String)names.get(i));
            }
        }

        public boolean isAccessToken() {
            return !isNull(ACCESS_TOKEN);
        }

        @Override
        public String getString(String name) throws JSONException {
            try {
                return super.getString(name);
            } catch (Exception e) {
                return "";
            }
        }

        @Override
        public int getInt(String name) throws JSONException {
            try {
                return super.getInt(name);
            } catch (Exception e) {
                return 0;
            }
        }

        @Override
        public long getLong(String name) throws JSONException {
            try {
                return super.getLong(name);
            } catch (Exception e) {
                return 0;
            }
        }

        @Override
        public double getDouble(String name) throws JSONException {
            try {
                return super.getDouble(name);
            } catch (Exception e) {
                return 0d;
            }
        }

        public float getFloat(String name) throws JSONException {
            try {
                return (float)super.getDouble(name);
            } catch (Exception e) {
                return 0f;
            }
        }

        @Override
        public JSONArray getJSONArray(String name) throws JSONException {
            try {
                return super.getJSONArray(name);
            } catch (Exception e) {
                return new JSONArray();
            }
        }

        @Override
        public boolean getBoolean(String name) throws JSONException {
            try {
                int value =  super.getInt(name);
                return (value == 1);
            } catch (Exception e) {
                try {
                    return super.getBoolean(name);
                } catch (Exception e2) {
                    return false;
                }
            }
        }

        @Override
        public JSONObject getJSONObject(String name) throws JSONException {
            try {
                return super.getJSONObject(name);
            } catch (Exception e) {
                return null;
            }
        }

        public Date getDate(String name) throws JSONException {
            try {
                return UtilDate.getString2Date(getString(name));
            } catch (Exception e) {
                return null;
            }
        }
        public Bitmap getImage(String name) throws JSONException {
            try {
                return UtilBitmap.decodeBase64(getString(name));
            } catch (Exception e) {
                return null;
            }
        }
    }

    /**
     * 位置情報取得
     */
    public static class getLocation extends BaseResponce {

        public LocationDataList locationList;
        public String lastUpdateDate;

        public getLocation(JSONObject json) {
            super(json);
            try {
                if (isReturnOK()) {
                    // 位置情報
                    locationList = new LocationDataList();

                    lastUpdateDate = data.getString("last_update_date");
                    JSONArray jsonLocationList = data.getJSONArray("list");

                    for (int i = 0; i < jsonLocationList.length(); i++) {
                        LocationData locationData = new LocationData();
                        BaseJSONObject list_data = new BaseJSONObject(jsonLocationList.getJSONObject(i));

                        locationData.ID = list_data.getInt("loc_id");
                        locationData.latitude = list_data.getDouble("latitude");
                        locationData.longitude = list_data.getDouble("longitude");
                        locationData.pokemonNo = list_data.getInt("pokemonNo");
                        locationData.pokemonName = list_data.getString("pokemonName");
                        locationData.goodCnt = list_data.getInt("goodCnt");
                        locationData.badCnt = list_data.getInt("badCnt");
                        locationData.comment1 = list_data.getString("comment1");
                        locationData.comment2 = list_data.getString("comment2");
                        locationData.createDate = list_data.getString("create_date");

                        locationList.add(locationData);
                    }
                }
            } catch (Exception e) {
            }
        }
    }


}

