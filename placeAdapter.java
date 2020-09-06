package am.aamchiimumbai;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;


public class placeAdapter extends FirestoreRecyclerAdapter<place, placeAdapter.placeHolder> {

    public placeAdapter(@NonNull FirestoreRecyclerOptions<place> options) {
        super(options);
    }

    @Override

    protected void onBindViewHolder(@NonNull placeHolder holder, int position, @NonNull place model) {
        holder.textViewBusstop.setText(model.getBusstop());
        holder.textViewCabs.setText(model.getCabs());
        holder.textViewPriority.setText(String.valueOf(model.getPriority()));
    }

    @NonNull
    @Override
    public placeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.place_item,
                parent, false);
        return new placeHolder(v);
    }

    class placeHolder extends RecyclerView.ViewHolder {
        TextView textViewBusstop;
        TextView textViewCabs;
        TextView textViewPriority;

        public placeHolder(View itemView) {
            super(itemView);
            textViewBusstop = itemView.findViewById(R.id.text_view_busstop);
            textViewCabs = itemView.findViewById(R.id.text_view_cabs);
            textViewPriority = itemView.findViewById(R.id.text_view_priority);
        }
    }
}