package e.juliettepouchol.dds_app;

import android.app.ListActivity;
import android.database.Cursor;
import android.provider.Contacts;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.app.ListActivity;

public class MenuActivity extends ListActivity {

    private TextView text;
    private List<String> listValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_list_activity_view);

        final String dining_hall = getIntent().getStringExtra("EXTRA_DH");
        text = (TextView) findViewById(R.id.mainText);
        text.setText(dining_hall + " Menu");


        if(dining_hall.equals("Collis")) {
            String [] menu = getResources().getStringArray(R.array.collis_menu);
            // initiate the listadapter
            ArrayAdapter<String> myAdapter = new ArrayAdapter <String>(this, R.layout.row_layout, R.id.listText, menu);

            // assign the list adapter
            setListAdapter(myAdapter);
        }
        else if(dining_hall.equals("Hop")) {
            String [] menu = getResources().getStringArray(R.array.hop_menu);
            // initiate the listadapter
            ArrayAdapter<String> myAdapter = new ArrayAdapter <String>(this, R.layout.row_layout, R.id.listText, menu);

            // assign the list adapter
            setListAdapter(myAdapter);
        }
        if(dining_hall.equals("Kaf")) {
            String [] menu = getResources().getStringArray(R.array.kaf_menu);
            // initiate the listadapter
            ArrayAdapter<String> myAdapter = new ArrayAdapter <String>(this, R.layout.row_layout, R.id.listText, menu);

            // assign the list adapter
            setListAdapter(myAdapter);
        }
        if(dining_hall.equals("Novack")) {
            String [] menu = getResources().getStringArray(R.array.novack_menu);
            // initiate the listadapter
            ArrayAdapter<String> myAdapter = new ArrayAdapter <String>(this, R.layout.row_layout, R.id.listText, menu);

            // assign the list adapter
            setListAdapter(myAdapter);
        }





    }

    // when an item of the list is clicked
    @Override
    protected void onListItemClick(ListView list, View view, int position, long id) {
        super.onListItemClick(list, view, position, id);

        String selectedItem = (String) getListView().getItemAtPosition(position);
        //String selectedItem = (String) getListAdapter().getItem(position);

    }

}