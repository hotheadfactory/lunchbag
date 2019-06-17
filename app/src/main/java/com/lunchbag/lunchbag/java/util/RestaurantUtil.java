package com.lunchbag.lunchbag.java.util;

import android.content.Context;

import com.lunchbag.lunchbag.R;
import com.lunchbag.lunchbag.java.model.Restaurant;

import java.util.Arrays;
import java.util.Locale;
import java.util.Random;

/**
 * Utilities for Restaurants.
 */
public class RestaurantUtil {

    private static final String TAG = "RestaurantUtil";

    private static final String RESTAURANT_URL_FMT = "https://storage.googleapis.com/firestorequickstarts.appspot.com/food_%d.png";
    private static final int MAX_IMAGE_NUM = 22;
    /** 자동 생성 식당 이름 매크로 문구 */
    private static final String[] NAME_FIRST_WORDS = {
            "용봉",
            "광주",
            "무등",
            "호남",
            "전라도",
            "원조",
            "일번가",
            "충장",
            "양동",
            "말바우",
            "울트라",
            "털보네",
            "프라임",
            "일품",
    };

    private static final String[] NAME_SECOND_WORDS = {
            "커피",
            "피자",
            "닭갈비",
            "해장국",
            "햄버거",
            "식당",
            "횟집",
            "갈비탕",
            "치킨",
            "버거",
            "레스토랑",
            "분식",
    };


    public static Restaurant getRandom(Context context) {
        Restaurant restaurant = new Restaurant();
        Random random = new Random();

        // Places (first elemnt is 'Any')
        String[] places = context.getResources().getStringArray(R.array.places);
        places = Arrays.copyOfRange(places, 1, places.length);

        // Categories (first element is 'Any')
        String[] categories = context.getResources().getStringArray(R.array.categories);
        categories = Arrays.copyOfRange(categories, 1, categories.length);

        int[] prices = new int[]{1, 2, 3, 4, 5, 6};

        int[] congestion = new int[]{1, 2, 3, 4, 5};

        restaurant.setName(getRandomName(random));
        restaurant.setPlace(getRandomString(places, random));
        restaurant.setCategory(getRandomString(categories, random));
        restaurant.setPhoto(getRandomImageUrl(random));
        restaurant.setPrice(getRandomInt(prices, random));
        restaurant.setCong(getRandomInt(congestion, random));
        restaurant.setNumRatings(random.nextInt(20));

        // Note: average rating intentionally not set

        return restaurant;
    }


    /**
     * Get a random image.
     */
    private static String getRandomImageUrl(Random random) {
        // Integer between 1 and MAX_IMAGE_NUM (inclusive)
        int id = random.nextInt(MAX_IMAGE_NUM) + 1;

        return String.format(Locale.getDefault(), RESTAURANT_URL_FMT, id);
    }

    /**
     * Get price represented as dollar signs.
     */
    public static String getPriceString(Restaurant restaurant) {
        return getPriceString(restaurant.getPrice());
    }

    /**
     * Get price represented as dollar signs.
     */
    public static String getPriceString(int priceInt) {
        switch (priceInt) {
            case 1:
                return "~2900원";
            case 2:
                return "3000원~4900원";
            case 3:
                return "5000원~6900원";
            case 4:
                return "7000원~8900원";
            case 5:
                return "9000원~11900원";
            case 6:
            default:
                return "12000원~";
        }
    }

    public static String getCongString(Restaurant restaurant) {
        return getCongString(restaurant.getCong());
    }

    public static String getCongString(int cong) {
        switch (cong) {
            case 1:
                return "한가함";
            case 2:
                return "적당";
            case 3:
                return "혼잡";
            case 4:
                return "대기 시간 10분 이상";
            case 5:
                return "대기 시간 30분 이상";
            default:
                return "혼잡도 정보 없음";
        }
    }

    private static String getRandomName(Random random) {
        return getRandomString(NAME_FIRST_WORDS, random)
                + getRandomString(NAME_SECOND_WORDS, random);
    }

    private static String getRandomString(String[] array, Random random) {
        int ind = random.nextInt(array.length);
        return array[ind];
    }

    private static int getRandomInt(int[] array, Random random) {
        int ind = random.nextInt(array.length);
        return array[ind];
    }

}
