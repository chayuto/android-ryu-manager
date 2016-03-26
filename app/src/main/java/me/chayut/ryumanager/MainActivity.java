package me.chayut.ryumanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    Button btnConnect;
    CheckBox cbConnect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnConnect = (Button) findViewById(R.id.btnConnect);
        cbConnect = (CheckBox) findViewById(R.id.checkBoxRemember);

    }

    private void onButtonPressed(View view){

    }
}
