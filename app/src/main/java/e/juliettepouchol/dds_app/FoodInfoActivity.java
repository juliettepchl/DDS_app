package e.juliettepouchol.dds_app;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class FoodInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_info);
        ImageView nutrition_image = findViewById(R.id.food_info);
        nutrition_image.setImageDrawable(getResources().getDrawable(R.drawable.billybob));
    }
}
