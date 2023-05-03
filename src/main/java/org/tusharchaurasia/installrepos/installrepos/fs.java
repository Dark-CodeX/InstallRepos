/**
 * @file fs.java
 * @license This file is licensed under the GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007. You may obtain a copy of this license at https://www.gnu.org/licenses/gpl-3.0.en.html.
 * @version 1.1.0
 * @author Tushar Chaurasia (Dark-CodeX)
 */

package org.tusharchaurasia.installrepos.installrepos;

import javafx.scene.control.TextArea;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class fs {

    public static String make_path(String path) {
        StringBuilder sb = new StringBuilder(path);
        if (OS_TYPE.get_os() == OS_TYPE.OS.WINDOWS) {
            if (sb.charAt(sb.length() - 1) != '\\' && sb.charAt(sb.length() - 1) != '/')
                sb.append("\\");
            else
                sb.setCharAt(sb.length() - 1, '\\');
        } else {
            if (sb.charAt(sb.length() - 1) != '\\' && sb.charAt(sb.length() - 1) != '/')
                sb.append("/");
            else
                sb.setCharAt(sb.length() - 1, '/');
        }
        return sb.toString();
    }

    private static boolean delete_directory(String directory) {
        File file = new File(directory);
        for (File sub_file : Objects.requireNonNull(file.listFiles())) {
            if (sub_file.isDirectory()) {
                delete_directory(sub_file.getPath());
            }
            if (!sub_file.delete())
                return false;
        }
        return file.delete();
    }

    public static void install(String package_name, String location, String[] urls, TextArea txt) {
        if (txt != null) {
            if (new File(location + "openutils/" + package_name + "/").exists()) {
                txt.setText(
                        txt.getText() + "Directory exists: " + "`" + location + "openutils/" + package_name + "`.\n");
            } else if (!new File(location + "openutils/" + package_name + "/").mkdirs()) {
                txt.setText(txt.getText() + "Could not create directory: `" + location + "openutils/" + package_name
                        + "`.\nInstallation failed `" + package_name + "`.\n");
                return;
            } else {
                txt.setText(txt.getText() + "Directory created: `" + location + "openutils/" + package_name + "`.\n");
            }
            String[] data = new String[urls.length];
            for (int i = 0; i < urls.length; i++) {
                data[i] = DownloadFile.Download(urls[i]);
                txt.setText(txt.getText() + "File downloaded: " + "`" + urls[i] + "`" + ".\n");
                try {
                    if (!new File(location + "openutils/" + package_name + "/" + DownloadFile.get_file_name(urls[i]))
                            .createNewFile()) {
                        txt.setText(txt.getText() + "Could not create file: `" + location + "openutils/" + package_name
                                + "/" + DownloadFile.get_file_name(urls[i]) + "`.\nInstallation failed `" + package_name
                                + "`.\n");
                        return;
                    }
                    try {
                        FileWriter fw = new FileWriter(
                                location + "openutils/" + package_name + "/" + DownloadFile.get_file_name(urls[i]));
                        fw.write(data[i]);
                        fw.close();
                    } catch (IOException e) {
                        txt.setText(txt.getText() + "Could not write file: " + "`" + location + "openutils/"
                                + package_name + "/" + DownloadFile.get_file_name(urls[i]) + "`.\nInstallation failed `"
                                + package_name + "`.\n");
                        return;
                    }
                    txt.setText(txt.getText() + "File written: " + "`" + location + "openutils/" + package_name + "/"
                            + DownloadFile.get_file_name(urls[i]) + "`" + ".\n");
                } catch (IOException e) {
                    txt.setText(txt.getText() + "Could not write file: " + "`" + location + "openutils/" + package_name
                            + "/" + DownloadFile.get_file_name(urls[i]) + "`.\nInstallation failed `" + package_name
                            + "`.\n");
                    return;
                }
            }
            txt.setText(txt.getText() + "Installation completed `" + package_name + "`.\n");
        } else {
            if (new File(location + "openutils/" + package_name + "/").exists()) {
                System.err.println("Directory exists: " + "`" + location + "openutils/" + package_name + "`.");
            } else if (!new File(location + "openutils/" + package_name + "/").mkdirs()) {
                System.err.println("Could not create directory: `" + location + "openutils/" + package_name
                        + "`.\nInstallation failed `" + package_name + "`.");
                return;
            } else {
                System.out.println("Directory created: `" + location + "openutils/" + package_name + "`.");
            }
            String[] data = new String[urls.length];
            for (int i = 0; i < urls.length; i++) {
                data[i] = DownloadFile.Download(urls[i]);
                System.out.println("File downloaded: " + "`" + urls[i] + "`.");
                try {
                    if (!new File(location + "openutils/" + package_name + "/" + DownloadFile.get_file_name(urls[i]))
                            .createNewFile()) {
                        System.err.println("Could not create file: `" + location + "openutils/" + package_name + "/"
                                + DownloadFile.get_file_name(urls[i]) + "`.\nInstallation failed `" + package_name
                                + "`.");
                        return;
                    }
                    try {
                        FileWriter fw = new FileWriter(
                                location + "openutils/" + package_name + "/" + DownloadFile.get_file_name(urls[i]));
                        fw.write(data[i]);
                        fw.close();
                    } catch (IOException e) {
                        System.err.println("Could not write file: " + "`" + location + "openutils/" + package_name + "/"
                                + DownloadFile.get_file_name(urls[i]) + "`.\nInstallation failed `" + package_name
                                + "`.");
                        return;
                    }
                    System.out.println("File written: " + "`" + location + "openutils/" + package_name + "/"
                            + DownloadFile.get_file_name(urls[i]) + "`.");
                } catch (IOException e) {
                    System.err.println("Could not write file: " + "`" + location + "openutils/" + package_name + "/"
                            + DownloadFile.get_file_name(urls[i]) + "`.\nInstallation failed `" + package_name + "`.");
                    return;
                }
            }
            System.out.println("Installation completed `" + package_name + "`.");
        }
    }

    public static void uninstall(String package_name, String location, TextArea txt) {
        if (txt != null) {
            if (!new File(location + "openutils/" + package_name + "/").exists()) {
                txt.setText(txt.getText() + "Directory does not exists: " + "`" + location + "openutils/" + package_name
                        + "`.\nUninstallation failed `" + package_name + "`.\n");
            } else if (!delete_directory(location + "openutils/" + package_name + "/")) {
                txt.setText(txt.getText() + "Could not delete directory: `" + location + "openutils/" + package_name
                        + "`.\nUninstallation failed `" + package_name + "`.\n");
            } else {
                txt.setText(txt.getText() + "Directory deleted: `" + location + "openutils/" + package_name
                        + "`.\nUninstallation completed `" + package_name + "`.\n");
            }
        } else {
            if (!new File(location + "openutils/" + package_name + "/").exists()) {
                System.err.println("Directory does not exists: " + "`" + location + "openutils/" + package_name
                        + "`.Uninstallation failed `" + package_name + "`.");
            } else if (!delete_directory(location + "openutils/" + package_name + "/")) {
                System.err.println("Could not delete directory: `" + location + "openutils/" + package_name
                        + "`.\nUninstallation failed `" + package_name + "`.");
            } else {
                System.out.println("Directory deleted: `" + location + "openutils/" + package_name
                        + "`.\nUninstallation completed `" + package_name + "`.");
            }
        }
    }
}
