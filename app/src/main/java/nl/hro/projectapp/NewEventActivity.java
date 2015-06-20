package nl.hro.projectapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import java.util.Calendar;
import java.util.Date;

import nl.hro.projectapp.common.Entities.Event;
import nl.hro.projectapp.common.EventManager;


public class NewEventActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event);


        Calendar cal = Calendar.getInstance();
        cal.set(2015, 6, 14, 15, 0);

        Event event = new Event();
        event.Name = "Trail";
        event.Date_Start = cal.getTime();
        event.Date_Start = cal.getTime();
        event.Date_End = event.Date_Start;
        event.Latitude = 51.935261;
        event.Longitude = 4.358891;
        event.Age_Min = 12;

        // event manager
        EventManager evmgr = new EventManager(getApplicationContext());


        evmgr.CreateEvent(event); // verstuur naar db?
    }
}
