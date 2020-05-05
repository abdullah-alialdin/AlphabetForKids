/*
    * Copyright (C) 2020 Abdoroid (Abdullah Alialdin)

    * Licensed under the Apache License, Version 2.0 (the "License");
    * you may not use this file except in compliance with the License.
    * You may obtain a copy of the License at

    *    http://www.apache.org/licenses/LICENSE-2.0

    * Unless required by applicable law or agreed to in writing, software
    * distributed under the License is distributed on an "AS IS" BASIS,
    * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    * See the License for the specific language governing permissions and
    * limitations under the License.
 */
package abdullah.alialdin.alphapetforkids.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;
import java.util.List;

import abdullah.alialdin.alphapetforkids.R;
import abdullah.alialdin.alphapetforkids.model.DataModel;
import abdullah.alialdin.alphapetforkids.ui.CategoryActivity;

public class CategoryAdapter  extends RecyclerView.Adapter<CategoryAdapter.viewHolder> {
    private List<DataModel> mList;
    private MediaPlayer mMediaPlayer;
    private Context mContext;
    public CategoryAdapter(Context context, ArrayList<DataModel> list){
        this.mList = list;
        this.mContext = context;
    }
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        final DataModel data = mList.get(position);
        holder.title.setText(data.getTitle());
        holder.image.setImageResource(data.getImageReference());
        holder.cardView.setCardBackgroundColor(Color.parseColor(data.getColor()));
        final InterstitialAd mInterstitialAd = new InterstitialAd(mContext);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, CategoryActivity.class);
                intent.putExtra("Category", data.getCategory());
                mContext.startActivity(intent);
                mMediaPlayer = MediaPlayer.create(mContext, data.getSound());
                mMediaPlayer.start();
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    static class viewHolder extends RecyclerView.ViewHolder{
        TextView title;
        ImageView image;
        LinearLayout linearLayout;
        CardView cardView;
        viewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            image = itemView.findViewById(R.id.item_image);
            linearLayout = itemView.findViewById(R.id.list_layout);
            cardView = itemView.findViewById(R.id.card_view);
        }
    }
}
