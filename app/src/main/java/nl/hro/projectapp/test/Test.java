package nl.hro.projectapp.test;

import android.content.Context;
import android.widget.Toast;
import java.util.Date;

import nl.hro.projectapp.common.Entities.Event;
import nl.hro.projectapp.common.EventManager;
import nl.hro.projectapp.common.SpeetRestClient;

/**
 * Created by walter on 18-6-15.
 */
public class Test {

    public static void events(Context context) {
        /*
        Testcode voor 't aanmaken van 'n nieuw event en later sturen naar db en halen van db
        Aanroepen met Test.events( Context );
        Context aangeven voor het printen van toast messages/
        */

        // 'n event
        Event event = new Event();
        event.Name = "Trail";
        event.Date_Start = new Date( 14, 6, 2015);
        event.Date_End = event.Date_Start;
        event.Latitude = 51.935261;
        event.Longitude = 4.358891;
        event.Age_Min = 12;

        // event manager
        EventManager evmgr = new EventManager(context);


        evmgr.CreateEvent( event ); // verstuur naar db?


        // 'n print om te kijken of het tot hier loopt
        Toast.makeText( context, "eventtest crasht niet", Toast.LENGTH_LONG).show();
    }

}

