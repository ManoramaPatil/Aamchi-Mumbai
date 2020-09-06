package am.aamchiimumbai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

import am.aamchiimumbai.Models.DemoFood;

public class FoodActivity extends AppCompatActivity {

    private  Button btnBack ;
    private static final String TAG ="MainActivity" ;
    private static final  String COLLECTION_NAME = "Reastaurants";
    private FirebaseFirestore db;



  // private foodAdapter adapter;

    List<DemoFood> demoFoodList;
    RecyclerView rv_food;
    DemoFoodAdapter demoFoodAdapter;
    //Button btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        demoFoodList = new ArrayList<>();
        db = FirebaseFirestore.getInstance();
        loadData();


       // btn_back = findViewById(R.id.btn_back);
        rv_food = findViewById(R.id.rv_food);

        demoFoodAdapter = new DemoFoodAdapter(demoFoodList,this);
        rv_food.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rv_food.setLayoutManager(layoutManager);
        rv_food.setAdapter(demoFoodAdapter);
        demoFoodAdapter.notifyDataSetChanged();


    }

    private void loadData() {
        db.collection("Reastaurants").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                for(DocumentSnapshot documentSnapshot : task.getResult()){
                    DemoFood demoFood = new DemoFood(documentSnapshot.getString("foodName"),
                            documentSnapshot.getString("foodAddress"),
                            documentSnapshot.getString("foodDistance"),
                            documentSnapshot.getString("foodNear"),
                            documentSnapshot.getString("foodPhoneNumber"),
                            documentSnapshot.getString("foodRatings"),
                            documentSnapshot.getString("foodTimings"),
                            documentSnapshot.getString("foodType"),
                            documentSnapshot.getGeoPoint("foodGeo")
                    )
                            ;

                    demoFoodList.add(demoFood);
                    demoFoodAdapter.notifyDataSetChanged(); //c
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(FoodActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                Intent intent=new Intent(FoodActivity.this, OptionsActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        return true;
    }





}

