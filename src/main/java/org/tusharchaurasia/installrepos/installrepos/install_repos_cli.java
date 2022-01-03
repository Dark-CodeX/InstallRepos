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
        System.out.println("\nGCC Include Path: => `" + gcc_include_path + "`\nALWAYS RUN THIS APPLICATION UNDER " + ((OS_TYPE.get_os() == OS_TYPE.OS.WINDOWS) ? "ADMINISTRATOR PRIVILEGES." : "SUPERUSER PRIVILEGES."));
        Scanner scanner = new Scanner(System.in);
        int option;
        while (true) {
            System.out.print("Which GitHub repository you want to install:\n\t1. sstring(`https://www.github.com/Dark-CodeX/sstring.git`)\n\t2. vector(`https://www.github.com/Dark-CodeX/vector.git`)\n\t3. map(`https://www.github.com/Dark-CodeX/map.git`)\n\t4. returns(`https://www.github.com/Dark-CodeX/returns.git`)\n\t-1. Exits the application.\n<repository number>: ");
            option = scanner.nextInt();
            if (option == 1) {
                if (new File(gcc_include_path + "openutils/sstring/").exists()) {
                    System.out.println("Directory Exists: " + "`" + gcc_include_path + "openutils/sstring`");
                } else if (!new File(gcc_include_path + "openutils/sstring/").mkdirs()) {
                    System.out.println("Could not create directory: `" + gcc_include_path + "openutils/sstring`\nInstallation Failed `sstring`.");
                    return;
                } else {
                    System.out.println("Directory Created: `" + gcc_include_path + "openutils/sstring`");
                }
                String[] data = new String[5];
                String[] urls = {"https://raw.githubusercontent.com/Dark-CodeX/sstring/master/sstring/sstring.h",
                        "https://raw.githubusercontent.com/Dark-CodeX/SafeString/main/sstring/prototype_err.h",
                        "https://raw.githubusercontent.com/Dark-CodeX/SafeString/main/sstring/binary.h",
                        "https://raw.githubusercontent.com/Dark-CodeX/SafeString/main/sstring/morse_code.h",
                        "https://raw.githubusercontent.com/Dark-CodeX/SafeString/main/sstring/sstring.hh"};
                for (int i = 0; i < urls.length; i++) {
                    data[i] = DownloadFile.Download(urls[i]);
                    System.out.println("Downloaded File: " + "`" + urls[i] + "`" + "");
                    try {
                        new File(gcc_include_path + "openutils/sstring/" + DownloadFile.get_file_name(urls[i])).createNewFile();
                        try {
                            FileWriter fw = new FileWriter(gcc_include_path + "openutils/sstring/" + DownloadFile.get_file_name(urls[i]));
                            fw.write(data[i]);
                            fw.close();
                        } catch (IOException e) {
                            System.out.println("Could not write file: " + "`" + gcc_include_path + "openutils/sstring/" + DownloadFile.get_file_name(urls[i]) + "`\nInstallation Failed `sstring`.");
                            return;
                        }
                        System.out.println("File Written: " + "`" + gcc_include_path + "openutils/sstring/" + DownloadFile.get_file_name(urls[i]) + "`" + "");
                    } catch (IOException e) {
                        System.out.println("Could not write file: " + "`" + gcc_include_path + "openutils/sstring/" + DownloadFile.get_file_name(urls[i]) + "`\nInstallation Failed `sstring`.");
                        return;
                    }
                }
                System.out.println("Installation Completed `sstring`.");
            } else if (option == 2) {
                if (new File(gcc_include_path + "openutils/vector/").exists()) {
                    System.out.println("Directory Exists: " + "`" + gcc_include_path + "openutils/vector`");
                } else if (!new File(gcc_include_path + "openutils/vector/").mkdirs()) {
                    System.out.println("Could not create directory: `" + gcc_include_path + "openutils/vector`\nInstallation Failed `vector`.");
                    return;
                } else {
                    System.out.println("Directory Created: `" + gcc_include_path + "openutils/vector`");
                }
                String[] data = new String[2];
                String[] urls = {"https://raw.githubusercontent.com/Dark-CodeX/vector/main/vector/vector.h",
                        "https://raw.githubusercontent.com/Dark-CodeX/vector/main/vector/vector.hh"};
                for (int i = 0; i < urls.length; i++) {
                    data[i] = DownloadFile.Download(urls[i]);
                    System.out.println("Downloaded File: " + "`" + urls[i] + "`" + "");
                    try {
                        new File(gcc_include_path + "openutils/vector/" + DownloadFile.get_file_name(urls[i])).createNewFile();
                        try {
                            FileWriter fw = new FileWriter(gcc_include_path + "openutils/vector/" + DownloadFile.get_file_name(urls[i]));
                            fw.write(data[i]);
                            fw.close();
                        } catch (IOException e) {
                            System.out.println("Could not write file: " + "`" + gcc_include_path + "openutils/vector/" + DownloadFile.get_file_name(urls[i]) + "`\nInstallation Failed `vector`.");
                            return;
                        }
                        System.out.println("File Written: " + "`" + gcc_include_path + "openutils/vector/" + DownloadFile.get_file_name(urls[i]) + "`" + "");
                    } catch (IOException e) {
                        System.out.println("Could not write file: " + "`" + gcc_include_path + "openutils/vector/" + DownloadFile.get_file_name(urls[i]) + "`\nInstallation Failed `vector`.");
                        return;
                    }
                }
                System.out.println("Installation Completed `vector`.");
            } else if (option == 3) {
                if (new File(gcc_include_path + "openutils/map/").exists()) {
                    System.out.println("Directory Exists: " + "`" + gcc_include_path + "openutils/map`");
                } else if (!new File(gcc_include_path + "openutils/map/").mkdirs()) {
                    System.out.println("Could not create directory: `" + gcc_include_path + "openutils/map`\nInstallation Failed `map`.");
                    return;
                } else {
                    System.out.println("Directory Created: `" + gcc_include_path + "openutils/map`");
                }
                String[] data = new String[1];
                String[] urls = {"https://raw.githubusercontent.com/Dark-CodeX/map/master/map/map.hh"};
                for (int i = 0; i < urls.length; i++) {
                    data[i] = DownloadFile.Download(urls[i]);
                    System.out.println("Downloaded File: " + "`" + urls[i] + "`" + "");
                    try {
                        new File(gcc_include_path + "openutils/map/" + DownloadFile.get_file_name(urls[i])).createNewFile();
                        try {
                            FileWriter fw = new FileWriter(gcc_include_path + "openutils/map/" + DownloadFile.get_file_name(urls[i]));
                            fw.write(data[i]);
                            fw.close();
                        } catch (IOException e) {
                            System.out.println("Could not write file: " + "`" + gcc_include_path + "openutils/map/" + DownloadFile.get_file_name(urls[i]) + "`\nInstallation Failed `map`.");
                            return;
                        }
                        System.out.println("File Written: " + "`" + gcc_include_path + "openutils/map/" + DownloadFile.get_file_name(urls[i]) + "`" + "");
                    } catch (IOException e) {
                        System.out.println("Could not write file: " + "`" + gcc_include_path + "openutils/map/" + DownloadFile.get_file_name(urls[i]) + "`\nInstallation Failed `map`.");
                        return;
                    }
                }
                System.out.println("Installation Completed `map`.");
            } else if (option == 4) {
                if (new File(gcc_include_path + "openutils/returns/").exists()) {
                    System.out.println("Directory Exists: " + "`" + gcc_include_path + "openutils/returns`");
                } else if (!new File(gcc_include_path + "openutils/returns/").mkdirs()) {
                    System.out.println("Could not create directory: `" + gcc_include_path + "openutils/returns`\nInstallation Failed `returns`.");
                    return;
                } else {
                    System.out.println("Directory Created: `" + gcc_include_path + "openutils/returns`");
                }
                String[] data = new String[2];
                String[] urls = {"https://raw.githubusercontent.com/Dark-CodeX/returns/master/returns/default.hh",
                        "https://raw.githubusercontent.com/Dark-CodeX/returns/master/returns/optional.hh"};
                for (int i = 0; i < urls.length; i++) {
                    data[i] = DownloadFile.Download(urls[i]);
                    System.out.println("Downloaded File: " + "`" + urls[i] + "`" + "");
                    try {
                        new File(gcc_include_path + "openutils/returns/" + DownloadFile.get_file_name(urls[i])).createNewFile();
                        try {
                            FileWriter fw = new FileWriter(gcc_include_path + "openutils/returns/" + DownloadFile.get_file_name(urls[i]));
                            fw.write(data[i]);
                            fw.close();
                        } catch (IOException e) {
                            System.out.println("Could not write file: " + "`" + gcc_include_path + "openutils/returns/" + DownloadFile.get_file_name(urls[i]) + "`\nInstallation Failed `returns`.");
                            return;
                        }
                        System.out.println("File Written: " + "`" + gcc_include_path + "openutils/returns/" + DownloadFile.get_file_name(urls[i]) + "`" + "");
                    } catch (IOException e) {
                        System.out.println("Could not write file: " + "`" + gcc_include_path + "openutils/returns/" + DownloadFile.get_file_name(urls[i]) + "`\nInstallation Failed `returns`.");
                        return;
                    }
                }
                System.out.println("Installation Completed `returns`.");
            } else if (option == -1) {
                scanner.close();
                System.exit(0);
            } else {
                System.err.println("Invalid choice `" + option + "`.");
            }
        }
    }
}
