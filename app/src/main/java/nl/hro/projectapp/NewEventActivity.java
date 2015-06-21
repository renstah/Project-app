package nl.hro.projectapp;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

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


    }

    public void submitNewEvent(View v){
        // get project name
        EditText et = (EditText) findViewById(R.id.input_event_name);
        String event_name = et.getText().toString();

        // get time fields
        TimePicker start_time = (TimePicker) findViewById(R.id.input_start_time);

        int start_hour = start_time.getCurrentHour();
        int start_minute = start_time.getCurrentMinute();

        TimePicker end_time = (TimePicker) findViewById(R.id.input_end_time);
        int end_hour = end_time.getCurrentHour();
        int end_minute = end_time.getCurrentMinute();

        DatePicker start_date = (DatePicker) findViewById(R.id.input_start_date);
        int start_day = start_date.getDayOfMonth();
        int start_month = start_date.getMonth();
        int start_year = start_date.getYear();

        // TODO end date


        //  TODO datum en tijd parsen in datetime
        Calendar start_cal = Calendar.getInstance();
        start_cal.set( start_year, start_month, start_day, start_hour, start_minute);


        // minimum age

        het = (EditText) findViewById(R.id.input_minimum_age);
        Short minimum_age = Short.parseShort( et.getText().toString() );
        //Context context = v.getContext();
        //Toast.makeText(context, minimum_age, Toast.LENGTH_LONG).show();


        // create the event
        Event event = new Event();
        event.Name = event_name;
        event.Date_Start = start_cal.getTime();
        event.Date_End = event.Date_Start;
        event.Latitude = 51.935261;
        event.Longitude = 4.358891;
        event.Age_Min = (short) minimum_age;

        // event manager
        EventManager evmgr = new EventManager(getApplicationContext());

        evmgr.CreateEvent(event); // verstuur naar db?


    }


}
