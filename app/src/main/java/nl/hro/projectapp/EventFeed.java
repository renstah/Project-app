package nl.hro.projectapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class EventFeed extends android.support.v4.app.Fragment {

    public EventFeed() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Context context = this.getActivity().getApplicationContext();
        //Toast.makeText(context, "aap", Toast.LENGTH_LONG).show();

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event_feed, container, false);
        Context context = this.getActivity().getApplicationContext();
        Toast.makeText(context, "aap", Toast.LENGTH_LONG).show();
        return view;
    }


}
