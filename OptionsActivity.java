package am.aamchiimumbai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OptionsActivity extends AppCompatActivity {

    private Button btnPlaces, btnFood, btnEvents, btnTrain, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        btnPlaces = (Button) findViewById(R.id.btn_places);
        btnFood = (Button) findViewById(R.id.btn_food);
        btnEvents = (Button) findViewById(R.id.btn_events);
        btnTrain= (Button) findViewById(R.id.btn_train) ;
        btnExit=(Button)findViewById(R.id.btn_exit);

        btnPlaces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OptionsActivity.this, PlacesActivity.class);
                startActivity(intent);
                finish();
            }

        });
        btnFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OptionsActivity.this, FoodActivity.class);
                startActivity(intent);
                finish();
            }

        });
        btnEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OptionsActivity.this, EventsActivity.class);
                startActivity(intent);
                finish();
            }



        });
        btnTrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OptionsActivity.this, TrainActivity.class);
                startActivity(intent);
                finish();
            }



        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OptionsActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }



        });
    }
}