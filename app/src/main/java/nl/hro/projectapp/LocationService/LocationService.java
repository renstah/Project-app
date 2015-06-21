package nl.hro.projectapp.LocationService;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.util.Log;

import java.util.List;
import java.util.Locale;

/**
 * Created by lorenzo on 6/21/15.
 */

public class LocationService {

    Context context;

    public LocationService(Context context) {
        this.context = context;
    }

    public List getAddress(Double latitude, Double longitude) {
        Geocoder geocoder;
        List<Address> address;
        geocoder = new Geocoder(this.context, Locale.getDefault());

        try {
            address = geocoder.getFromLocation(latitude, longitude, 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5

            return address;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

}
