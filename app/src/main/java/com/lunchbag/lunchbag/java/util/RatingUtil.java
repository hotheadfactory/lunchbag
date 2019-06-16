package com.lunchbag.lunchbag.java.util;

import com.lunchbag.lunchbag.java.model.Rating;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;


public class RatingUtil {
    /** 자동 생성 리뷰 매크로 문구*/
    public static final String[] REVIEW_CONTENTS = {
            // 0 - 1 stars
            "너무 맛없어서 남기고나왔습니다.",

            // 1 - 2 stars
            "별로 맛없었어요. 다시 안 오게 될듯",

            // 2 - 3 stars
            "그럭저럭 먹을만 했습니다.",

            // 3 - 4 stars
            "맛있어요. 다음에 또오게 될듯.",

            // 4 - 5 stars
            "존맛탱 이곳저곳 소문내고 다니겠습니당"
    };

    /**
     * Get a list of random Rating POJOs.
     */
    public static List<Rating> getRandomList(int length) {
        List<Rating> result = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            result.add(getRandom());
        }

        return result;
    }

    /**
     * Get the average rating of a List.
     */
    public static double getAverageRating(List<Rating> ratings) {
        double sum = 0.0;

        for (Rating rating : ratings) {
            sum += rating.getRating();
        }

        return sum / ratings.size();
    }

    /**
     * Create a random Rating POJO.
     */
    public static Rating getRandom() {
        Rating rating = new Rating();

        Random random = new Random();

        double score = random.nextDouble() * 5.0;
        String text = REVIEW_CONTENTS[(int) Math.floor(score)];

        rating.setUserId(UUID.randomUUID().toString());
        rating.setUserName("Random User");
        rating.setRating(score);
        rating.setText(text);

        return rating;
    }

}
