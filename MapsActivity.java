package am.aamchiimumbai;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.firestore.GeoPoint;

import am.aamchiimumbai.Models.DemoFood;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private GeoPoint geoPoint;
    private double latitude, longitude;
    //private double latitudee, longitudee;

    private  String foodName;
    private String placeName;
//ou i pyar youuuuuuuuu i pyar uuuu toooo ok byebyeee
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        Bundle bundle = getIntent().getExtras();

        if (bundle.getInt("key") == 0) {


            // Bundle bundle = getIntent().getExtras();
            latitude = bundle.getDouble("foodLat", 0.0);
            longitude = bundle.getDouble("foodLong", 0.0);
            foodName = bundle.getString("foodName");
            mapFragment.getMapAsync(this);
        } else {
            //bundle = getIntent().getExtras();
            latitude = bundle.getDouble("placeLat",0.0);
            longitude = bundle.getDouble("placeLong",0.0);
            placeName = bundle.getString("placeName");

            mapFragment.getMapAsync(this);
        }
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
//
//        // Add a marker in Sydney and move the camera
        //Done and dusted run kr
        LatLng marker = new LatLng(latitude, longitude);
        Log.e("marker",marker.toString());
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker,15));
        // Zoom in, animating the camera.
        mMap.addMarker(new MarkerOptions().position(marker).title(foodName));
        mMap.addMarker(new MarkerOptions().position(marker).title(placeName));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(marker, 18));
    }
}
