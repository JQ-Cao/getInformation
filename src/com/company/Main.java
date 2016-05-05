package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        CaptureHtml cH = new CaptureHtml();
        String DL[] = new String[100];
        DL[0] = "58.213.48.108" ;
        DL[1] = "80";
        DL[2] = "220.189.97.123";
        DL[3] = "3218";
        DL[4] = "58.221.85.182";
        DL[5] = "3218";
        DL[6] = "125.84.143.68";
        DL[7] = "9999";
        DL[8] = "220.185.102.142";
        DL[9] = "3128";
        DL[10] = "115.28.85.240";
        DL[11] = "8088";
        for(int i = 500000;i < 510000; ++i) {
//            if(i%50==0){
//                int m = (int) (Math.random() * 12);
//                int k = (int) (Math.random() * 5);
//                if(k!=2){
//                    if(m%2==0){
//                        System.setProperty("http.proxyHost",DL[++m]);
//                        System.setProperty("http.proxyPort",DL[m]);
//                    }
//                    System.setProperty("http.proxyHost",DL[(m+1)%12]);
//                    System.setProperty("http.proxyPort",DL[(m+2)%12]);
//                }
//            }
            try {
                cH.getInformation(""+ i);
                System.out.println(i);
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }
    }
}
