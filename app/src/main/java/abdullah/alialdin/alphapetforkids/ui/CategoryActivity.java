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

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;

import abdullah.alialdin.alphapetforkids.R;
import abdullah.alialdin.alphapetforkids.model.CategoryModel;

public class CategoryActivity extends AppCompatActivity {

    private AnimatorSet mSetRightOut;
    private AnimatorSet mSetLeftIn;
    private boolean mIsBackVisible = false;
    private View mCardFrontLayout;
    private View mCardBackLayout;
    private ImageView mFrontImage;
    private ImageView mBackImage;
    private ArrayList<CategoryModel> category = new ArrayList<>();
    private int count = 0;
    private InterstitialAd mInterstitialAd;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_category);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_id));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                AdRequest adRequest = new AdRequest.Builder().build();
                mInterstitialAd.loadAd(adRequest);
            }
        });
        Intent intent = getIntent();
        category = intent.getParcelableArrayListExtra("Category");
        mFrontImage = findViewById(R.id.front_image);
        mBackImage = findViewById(R.id.back_image);
        mFrontImage.setImageResource(category.get(0).getLetterImageSource());
        mBackImage.setImageResource(category.get(0).getPhotoImageSource());
        ImageView mForward = findViewById(R.id.forward_button);
        ImageView mBackward = findViewById(R.id.backward_button);
        mCardBackLayout = findViewById(R.id.card_back);
        mCardFrontLayout = findViewById(R.id.card_front);
        loadAnimations();
        changeCameraDistance();
        mForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count += 1;
                if (mInterstitialAd.isLoaded() && count%4 == 0) {
                    mInterstitialAd.show();
                }
                if (count > category.size()-1) {
                    count = category.size()-1;
                    playSound(CategoryActivity.this, R.raw.applause);
                }
                mFrontImage.setImageResource(category.get(count).getLetterImageSource());
                mBackImage.setImageResource(category.get(count).getPhotoImageSource());
                playSound(CategoryActivity.this, category.get(count).getLetterSound());
            }
        });
        mBackward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count -= 1;
                if (mInterstitialAd.isLoaded() && count%4 == 0) {
                    mInterstitialAd.show();
                }
                if (count < 0){count = 0;}
                mFrontImage.setImageResource(category.get(count).getLetterImageSource());
                mBackImage.setImageResource(category.get(count).getPhotoImageSource());
                playSound(CategoryActivity.this, category.get(count).getLetterSound());
            }
        });

    }


    private void changeCameraDistance() {
        int distance = 8000;
        float scale = getResources().getDisplayMetrics().density * distance;
        mCardFrontLayout.setCameraDistance(scale);
        mCardBackLayout.setCameraDistance(scale);
    }

    @SuppressLint("ResourceType")
    private void loadAnimations() {
        mSetRightOut = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.anim.out_animation);
        mSetLeftIn = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.anim.in_animation);
    }

    public void flipCard(View view) {
        if (!mIsBackVisible) {
            mSetRightOut.setTarget(mCardFrontLayout);
            mSetLeftIn.setTarget(mCardBackLayout);
            mSetRightOut.start();
            mSetLeftIn.start();
            mIsBackVisible = true;
            int sound = category.get(count).getImageSound();
            if (sound != 0){
                playSound(this, sound);
            }

        } else {
            mSetRightOut.setTarget(mCardBackLayout);
            mSetLeftIn.setTarget(mCardFrontLayout);
            mSetRightOut.start();
            mSetLeftIn.start();
            mIsBackVisible = false;
            playSound(this, category.get(count).getLetterSound());
        }
    }

    private void playSound(Context context, int sound){
        mediaPlayer = MediaPlayer.create(context, sound);
        mediaPlayer.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
    }
}
