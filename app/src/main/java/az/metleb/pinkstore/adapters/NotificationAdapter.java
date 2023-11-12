package az.metleb.pinkstore.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import az.metleb.pinkstore.R;

public class NotificationAdapter extends ArrayAdapter {
    private Context context;
    private int resource;
    public NotificationAdapter(@NonNull Context context, int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
    }

    @Override
    public int getCount() {
        return  20;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(this.resource, null);
        }

        TextView title = (TextView) v.findViewById(R.id.notificationTitle);
        title.setText(String.format("Basliq: %d", position+1));
        TextView description = (TextView) v.findViewById(R.id.notificationDescription);
        description.setText(String.format("Aciqlama: %d", position+1));
        return  v;
    }
}
