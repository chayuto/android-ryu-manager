package me.chayut.ryumanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SwitchesActivity extends AppCompatActivity {

    private final static String TAG = "SwitchesActivity";

    // Instantiate the RequestQueue.
    RequestQueue queue ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switches);


        //query queue
        queue = Volley.newRequestQueue(this);

    }

    public void getResultsList (){

        String username ="chayut_orapinpatipat";
        String codekey = "6be4a4bbf9a57b39ffd296f29e899309";


        String url = String.format("https://secure.worldcommunitygrid.org/api/members/%s/" +
                "results?code=%s&limit=20&SortBy=ReceivedTime&ServerState=5", username, codekey);
        //&ValidateState=0



        Log.d(TAG, url);
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                    }

                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub
                    }
                });



        // Add the request to the RequestQueue.
        queue.add(jsObjRequest);
    }
}
