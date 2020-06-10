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


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import abdullah.alialdin.alphapetforkids.R;

public class Tracing extends Activity implements View.OnClickListener {

    private DrawingView dv ;
    private Paint mPaint;
    private ImageButton next, back;
    private int count = 0;
    private int color;
    private int[][] resources = new int[][]{
            {R.drawable.trace_a, R.raw.alligator_a}, {R.drawable.trace_b, R.raw.bear_b},
            {R.drawable.trace_c, R.raw.cat_c}, {R.drawable.trace_d, R.raw.dog_d},
            {R.drawable.trace_e, R.raw.elephant_e}, {R.drawable.trace_f, R.raw.fox_f},
            {R.drawable.trace_g, R.raw.giraffe_g}, {R.drawable.trace_h, R.raw.hippo_h},
            {R.drawable.trace_i, R.raw.iguana_i}, {R.drawable.trace_j, R.raw.jellyfish_j},
            {R.drawable.trace_k, R.raw.kangaroo_k}, {R.drawable.trace_l, R.raw.lion_l},
            {R.drawable.trace_m, R.raw.monkey_m}, {R.drawable.trace_n, R.raw.nest_n},
            {R.drawable.trace_o, R.raw.owl_o}, {R.drawable.trace_p, R.raw.penguin_p},
            {R.drawable.trace_q, R.raw.quail_q}, {R.drawable.trace_r, R.raw.rhino_r},
            {R.drawable.trace_s, R.raw.squirrel_s}, {R.drawable.trace_t, R.raw.turtle_t},
            {R.drawable.trace_u, R.raw.unicorn_u}, {R.drawable.trace_v, R.raw.vulture_v},
            {R.drawable.trace_w, R.raw.whale_w}, {R.drawable.trace_x, R.raw.xerus_x},
            {R.drawable.trace_y, R.raw.yak_y}, {R.drawable.trace_z, R.raw.zebra_z}
    };
    private ImageButton red, blue, brown, green, pink, purple, speaker;
    private InterstitialAd mInterstitialAd;
    private MediaPlayer mediaPlayer;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracing);
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
        final RelativeLayout mTile = findViewById(R.id.mTile);
        next = findViewById(R.id.next);
        back = findViewById(R.id.back);
        dv = new DrawingView(this);
        mTile.addView(dv);
        final View rvTrans = new View(this);
        rvTrans.setBackgroundResource(R.drawable.trace_a);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count += 1;
                if (mInterstitialAd.isLoaded() && count%4 == 0) {
                    mInterstitialAd.show();
                }
                if (count > 25) {
                    playSound(R.raw.applause);
                    count = 25;
                }
                playSound(R.raw.arrow);
                dv.removePaint();
                rvTrans.setBackgroundResource(resources[count][0]);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count -= 1;
                if (mInterstitialAd.isLoaded() && count%4 == 0) {
                    mInterstitialAd.show();
                }
                if (count < 0){
                    count = 0;
                }
                playSound(R.raw.arrow);
                dv.removePaint();
                rvTrans.setBackgroundResource(resources[count][0]);
            }
        });
        speaker = findViewById(R.id.speaker);
        speaker.setOnClickListener(this);
        color = getResources().getColor(R.color.red);
        red = findViewById(R.id.red);
        red.setOnClickListener(this);
        brown = findViewById(R.id.brown);
        brown.setOnClickListener(this);
        green = findViewById(R.id.green);
        green.setOnClickListener(this);
        blue = findViewById(R.id.blue);
        blue.setOnClickListener(this);
        purple = findViewById(R.id.purple);
        purple.setOnClickListener(this);
        pink = findViewById(R.id.pink);
        pink.setOnClickListener(this);
        mTile.addView(rvTrans);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setColor(color);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeWidth(40);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.red:
                playSound(R.raw.red);
                color = getResources().getColor(R.color.red);
                mPaint.setColor(color);
                break;
            case R.id.blue:
                playSound(R.raw.blue);
                color = getResources().getColor(R.color.blue);
                mPaint.setColor(color);
                break;
            case R.id.green:
                playSound(R.raw.green);
                color = getResources().getColor(R.color.green);
                mPaint.setColor(color);
                break;
            case R.id.purple:
                playSound(R.raw.purple);
                color = getResources().getColor(R.color.purple);
                mPaint.setColor(color);
                break;
            case R.id.pink:
                playSound(R.raw.pink);
                color = getResources().getColor(R.color.pink);
                mPaint.setColor(color);
                break;
            case R.id.brown:
                playSound(R.raw.brown);
                color = getResources().getColor(R.color.brown);
                mPaint.setColor(color);
                break;
            case R.id.speaker:
                playSound(resources[count][1]);
        }
    }

    private void playSound(int sound){
        mediaPlayer = MediaPlayer.create(Tracing.this, sound);
        mediaPlayer.start();
    }

    public class DrawingView extends View {

        private Bitmap mBitmap;
        private Canvas mCanvas;
        private Path mPath;
        private Paint   mBitmapPaint;
        Context context;
        private Paint circlePaint;
        private Path circlePath;

        public DrawingView(Context c) {
            super(c);
            context=c;
            mPath = new Path();
            mBitmapPaint = new Paint(Paint.DITHER_FLAG);
            circlePaint = new Paint();
            circlePath = new Path();
            circlePaint.setAntiAlias(true);
            circlePaint.setColor(Color.BLUE);
            circlePaint.setStyle(Paint.Style.STROKE);
            circlePaint.setStrokeJoin(Paint.Join.MITER);
            circlePaint.setStrokeWidth(4f);
        }

        public void removePaint(){
            mBitmap.eraseColor(Color.TRANSPARENT);
            mPath.reset();
        }

        @Override
        protected void onSizeChanged(int width, int height, int oldWidth, int oldHeight) {
            super.onSizeChanged(width, height, oldWidth, oldHeight);

            mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            mCanvas = new Canvas(mBitmap);

        }
        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawBitmap( mBitmap, 0, 0, mBitmapPaint);
            canvas.drawPath( mPath,  mPaint);
            canvas.drawPath( circlePath,  circlePaint);
        }

        private float mX, mY;
        private static final float TOUCH_TOLERANCE = 4;

        private void touch_start(float x, float y) {
            mPath.reset();
            mPath.moveTo(x, y);
            mX = x;
            mY = y;
            Log.d("start xy==>", x+","+y);
        }
        private void touch_move(float x, float y) {
            Log.d("move xy==>", x+","+y);
            float dx = Math.abs(x - mX);
            float dy = Math.abs(y - mY);
            if ((dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE)) {
                mPath.quadTo(mX, mY, (x + mX)/2, (y + mY)/2);
                mX = x;
                mY = y;
            }
        }
        private void touch_up() {
            mPath.lineTo(mX, mY);
            circlePath.reset();
            mCanvas.drawPath(mPath,  mPaint);
            mPath.reset();
        }

        @SuppressLint("ClickableViewAccessibility")
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            float x = event.getX();
            float y = event.getY();
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    touch_start(x, y);
                    invalidate();
                    break;
                case MotionEvent.ACTION_MOVE:
                    touch_move(x, y);
                    invalidate();
                    break;
                case MotionEvent.ACTION_UP:
                    touch_up();
                    invalidate();
                    break;
            }
            return true;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
    }
}