package com.example.spinnertest;

import android.provider.BaseColumns;

public final class UserManagement {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private UserManagement() {}

    /* Inner class that defines the table contents */
    public static class User implements BaseColumns {
        public static final String TABLE_NAME = "UserInfo";
        public static final String COLUMN_1 = "UserName";
        public static final String COLUMN_2 = "Type";
        public static final String COLUMN_3 = "Gender";
    }
}