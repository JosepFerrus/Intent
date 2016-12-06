package com.example.josep.registro;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;
    Button btn2;
    TextView txt;
    TextView txt2;
    EditText edt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button4);
        txt = (TextView) findViewById(R.id.textView3);
        txt2 = (TextView) findViewById(R.id.textView5);
        edt = (EditText) findViewById(R.id.editText);

        btn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SubActivity.class);
                startActivityForResult(intent, 0);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(getApplicationContext(), "He tornat", Toast.LENGTH_LONG).show();
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                btn.setVisibility(View.INVISIBLE);
                btn2.setVisibility(View.VISIBLE);
                txt.setVisibility(View.VISIBLE);
                txt2.setVisibility(View.VISIBLE);
                edt.setVisibility(View.VISIBLE);
                Bundle bundle = data.getExtras();
                txt.setText(bundle.getString("NOMBRE"));
                btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        int numero = Integer.parseInt(edt.getText().toString());

                        Intent i = new Intent(android.content.Intent.ACTION_DIAL,Uri.parse("+34"+numero));
                        startActivity(i);

                    }
                });

            }
            if (resultCode==RESULT_CANCELED){
                Toast.makeText(getApplicationContext(),"Cancelat",Toast.LENGTH_LONG).show();

            }
        }


    }

}

