package com.lunchbag.lunchbag.java;

import android.content.Context;
import android.text.TextUtils;

import com.lunchbag.lunchbag.R;
import com.lunchbag.lunchbag.java.model.Restaurant;
import com.lunchbag.lunchbag.java.util.RestaurantUtil;
import com.google.firebase.firestore.Query;

/**
 * Object for passing filters around.
 */
public class Filters {

    private String category = null;
    private String place = null;
    private int price = -1;
    private String sortBy = null;
    private Query.Direction sortDirection = null;

    public Filters() {}

    public static Filters getDefault() {
        Filters filters = new Filters();
        filters.setSortBy(Restaurant.FIELD_AVG_RATING);
        filters.setSortDirection(Query.Direction.DESCENDING);

        return filters;
    }

    public boolean hasCategory() {
        return !(TextUtils.isEmpty(category));
    }

    public boolean hasPlace() {
        return !(TextUtils.isEmpty(place));
    }

    public boolean hasPrice() {
        return (price > 0);
    }

    public boolean hasSortBy() {
        return !(TextUtils.isEmpty(sortBy));
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public Query.Direction getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(Query.Direction sortDirection) {
        this.sortDirection = sortDirection;
    }

    public String getSearchDescription(Context context) {
        StringBuilder desc = new StringBuilder();

        if (category == null && place == null) {
            desc.append("<b>");
            desc.append(context.getString(R.string.all_restaurants));
            desc.append("</b>");
        }

        if (place != null) {
            desc.append("<b>");
            desc.append(place);
            desc.append("</b>");
        }

        if (category != null && place != null) {
            desc.append("의 ");
        }

        if (category != null) {
            desc.append("<b>");
            desc.append(category);
            desc.append("</b>");
        }

        if (price > 0) {
            desc.append(", ");
            desc.append("<b>");
            desc.append(RestaurantUtil.getPriceString(price));
            desc.append("</b>");
        }

        return desc.toString();
    }

    public String getOrderDescription(Context context) {
        if (Restaurant.FIELD_PRICE.equals(sortBy)) {
            return context.getString(R.string.sorted_by_price);
        } else if (Restaurant.FIELD_POPULARITY.equals(sortBy)) {
            return context.getString(R.string.sorted_by_popularity);
        } else {
            return context.getString(R.string.sorted_by_rating);
        }
    }
}
