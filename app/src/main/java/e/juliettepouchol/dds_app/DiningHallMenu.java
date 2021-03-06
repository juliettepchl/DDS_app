package e.juliettepouchol.dds_app;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;

public class DiningHallMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dining_hall_menu);
        EditText people = findViewById(R.id.people);
        EditText wait = findViewById(R.id.wait);
        people.setEnabled(false);
        people.setClickable(false);
        wait.setEnabled(false);
        wait.setClickable(false);

        findViewById(R.id.help_button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builder = new AlertDialog.Builder(DiningHallMenu.this, android.R.style.Theme_Material_Dialog_Alert);
                } else {
                    builder = new AlertDialog.Builder(DiningHallMenu.this);
                }
                builder.setTitle("Welcome to Ditching Dartmouth Struggles!")
                        .setMessage(R.string.help_content)
                        .show();
            }
        });

        findViewById(R.id.preferences_button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent settingsIntent = new Intent(DiningHallMenu.this, SettingsActivity.class);
                startActivity(settingsIntent);
            }
        });

        final String dining_hall = getIntent().getStringExtra("EXTRA_DH");
        ImageView graph = findViewById(R.id.imageView);
        EditText wait_view = (EditText)findViewById(R.id.wait);
        EditText people_view = (EditText)findViewById(R.id.people);

        if(dining_hall.equals("Collis")) {
            graph.setImageDrawable(getResources().getDrawable(R.drawable.collis_flow));
            ((TextView)findViewById(R.id.title)).setText("COLLIS");
            wait_view.setText(R.string.pref_collis_wait);
            people_view.setText(R.string.pref_collis_people);
        }
        else if(dining_hall.equals("Hop")) {
            graph.setImageDrawable(getResources().getDrawable(R.drawable.hop_graph));
            wait_view.setText(R.string.pref_hop_wait);
            ((TextView)findViewById(R.id.title)).setText("HOP");
            people_view.setText(R.string.pref_hop_people);
        }
        if(dining_hall.equals("Kaf")) {
            graph.setImageDrawable(getResources().getDrawable(R.drawable.kaf_chart));
            ((TextView)findViewById(R.id.title)).setText("KAF");
            wait_view.setText(R.string.pref_kaf_wait);
            people_view.setText(R.string.pref_kaf_people);
        }
        if(dining_hall.equals("Novack")) {
            graph.setImageDrawable(getResources().getDrawable(R.drawable.novack_graph));
            ((TextView)findViewById(R.id.title)).setText("NOVACK");
            wait_view.setText(R.string.pref_novack_wait);
            people_view.setText(R.string.pref_novack_people);
        }



        final Button menu = findViewById(R.id.menu_button);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent menu_intent = new Intent(DiningHallMenu.this, MenuActivity.class);
                menu_intent.putExtra("EXTRA_DH", dining_hall);
                startActivity(menu_intent);*/
                Intent menu_intent = new Intent(DiningHallMenu.this, TabbedActivity.class);
                menu_intent.putExtra("EXTRA_DH", dining_hall);
                startActivity(menu_intent);
            }
        });
    }
}
