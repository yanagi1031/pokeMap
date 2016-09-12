package jp.co.use_eng.pokemap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import jp.co.useeng.uselib.base.BaseActivity;
import jp.co.useeng.uselib.lib.Consts;
import jp.co.useeng.uselib.util.UtilView;
import jp.co.useeng.uselib.util.UtilWindow;

public class PM0200RegistActivity extends BaseActivity {

    @Override
    public int getLayoutId() throws Exception {
        return R.layout.activity_pm0200_regist;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    // メイン画面に戻る
    public void onClickCencel(View view) {
        addView(PM0100MainActivity.class);
    }

    // 登録画面に戻る
    public void onClickToukou(View view) {




    }

}
