/**
 * BSD 3-Clause License
 * 
 * Copyright (c) 2023, Tushar Chaurasia
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 
 * 3. Neither the name of the copyright holder nor the names of its
 *    contributors may be used to endorse or promote products derived from
 *    this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
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
                    "-4. returns [`https://www.github.com/Dark-CodeX/returns.git`]\n\t" +
                    "-5. set [`https://www.github.com/Dark-CodeX/set.git`]\n\t" +
                    "-6. array [`https://www.github.com/Dark-CodeX/array.git`]\n\t" +
                    "-7. date-time [`https://www.github.com/Dark-CodeX/date-time.git`]\n\t" +
                    "-8. heap-pair [`https://www.github.com/Dark-CodeX/heap-pair.git`]\n\t" +
                    "0. Exits the application.");

            System.out.print("Which GitHub repository you want to install:\n\t" +
                    "1. sstring [`https://www.github.com/Dark-CodeX/sstring.git`]\n\t" +
                    "2. vector [`https://www.github.com/Dark-CodeX/vector.git`]\n\t" +
                    "3. map [`https://www.github.com/Dark-CodeX/map.git`]\n\t" +
                    "4. returns [`https://www.github.com/Dark-CodeX/returns.git`]\n\t" +
                    "5. set [`https://www.github.com/Dark-CodeX/set.git`]\n\t" +
                    "6. array [`https://www.github.com/Dark-CodeX/array.git`]\n\t" +
                    "7. date-time [`https://www.github.com/Dark-CodeX/date-time.git`]\n\t" +
                    "8. heap-pair [`https://www.github.com/Dark-CodeX/heap-pair.git`]\n" +
                    "<option number>: ");

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
            } else if (option == -8) {
                fs.uninstall("heap-pair", gcc_include_path, null);
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
            } else if (option == 8) {
                fs.install("heap-pair", gcc_include_path, Links.heap_pair_urls, null);
            } else {
                System.err.println("Invalid choice `" + option + "`.");
            }
        }
    }
}
