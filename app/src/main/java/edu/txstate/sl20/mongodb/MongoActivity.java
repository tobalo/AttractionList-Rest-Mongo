package edu.txstate.sl20.mongodb;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.message.BasicHeader;

public class MongoActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<Header> headers = new ArrayList<Header>();
        headers.add(new BasicHeader("Accept", "application/json"));
        //https://api.mlab.com/api/1/databases/samlee/collections/Attractions?apiKey=Nxu46qz3EY1ixdLipVPayQNfznZuAZPW
        RestClient.get(this, "https://api.mlab.com/api/1/databases/samlee/collections/Employees?apiKey=Nxu46qz3EY1ixdLipVPayQNfznZuAZPW",headers.toArray(new Header[headers.size()]),
                null, new JsonHttpResponseHandler(){
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                        ArrayList<Employee> array = new ArrayList<Employee>();
                        for (int i=0; i < response.length(); i++){
                            try {
                                //The Json key is case sensitive.
                                String oid = response.getJSONObject(i).getJSONObject("_id").getString("$oid");
                                int eid = response.getJSONObject(i).getInt("EmployeeId");
                                String account = response.getJSONObject(i).getString("Account");
                                double salary = response.getJSONObject(i).getDouble("Salary");
                                Employee e = new Employee(oid, eid, account, salary);
                                array.add(e);
                                setListAdapter( new ArrayAdapter<Employee>(
                                        MongoActivity.this, android.R.layout.simple_list_item_1, array));
                            } catch (Exception ex) {}

                        }
                    }
                });
    }
}
