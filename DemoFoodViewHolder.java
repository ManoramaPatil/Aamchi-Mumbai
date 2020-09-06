package am.aamchiimumbai;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DemoFoodViewHolder extends RecyclerView.ViewHolder {
    TextView foodAddress,foodName, foodDistance, foodNear, foodPhoneNumber, foodRatings, foodTimings, foodType, foodGeo;
    Button btn_location;
    public DemoFoodViewHolder(@NonNull View itemView) {
        super(itemView);
        foodAddress=itemView.findViewById(R.id.foodAddress);
        foodDistance=itemView.findViewById(R.id.foodDistance);
        foodName=itemView.findViewById(R.id.foodName);
        foodNear=itemView.findViewById(R.id.foodNear);
        foodPhoneNumber=itemView.findViewById(R.id.foodPhoneNumber);
        foodRatings=itemView.findViewById(R.id.foodRatings);
        foodTimings=itemView.findViewById(R.id.foodTimings);
        foodType=itemView.findViewById(R.id.foodType);
        foodGeo=itemView.findViewById(R.id.foodGeo);
        btn_location =itemView.findViewById(R.id.btn_location);
    }



}
