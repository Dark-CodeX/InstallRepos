/*
MIT License

Copyright (c) 2021 Tushar Chaurasia

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/

package org.tusharchaurasia.installrepos.installrepos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class install_repos extends Application {
    public static String gcc_include_path = "";

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(install_repos.class.getResource("gui_install_repos.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 320);
        stage.setTitle("Install Repos");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) throws IOException {
        if (OS_TYPE.get_os() == OS_TYPE.OS.LINUX || OS_TYPE.get_os() == OS_TYPE.OS.MAC_OS) {
            gcc_include_path = "/usr/include/";
        }
        else {
            ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "where gcc");
            builder.redirectErrorStream(true);
            Process p = builder.start();
            InputStreamReader isr = new InputStreamReader(p.getInputStream());
            BufferedReader r = new BufferedReader(isr);
            gcc_include_path = r.readLine();
            if (OS_TYPE.get_arch() == 64)
                gcc_include_path = gcc_include_path.replace("\\bin\\gcc.exe", "/x86_64-w64-mingw32/include/");
            else if (OS_TYPE.get_arch() == 32)
                gcc_include_path = gcc_include_path.replace("\\bin\\gcc.exe", "/x86-w64-mingw32/include/");
            else {
                r.close();
                isr.close();
                System.exit(-1);
            }
            r.close();
            isr.close();
        }
        if(gcc_include_path.length() == 0) {
            System.err.println("Could not detect GCC include path.");
            System.exit(-1);
        }
        launch(args);
    }
}