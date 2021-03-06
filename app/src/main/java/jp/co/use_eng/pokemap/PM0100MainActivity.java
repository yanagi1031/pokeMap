package jp.co.use_eng.pokemap;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.util.Log;
import android.Manifest;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter;
import com.google.android.gms.maps.model.Marker;

import java.io.IOException;

import jp.co.use_eng.pokemap.Data.PokemonDataList;
import jp.co.use_eng.pokemap.R;
import jp.co.use_eng.pokemap.common.App;
import jp.co.use_eng.pokemap.common.Consts;
import jp.co.use_eng.pokemap.common.Server.Server;
import jp.co.use_eng.pokemap.common.Server.ServerResponce;
import jp.co.useeng.uselib.component.AdMobBannerView;
import jp.co.useeng.uselib.base.BaseActivity;

public class PM0100MainActivity extends BaseActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    public int getLayoutId() throws Exception {
        return R.layout.activity_pm0100_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 広告表示
        startAdBannerView(R.id.adView,Consts.AD_ID_BANNER);

        // GoogleMapの使用
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        // 位置情報の取得
        getLocation();

    }

    private void getLocation() {

        progressStart("位置情報取得中", "");

        try {
            new Server().getServerLocation(
                    "",
                    new Server.OnFinishListener() {
                        @Override
                        public <T extends ServerResponce.BaseResponce> void onFinish(@Nullable T responce) {
                            try {
                                ServerResponce.getResponceLocation locationList = (ServerResponce.getResponceLocation)responce;

                                //ここに取得後の処理を書く
                                //Toast.makeText(this, "抽出件数：" + locationList.lastUpdateDate, Toast.LENGTH_LONG).show();
                                //Toast.makeText(this, "中心位置\n緯度:" + cameraPos.target.latitude + "\n経度:" + cameraPos.target.longitude, Toast.LENGTH_LONG).show();




                            } catch (Exception e) {
                            } finally {
                                progressEnd();
                            }
                        }

                        @Override
                        public void onError(String message) {
                            try {
                                showDialog("", 0, message);
                            } catch (Exception e) {
                            } finally {
                                progressEnd();
                            }
                        }
                    });

        } catch (Exception e) {
            progressEnd();
        }
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        //LocationManagerの取得
        LocationManager locationManager = (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
        Location myLocate = null;
        //GPSから現在地の情報を取得
        if(locationManager != null) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                // GPS使用可能
                myLocate = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

            } else {
                // GPSが使用できない端末？


            }

        } else {
            // 位置情報サービスが使用不可

        }

        if (myLocate != null) {
            // カメラの移動
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom( new LatLng(myLocate.getLatitude(), myLocate.getLongitude()), 18));
        } else {
            // カメラの移動
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom( new LatLng(35.68, 139.76), 18));
        }

        // ピンがタップされた時に表示するバルーンのカスタマイズ
        mMap.setInfoWindowAdapter(new InfoWindowAdapter() {

            @Override
            public View getInfoContents(Marker marker) {
                View view = getLayoutInflater().inflate(R.layout.info_window, null);
                view.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.MATCH_PARENT));

                // タイトル設定
                TextView pokeName = (TextView)view.findViewById(R.id.txtPokemonName);
                pokeName.setText(marker.getId());

                // いいね件数
                TextView goodCnt = (TextView)view.findViewById(R.id.txtGoodCnt);
                goodCnt.setText("100");

                // いないね件数
                TextView badCnt = (TextView)view.findViewById(R.id.txtBadCnt);
                badCnt.setText("200");

                return view;
            }

            @Override
            public View getInfoWindow(Marker marker) {
                // とりあえず、このメソッドは必須のようなので、定義しておく
                return null;
            }

        });



    }

    // テスト的なボタン押下処理
    public void onGetCenter(View view) {
        // 地図の中央地点を取得
        CameraPosition cameraPos = mMap.getCameraPosition();
        Toast.makeText(this, "中心位置\n緯度:" + cameraPos.target.latitude + "\n経度:" + cameraPos.target.longitude, Toast.LENGTH_LONG).show();

        // マーカーの追加
        MarkerOptions options = new MarkerOptions();
        options.position(new LatLng(cameraPos.target.latitude, cameraPos.target.longitude));
        options.title("Hello world");
        Marker marker = mMap.addMarker(options);
    }

    // 登録画面に遷移
    public void onClickRegist(View view) {

        // インテントの生成
        Intent intent = new Intent();
        intent.setClassName("jp.co.use_eng.pokemap", "jp.co.use_eng.pokemap.PM0200RegistActivity");

        // SubActivity の起動
        startActivity(intent);

    }

}
