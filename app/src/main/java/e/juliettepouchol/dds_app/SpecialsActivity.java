package e.juliettepouchol.dds_app;

import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class SpecialsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);


        ImageView nutrition_image = findViewById(R.id.nutrition_image);
        nutrition_image.setImageDrawable(getResources().getDrawable(R.drawable.veggie_burger));
    }
}
