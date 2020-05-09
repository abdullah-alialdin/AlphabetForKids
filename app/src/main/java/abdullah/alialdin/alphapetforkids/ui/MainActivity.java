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

package abdullah.alialdin.alphapetforkids.ui;

import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.leinardi.android.speeddial.SpeedDialActionItem;
import com.leinardi.android.speeddial.SpeedDialView;

import java.util.ArrayList;

import abdullah.alialdin.alphapetforkids.R;
import abdullah.alialdin.alphapetforkids.adapter.CategoryAdapter;
import abdullah.alialdin.alphapetforkids.data.DataArrays;
import abdullah.alialdin.alphapetforkids.model.CategoryModel;
import abdullah.alialdin.alphapetforkids.model.DataModel;

public class MainActivity extends AppCompatActivity {

    private ArrayList<DataModel> list = new ArrayList<>();
    public static RecyclerView mRecyclerView;
    public static SpeedDialView speedDialView;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        ArrayList<CategoryModel> mAlphabetList = DataArrays.makeAlphabetList();
        ArrayList<CategoryModel> mAnimalsList = DataArrays.makeAnimalsList();
        ArrayList<CategoryModel> mNumbersList = DataArrays.makeNumbersList();
        ArrayList<CategoryModel> mFoodList = DataArrays.makeFoodList();
        ArrayList<CategoryModel> mSportsList = DataArrays.makeSportsList();
        ArrayList<CategoryModel> mTransportsList = DataArrays.makeTransportsList();
        ArrayList<CategoryModel> mObjectsList = DataArrays.makeObjectsList();
        list.add(new DataModel(R.drawable.alphabet,getString(R.string.cat_alphabet), R.raw.alphabet,
                getString(R.color.alphabet_cat_color), mAlphabetList));
        list.add(new DataModel(R.drawable.numbers, getString(R.string.cat_numbers), R.raw.numbers,
                getString(R.color.number_cat_color), mNumbersList));
        list.add(new DataModel(R.drawable.animals, getString(R.string.cat_animals), R.raw.animals,
                getString(R.color.animals_cat_color), mAnimalsList));
        list.add(new DataModel(R.drawable.food, getString(R.string.cat_food), R.raw.food,
                getString(R.color.food_cat_color), mFoodList));
        list.add(new DataModel(R.drawable.sports, getString(R.string.cat_sports), R.raw.sports,
                getString(R.color.sports_cat_color), mSportsList));
        list.add(new DataModel(R.drawable.transports, getString(R.string.cat_transports), R.raw.transports,
                getString(R.color.transports_cat_color), mTransportsList));
        list.add(new DataModel(R.drawable.objects,getString(R.string.cat_objects), R.raw.objects,
                getString(R.color.objects_cat_color), mObjectsList));

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        CategoryAdapter adapter = new CategoryAdapter(this, list);
        mRecyclerView.setAdapter(adapter);

        final Fragment mFragment = new AboutFragment();
        final FragmentManager fragmentManager = getSupportFragmentManager();
        speedDialView = findViewById(R.id.speedDial);
        speedDialView.addActionItem(
                new SpeedDialActionItem.Builder(R.id.fab_about,R.drawable.ic_menu_about)
                        .create());
        speedDialView.addActionItem(
                new SpeedDialActionItem.Builder(R.id.fab_share,R.drawable.ic_menu_share)
                        .create());
        speedDialView.addActionItem(
                new SpeedDialActionItem.Builder(R.id.fab_rate,R.drawable.ic_menu_rate)
                        .create());

        speedDialView.setOnActionSelectedListener(new SpeedDialView.OnActionSelectedListener() {
            @Override
            public boolean onActionSelected(SpeedDialActionItem speedDialActionItem) {
                switch (speedDialActionItem.getId()) {
                    case R.id.fab_rate:
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(
                                getString(R.string.google_play_url)));
                        intent.setPackage("com.android.vending");
                        startActivity(intent);
                        return false; // true to keep the Speed Dial open
                    case R.id.fab_share:
                        Intent sendIntent = new Intent();
                        sendIntent.setAction(Intent.ACTION_SEND);
                        sendIntent.putExtra(Intent.EXTRA_TEXT,
                                getString(R.string.share_message) +
                                        getString(R.string.google_play_url));
                        sendIntent.setType("text/plain");
                        Intent shareIntent = Intent.createChooser(sendIntent, null);
                        startActivity(shareIntent);
                        return false;
                    case R.id.fab_about:
                        mRecyclerView.setVisibility(View.INVISIBLE);
                        fragmentManager.beginTransaction()
                                .replace(R.id.container, mFragment).commit();
                        speedDialView.setVisibility(View.INVISIBLE);
                        return false;
                    default:
                        return false;
                }
            }
        });

    }

}
