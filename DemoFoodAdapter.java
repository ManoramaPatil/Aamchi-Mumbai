package am.aamchiimumbai;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import am.aamchiimumbai.Models.DemoFood;
import am.aamchiimumbai.Models.DemoPlace;

public class DemoFoodAdapter extends RecyclerView.Adapter<DemoFoodViewHolder> {

    List<DemoFood> demoFoodList;
    Context context;


    public DemoFoodAdapter(List<DemoFood> demoFoodList, Context context) {
        this.demoFoodList = demoFoodList;
        this.context = context;
    }

    @NonNull
    @Override
    public DemoFoodViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.demo_food,viewGroup,false);
        return new DemoFoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DemoFoodViewHolder holder, int position) {
        final DemoFood demoFood = this.demoFoodList.get(position);
        holder.foodName.setText(demoFood.getFoodName());
        holder.foodType.setText(demoFood.getFoodType());
        holder.foodTimings.setText(demoFood.getFoodTimings());
        holder.foodRatings.setText(demoFood.getFoodRatings());
        holder.foodPhoneNumber.setText(demoFood.getFoodPhoneNumber());
        holder.foodNear.setText(demoFood.getFoodNear());
        holder.foodDistance.setText(demoFood.getFoodDistance());
        holder.foodAddress.setText(demoFood.getFoodAddress());


        holder.btn_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,MapsActivity.class);
                Bundle bundle =new Bundle();
                bundle.putInt("key",0);
                bundle.putString("foodName",demoFood.getFoodName());
                bundle.putDouble("foodLat",demoFood.getFoodGeo().getLatitude());
                bundle.putDouble("foodLong",demoFood.getFoodGeo().getLongitude());
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
//        holder.foodGeo.setText(demoFood.getFoodGeo());

//        anA?N?D??????????Why would setText is beyond my thinking?



    }

    @Override
    public int getItemCount() {
        return demoFoodList.size();
    }


}
