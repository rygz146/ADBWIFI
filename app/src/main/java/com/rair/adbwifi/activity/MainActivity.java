package com.rair.adbwifi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.clans.fab.FloatingActionButton;
import com.rair.adbwifi.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.iv_state)
    ImageView ivState;
    @BindView(R.id.tv_cmd_ip)
    TextView tvCmdIp;
    @BindView(R.id.fab_cmd)
    FloatingActionButton fabCmd;
    @BindView(R.id.fab_info)
    FloatingActionButton fabInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_state, R.id.fab_cmd, R.id.fab_info})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_state:

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
}
