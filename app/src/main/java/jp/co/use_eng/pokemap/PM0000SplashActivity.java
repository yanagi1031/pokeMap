package jp.co.use_eng.pokemap;

import android.os.Bundle;
import jp.co.use_eng.pokemap.common.App;

//import jp.co.useeng.makebabies.common.App;
import jp.co.useeng.uselib.base.BaseSplashActivity;

public class PM0000SplashActivity extends BaseSplashActivity {

    @Override
    public Class<?> getNextActivityClass() throws Exception {
        // スプラッシュ画面表示後に遷移する画面クラスを定義
        return PM0100MainActivity.class;
    }

    @Override
    public int getLayoutId() throws Exception {
        return R.layout.slpash;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 初期処理
        App.init(this);
    }
}
