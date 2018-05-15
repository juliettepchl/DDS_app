package e.juliettepouchol.dds_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

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

        final String dining_hall = getIntent().getStringExtra("EXTRA_DH");
        ImageView graph = findViewById(R.id.imageView);

        if(dining_hall.equals("Collis")) {
            graph.setImageDrawable(getResources().getDrawable(R.drawable.collis_graph));
        }
        else if(dining_hall.equals("Hop")) {
            graph.setImageDrawable(getResources().getDrawable(R.drawable.hop_graph));
        }
        if(dining_hall.equals("Kaf")) {
            graph.setImageDrawable(getResources().getDrawable(R.drawable.kaf_graph));
        }
        if(dining_hall.equals("Novack")) {
            graph.setImageDrawable(getResources().getDrawable(R.drawable.novack_graph));
        }



        Button menu = findViewById(R.id.menu_button);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent menu_intent = new Intent(DiningHallMenu.this, MenuActivity.class);
                menu_intent.putExtra("EXTRA_DH", dining_hall);
                startActivity(menu_intent);
            }
        });
    }
}
