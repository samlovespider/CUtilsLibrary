package com.samcai.cutilslibrary.utils;

import java.math.BigDecimal;

/**
 * Created by caizhenliang on 2018/2/20.
 *
 * @version 1.3
 */
public class PriceUtils {

    public static int Price2IntegerFormat(String price) {
        return new BigDecimal(price)
                .multiply(new BigDecimal(100))
                .intValue();
    }

    public static String Integer2PriceFormat(int number) {
        return new BigDecimal(number)
                .divide(new BigDecimal(100), 2, BigDecimal.ROUND_DOWN)
                .toString();
    }

    public static int SignedPrice2IntegerFormat(String price) {
        StringBuilder stringBuilder = new StringBuilder(price);
        stringBuilder.deleteCharAt(0);
        return new BigDecimal(stringBuilder.toString())
                .multiply(new BigDecimal(100))
                .intValue();
    }

}
