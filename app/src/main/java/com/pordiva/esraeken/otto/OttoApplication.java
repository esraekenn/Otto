package com.pordiva.esraeken.otto;

import android.app.Application;
import com.squareup.otto.Bus;

/**
 * Created by esraeken on 12/08/16.
 */
public class OttoApplication extends Application

{
    public static Bus ottoBus = new Bus();

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
