/*
MIT License

Copyright (c) 2022 Tushar Chaurasia

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

import java.util.Scanner;

public class install_repos_cli {
    public static String gcc_include_path = "";

    public static void main(String[] args) {
        System.out.println("Enter GCC include path or any path to install repos:");
        System.out.print("Path: ");
        Scanner scanner = new Scanner(System.in);
        gcc_include_path = scanner.nextLine();
        gcc_include_path = fs.make_path(gcc_include_path);
        if (gcc_include_path.length() == 0) {
            System.err.println("err: could not get GCC include path.");
            System.exit(1);
        }
        System.out.println("\nGCC Include Path: => `" + gcc_include_path + "`\nALWAYS RUN THIS APPLICATION UNDER "
                + ((OS_TYPE.get_os() == OS_TYPE.OS.WINDOWS) ? "ADMINISTRATOR PRIVILEGES." : "SUPERUSER PRIVILEGES."));
        int option;
        while (true) {
            System.out.println(
                    "Which GitHub repository you want to uninstall:\n\t-1. sstring(`https://www.github.com/Dark-CodeX/sstring.git`)\n\t-2. vector(`https://www.github.com/Dark-CodeX/vector.git`)\n\t-3. map(`https://www.github.com/Dark-CodeX/map.git`)\n\t-4. returns(`https://www.github.com/Dark-CodeX/returns.git`)\n\t-5. set(`https://www.github.com/Dark-CodeX/set.git`)\n\t-6. set(`https://www.github.com/Dark-CodeX/array.git`)\n\t-7. set(`https://www.github.com/Dark-CodeX/date-time.git`)\n\t0. Exits the application.");
            System.out.print(
                    "Which GitHub repository you want to install:\n\t1. sstring(`https://www.github.com/Dark-CodeX/sstring.git`)\n\t2. vector(`https://www.github.com/Dark-CodeX/vector.git`)\n\t3. map(`https://www.github.com/Dark-CodeX/map.git`)\n\t4. returns(`https://www.github.com/Dark-CodeX/returns.git`)\n\t5. set(`https://www.github.com/Dark-CodeX/set.git`)\n\t6. set(`https://www.github.com/Dark-CodeX/array.git`)\n\t7. set(`https://www.github.com/Dark-CodeX/date-time.git`)\n<option number>: ");
            option = scanner.nextInt();
            if (option == -1) {
                fs.uninstall("sstring", gcc_include_path, null);
            } else if (option == -2) {
                fs.uninstall("vector", gcc_include_path, null);
            } else if (option == -3) {
                fs.uninstall("map", gcc_include_path, null);
            } else if (option == -4) {
                fs.uninstall("returns", gcc_include_path, null);
            } else if (option == -5) {
                fs.uninstall("set", gcc_include_path, null);
            } else if (option == -6) {
                fs.uninstall("array", gcc_include_path, null);
            } else if (option == -7) {
                fs.uninstall("date-time", gcc_include_path, null);
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
            } else if (option == 5) {
                fs.install("set", gcc_include_path, Links.set_urls, null);
            } else if (option == 6) {
                fs.install("array", gcc_include_path, Links.array_urls, null);
            } else if (option == 7) {
                fs.install("date-time", gcc_include_path, Links.date_time_urls, null);
            } else {
                System.err.println("Invalid choice `" + option + "`.");
            }
        }
    }
}
