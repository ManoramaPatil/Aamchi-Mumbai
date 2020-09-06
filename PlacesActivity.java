package am.aamchiimumbai;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import am.aamchiimumbai.Models.DemoPlace;

public class PlacesActivity extends AppCompatActivity {
private  Button btnBack;
    private static final String TAG ="MainActivity" ;
    private static final  String COLLECTION_NAME = "DemoPlace";
    private FirebaseFirestore db;

   // private placeAdapter adapter;

    List<DemoPlace> demoPlaceList;
    RecyclerView rv_places;
    DemoPlaceAdapter demoPlaceAdapter;
   // Button btn_back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);




        demoPlaceList = new ArrayList<>();
        db = FirebaseFirestore.getInstance();
        loadData();


        //btn_back = findViewById(R.id.btn_back);
        rv_places = findViewById(R.id.rv_places);

        demoPlaceAdapter = new DemoPlaceAdapter(demoPlaceList,this);
        rv_places.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rv_places.setLayoutManager(layoutManager);
        rv_places.setAdapter(demoPlaceAdapter);
        demoPlaceAdapter.notifyDataSetChanged();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



    }

    private void loadData() {
        db.collection("DemoPlace").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                for(DocumentSnapshot documentSnapshot : task.getResult()){
                    DemoPlace demoPlace = new DemoPlace(documentSnapshot.getString("placeName"),
                            documentSnapshot.getString("placeBusStop"),
                            documentSnapshot.getString("placeCabs"),
                            documentSnapshot.getString("placeBestTime"),
                            documentSnapshot.getString("placeEntryFees"),
                            documentSnapshot.getString("placeHistory"),
                            documentSnapshot.getString("placeHowFar"),
                            documentSnapshot.getString("placeHowToReach"),
                            documentSnapshot.getString("placeHighlights"),
                            documentSnapshot.getString("placeInfo"),
                            documentSnapshot.getString("placeLocation"),
                            documentSnapshot.getString("placeNearbyPlaces"),
                            documentSnapshot.getString("placeReadMore"),
                            documentSnapshot.getString("placeImageUrl"),
                            documentSnapshot.getGeoPoint("placeGeo"))
                            ;

                    demoPlaceList.add(demoPlace);
                    demoPlaceAdapter.notifyDataSetChanged(); //bhagwan ka naam le and lets hope gooogle drive restrict na kare access
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(PlacesActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                Intent intent=new Intent(PlacesActivity.this, OptionsActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        return true;
    }




}




