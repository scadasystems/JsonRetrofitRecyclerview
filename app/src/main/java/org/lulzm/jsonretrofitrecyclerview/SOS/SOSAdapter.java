package org.lulzm.jsonretrofitrecyclerview.SOS;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.lulzm.jsonretrofitrecyclerview.R;

import java.util.List;

/*********************************************************
 *   $$\                  $$\             $$\      $$\   
 *   $$ |                 $$ |            $$$\    $$$ |  
 *   $$ |      $$\   $$\  $$ | $$$$$$$$\  $$$$\  $$$$ |  
 *   $$ |      $$ |  $$ | $$ | \____$$  | $$ \$\$$ $$ | 
 *   $$ |      $$ |  $$ | $$ |   $$$$ _/  $$  \$$  $$ |  
 *   $$ |      $$ |  $$ | $$ |  $$  _/    $$ | $  /$$ |  
 *   $$$$$$$$  \$$$$$$$ | $$ | $$$$$$$$\  $$ | \_/ $$ |  
 *   \_______| \______/   \__| \________| \__|     \__|  
 *
 * Project : JsonRetrofittest                             
 * Created by Android Studio                           
 * Developer : Lulz_M                                    
 * Date : 2019-06-11 011                                        
 * Time : 오후 2:49                                       
 * GitHub : https://github.com/scadasystems              
 * E-mail : redsmurf@lulzm.org                           
 *********************************************************/
public class SOSAdapter extends RecyclerView.Adapter<SOSAdapter.CustomViewHolder> {
    private List<Datum> datumList;

    public SOSAdapter(List<Datum> datumList) {
        this.datumList = datumList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_post, viewGroup, false);
        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int postion) {
        Datum datum = datumList.get(postion);
        holder.countryView.setText(datum.getCountry().getName());
        holder.policeView.setText(("경찰: " + datum.getPolice().getAll()).replace("[", "").replace("]", ""));
        holder.ambView.setText(("응급: " + datum.getAmbulance().getAll()).replace("[", "").replace("]", ""));
        holder.fireView.setText(("소방: " + datum.getFire().getAll()).replace("[", "").replace("]", ""));
    }

    @Override
    public int getItemCount() {
        return datumList.size();
    }


    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView countryView, policeView, ambView, fireView;

        public CustomViewHolder(View view) {
            super(view);
            countryView = (TextView) view.findViewById(R.id.tv_country);
            policeView = (TextView) view.findViewById(R.id.tv_police);
            ambView = (TextView) view.findViewById(R.id.tv_amb);
            fireView = (TextView) view.findViewById(R.id.tv_fire);
        }
    }
}
