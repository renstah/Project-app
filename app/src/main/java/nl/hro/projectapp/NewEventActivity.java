package nl.hro.projectapp;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

import java.util.Calendar;
import java.util.Date;

import nl.hro.projectapp.common.Entities.Event;
import nl.hro.projectapp.common.EventManager;


public class NewEventActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event);

        // get time fields
        TimePicker start_time = (TimePicker) findViewById(R.id.input_start_time);
        TimePicker end_time = (TimePicker) findViewById(R.id.input_end_time);

        // set to 24h format
        start_time.setIs24HourView(Boolean.TRUE);
        end_time.setIs24HourView(Boolean.TRUE);


        Calendar cal = Calendar.getInstance();
        cal.set(2015, 6, 14, 15, 0);

        Event event = new Event();
        event.Name = "Trail";
        event.Date_Start = cal.getTime();
        event.Date_End = event.Date_Start;
        event.Latitude = 51.935261;
        event.Longitude = 4.358891;
        event.Age_Min = 12;


        // event manager
        EventManager evmgr = new EventManager(getApplicationContext());

        // evmgr.CreateEvent(event); // verstuur naar db?
    }

    public void submitNewEvent(){
        // get project name
        String event_name = (String) findViewById(R.id.input_event_name).toString();

        // get time fields
        TimePicker start_time = (TimePicker) findViewById(R.id.input_start_time);
        TimePicker end_time = (TimePicker) findViewById(R.id.input_end_time);
        DatePicker start_date = (DatePicker) findViewById(R.id.input_start_date);
        // TODO end date

        // get


    }


}
