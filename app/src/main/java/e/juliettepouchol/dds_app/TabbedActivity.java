package e.juliettepouchol.dds_app;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TabbedActivity extends ListActivity {

    private TextView mTextMessage;
    public String current_category;
    public String dining_hall;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.entrees:
                    ((ImageView)findViewById(R.id.nutrition_image2)).setVisibility(View.INVISIBLE);
                    findViewById(R.id.list_layout).setVisibility(View.VISIBLE);
                    findViewById(R.id.help_button3).setVisibility(View.VISIBLE);
                    findViewById(R.id.preferences_button3).setVisibility(View.VISIBLE);
                    current_category = "entree";
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
                    return true;
                case R.id.beverages:
                    ((ImageView)findViewById(R.id.nutrition_image2)).setVisibility(View.INVISIBLE);
                    findViewById(R.id.list_layout).setVisibility(View.VISIBLE);
                    findViewById(R.id.help_button3).setVisibility(View.VISIBLE);
                    findViewById(R.id.preferences_button3).setVisibility(View.VISIBLE);
                    current_category = "beverage";
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
                    return true;
                case R.id.deserts:
                    ((ImageView)findViewById(R.id.nutrition_image2)).setVisibility(View.INVISIBLE);
                    findViewById(R.id.list_layout).setVisibility(View.VISIBLE);
                    findViewById(R.id.help_button3).setVisibility(View.VISIBLE);
                    findViewById(R.id.preferences_button3).setVisibility(View.VISIBLE);
                    current_category = "desert";
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
                    return true;
                case R.id.sides:
                    current_category = "side";
                    ((ImageView)findViewById(R.id.nutrition_image2)).setVisibility(View.INVISIBLE);
                    findViewById(R.id.list_layout).setVisibility(View.VISIBLE);
                    findViewById(R.id.help_button3).setVisibility(View.VISIBLE);
                    findViewById(R.id.preferences_button3).setVisibility(View.VISIBLE);
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
                    return true;
                case R.id.special:
                    ImageView image_view = ((ImageView)findViewById(R.id.nutrition_image2));
                    image_view.setImageDrawable(getResources().getDrawable(R.drawable.veggie_burger));
                    image_view.setVisibility(View.VISIBLE);
                    findViewById(R.id.list_layout).setVisibility(View.INVISIBLE);
                    findViewById(R.id.help_button3).setVisibility(View.INVISIBLE);
                    findViewById(R.id.preferences_button3).setVisibility(View.INVISIBLE);
                    return true;
            }
            return false;
        }
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) this.findViewById(R.id.navigation);
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) bottomNavigationView.getChildAt(0);
        for (int i = 0; i < menuView.getChildCount(); i++) {
            final View iconView = menuView.getChildAt(i).findViewById(android.support.design.R.id.icon);
            final ViewGroup.LayoutParams layoutParams = iconView.getLayoutParams();
            final DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            // set your height here
            layoutParams.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24
                    , displayMetrics);
            // set your width here
            layoutParams.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 42, displayMetrics);
            iconView.setLayoutParams(layoutParams);
        }

        findViewById(R.id.help_button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builder = new AlertDialog.Builder(TabbedActivity.this, android.R.style.Theme_Material_Dialog_Alert);
                } else {
                    builder = new AlertDialog.Builder(TabbedActivity.this);
                }
                builder.setTitle("Welcome to Ditching Dartmouth Struggles!")
                        .setMessage(R.string.help_content)
                        .show();
            }
        });

        findViewById(R.id.preferences_button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent settingsIntent = new Intent(TabbedActivity.this, SettingsActivity.class);
                startActivity(settingsIntent);
            }
        });

        current_category = "entree";

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        dining_hall = getIntent().getStringExtra("EXTRA_DH");



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

    @Override
    protected void onResume() {
        super.onResume();
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
        Map<String, String> category_item = new HashMap();
        Map<String, ArrayList<String>> item_restriction = new HashMap<String, ArrayList<String>>();
        for(String item : list){
            ArrayList<String> restrictions = new ArrayList<String>();
            String[] items = item.split("\\|");
            for(String restriction :items[2].split(",")){
                restrictions.add(restriction);
            }

            category_item.put(items[0], items[1]);
            item_restriction.put(items[0], restrictions);
            menu.add(items[0]);
        }

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String restriction = prefs.getString("diet_list", "default");
        // initiate the listadapter

        if(restriction.equals("none")){

            ArrayList<String> categorized_menu = new ArrayList<String>();
            for(String item : menu){
                if(category_item.get(item).equals(current_category)){
                    categorized_menu.add(item);
                }
            }
            ArrayAdapter<String> myAdapter = new ArrayAdapter <String>(this, R.layout.row_layout, R.id.listText, categorized_menu);
            setListAdapter(myAdapter);
        }

        else {
            ArrayList<String> filtered_menu = new ArrayList<String>();
            for(String item : menu){
                if((item_restriction.get(item).contains(restriction)) && (category_item.get(item).equals(current_category))){
                    filtered_menu.add(item);
                }
            }

            ArrayAdapter<String> myAdapter = new ArrayAdapter <String>(this, R.layout.row_layout, R.id.listText, filtered_menu);
            setListAdapter(myAdapter);
        }
    }
    @Override
    protected void onListItemClick(ListView list, View view, int position, long id) {
        Intent intent = new Intent(getApplicationContext(), FoodInfoActivity.class);
        String selectedFromList = (String) list.getItemAtPosition(position);
        intent.putExtra("EXTRA_FOOD", selectedFromList);
        startActivity(intent);

    }

}
