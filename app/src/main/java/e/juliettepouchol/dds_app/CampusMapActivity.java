package e.juliettepouchol.dds_app;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CampusMapActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {
    private GoogleMap mMap;
    private LatLng dartmouthCampus = new LatLng(43.703748313891886, -72.28884890179347);
    private LatLng Collis = new LatLng(43.702668, -72.289846);
    private LatLng Hop = new LatLng(43.701827, -72.288270);
    private LatLng Kaf = new LatLng(43.705151,-72.288507 );
    private LatLng Novack = new LatLng(43.705837, -72.289323);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campus_map);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        findViewById(R.id.help_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builder = new AlertDialog.Builder(CampusMapActivity.this, android.R.style.Theme_Material_Dialog_Alert);
                } else {
                    builder = new AlertDialog.Builder(CampusMapActivity.this);
                }
                builder.setTitle("Welcome to Ditching Dartmouth Struggles!")
                        .setMessage(R.string.help_content)
                        .show();
            }
        });

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        BitmapDescriptor hop_icon = BitmapDescriptorFactory.fromResource(R.drawable.hop_icon);
        BitmapDescriptor collis_icon = BitmapDescriptorFactory.fromResource(R.drawable.collis_icon);
        BitmapDescriptor kaf_icon = BitmapDescriptorFactory.fromResource(R.drawable.kaf_icon);
        BitmapDescriptor novack_icon = BitmapDescriptorFactory.fromResource(R.drawable.novack_icon);
        // Add markers at the different dining halls, change color, move camera

        mMap.addMarker(new MarkerOptions().position(Collis).title("Collis")
                .icon(collis_icon));

        mMap.addMarker(new MarkerOptions().position(Hop).title("Hop")
                .icon(hop_icon));

        mMap.addMarker(new MarkerOptions().position(Kaf).title("Kaf")
                .icon(kaf_icon));

        mMap.addMarker(new MarkerOptions().position(Novack).title("Novack")
                .icon(novack_icon));

        googleMap.setOnMarkerClickListener(this);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(dartmouthCampus));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(dartmouthCampus, 17.0f));


        findViewById(R.id.preferences).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent settingsIntent = new Intent(CampusMapActivity.this, SettingsActivity.class);
                startActivity(settingsIntent);
            }
        });
    }

    @Override
    public boolean onMarkerClick(Marker marker) {

        marker.showInfoWindow();
        Intent markerIntent = new Intent(CampusMapActivity.this, DiningHallMenu.class);
        markerIntent.putExtra("EXTRA_DH", marker.getTitle().toString());
        startActivity(markerIntent);
        return true;
    }
}
