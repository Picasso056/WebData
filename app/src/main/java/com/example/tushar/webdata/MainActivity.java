package com.example.tushar.webdata;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements AsyncResponse {

    BackgroundActivity backgroundActivity = new BackgroundActivity();
    private Button submit;
    private TextView display;
    private String DATA;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_main);

        backgroundActivity.delegate = this;

        submit = (Button) findViewById(R.id.button);
        display = (TextView)findViewById(R.id.textView);

        if(savedInstanceState == null);

        else
        {
            DATA = savedInstanceState.getString("DATA");
            display.setText(DATA);
        }


        display.setMovementMethod(new ScrollingMovementMethod());
        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                //BackgroundActivity backgroundActivity = new BackgroundActivity();
                backgroundActivity.execute();
            }
        });



    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("DATA",DATA );
    }

    @Override
    public void processFinish(String out) {

        DATA = out;
        display.setText(out);
    }
}
