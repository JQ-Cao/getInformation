package com.company;

import java.io.BufferedInputStream;
import java.io.*;


/**
 * Created by JQ-Cao on 15/4/27.
 */
public class FileOutput {
    static String file1 = "/Users/JQ-Cao/Desktop/result_POI.txt";
    static String file2 = "/Users/JQ-Cao/Desktop/result_webPage.txt";
    public void fileOutput1(String information)throws IOException {
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file1,true)));
        out.println(information);
        out.flush();
        out.close();
    }
    public void fileOutput2(String information)throws IOException {
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file2,true)));
        out.println(information);
        out.flush();
        out.close();
    }
}
