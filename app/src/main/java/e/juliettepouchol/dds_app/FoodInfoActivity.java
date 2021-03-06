package e.juliettepouchol.dds_app;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class FoodInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        final String food_name = getIntent().getStringExtra("EXTRA_FOOD");
        if(food_name.equals("French Fries")){
            ((ImageView)findViewById(R.id.nutrition_image)).setImageDrawable(getResources().getDrawable(R.drawable.french_fries_info));
        }
        else if(food_name.equals("Billy Bob")){
            ((ImageView)findViewById(R.id.nutrition_image)).setImageDrawable(getResources().getDrawable(R.drawable.billy_bob));
        }
        else if(food_name.equals("New England Salad")){
            ((ImageView)findViewById(R.id.nutrition_image)).setImageDrawable(getResources().getDrawable(R.drawable.new_england_salad));
        }
        else if(food_name.equals("Thai Chicken Noodle Soup")){
            ((ImageView)findViewById(R.id.nutrition_image)).setImageDrawable(getResources().getDrawable(R.drawable.thai_chicken_noodle_soup));
        }
        else if(food_name.equals("Chicken Stir Fry")){
            ((ImageView)findViewById(R.id.nutrition_image)).setImageDrawable(getResources().getDrawable(R.drawable.chicken_stir_fry));
        }
    }
}
