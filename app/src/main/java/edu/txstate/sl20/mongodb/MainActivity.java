package edu.txstate.sl20.mongodb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.TextHttpResponseHandler;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;
import cz.msebera.android.httpclient.message.BasicHeader;
import cz.msebera.android.httpclient.protocol.HTTP;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /// Show MongoDB
        Button testMongo = findViewById(R.id.btnTestMongo) ;
        testMongo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MongoActivity.class));
            }
        });

        /// Add Mongo
        Button addMongo = findViewById(R.id.btnAddMongo) ;
        addMongo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Employee e = new Employee(10, "jd10", 50000.90);
                JSONObject e = new JSONObject();
                try {
                    e.put("EmployeeId", 66);
                    e.put("Account", "bc10");
                    e.put("Salary", 35000);
                } catch (Exception ex){}

                AsyncHttpClient client = new AsyncHttpClient();
                String url = "https://api.mlab.com/api/1/databases/samlee/collections/Employees?apiKey=Nxu46qz3EY1ixdLipVPayQNfznZuAZPW";

                try {
                    StringEntity entity = new StringEntity(e.toString());
                    entity.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
                    client.post(MainActivity.this, url, entity,
                            "application/json", new AsyncHttpResponseHandler(){
                                @Override
                                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                                    Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                                    Toast.makeText(MainActivity.this, responseBody.toString() , Toast.LENGTH_SHORT).show();
                                }
                            });
                } catch (Exception ex){ex.printStackTrace();}
            }
        });

        /// Update Mongo
        Button updateMongo = findViewById(R.id.btnUpdateMongo) ;
        updateMongo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JSONObject v = new JSONObject();
                JSONObject e = new JSONObject();
                try {
                    v.put("Salary", 65000);
                    e.put("$set", v);
                } catch (Exception ex){ex.printStackTrace();}

                AsyncHttpClient client = new AsyncHttpClient();
                String url = "https://api.mlab.com/api/1/databases/samlee/collections/Employees/5add2c3dbd966f5a0a3628b9?apiKey=Nxu46qz3EY1ixdLipVPayQNfznZuAZPW";
                try {
                    StringEntity entity = new StringEntity(e.toString());
                    entity.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
                    client.put(MainActivity.this, url, entity,
                            "application/json", new TextHttpResponseHandler(){
                                @Override
                                public void onSuccess(int statusCode, Header[] headers, String responseString) {
                                    Toast.makeText(MainActivity.this, "success", Toast.LENGTH_LONG).show();

                                }

                                @Override
                                public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                                    Toast.makeText(MainActivity.this, responseString, Toast.LENGTH_LONG).show();
                                }
                            });
                } catch (Exception ex){ex.printStackTrace();}
            }
        });
    }
}
