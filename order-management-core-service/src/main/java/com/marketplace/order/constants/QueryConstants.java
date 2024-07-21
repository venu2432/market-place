package com.marketplace.order.constants;

public class QueryConstants {
    public static final String GET_PRODUCT_BY_NAME =
            "SELECT products.ID, " +
                    "products.SELLER_ID, " +
                    "products.CATEGORY_ID, " +
                    "products.NAME, " +
                    "products.DESCRIPTION, " +
                    "products.PRICE, " +
                    "products.CREATED_AT, " +
                    "products.UPDATED_AT " +
                    "FROM products " +
                    "WHERE products.NAME LIKE %:name%";

    public static final String GET_CATEGORY_BY_NAME =
            "SELECT categories.CATEGORY_ID, " +
                    "categories.NAME, " +
                    "categories.DESCRIPTION, " +
                    "categories.CREATED_AT, " +
                    "categories.UPDATED_AT " +
                    "FROM categories " +
                    "WHERE categories.NAME LIKE %:name%";



}
