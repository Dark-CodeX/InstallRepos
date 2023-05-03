/**
 * @file install_repos_cli.java
 * @license This file is licensed under the GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007. You may obtain a copy of this license at https://www.gnu.org/licenses/gpl-3.0.en.html.
 * @version 1.1.0
 * @author Tushar Chaurasia (Dark-CodeX)
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
            System.out.println("Which GitHub repository you want to uninstall:\n\t" +
                    "-1. sstring [`https://www.github.com/Dark-CodeX/sstring.git`]\n\t" +
                    "-2. vector [`https://www.github.com/Dark-CodeX/vector.git`]\n\t" +
                    "-3. map [`https://www.github.com/Dark-CodeX/map.git`]\n\t" +
                    "-4. optional [`https://www.github.com/Dark-CodeX/optional.git`]\n\t" +
                    "-5. array [`https://www.github.com/Dark-CodeX/array.git`]\n\t" +
                    "-6. date-time [`https://www.github.com/Dark-CodeX/date-time.git`]\n\t" +
                    "-7. heap-pair [`https://www.github.com/Dark-CodeX/heap-pair.git`]\n\t" +
                    "-8. chunkio [`https://www.github.com/Dark-CodeX/chunkio.git`]\n\t" +
                    "-9. mthread [`https://www.github.com/Dark-CodeX/mthread.git`]\n\t" +
                    " 0. Exits the application.");

            System.out.print("Which GitHub repository you want to install:\n\t" +
                    " 1. sstring [`https://www.github.com/Dark-CodeX/sstring.git`]\n\t" +
                    " 2. vector [`https://www.github.com/Dark-CodeX/vector.git`]\n\t" +
                    " 3. map [`https://www.github.com/Dark-CodeX/map.git`]\n\t" +
                    " 4. optional [`https://www.github.com/Dark-CodeX/optional.git`]\n\t" +
                    " 5. array [`https://www.github.com/Dark-CodeX/array.git`]\n\t" +
                    " 6. date-time [`https://www.github.com/Dark-CodeX/date-time.git`]\n\t" +
                    " 7. heap-pair [`https://www.github.com/Dark-CodeX/heap-pair.git`]\n\n" +
                    " 8. chunkio [`https://www.github.com/Dark-CodeX/chunkio.git`]\n\n" +
                    " 9. mthread [`https://www.github.com/Dark-CodeX/mthread.git`]\n\n" +
                    "<option number>: ");

            option = scanner.nextInt();
            if (option == -1) {
                fs.uninstall("sstring", gcc_include_path, null);
            } else if (option == -2) {
                fs.uninstall("vector", gcc_include_path, null);
            } else if (option == -3) {
                fs.uninstall("map", gcc_include_path, null);
            } else if (option == -4) {
                fs.uninstall("optional", gcc_include_path, null);
            } else if (option == -5) {
                fs.uninstall("array", gcc_include_path, null);
            } else if (option == -6) {
                fs.uninstall("date-time", gcc_include_path, null);
            } else if (option == -7) {
                fs.uninstall("heap-pair", gcc_include_path, null);
            } else if (option == -8) {
                fs.uninstall("chunkio", gcc_include_path, null);
            } else if (option == -9) {
                fs.uninstall("mthread", gcc_include_path, null);
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
                fs.install("optional", gcc_include_path, Links.optional_urls, null);
            } else if (option == 5) {
                fs.install("array", gcc_include_path, Links.array_urls, null);
            } else if (option == 6) {
                fs.install("date-time", gcc_include_path, Links.date_time_urls, null);
            } else if (option == 7) {
                fs.install("heap-pair", gcc_include_path, Links.heap_pair_urls, null);
            } else if (option == 8) {
                fs.install("chunkio", gcc_include_path, Links.chunkio_urls, null);
            } else if (option == 9) {
                fs.install("mthread", gcc_include_path, Links.mthread_urls, null);
            } else {
                System.err.println("Invalid choice `" + option + "`.");
            }
        }
    }
}
