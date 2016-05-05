package com.company;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by JQ-Cao on 15/4/28.
 */
public class Dazhong {
    private String shopName;//店名

    private String province = "";//省
    private String city = "";//市
    private String region = "";//区
    private String address = "";//地址

    private String tel = "";//联系电话

    private String anotherName = "";//别名

    private String shopHours = "";//营业时间

    private String introduce = "";//店铺简介

    private String shopTag = "";//店铺标签

    private String price = "";//价格
    private String delicious = "";//口味
    private String environment = "";//环境
    private String service = "";//服务

    private String reviews = "";//评论

    private String POI = "";//坐标

    private String shopClass = "";//店铺分类

    private String menu = "";//菜单

    public String analysisDazhong(String buf){
        StringBuffer information = new StringBuffer();
        Pattern pattern = Pattern.compile("<h1 class=\"shop-name\">(.+?)<a");
        Matcher matcher =  pattern.matcher(buf);
        if(matcher.find())
            shopName = matcher.group(1);
        pattern = Pattern.compile("province=(.+?);");
        matcher =  pattern.matcher(buf);
        if(matcher.find())
            province = matcher.group(1);
        pattern = Pattern.compile("city=(.+?);");
        matcher =  pattern.matcher(buf);
        if(matcher.find())
            city = matcher.group(1);
        pattern = Pattern.compile("itemprop=\"locality region\">(.+?)</span>");
        matcher =  pattern.matcher(buf);
        if(matcher.find())
            region = matcher.group(1);
        pattern = Pattern.compile("itemprop=\"street-address\" title=\"(.+?)\">");
        matcher =  pattern.matcher(buf);
        if(matcher.find())
            address = matcher.group(1);
        pattern = Pattern.compile("itemprop=\"tel\">(.+?)</span>");
        matcher =  pattern.matcher(buf);
        while(matcher.find())
            tel= tel + "   " + matcher.group(1);
        pattern = Pattern.compile("<span class=\"info-name\">别&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</span>\n" +
                "            <span class=\"item\">(.+?)</span>");
        matcher =  pattern.matcher(buf);
        if(matcher.find())
            anotherName = matcher.group(1);
        pattern = Pattern.compile("class=\"info-name\">营业时间：</span>\n" +
                "                <span class=\"item\">(.+?)</span>");
        matcher =  pattern.matcher(buf);
        if(matcher.find())
            shopHours = matcher.group(1);
        pattern = Pattern.compile("餐厅简介：</span>(.+?)</p>");
        matcher =  pattern.matcher(buf);
        if(matcher.find())
            introduce = matcher.group(1);
        pattern = Pattern.compile("rel=\"tag\" target=\"_blank\">(.+?)</a>");
        matcher =  pattern.matcher(buf);
        while(matcher.find())
            shopTag = shopTag+ "  " + matcher.group(1);
        pattern = Pattern.compile("class=\"item\">人均：(.+?)</span>");
        matcher =  pattern.matcher(buf);
        if(matcher.find())
            price = matcher.group(1);
        pattern = Pattern.compile("class=\"item\">口味：(.+?)</span>");
        matcher =  pattern.matcher(buf);
        if(matcher.find())
            delicious = matcher.group(1);
        pattern = Pattern.compile("class=\"item\">环境：(.+?)</span>");
        matcher =  pattern.matcher(buf);
        if(matcher.find())
            environment = matcher.group(1);
        pattern = Pattern.compile("class=\"item\">服务：(.+?)</span>");
        matcher =  pattern.matcher(buf);
        if(matcher.find())
            service = matcher.group(1);
        pattern = Pattern.compile("poi: \"(.+?)\"");
        matcher =  pattern.matcher(buf);
        if(matcher.find()) {
            Analysis anal = new Analysis();
            double lngLat[]= anal.analysis(matcher.group(1).toString());
            POI = "[" + lngLat[0] + " " + lngLat[1] + "]";
        }
        pattern = Pattern.compile("itemprop=\"url\">(.+?)</a>");
        matcher =  pattern.matcher(buf);
        while(matcher.find())
            shopClass = shopClass+ "  " + matcher.group(1).replaceAll("\\s{1,}"," ").replace("\n","");
        return information.append("店名："+shopName + " *#* " + "省:" + province + " *#* " + "市：" + city + " *#* " +
        "区:" + region + " *#* " + "地址:" + address + " *#* " +"联系电话:" + tel + " *#* " + "别名：" + anotherName +
        " *#* " + "营业时间：" + shopHours + " *#* " + "店铺简介：" + introduce + " *#* " +"店铺标签：" + shopTag +
        " *#* " + "人均：" + price + " *#* " + "口味：" + delicious + " *#* " + "环境：" + environment + " *#* " +
        "服务：" + service + " *#* " + "经纬度：" + POI +" *#* " + "店铺分类：" + shopClass + " *#* ").toString();

    }
     public String getMenu(String buf){
         StringBuffer information = new StringBuffer();
         Pattern pattern = Pattern.compile("class=\"recommend-item\">(.+?)</div>");
         Matcher matcher =  pattern.matcher(buf);
         information.append("\n推荐菜：\n");
         while(matcher.find()){
             pattern = Pattern.compile("target=\"_blank\">(.+?)</span>");
             Matcher matcher1 = pattern.matcher(matcher.group(1));
             while (matcher1.find()){
                 information.append("  "+ matcher1.group(1).replaceAll("[<>\"=/[a-zA-Z]]","").replaceAll("\\s{1,}"," ") + "\n");
             }
         }
         pattern = Pattern.compile("class=\"menus-mode\" id=\"(.+?)menus-bottom");
         matcher =  pattern.matcher(buf);
         while(matcher.find()){
             information.append("\n" + matcher.group(1).substring(0, matcher.group(1).indexOf("\"")) + "：\n");
             pattern = Pattern.compile("dish-name=\"(.+?)</em>");
             Matcher matcher1 = pattern.matcher(matcher.group(1));
             while (matcher1.find()){
                 information.append(delRepeat(matcher1.group(1).replaceAll("[<>\"=/[a-zA-Z]]","").replaceAll("\\s{1,}"," ").replace("&;","").replace("-","")) + "\n");
             }
         }
         return information.toString();
     }
    public String delRepeat(String sub){
        String result = "";
        String s[] = sub.split(" ");
        for(int i = 1 ;i < s.length;++i)
            result = result + s[i] + " ";
        return result;
    }

}
