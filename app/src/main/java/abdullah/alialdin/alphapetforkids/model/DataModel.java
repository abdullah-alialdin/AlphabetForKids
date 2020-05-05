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

import java.util.ArrayList;

public class DataModel {

    private int imageReference;
    private String title;
    private int sound;
    private String color;
    private ArrayList<CategoryModel> category;

    public DataModel(int imageReference, String title, int sound, String color, ArrayList<CategoryModel> category) {
        this.imageReference = imageReference;
        this.title = title;
        this.sound = sound;
        this.color = color;
        this.category = category;
    }

    public int getImageReference() {
        return imageReference;
    }

    public String getTitle() {
        return title;
    }

    public int getSound() {
        return sound;
    }

    public String getColor() {
        return color;
    }

    public ArrayList<CategoryModel> getCategory() {
        return category;
    }
}
