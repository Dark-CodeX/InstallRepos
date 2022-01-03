package org.tusharchaurasia.installrepos.installrepos;

import java.io.IOException;

public class Start {
    public static void main(String[] args){
        try {
            install_repos.main(args);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
