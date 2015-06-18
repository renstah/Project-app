package nl.hro.projectapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nl.hro.projectapp.common.CategoryManager;
import nl.hro.projectapp.common.Entities.Category;
import nl.hro.projectapp.common.EventManager;

public class EventFeedFragment extends android.support.v4.app.Fragment {

    public EventFeedFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event_feed, container, false);
        CategoryManager categoryManager = new CategoryManager(getActivity());
        List<Category> categories = categoryManager.GetCategories();
        return view;
    }


}
