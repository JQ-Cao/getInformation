package com.company;

/**
 * Created by JQ-Cao on 15/4/28.
 */
public class To36{
    private static char[] X36 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        public String ConvertTo36(int val)
        {
            String result = "";
            while (val >= 36)
            {
                result = X36[val % 36] + result;
                val /= 36;
            }
            if (val >= 0) result = X36[val] + result;
            return result;
        }
}
