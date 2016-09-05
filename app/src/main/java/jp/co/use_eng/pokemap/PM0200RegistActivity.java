package jp.co.use_eng.pokemap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import jp.co.useeng.uselib.base.BaseActivity;
import butterknife.InjectView;
import butterknife.OnClick;
import jp.co.useeng.uselib.util.UtilView;
import jp.co.useeng.uselib.util.UtilWindow;

public class PM0200RegistActivity extends AppCompatActivity {

    // ヘッダー
    @InjectView(R.id.llHead)
    RelativeLayout llHead;
    @InjectView(R.id.llHeadBack)
    LinearLayout llHeadBack;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pm0200_regist);

        llHead.post(new Runnable() {
            @Override
            public void run() {
                UtilView.setViewSize(llHeadBack, llHead.getWidth(), llHead.getHeight());
            }
        });

    }
}
