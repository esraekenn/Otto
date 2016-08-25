package com.pordiva.esraeken.otto;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pordiva.esraeken.otto.otto.OttoMessage;
import com.squareup.otto.Subscribe;

/**
 * Created by esraeken on 12/08/16.
 */
public class fragment extends Fragment

{
    TextView gelen_yazi;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment,container,false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        gelen_yazi = (TextView) view.findViewById(R.id.textView);
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        OttoApplication.ottoBus.register(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        OttoApplication.ottoBus.unregister(this);
    }
    @Subscribe
    public void messageReceived(OttoMessage event) {
        gelen_yazi.setText(event.isim+" jfgfg");
    }


}
