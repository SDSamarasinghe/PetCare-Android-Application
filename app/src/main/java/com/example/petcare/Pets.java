package com.example.petcare;

import android.provider.BaseColumns;

public final class Pets {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private Pets() {}

    /* Inner class that defines the table contents */
    public static class Pet implements BaseColumns {
        public static final String TABLE_NAME = "PetInfo";
        public static final String COLUMN_1 = "petName";
        public static final String COLUMN_2 = "password";
        public static final String COLUMN_3 = "address";


    }
}