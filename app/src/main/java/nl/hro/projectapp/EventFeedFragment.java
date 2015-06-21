package nl.hro.projectapp;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.loopj.android.http.JsonHttpResponseHandler;
import nl.hro.projectapp.LocationService.LocationService;
import nl.hro.projectapp.common.CategoryManager;
import nl.hro.projectapp.common.Entities.Category;
import nl.hro.projectapp.common.Entities.Event;
import nl.hro.projectapp.common.EventManager;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EventFeedFragment extends android.support.v4.app.Fragment {

    View view;
    ArrayAdapter<String> adapter;
    ArrayList<Event> events = new ArrayList<Event>();

    List<HashMap<String, String>> fillMaps = new ArrayList<HashMap<String, String>>();
    EventManager eventManager;

    Context context;

    ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_event_feed, container, false);
        EventManager eventManager = new EventManager(this.getActivity());
        context = this.getActivity();

        //adapter = new ArrayAdapter<String>(context, R.layout.layout_event_list, R.id.firstLine, eventNames);

        listView = (ListView) view.findViewById(R.id.listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView adapterView, View view, int position, long id) {
                SimpleAdapter adapter = (SimpleAdapter) adapterView.getAdapter();

                Object item = adapter.getItem(position);
                Intent intent = new Intent(context, EventDetailActivity.class);

                intent.putExtra("id", ""+position);

                startActivity(intent);
            }
        });

        eventManager.client.get("/events", null, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    if (!response.getBoolean("error")) {
                        JSONArray events = response.getJSONArray("events");


                        new EventAsyncTask().execute(events);
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

        return view;
    }

    private class EventAsyncTask extends AsyncTask<JSONArray, Void, List<HashMap<String, String>>> {
        @Override
        protected List<HashMap<String, String>> doInBackground(JSONArray... events) {

            JSONArray eventsList = events[0];

            try {

                for (int i = 0; i < eventsList.length(); i++) {
                    JSONObject jsonEvent = eventsList.getJSONObject(i);

                    HashMap<String, String> map = new HashMap<String, String>();
                    map.put("EventID", "" + jsonEvent.get("EventID").toString());
                    map.put("Name", "" + jsonEvent.get("Name").toString());
                    map.put("Date_Start", "" + jsonEvent.get("Date_Start").toString());

                    LocationService locationService = new LocationService(context);

                    if (jsonEvent.get("Latitude").toString() != "null" && jsonEvent.get("Longitude").toString() != "null") {
                        Double latitude = Double.parseDouble(jsonEvent.get("Latitude").toString());
                        Double longitude = Double.parseDouble(jsonEvent.get("Longitude").toString());

                        List<Address> address = locationService.getAddress(latitude, longitude);

                        map.put("City", "" + address.get(0).getLocality());
                        map.put("Street", "" + address.get(0).getThoroughfare());
                    } else {
                        map.put("City", "Not specified" );
                        map.put("Street", "Not specified");
                    }

                    fillMaps.add(map);
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return fillMaps;
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(List<HashMap<String, String>> results) {

            String[] from = new String[]{"EventID", "City", "Date_Start", "Street", "Name"};
            int[] to = new int[]{R.id.firstLine, R.id.secondLine, R.id.thirdLine, R.id.fourthLine, R.id.fifthLine};

            SimpleAdapter eventAdapter = new SimpleAdapter(context, results, R.layout.layout_event_list, from, to);
            listView.setAdapter(eventAdapter);
        }
    }
}


