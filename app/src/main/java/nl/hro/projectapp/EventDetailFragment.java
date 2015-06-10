package nl.hro.projectapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import nl.hro.projectapp.dummy.DummyContent;

public class EventDetailFragment extends android.support.v4.app.Fragment {

    public EventDetailFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event_detail, container, false);

        return view;
    }
}
