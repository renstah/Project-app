package nl.hro.projectapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.loopj.android.http.JsonHttpResponseHandler;
import nl.hro.projectapp.common.CategoryManager;
import nl.hro.projectapp.common.Entities.Category;
import nl.hro.projectapp.common.Entities.Event;
import nl.hro.projectapp.common.EventManager;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

public class EventFeedFragment extends android.support.v4.app.Fragment {

    ArrayAdapter<String> adapter;
    ListView listView;
    ArrayList<String> eventNames = new ArrayList<String>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_event_feed, container, false);

        listView = (ListView)view.findViewById(R.id.listView);

        final EventManager eventManager = new EventManager(this.getActivity());
        final Context context = this.getActivity();

        eventNames.add("Lorenzo");
        eventNames.add("Lex");
        eventNames.add("Walter");

        adapter = new ArrayAdapter<String>(context, R.layout.fragment_event_feed, eventNames);
        listView.setAdapter(adapter);

//        eventManager.client.get("/events", null, new JsonHttpResponseHandler() {
//
//            @Override
//            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
//                System.out.println(response);
//                try {
//                    if (!response.getBoolean("error")) {
//                        JSONArray events = response.getJSONArray("events");
//                        for (int i = 0; events.length() < i; i++) {
//                            Event event = eventManager.gson.fromJson(events.getString(i), Event.class);
//                            eventNames.add(event.Name);
//                        }
//
//                        adapter = new ArrayAdapter<String>(context, R.layout.fragment_event_feed, eventNames);
//                        listView.setAdapter(adapter);
//                        view.invalidate();
//
//                    }
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//                super.onSuccess(statusCode, headers, response);
//            }
//
//            @Override
//            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
//                super.onFailure(statusCode, headers, throwable, errorResponse);
//                System.out.println(errorResponse);
//            }
//        });

        return view;
    }

    private void getEvents() {

    }
}
