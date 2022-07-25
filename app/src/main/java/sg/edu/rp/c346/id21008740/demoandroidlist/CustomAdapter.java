package sg.edu.rp.c346.id21008740.demoandroidlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<ToDoItem> TodoList;

    public CustomAdapter(Context context, int resource,
                         ArrayList<ToDoItem> objects){
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        TodoList = objects;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tvName = rowView.findViewById(R.id.textViewName);
        TextView tvVersion = rowView.findViewById(R.id.textViewVersion);

        // Obtain the Android Version information based on the position
        ToDoItem currentVersion = TodoList.get(position);



            // Set values to the TextView to display the corresponding information
        Calendar date = currentVersion.getDate();
            String str = date.get(Calendar.DAY_OF_MONTH)+"/"+date.get(Calendar.MONTH)
                    +"/"+date.get(Calendar.YEAR);
        tvName.setText(currentVersion.getTitle());
        tvVersion.setText(str);

        return rowView;
    }


}
