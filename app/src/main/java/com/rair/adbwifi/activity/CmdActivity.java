package com.rair.adbwifi.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.rair.adbwifi.R;
import com.rair.adbwifi.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CmdActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cmd);
        ButterKnife.bind(this);
        setToolbar(toolbar, true);
    }
}
