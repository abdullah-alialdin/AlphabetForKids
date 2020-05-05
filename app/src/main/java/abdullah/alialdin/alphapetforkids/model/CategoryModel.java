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

package abdullah.alialdin.alphapetforkids.model;

import android.os.Parcel;
import android.os.Parcelable;

public class CategoryModel implements Parcelable {

    private int letterImageSource;
    private int photoImageSource;
    private int letterSound;
    private int imageSound;

    public CategoryModel(int letterImageSource, int photoImageSource, int letterSound, int imageSound) {
        this.letterImageSource = letterImageSource;
        this.photoImageSource = photoImageSource;
        this.letterSound = letterSound;
        this.imageSound = imageSound;
    }

    public CategoryModel(int letterImageSource, int photoImageSource, int letterSound) {
        this.letterImageSource = letterImageSource;
        this.photoImageSource = photoImageSource;
        this.letterSound = letterSound;
    }

    public int getLetterImageSource() {
        return letterImageSource;
    }

    public int getPhotoImageSource() {
        return photoImageSource;
    }

    public int getLetterSound() {
        return letterSound;
    }

    public int getImageSound() {
        return imageSound;
    }


    private CategoryModel(Parcel in) {
        this.letterImageSource = in.readInt();
        this.photoImageSource = in.readInt();
        this.letterSound = in.readInt();
        this.imageSound = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.letterImageSource);
        dest.writeInt(this.photoImageSource);
        dest.writeInt(this.letterSound);
        dest.writeInt(this.imageSound);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CategoryModel> CREATOR = new Creator<CategoryModel>() {
        @Override
        public CategoryModel createFromParcel(Parcel in) {
            return new CategoryModel(in);
        }

        @Override
        public CategoryModel[] newArray(int size) {
            return new CategoryModel[size];
        }
    };
}
