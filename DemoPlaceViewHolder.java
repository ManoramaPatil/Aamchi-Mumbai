package am.aamchiimumbai;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

class DemoPlaceViewHolder extends RecyclerView.ViewHolder {
    TextView placeName, placeHistory, placeBusStop,
            placeBestTime, placeCabs, placeEntryFees, placeHowFar, placeHowToReach,placeHighlights,placeInfo,placeLocation,placeNearbyPlaces,placeReadMore;
    ImageView iv_placeImage;
    Button btn_location;
    public DemoPlaceViewHolder(@NonNull View itemView) {
        super(itemView);
        placeName = itemView.findViewById(R.id.name);
        placeBestTime = itemView.findViewById(R.id.placeBestTime);
        placeCabs= itemView.findViewById(R.id.placeCabs);
        placeBusStop= itemView.findViewById(R.id.placeBusStop);
        placeHistory= itemView.findViewById(R.id.placeHistory);
        placeEntryFees=itemView.findViewById(R.id.placeEntryFees);
        placeHowFar=itemView.findViewById(R.id.placeHowFar);
        placeHowToReach=itemView.findViewById(R.id.placeHowToReach);
        placeHighlights=itemView.findViewById(R.id.placeHighlights);
        placeInfo=itemView.findViewById(R.id.placeInfo);
        placeLocation=itemView.findViewById(R.id.placeLocation);
        placeNearbyPlaces=itemView.findViewById(R.id.placeNearbyPlaces);
        placeReadMore=itemView.findViewById(R.id.placeReadMore);
        iv_placeImage = itemView.findViewById(R.id.iv_placeImage);
        btn_location= itemView.findViewById(R.id.btn_location);

    }
}
