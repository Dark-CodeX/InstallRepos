package org.tusharchaurasia.installrepos.installrepos;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadFile {
    public static String get_file_name(String url){
        StringBuilder x = new StringBuilder();
        int ind = url.lastIndexOf('/') + 1;
        for (int i = ind; i < url.length(); i++)
            x.append(url.charAt(i));
        return x.toString();
    }
    public static String Download(String location){
        URL url = null;
        try {
            url = new URL(location);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        StringBuilder x = new StringBuilder();
        try {
            byte[] data = url.openStream().readAllBytes();
            for (byte datum : data) x.append((char) datum);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return x.toString();
    }
}
