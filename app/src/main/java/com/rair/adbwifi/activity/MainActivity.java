package com.rair.adbwifi.activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.clans.fab.FloatingActionButton;
import com.rair.adbwifi.App;
import com.rair.adbwifi.R;
import com.rair.adbwifi.utils.SPUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.mobiwise.materialintro.shape.ShapeType;
import co.mobiwise.materialintro.view.MaterialIntroView;
import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.iv_state)
    ImageView ivState;
    @BindView(R.id.tv_cmd_ip)
    TextView tvCmdIp;
    @BindView(R.id.fab_cmd)
    FloatingActionButton fabCmd;
    @BindView(R.id.fab_info)
    FloatingActionButton fabInfo;
    @BindView(R.id.btn_copy)
    Button btnCopy;

    /**
     * 是否打开
     */
    private boolean isOpen;
    private SPUtils spUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        spUtils = App.getSpUtils();
        showIntro();
    }

    /**
     * 改变开关状态
     */
    private void changeStatus() {
        if (isOpen) {
            ivState.setImageResource(R.mipmap.ic_wifi_close);
            isOpen = false;
        } else {
            ivState.setImageResource(R.mipmap.ic_wifi_open);
            isOpen = true;
        }
    }

    @OnClick({R.id.iv_state, R.id.btn_copy, R.id.fab_cmd, R.id.fab_info})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_state:
                changeStatus();
                break;
            case R.id.btn_copy:
                copyCmd();
                break;
            case R.id.fab_cmd:
                Intent cmdIntent = new Intent(this, CmdActivity.class);
                startActivity(cmdIntent);
                break;
            case R.id.fab_info:
                Intent infoIntent = new Intent(this, InfoActivity.class);
                startActivity(infoIntent);
                break;
            default:
                break;
        }
    }

    /**
     * 复制命令
     */
    private void copyCmd() {
        ClipboardManager cm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        String cmdText = tvCmdIp.getText().toString().trim();
        ClipData mClipData = ClipData.newPlainText("text", cmdText);
        cm.setPrimaryClip(mClipData);
        Toasty.info(this, "已复制到剪切板").show();
    }

    /**
     * 第一次安装指引
     */
    private void showIntro() {
        new MaterialIntroView.Builder(this).setShape(ShapeType.CIRCLE).enableDotAnimation(true)
                .enableIcon(false).setTextColor(Color.parseColor("#DA4336")).setInfoTextSize(18)
                .enableFadeAnimation(true).setTarget(ivState).setUsageId("first")
                .setInfoText("点击打开或关闭adb连接").show();
    }

}
