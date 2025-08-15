package com.qms.backend.filters;

import java.text.SimpleDateFormat;
import java.util.Date;


public class DateModifier {

    public static String formatToLocalDate(Date date) {
        // Define your desired date format
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
    }
}
