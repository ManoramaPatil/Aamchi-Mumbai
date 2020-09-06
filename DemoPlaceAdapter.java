package am.aamchiimumbai;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

import am.aamchiimumbai.Models.DemoPlace;

public class DemoPlaceAdapter extends RecyclerView.Adapter<DemoPlaceViewHolder> {

    List<DemoPlace> demoPlaceList;
    Context context;


    public DemoPlaceAdapter(List<DemoPlace> demoPlaceList, Context context) {
        this.demoPlaceList = demoPlaceList;
        this.context = context;
    }

    @NonNull
    @Override
    public DemoPlaceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.demo_places,viewGroup,false);
        return new DemoPlaceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DemoPlaceViewHolder holder, int position) {
        final DemoPlace demoPlace = this.demoPlaceList.get(position);
        holder.placeName.setText(demoPlace.getPlaceName());
        holder.placeBestTime.setText(demoPlace.getPlaceBestTime());
        holder.placeCabs.setText(demoPlace.getPlaceCabs());
        holder.placeHistory.setText(demoPlace.getPlaceHistory());
        holder.placeBusStop.setText(demoPlace.getBusStop());
        holder.placeEntryFees.setText(demoPlace.getPlaceEntryFees());
        holder.placeHowFar.setText(demoPlace.getPlaceHowFar());
        holder.placeHowToReach.setText(demoPlace.getPlaceHowToReach());
        holder.placeHighlights.setText(demoPlace.getPlaceHighlights());
        holder.placeInfo.setText(demoPlace.getPlaceInfo());
        holder.placeLocation.setText(demoPlace.getPlaceLocation());
        holder.placeNearbyPlaces.setText(demoPlace.getPlaceNearbyPlaces());
        holder.placeReadMore.setText(demoPlace.getPlaceReadMore());

        holder.btn_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context, MapsActivity.class);
                Bundle bundle=new Bundle();
                bundle.putInt("key",1);
                bundle.putString("placeName",demoPlace.getPlaceName());
                bundle.putDouble("placeLat",demoPlace.getPlaceGeo().getLatitude());
                bundle.putDouble("placeLong",demoPlace.getPlaceGeo().getLongitude());
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
        Picasso.get().load(demoPlace.getImageUrl())
                .into(holder.iv_placeImage, new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError(Exception e) {
                        Log.i("PICASSO ERRRE", e.getLocalizedMessage());
                    }
                });
//phone marr gaya ek min // ek last run hai fatfay hojayega nai hua toh mar dena mereko aisa me nai bolunga:)oyeeee aya image par bhot chotu hai and sab me same image hai ha pata hai!!
//        now ek ek kr ke image dhund sbke google images se jaise mene abhu causeway ka kiya and then wo image ka link unke respective fiELD ME PASTW KR IN CONSOLW okkk
        //and about the size wo layout me tu changes kr le apne according mene testing ke batte
    }

    @Override
    public int getItemCount() {
        return demoPlaceList.size();
    }

//    public void refreshAdapter() {
//n
//    }

    //crash hora h je
    //Run kr ke dekhokk
    //kalpeshhhhh nahiiiii horaaa
    //are re mene hug diya //most probably tera layout hugega in respect to the screen size but main concern image dikhna hai
    //and btw low resolution ka image upload kiya hai na? wo nahi dekha mene
    //apk kui nai install horha?scroll kiya niche toh crash ho gaya
    //refactoring me pure project ke files refactor hogye
}
