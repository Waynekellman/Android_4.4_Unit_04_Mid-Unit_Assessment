package com.nyc.android_44_unit_04_mid_unit_assessment.models;

/**
 * Created by Wayne Kellman on 12/20/17.
 */

public class BookModel {
    String string = "{\n" +
            "  \"books\": [\n" +
            "    {\n" +
            "      \"title\": \"Northanger Abbey\",\n" +
            "      \"author\": \"Austen, Jane\",\n" +
            "      \"year\": 1814\n" +
            "    };\n"+
            "  ]\n" +
            "}\n";

    public Books[] getBooks() {
        return books;
    }

    private Books[] books;

    public void setBooks(Books[] books) {
        this.books = books;
    }
}
