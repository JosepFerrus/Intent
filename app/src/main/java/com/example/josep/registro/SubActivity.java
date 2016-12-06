package com.example.josep.registro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.LoginFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SubActivity extends AppCompatActivity {

     String nombre;
    Bundle b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);

       final Button ok = (Button) findViewById(R.id.button2);
        final Button cancel = (Button) findViewById(R.id.button3);

        final EditText usuario = (EditText) findViewById(R.id.editText2);
        final EditText password = (EditText) findViewById(R.id.password);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((usuario.getText().length()==0)||(password.getText().length()==0)){

                }else{
                    Toast.makeText(getApplicationContext(),"He tornat", Toast.LENGTH_LONG).show();


                    Intent intent = new Intent ();
                    b= new Bundle();
                    b.putString("NOMBRE", usuario.getText().toString());
                    intent.putExtras(b);
                    setResult(RESULT_OK,intent);
                    finish();
                }
            }
        });


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult(RESULT_CANCELED,intent);
                finish();

            }
        });



    }
}


