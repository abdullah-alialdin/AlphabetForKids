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

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import abdullah.alialdin.alphapetforkids.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, RewardedVideoAdListener {

    CardView flashCards, tracing;
    private InterstitialAd mInterstitialAd;
    private RewardedVideoAd mRewardedVideoAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_main);

        flashCards = findViewById(R.id.flash_cards);
        flashCards.setOnClickListener(this);
        tracing = findViewById(R.id.tracing);
        tracing.setOnClickListener(this);
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
        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        mRewardedVideoAd.setRewardedVideoAdListener(this);
        loadRewardedVideoAd();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_share:
                        Intent sendIntent = new Intent();
                        sendIntent.setAction(Intent.ACTION_SEND);
                        sendIntent.putExtra(Intent.EXTRA_TEXT,
                                getString(R.string.share_message) +
                                        getString(R.string.google_play_url));
                        sendIntent.setType("text/plain");
                        Intent shareIntent = Intent.createChooser(sendIntent, null);
                        if (shareIntent.resolveActivity(getPackageManager()) != null) {
                            startActivity(shareIntent);
                        }
                        break;
                    case R.id.action_rate:
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(
                                getString(R.string.google_play_url)));
                        intent.setPackage("com.android.vending");
                        if (intent.resolveActivity(getPackageManager()) != null) {
                            startActivity(intent);
                        }
                        break;
                    case R.id.action_donate:
                        if (mRewardedVideoAd.isLoaded()) {
                            mRewardedVideoAd.show();
                        }
                        break;
                    case R.id.action_about:
                        Intent aboutIntent = new Intent(MainActivity.this, AboutActivity.class);
                        startActivity(aboutIntent);
                        break;
                }
                return true;
            }
        });
    }

    private void loadRewardedVideoAd() {
        mRewardedVideoAd.loadAd(getString(R.string.rewarded_ad_id),
                new AdRequest.Builder().build());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.flash_cards:
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }
                Intent flashIntent = new Intent(MainActivity.this, FlashCards.class);
                startActivity(flashIntent);
                break;
            case R.id.tracing:
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }
                Intent traceIntent = new Intent(MainActivity.this, Tracing.class);
                startActivity(traceIntent);
                break;
        }


    }

    @Override
    public void onRewardedVideoAdLoaded() {

    }

    @Override
    public void onRewardedVideoAdOpened() {

    }

    @Override
    public void onRewardedVideoStarted() {

    }

    @Override
    public void onRewardedVideoAdClosed() {
        loadRewardedVideoAd();
    }

    @Override
    public void onRewarded(RewardItem rewardItem) {

    }

    @Override
    public void onRewardedVideoAdLeftApplication() {

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {
        Toast.makeText(this, R.string.rewarded_add_failed,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoCompleted() {
        Toast.makeText(this, R.string.thanks_for_support,
                Toast.LENGTH_SHORT).show();
    }
}