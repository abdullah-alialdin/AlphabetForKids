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

package abdullah.alialdin.alphapetforkids.data;

import java.util.ArrayList;

import abdullah.alialdin.alphapetforkids.R;
import abdullah.alialdin.alphapetforkids.model.CategoryModel;

public class DataArrays {

    public static ArrayList<CategoryModel> makeAlphabetList(){
        ArrayList<CategoryModel> mAlphabetList = new ArrayList<>();
        mAlphabetList.add(new CategoryModel(R.drawable.letter_a, R.drawable.apple, R.raw.a, R.raw.apple));
        mAlphabetList.add(new CategoryModel(R.drawable.letter_b, R.drawable.ball, R.raw.b, R.raw.ball));
        mAlphabetList.add(new CategoryModel(R.drawable.letter_c, R.drawable.car, R.raw.c, R.raw.car));
        mAlphabetList.add(new CategoryModel(R.drawable.letter_d, R.drawable.duck, R.raw.d, R.raw.duck));
        mAlphabetList.add(new CategoryModel(R.drawable.letter_e, R.drawable.egg, R.raw.e, R.raw.egg));
        mAlphabetList.add(new CategoryModel(R.drawable.letter_f, R.drawable.fish, R.raw.f, R.raw.fish));
        mAlphabetList.add(new CategoryModel(R.drawable.letter_g, R.drawable.giraffe, R.raw.g, R.raw.giraffe));
        mAlphabetList.add(new CategoryModel(R.drawable.letter_h, R.drawable.hen, R.raw.h, R.raw.hen));
        mAlphabetList.add(new CategoryModel(R.drawable.letter_i, R.drawable.ice_cream, R.raw.i, R.raw.ice_cream));
        mAlphabetList.add(new CategoryModel(R.drawable.letter_j, R.drawable.jug, R.raw.j, R.raw.jug));
        mAlphabetList.add(new CategoryModel(R.drawable.letter_k, R.drawable.kite, R.raw.k, R.raw.kite));
        mAlphabetList.add(new CategoryModel(R.drawable.letter_l, R.drawable.lion, R.raw.l, R.raw.lion));
        mAlphabetList.add(new CategoryModel(R.drawable.letter_m, R.drawable.monkey, R.raw.m, R.raw.monkey));
        mAlphabetList.add(new CategoryModel(R.drawable.letter_n, R.drawable.nose, R.raw.n, R.raw.nose));
        mAlphabetList.add(new CategoryModel(R.drawable.letter_o, R.drawable.orange, R.raw.o, R.raw.orange));
        mAlphabetList.add(new CategoryModel(R.drawable.letter_p, R.drawable.pen, R.raw.p, R.raw.pen));
        mAlphabetList.add(new CategoryModel(R.drawable.letter_q, R.drawable.queen, R.raw.q, R.raw.queen));
        mAlphabetList.add(new CategoryModel(R.drawable.letter_r, R.drawable.rat, R.raw.r, R.raw.rat));
        mAlphabetList.add(new CategoryModel(R.drawable.letter_s, R.drawable.sun, R.raw.s, R.raw.sun));
        mAlphabetList.add(new CategoryModel(R.drawable.letter_t, R.drawable.tree, R.raw.t, R.raw.tree));
        mAlphabetList.add(new CategoryModel(R.drawable.letter_u, R.drawable.umbrella, R.raw.u, R.raw.umbrella));
        mAlphabetList.add(new CategoryModel(R.drawable.letter_v, R.drawable.violin, R.raw.v, R.raw.violin));
        mAlphabetList.add(new CategoryModel(R.drawable.letter_w, R.drawable.watch, R.raw.w, R.raw.watch));
        mAlphabetList.add(new CategoryModel(R.drawable.letter_x, R.drawable.xylophone, R.raw.x, R.raw.xylophone));
        mAlphabetList.add(new CategoryModel(R.drawable.letter_y, R.drawable.yoyo, R.raw.y, R.raw.yoyo));
        mAlphabetList.add(new CategoryModel(R.drawable.letter_z, R.drawable.zebra, R.raw.z, R.raw.zebra));
        return mAlphabetList;
    }

    public static ArrayList<CategoryModel> makeAnimalsList(){
        ArrayList<CategoryModel> mAnimalsList = new ArrayList<>();
        mAnimalsList.add(new CategoryModel(R.drawable.bear_w, R.drawable.bear, R.raw.bear));
        mAnimalsList.add(new CategoryModel(R.drawable.cat_w, R.drawable.cat, R.raw.cat));
        mAnimalsList.add(new CategoryModel(R.drawable.dog_w, R.drawable.dog, R.raw.dog));
        mAnimalsList.add(new CategoryModel(R.drawable.elephant_w, R.drawable.elephant_2, R.raw.elephant));
        mAnimalsList.add(new CategoryModel(R.drawable.fox_w, R.drawable.fox, R.raw.fox));
        mAnimalsList.add(new CategoryModel(R.drawable.giraffe_w, R.drawable.giraffe_2, R.raw.giraffe));
        mAnimalsList.add(new CategoryModel(R.drawable.horse_w, R.drawable.horse, R.raw.horse));
        mAnimalsList.add(new CategoryModel(R.drawable.jaguar_w, R.drawable.jaguar, R.raw.jaguar));
        mAnimalsList.add(new CategoryModel(R.drawable.kangaroo_w, R.drawable.kangaroo, R.raw.kangaroo));
        mAnimalsList.add(new CategoryModel(R.drawable.lion_w, R.drawable.lion_2, R.raw.lion));
        mAnimalsList.add(new CategoryModel(R.drawable.monkey_w, R.drawable.monkey_2, R.raw.monkey));
        mAnimalsList.add(new CategoryModel(R.drawable.ostrich_w, R.drawable.ostrich, R.raw.ostrich));
        mAnimalsList.add(new CategoryModel(R.drawable.rabbit_w, R.drawable.rabbit, R.raw.rabbit));
        mAnimalsList.add(new CategoryModel(R.drawable.sheep_w, R.drawable.sheep, R.raw.sheep));
        mAnimalsList.add(new CategoryModel(R.drawable.tiger_w, R.drawable.tiger, R.raw.tiger));
        mAnimalsList.add(new CategoryModel(R.drawable.wolf_w, R.drawable.wolf, R.raw.wolf));
        mAnimalsList.add(new CategoryModel(R.drawable.zebra_w, R.drawable.zebra_2, R.raw.zebra));
        return mAnimalsList;
    }

    public static ArrayList<CategoryModel> makeNumbersList(){
        ArrayList<CategoryModel> mNumbersList = new ArrayList<>();
        mNumbersList.add(new CategoryModel(R.drawable.zero, R.drawable.zero_i, R.raw.zero));
        mNumbersList.add(new CategoryModel(R.drawable.one, R.drawable.one_i, R.raw.one));
        mNumbersList.add(new CategoryModel(R.drawable.two, R.drawable.two_i, R.raw.two));
        mNumbersList.add(new CategoryModel(R.drawable.three, R.drawable.three_i, R.raw.three));
        mNumbersList.add(new CategoryModel(R.drawable.four, R.drawable.four_i, R.raw.four));
        mNumbersList.add(new CategoryModel(R.drawable.five, R.drawable.five_i, R.raw.five));
        mNumbersList.add(new CategoryModel(R.drawable.six, R.drawable.six_i, R.raw.six));
        mNumbersList.add(new CategoryModel(R.drawable.seven, R.drawable.seven_i, R.raw.seven));
        mNumbersList.add(new CategoryModel(R.drawable.eight, R.drawable.eight_i, R.raw.eight));
        mNumbersList.add(new CategoryModel(R.drawable.nine, R.drawable.nine_i, R.raw.nine));
        return mNumbersList;
    }

    public static ArrayList<CategoryModel> makeFoodList(){
        ArrayList<CategoryModel> mFoodList = new ArrayList<>();
        mFoodList.add(new CategoryModel(R.drawable.avocado_w, R.drawable.avocado, R.raw.avocado));
        mFoodList.add(new CategoryModel(R.drawable.banana_w, R.drawable.banana, R.raw.banana));
        mFoodList.add(new CategoryModel(R.drawable.carrot_w, R.drawable.carrot, R.raw.carrot));
        mFoodList.add(new CategoryModel(R.drawable.cucumber_w, R.drawable.cucumber, R.raw.cucumber));
        mFoodList.add(new CategoryModel(R.drawable.eggplant_w, R.drawable.eggplant, R.raw.eggplant));
        mFoodList.add(new CategoryModel(R.drawable.garlic_w, R.drawable.garlic, R.raw.garlic));
        mFoodList.add(new CategoryModel(R.drawable.honey_w, R.drawable.honey, R.raw.honey));
        mFoodList.add(new CategoryModel(R.drawable.lemon_w, R.drawable.lemon, R.raw.limon));
        mFoodList.add(new CategoryModel(R.drawable.meat_w, R.drawable.meat, R.raw.meat));
        mFoodList.add(new CategoryModel(R.drawable.onion_w, R.drawable.onion, R.raw.onion));
        mFoodList.add(new CategoryModel(R.drawable.orange_w, R.drawable.orange, R.raw.orange));
        mFoodList.add(new CategoryModel(R.drawable.potato_w, R.drawable.potato, R.raw.potato));
        mFoodList.add(new CategoryModel(R.drawable.strawberry_w, R.drawable.strawberry, R.raw.strawberry));
        mFoodList.add(new CategoryModel(R.drawable.tomato_w, R.drawable.tomato, R.raw.tomato));
        mFoodList.add(new CategoryModel(R.drawable.watermelon_w, R.drawable.watermelon, R.raw.watermelon));
        return mFoodList;
    }

    public static ArrayList<CategoryModel> makeSportsList(){
        ArrayList<CategoryModel> mSportsList = new ArrayList<>();
        mSportsList.add(new CategoryModel(R.drawable.baseball_w, R.drawable.baseball, R.raw.baseball));
        mSportsList.add(new CategoryModel(R.drawable.basketball_w, R.drawable.basketball, R.raw.basketball));
        mSportsList.add(new CategoryModel(R.drawable.cricket_w, R.drawable.cricket, R.raw.cricket));
        mSportsList.add(new CategoryModel(R.drawable.football_w, R.drawable.football, R.raw.football));
        mSportsList.add(new CategoryModel(R.drawable.golf_w, R.drawable.golf, R.raw.golf));
        mSportsList.add(new CategoryModel(R.drawable.handball_w, R.drawable.handball, R.raw.handball));
        mSportsList.add(new CategoryModel(R.drawable.rugby_w, R.drawable.rugby, R.raw.rugby));
        mSportsList.add(new CategoryModel(R.drawable.swimming_w, R.drawable.swimming, R.raw.swimming));
        mSportsList.add(new CategoryModel(R.drawable.tennis_w, R.drawable.tennis, R.raw.tennis));
        mSportsList.add(new CategoryModel(R.drawable.volleyball_w, R.drawable.volleyball, R.raw.volleyball));
        mSportsList.add(new CategoryModel(R.drawable.wrestling_w, R.drawable.wrestling, R.raw.wrestling));
        return mSportsList;
    }

    public static ArrayList<CategoryModel> makeTransportsList(){
        ArrayList<CategoryModel> mTransportsList = new ArrayList<>();
        mTransportsList.add(new CategoryModel(R.drawable.bicycle_w, R.drawable.bicycle, R.raw.bicycle));
        mTransportsList.add(new CategoryModel(R.drawable.bus_w, R.drawable.bus, R.raw.bus));
        mTransportsList.add(new CategoryModel(R.drawable.car_w, R.drawable.car_2, R.raw.car));
        mTransportsList.add(new CategoryModel(R.drawable.helicopter_w, R.drawable.helicopter, R.raw.helicopter));
        mTransportsList.add(new CategoryModel(R.drawable.motorcycle_w, R.drawable.motorcycle, R.raw.motorcycle));
        mTransportsList.add(new CategoryModel(R.drawable.plane_w, R.drawable.plane, R.raw.plane));
        mTransportsList.add(new CategoryModel(R.drawable.rocket_w, R.drawable.rocket, R.raw.rocket));
        mTransportsList.add(new CategoryModel(R.drawable.ship_w, R.drawable.ship, R.raw.ship));
        mTransportsList.add(new CategoryModel(R.drawable.train_w, R.drawable.train, R.raw.train));
        mTransportsList.add(new CategoryModel(R.drawable.truck_w, R.drawable.truck, R.raw.truck));
        return mTransportsList;
    }

    public static ArrayList<CategoryModel> makeObjectsList(){
        ArrayList<CategoryModel> mObjectsList = new ArrayList<>();
        mObjectsList.add(new CategoryModel(R.drawable.jug_w, R.drawable.jug, R.raw.jug));
        mObjectsList.add(new CategoryModel(R.drawable.kite_w, R.drawable.kite, R.raw.kite));
        mObjectsList.add(new CategoryModel(R.drawable.pen_w, R.drawable.pen, R.raw.pen));
        mObjectsList.add(new CategoryModel(R.drawable.sun_w, R.drawable.sun, R.raw.sun));
        mObjectsList.add(new CategoryModel(R.drawable.tree_w, R.drawable.tree, R.raw.tree));
        mObjectsList.add(new CategoryModel(R.drawable.umbrella_w, R.drawable.umbrella, R.raw.umbrella));
        mObjectsList.add(new CategoryModel(R.drawable.violin_w, R.drawable.violin, R.raw.violin));
        mObjectsList.add(new CategoryModel(R.drawable.watch_w, R.drawable.watch, R.raw.watch));
        mObjectsList.add(new CategoryModel(R.drawable.xylophone_w, R.drawable.xylophone, R.raw.xylophone));
        mObjectsList.add(new CategoryModel(R.drawable.yoyo_w, R.drawable.yoyo, R.raw.yoyo));
        return mObjectsList;
    }
}
