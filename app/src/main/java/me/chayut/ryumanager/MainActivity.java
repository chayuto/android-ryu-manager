package me.chayut.ryumanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    Button btnConnect;
    CheckBox cbConnect;
    EditText etServerAddr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnConnect = (Button) findViewById(R.id.btnConnect);
        etServerAddr = (EditText ) findViewById(R.id.editText);
        cbConnect = (CheckBox) findViewById(R.id.checkBoxRemember);

    }

    public void onButtonPressed(View view){

        String serverAddress = etServerAddr.getText().toString();
        Log.d(TAG,"Address: " + serverAddress);

        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            new CheckConnectivityTask().execute(serverAddress);
        } else {
            Log.d(TAG,"No network connection available.");
        }



    }

    public boolean isConnectedToServer(String url, int timeout) {
        try{
            URL myUrl = new URL(url);
            URLConnection connection = myUrl.openConnection();
            connection.setConnectTimeout(timeout);
            connection.connect();
            return true;
        } catch (Exception e) {
            // Handle your exceptions
            return false;
        }
    }

    private class CheckConnectivityTask extends AsyncTask<String, Void, Boolean> {
        @Override
        protected Boolean doInBackground(String... urls) {

            return isConnectedToServer(urls[0],30);

        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(Boolean result) {

            //TODO:reponse to result
        }
    }

}
