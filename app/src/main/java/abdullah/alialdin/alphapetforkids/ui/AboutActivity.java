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

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ImageButton;

import java.util.Objects;

import abdullah.alialdin.alphapetforkids.R;

public class AboutActivity extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ImageButton email = findViewById(R.id.gmail);
        ImageButton twitter = findViewById(R.id.twitter);
        ImageButton youtube = findViewById(R.id.youtube);
        ImageButton linkedin = findViewById(R.id.linkedin);

        email.setOnClickListener(this);
        twitter.setOnClickListener(this);
        youtube.setOnClickListener(this);
        linkedin.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.gmail:
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, getString(R.string.email));
                intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.email_subject));
                if (intent.resolveActivity(Objects.requireNonNull(this).getPackageManager()) != null) {
                    startActivity(intent);
                }
                break;
            case R.id.twitter:
                followMeOn(getString(R.string.twitter));
                break;
            case R.id.youtube:
                followMeOn(getString(R.string.youtube));
                break;
            case R.id.linkedin:
                followMeOn(getString(R.string.linkedin));
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void followMeOn(String url){
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(Objects.requireNonNull(this).getPackageManager()) != null) {
            startActivity(intent);
        }
    }


}
