package com.company;

/**
 * Created by JQ-Cao on 15/4/27.
 */
public class Analysis {
    int digi = 16;
    int add = 10;
    int plus = 7;
    int cha = 36;
    int i = -1;
    int h = 0;
    String b = "";
    int j = 14;
    int g = 13;
    public double[] analysis(String words){
        To36 t36 = new To36();
        j=words.length();
        char G[] = words.toCharArray();
        g = G[G.length-1];
        --j;
        for(int e = 0;e < j;++e){
            int d = Integer.parseInt(words.charAt(e)+"",cha)-add;
            if(d >=add){
                d= d - plus;
            }
            b=b+t36.ConvertTo36(d);
            if(d > h){
                i = e;
                h = d;
            }
        }
        double a = (double)Integer.parseInt(b.substring(0,i),digi);
        double f = (double)Integer.parseInt(b.substring(i+1),digi);
        double l = ((a + f - g)/2);
        double k = (f - l)/100000;
        double result[]= {l/100000,k};
        return result;
    }

}
