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

import java.io.*;
import java.util.Scanner;

public class install_repos_cli {
    public static String gcc_include_path = "";

    public static void main(String[] args) throws IOException {
        if (OS_TYPE.get_os() == OS_TYPE.OS.LINUX || OS_TYPE.get_os() == OS_TYPE.OS.MAC_OS) {
            gcc_include_path = "/usr/include/";
        } else {
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
        if (gcc_include_path.length() == 0) {
            System.err.println("Could not detect GCC include path.");
            System.exit(-1);
        }
        System.out.println("\nGCC Include Path: => `" + gcc_include_path + "`\nALWAYS RUN THIS APPLICATION UNDER "
                + ((OS_TYPE.get_os() == OS_TYPE.OS.WINDOWS) ? "ADMINISTRATOR PRIVILEGES." : "SUPERUSER PRIVILEGES."));
        Scanner scanner = new Scanner(System.in);
        int option;
        while (true) {
            System.out.println(
                    "Which GitHub repository you want to uninstall:\n\t-1. sstring(`https://www.github.com/Dark-CodeX/sstring.git`)\n\t-2. vector(`https://www.github.com/Dark-CodeX/vector.git`)\n\t-3. map(`https://www.github.com/Dark-CodeX/map.git`)\n\t-4. returns(`https://www.github.com/Dark-CodeX/returns.git`)\n\t0. Exits the application.");
            System.out.print(
                    "Which GitHub repository you want to install:\n\t1. sstring(`https://www.github.com/Dark-CodeX/sstring.git`)\n\t2. vector(`https://www.github.com/Dark-CodeX/vector.git`)\n\t3. map(`https://www.github.com/Dark-CodeX/map.git`)\n\t4. returns(`https://www.github.com/Dark-CodeX/returns.git`)\n<option number>: ");
            option = scanner.nextInt();
            if (option == -1) {
                fs.uninstall("sstring", gcc_include_path, null);
            } else if (option == -2) {
                fs.uninstall("vector", gcc_include_path, null);
            } else if (option == -3) {
                fs.uninstall("map", gcc_include_path, null);
            } else if (option == -4) {
                fs.uninstall("returns", gcc_include_path, null);
            } else if (option == 0) {
                scanner.close();
                System.exit(0);
            } else if (option == 1) {
                fs.install("sstring", gcc_include_path, Links.sstring_urls, null);
            } else if (option == 2) {
                fs.install("vector", gcc_include_path, Links.vector_urls, null);
            } else if (option == 3) {
                fs.install("map", gcc_include_path, Links.map_urls, null);
            } else if (option == 4) {
                fs.install("returns", gcc_include_path, Links.returns_urls, null);
            } else {
                System.err.println("Invalid choice `" + option + "`.");
            }
        }
    }
}
