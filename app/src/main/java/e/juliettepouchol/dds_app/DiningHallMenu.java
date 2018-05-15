package e.juliettepouchol.dds_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class DiningHallMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dining_hall_menu);
        final String dining_hall = getIntent().getStringExtra("EXTRA_DH");

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
