package com.rair.adbwifi;

import android.app.Application;
import android.graphics.Color;

import com.rair.adbwifi.utils.SPUtils;
import com.socks.library.KLog;

import es.dmoral.toasty.Toasty;

/**
 * @author Rair
 * @date 2017/11/8
 * <p>
 * desc:
 */

public class App extends Application {

    private static SPUtils spUtils;

    @Override
    public void onCreate() {
        super.onCreate();
        KLog.init(true, "Rair");
        Toasty.Config.getInstance()
                .setInfoColor(Color.parseColor("#DA4336"))
                .apply();
        spUtils = SPUtils.getInstance(this, "Rair");
    }

    public static SPUtils getSpUtils() {
        return spUtils;
    }
}
