package com.company;


/**
 * Created by JQ-Cao on 15/4/27.
 */
public class CaptureHtml {
    public void getInformation(String ip) throws Exception {
        HttpConn HC = new HttpConn();
        Dazhong dz = new Dazhong();
        String result = dz.analysisDazhong(HC.httpConn(ip)) + dz.getMenu(HC.httpConn(ip+"/menu"));
        FileOutput fop = new FileOutput();
        System.out.println("result: \n" + result);
        fop.fileOutput1(result);
//        int j = (int) (Math.random() * 1);
//        try {
//            Thread.sleep(j*1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
