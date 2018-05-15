package e.juliettepouchol.dds_app;

import android.app.ListActivity;
import android.content.SharedPreferences;
import android.os.Bundle;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
            String [] list = getResources().getStringArray(R.array.collis_menu);
            set_up_list(list);

        }
        else if(dining_hall.equals("Hop")) {
            String [] list = getResources().getStringArray(R.array.hop_menu);
            set_up_list(list);
        }
        if(dining_hall.equals("Kaf")) {
            String [] list = getResources().getStringArray(R.array.kaf_menu);
            set_up_list(list);
        }
        if(dining_hall.equals("Novack")) {
            String [] list = getResources().getStringArray(R.array.novack_menu);
            set_up_list(list);
        }
    }

    public void set_up_list(String[] list){
        ArrayList<String> menu = new ArrayList();
        Map<String, ArrayList<String>> item_restriction = new HashMap<String, ArrayList<String>>();
        for(String item : list){
            ArrayList<String> restrictions = new ArrayList<String>();
            String[] items = item.split("\\|");
            for(String restriction :items[1].split(",")){
                restrictions.add(restriction);
            }
            item_restriction.put(items[0], restrictions);
            menu.add(items[0]);
        }

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String restriction = prefs.getString("diet_list", "default");
        // initiate the listadapter

        if(restriction.equals("none")){
            ArrayAdapter<String> myAdapter = new ArrayAdapter <String>(this, R.layout.row_layout, R.id.listText, menu);
            setListAdapter(myAdapter);
        }

        else {
            ArrayList<String> filtered_menu = new ArrayList<String>();
            for(String item : menu){
                if(item_restriction.get(item).contains(restriction)){
                    filtered_menu.add(item);
                }
            }

            ArrayAdapter<String> myAdapter = new ArrayAdapter <String>(this, R.layout.row_layout, R.id.listText, filtered_menu);
            setListAdapter(myAdapter);
        }


        // assign the list adapter


    }
    // when an item of the list is clicked
    @Override
    protected void onListItemClick(ListView list, View view, int position, long id) {
        super.onListItemClick(list, view, position, id);

        String selectedItem = (String) getListView().getItemAtPosition(position);
        //String selectedItem = (String) getListAdapter().getItem(position);

    }

}