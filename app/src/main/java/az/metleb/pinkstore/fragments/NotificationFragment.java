package az.metleb.pinkstore.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import az.metleb.pinkstore.R;
import az.metleb.pinkstore.adapters.NotificationAdapter;


public class NotificationFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_notification, container, false);
        ListView listView = v.findViewById(R.id.notificationsList);
        NotificationAdapter adapter = new NotificationAdapter(getContext(), R.layout.notification_list_item);
        listView.setAdapter(adapter);
        return v;
    }
}