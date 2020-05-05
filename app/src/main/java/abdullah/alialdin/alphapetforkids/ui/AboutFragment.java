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

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.Objects;

import abdullah.alialdin.alphapetforkids.R;

public class AboutFragment extends Fragment implements View.OnClickListener{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_about, container, false);
        Button closeButton = root.findViewById(R.id.okButton);
        ImageButton email = root.findViewById(R.id.gmail);
        ImageButton facebook = root.findViewById(R.id.facebook);
        ImageButton twitter = root.findViewById(R.id.twitter);
        ImageButton youtube = root.findViewById(R.id.youtube);
        ImageButton linkedin = root.findViewById(R.id.linkedin);

        closeButton.setOnClickListener(this);
        email.setOnClickListener(this);
        facebook.setOnClickListener(this);
        twitter.setOnClickListener(this);
        youtube.setOnClickListener(this);
        linkedin.setOnClickListener(this);

        return root;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.okButton:
                MainActivity.speedDialView.setVisibility(View.VISIBLE);
                MainActivity.mRecyclerView.setVisibility(View.VISIBLE);
                assert getFragmentManager() != null;
                getFragmentManager().beginTransaction().remove(this).commit();
                break;
            case R.id.gmail:
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, "abdullah.alialdin@gmail.com");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Alphabet for Kids FeedBack");
                if (intent.resolveActivity(Objects.requireNonNull(getActivity()).getPackageManager()) != null) {
                    startActivity(intent);
                }
                break;
            case R.id.facebook:
                Intent face = newFacebookIntent(getContext());
                startActivity(face);
                break;
            case R.id.twitter:
                followMeOn("https://twitter.com/abdoroid");
                break;
            case R.id.youtube:
                followMeOn("http://www.youtube.com/c/Abdoroid");
                break;
            case R.id.linkedin:
                followMeOn("https://www.linkedin.com/in/abdullah-alialdin/");
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void followMeOn(String url){
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(Objects.requireNonNull(getActivity()).getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private static Intent newFacebookIntent(Context context) {
        try {
           context.getPackageManager()
                   .getPackageInfo("com.facebook.katana", 0);
           return new Intent(Intent.ACTION_VIEW,Uri.parse("fb://facewebmodal/f?href="
                   + "https://www.facebook.com/abdoroid.channel"));
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/abdoroid.channel"));
        }
    }
}
