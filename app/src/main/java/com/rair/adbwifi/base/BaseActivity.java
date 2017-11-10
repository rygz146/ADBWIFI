package com.rair.adbwifi.base;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * @author Rair
 * @date 2017/11/10
 * <p>
 * desc:
 */

public class BaseActivity extends AppCompatActivity {

    /**
     * 设置tool并监听点击事件finish
     *
     * @param isSetBackBtn 是否给toolbar设置返回键
     */
    protected void setToolbar(Toolbar toolbar, boolean isSetBackBtn) {
        setSupportActionBar(toolbar);
        if (isSetBackBtn) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }
}
