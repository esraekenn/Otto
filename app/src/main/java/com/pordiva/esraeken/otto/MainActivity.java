package com.pordiva.esraeken.otto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.pordiva.esraeken.otto.otto.OttoMessage;

public class MainActivity extends AppCompatActivity {
    EditText yazi;
    Button buton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OttoApplication.ottoBus.register(this);

        yazi = (EditText) findViewById(R.id.editText);
        buton = (Button) findViewById(R.id.button);


        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    OttoApplication.ottoBus.post(new OttoMessage(yazi.getText().toString()));


            }

        });


    }


                @Override
                public void onResume() {
                    super.onResume();
                    OttoApplication.ottoBus.register(this);
                }

                @Override
                public void onPause() {
                    super.onPause();
                    OttoApplication.ottoBus.unregister(this);
                }

}
