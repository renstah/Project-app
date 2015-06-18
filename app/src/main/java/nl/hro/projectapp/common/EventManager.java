package nl.hro.projectapp.common;

import android.util.Log;
import com.google.gson.Gson;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.apache.http.entity.StringEntity;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import nl.hro.projectapp.common.Entities.Event;

/**
 * Created by Lex on 15-6-2015.
 */
public class EventManager {


    Gson gson;
    public EventManager()
    {
        this.gson = new Gson();
    }


    public void CreateEvent(Event event){

        StringEntity entity = null;
        try {
            entity = new StringEntity(gson.toJson(event));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        SpeetRestClient.post("event/create",null, entity, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                //TODO response verwerken naar user data
                super.onSuccess(statusCode, headers, response);
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                int a = statusCode;
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });
    }

    public List<Event> getEvents() {

        List<Event> events = new ArrayList<Event>();

        SpeetRestClient.get("/events", null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);

                System.out.println(statusCode);
                System.out.println(response);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);

                System.out.println(statusCode);
                System.out.println(errorResponse);
            }
        });


        return events;
    }
}
