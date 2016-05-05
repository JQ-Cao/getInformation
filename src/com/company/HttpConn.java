package com.company;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

/**
 * Created by JQ-Cao on 15/4/28.
 */
public class HttpConn  {
    public String httpConn(String ip) throws Exception {
        String strURL = "http://www.dianping.com/shop/" + ip;
        URL url = new URL(strURL);
        CookieManager cookieManager = CookieManager.getInstance();
        //InetSocketAddress addr = new InetSocketAddress("http.proxyHost","58.213.48.108":80);
        //Proxy proxy = new Proxy(Proxy.Type.HTTP,addr);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();


        int j = (int) (Math.random() * 2);
        if(j%2==1) {
            httpConn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/27.0.1453.94 Safari/537.36");
        }else {
            httpConn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 5.1; rv:5.0) Gecko/20100101 Firefox/5.0");
        }

        httpConn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        httpConn.setRequestProperty("Accept-Language", "zh-cn,zh;q=0.5");
        httpConn.setRequestProperty("Accept-Encoding", "GB2312,utf-8;q=0.7,*;q=0.7");
        httpConn.setRequestProperty("Referer", "http://http://www.dianping.com/");
        httpConn.setRequestProperty("Cache-Control", "max-age=0");
        httpConn.setRequestProperty("Cookie", cookieManager.getCookies(url.getHost()));
        //httpConn.connect();
//        InputStream in = httpConn.getInputStream();
//        int rc = 0;
//        byte[] buff = new byte[256];
//        while((rc=in.read(buff,0,256))>0)
//        System.out.print(buff);
        if(httpConn.getResponseCode()==403) {
            System.out.println("Err:403");
            System.exit(1);
        }
        InputStreamReader input = new InputStreamReader(httpConn.getInputStream());
        BufferedReader bufReader = new BufferedReader(input);
        String line = "";
        StringBuilder contentBuf = new StringBuilder();
        while((line = bufReader.readLine()) != null){
            contentBuf.append(line);
        }
        String buf = contentBuf.toString();
        httpConn.disconnect();
        input.close();
        bufReader.close();
        return  buf;
    }

}
