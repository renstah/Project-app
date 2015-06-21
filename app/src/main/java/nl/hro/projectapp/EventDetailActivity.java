package nl.hro.projectapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.loopj.android.http.JsonHttpResponseHandler;
import nl.hro.projectapp.common.EventManager;
import nl.hro.projectapp.dummy.DummyContent;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

public class EventDetailActivity extends BaseActivity {

    public EventDetailActivity() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_event_detail);

        int id = Integer.parseInt(getIntent().getStringExtra("id").toString());
        this.fillInData(id);
    }

    private void fillInData(int id) {

        final TextView textView = (TextView) findViewById(R.id.eventlist_detail);

        EventManager eventManager = new EventManager(this);
        eventManager.client.get("/event/" + id, null, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    if (!response.getBoolean("error")) {
                        textView.setText(response.toString());
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

                super.onSuccess(statusCode, headers, response);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                System.out.println(errorResponse);
            }
        });

    }
}
