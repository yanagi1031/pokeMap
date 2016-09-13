package jp.co.use_eng.pokemap;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
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
        AdMobBannerView adMobBannerView = (AdMobBannerView)findViewById(R.id.adView);
        adMobBannerView.startAd(Consts.AD_ID_BANNER);

        // GoogleMapの使用
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

//        // 初期情報を取得する
//        startSimpleThread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    // 初期情報取得
//                    final HttpsData httpsData = new AmanoHttpsData(T101TopActivity.this.getApplicationContext());
//                    if(httpsData.getInitData()) {
//                        if(is_dialog) {
//
//                            // クレジット決済チェック
//                            final boolean result = httpsData.DBGetIsOrderedCredit(AppManager.getOrderData().order_no);
//
//                            mHandler.post(new Runnable() {
//                                @Override
//                                public void run() {
//
//                                    if(getSelectedSaveData() != null) {
//                                        // 写真選択画面 確認ダイアログ
//                                        showConfDialog("年賀状作成", O201ImageSelActivity.class);
//                                        return;
//                                    } else {
//                                        CartDataList cartDataList = AppManager.getCartDataList();
//                                        if(cartDataList != null) {
//                                            if(!TextUtils.isEmpty(cartDataList.order_no)) {
//                                                // 注文番号取得済みの場合、注文送信画面 確認ダイアログ
//                                                showConfDialog("注文画像送信", O702SendActivity.class);
//                                                return;
//                                            } else if(cartDataList.size() > 0) {
//                                                // 注文番号未取得の場合、カート一覧画面 確認ダイアログ
//                                                showConfDialog("注文枚数入力", O701CartListActivity.class);
//                                                return;
//                                            } else {
//                                                AppManager.clearCartDataList();
//                                            }
//                                        }
//
//                                        if(AppManager.getOrderData().isData()) {
//                                            // 注文画像送信済みの場合
//                                            if(result){
//                                                // ダイアログ表示
//                                                showDialog("確認"
//                                                        , 0
//                                                        , "前回の注文のクレジットカード決済が完了しています。\n注文完了処理を行います。"
//                                                        , "OK"
//                                                        , new DialogInterface.OnClickListener() {
//                                                            @Override
//                                                            public void onClick(DialogInterface dialog, int which) {
//                                                                try {
//                                                                    // 注文履歴に追加
//                                                                    getOrderLogDataList().addOrder(AppManager.getOrderData());
//
//                                                                    // 注文履歴を保存
//                                                                    AppManager.saveOrderLogDataList();
//
//                                                                    // 注文情報をクリア
//                                                                    AppManager.clearOrderData();
//
//                                                                    // 注文完了画面を呼び出し
//                                                                    addView(O1005DetailActivity.class, null);
//                                                                } catch (IOException e) {
//                                                                }
//                                                            }
//                                                        }
//                                                );
//                                            } else {
//                                                // 再開確認メッセージ表示
//                                                showConfDialog("注文", O801LoginActivity.class);
//                                            }
//                                        }
//                                    }
//
//                                }
//                            });
//                        }
//                    } else {
//                        showErrorDialog(is_dialog);
//                    }
//
//                } catch(Exception e) {
//                    showErrorDialog(is_dialog);
//                } finally {
//                    closeSimpleThread();
//                    progressEnd();
//                }
//            }
//        });






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
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom( new LatLng(myLocate.getLatitude(), myLocate.getLongitude()), 12));
        } else {
            // カメラの移動
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom( new LatLng(35.68, 139.76), 12));
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
