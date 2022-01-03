package org.tusharchaurasia.installrepos.installrepos;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class install_repos_controller {
    @FXML
    private GridPane gui_grid_pane;
    @FXML
    private TextArea gui_txt_info;
    @FXML
    private Button gui_sstring_btn;
    @FXML
    private Button gui_vector_btn;
    @FXML
    private Button gui_map_btn;
    @FXML
    private Button gui_returns_btn;

    @FXML
    protected void initialize() {
        gui_txt_info.setText(gui_txt_info.getText() + "\nGCC Include Path: => `" + install_repos.gcc_include_path + "`\nALWAYS RUN THIS APPLICATION UNDER " + ((OS_TYPE.get_os() == OS_TYPE.OS.WINDOWS) ? "ADMINISTRATOR PRIVILEGES." : "SUPERUSER PRIVILEGES.") + "\n\n");
    }

    @FXML
    protected void click_event_gui_sstring_btn() {
        Platform.runLater(() ->
        {
            if (new File(install_repos.gcc_include_path + "openutils/sstring/").exists()) {
                gui_txt_info.setText(gui_txt_info.getText() + "Directory Exists: " + "`" + install_repos.gcc_include_path + "openutils/sstring`\n");
            } else if (!new File(install_repos.gcc_include_path + "openutils/sstring/").mkdirs()) {
                gui_txt_info.setText(gui_txt_info.getText() + "Could not create directory: `" + install_repos.gcc_include_path + "openutils/sstring`\nInstallation Failed `sstring`.\n");
                return;
            } else {
                gui_txt_info.setText(gui_txt_info.getText() + "Directory Created: `" + install_repos.gcc_include_path + "openutils/sstring`\n");
            }
            String[] data = new String[5];
            String[] urls = {"https://raw.githubusercontent.com/Dark-CodeX/sstring/master/sstring/sstring.h",
                    "https://raw.githubusercontent.com/Dark-CodeX/SafeString/main/sstring/prototype_err.h",
                    "https://raw.githubusercontent.com/Dark-CodeX/SafeString/main/sstring/binary.h",
                    "https://raw.githubusercontent.com/Dark-CodeX/SafeString/main/sstring/morse_code.h",
                    "https://raw.githubusercontent.com/Dark-CodeX/SafeString/main/sstring/sstring.hh"};
            for (int i = 0; i < urls.length; i++) {
                data[i] = DownloadFile.Download(urls[i]);
                gui_txt_info.setText(gui_txt_info.getText() + "Downloaded File: " + "`" + urls[i] + "`" + "\n");
                try {
                    new File(install_repos.gcc_include_path + "openutils/sstring/" + DownloadFile.get_file_name(urls[i])).createNewFile();
                    try {
                        FileWriter fw = new FileWriter(install_repos.gcc_include_path + "openutils/sstring/" + DownloadFile.get_file_name(urls[i]));
                        fw.write(data[i]);
                        fw.close();
                    } catch (IOException e) {
                        gui_txt_info.setText(gui_txt_info.getText() + "Could not write file: " + "`" + install_repos.gcc_include_path + "openutils/sstring/" + DownloadFile.get_file_name(urls[i]) + "`\nInstallation Failed `sstring`.\n");
                        return;
                    }
                    gui_txt_info.setText(gui_txt_info.getText() + "File Written: " + "`" + install_repos.gcc_include_path + "openutils/sstring/" + DownloadFile.get_file_name(urls[i]) + "`" + "\n");
                } catch (IOException e) {
                    gui_txt_info.setText(gui_txt_info.getText() + "Could not write file: " + "`" + install_repos.gcc_include_path + "openutils/sstring/" + DownloadFile.get_file_name(urls[i]) + "`\nInstallation Failed `sstring`.\n");
                    return;
                }
            }
            gui_txt_info.setText(gui_txt_info.getText() + "Installation Completed `sstring`.\n");
        });
    }

    @FXML
    protected void click_event_gui_vector_btn() {
        Platform.runLater(() ->
        {
            if (new File(install_repos.gcc_include_path + "openutils/vector/").exists()) {
                gui_txt_info.setText(gui_txt_info.getText() + "Directory Exists: " + "`" + install_repos.gcc_include_path + "openutils/vector`\n");
            } else if (!new File(install_repos.gcc_include_path + "openutils/vector/").mkdirs()) {
                gui_txt_info.setText(gui_txt_info.getText() + "Could not create directory: `" + install_repos.gcc_include_path + "openutils/vector`\nInstallation Failed `vector`.\n");
                return;
            } else {
                gui_txt_info.setText(gui_txt_info.getText() + "Directory Created: `" + install_repos.gcc_include_path + "openutils/vector`\n");
            }
            String[] data = new String[2];
            String[] urls = {"https://raw.githubusercontent.com/Dark-CodeX/vector/main/vector/vector.h",
                    "https://raw.githubusercontent.com/Dark-CodeX/vector/main/vector/vector.hh"};
            for (int i = 0; i < urls.length; i++) {
                data[i] = DownloadFile.Download(urls[i]);
                gui_txt_info.setText(gui_txt_info.getText() + "Downloaded File: " + "`" + urls[i] + "`" + "\n");
                try {
                    new File(install_repos.gcc_include_path + "openutils/vector/" + DownloadFile.get_file_name(urls[i])).createNewFile();
                    try {
                        FileWriter fw = new FileWriter(install_repos.gcc_include_path + "openutils/vector/" + DownloadFile.get_file_name(urls[i]));
                        fw.write(data[i]);
                        fw.close();
                    } catch (IOException e) {
                        gui_txt_info.setText(gui_txt_info.getText() + "Could not write file: " + "`" + install_repos.gcc_include_path + "openutils/vector/" + DownloadFile.get_file_name(urls[i]) + "`\nInstallation Failed `vector`.\n");
                        return;
                    }
                    gui_txt_info.setText(gui_txt_info.getText() + "File Written: " + "`" + install_repos.gcc_include_path + "openutils/vector/" + DownloadFile.get_file_name(urls[i]) + "`" + "\n");
                } catch (IOException e) {
                    gui_txt_info.setText(gui_txt_info.getText() + "Could not write file: " + "`" + install_repos.gcc_include_path + "openutils/vector/" + DownloadFile.get_file_name(urls[i]) + "`\nInstallation Failed `vector`.\n");
                    return;
                }
            }
            gui_txt_info.setText(gui_txt_info.getText() + "Installation Completed `vector`.\n");
        });
    }

    @FXML
    protected void click_event_gui_map_btn() {
        Platform.runLater(() ->
        {
            if (new File(install_repos.gcc_include_path + "openutils/map/").exists()) {
                gui_txt_info.setText(gui_txt_info.getText() + "Directory Exists: " + "`" + install_repos.gcc_include_path + "openutils/map`\n");
            } else if (!new File(install_repos.gcc_include_path + "openutils/map/").mkdirs()) {
                gui_txt_info.setText(gui_txt_info.getText() + "Could not create directory: `" + install_repos.gcc_include_path + "openutils/map`\nInstallation Failed `map`.\n");
                return;
            } else {
                gui_txt_info.setText(gui_txt_info.getText() + "Directory Created: `" + install_repos.gcc_include_path + "openutils/map`\n");
            }
            String[] data = new String[1];
            String[] urls = {"https://raw.githubusercontent.com/Dark-CodeX/map/master/map/map.hh"};
            for (int i = 0; i < urls.length; i++) {
                data[i] = DownloadFile.Download(urls[i]);
                gui_txt_info.setText(gui_txt_info.getText() + "Downloaded File: " + "`" + urls[i] + "`" + "\n");
                try {
                    new File(install_repos.gcc_include_path + "openutils/map/" + DownloadFile.get_file_name(urls[i])).createNewFile();
                    try {
                        FileWriter fw = new FileWriter(install_repos.gcc_include_path + "openutils/map/" + DownloadFile.get_file_name(urls[i]));
                        fw.write(data[i]);
                        fw.close();
                    } catch (IOException e) {
                        gui_txt_info.setText(gui_txt_info.getText() + "Could not write file: " + "`" + install_repos.gcc_include_path + "openutils/map/" + DownloadFile.get_file_name(urls[i]) + "`\nInstallation Failed `map`.\n");
                        return;
                    }
                    gui_txt_info.setText(gui_txt_info.getText() + "File Written: " + "`" + install_repos.gcc_include_path + "openutils/map/" + DownloadFile.get_file_name(urls[i]) + "`" + "\n");
                } catch (IOException e) {
                    gui_txt_info.setText(gui_txt_info.getText() + "Could not write file: " + "`" + install_repos.gcc_include_path + "openutils/map/" + DownloadFile.get_file_name(urls[i]) + "`\nInstallation Failed `map`.\n");
                    return;
                }
            }
            gui_txt_info.setText(gui_txt_info.getText() + "Installation Completed `map`.\n");
        });
    }

    @FXML
    protected void click_event_gui_returns_btn() {
        Platform.runLater(() ->
        {
            if (new File(install_repos.gcc_include_path + "openutils/returns/").exists()) {
                gui_txt_info.setText(gui_txt_info.getText() + "Directory Exists: " + "`" + install_repos.gcc_include_path + "openutils/returns`\n");
            } else if (!new File(install_repos.gcc_include_path + "openutils/returns/").mkdirs()) {
                gui_txt_info.setText(gui_txt_info.getText() + "Could not create directory: `" + install_repos.gcc_include_path + "openutils/returns`\nInstallation Failed `returns`.\n");
                return;
            } else {
                gui_txt_info.setText(gui_txt_info.getText() + "Directory Created: `" + install_repos.gcc_include_path + "openutils/returns`\n");
            }
            String[] data = new String[2];
            String[] urls = {"https://raw.githubusercontent.com/Dark-CodeX/returns/master/returns/default.hh",
                    "https://raw.githubusercontent.com/Dark-CodeX/returns/master/returns/optional.hh"};
            for (int i = 0; i < urls.length; i++) {
                data[i] = DownloadFile.Download(urls[i]);
                gui_txt_info.setText(gui_txt_info.getText() + "Downloaded File: " + "`" + urls[i] + "`" + "\n");
                try {
                    new File(install_repos.gcc_include_path + "openutils/returns/" + DownloadFile.get_file_name(urls[i])).createNewFile();
                    try {
                        FileWriter fw = new FileWriter(install_repos.gcc_include_path + "openutils/returns/" + DownloadFile.get_file_name(urls[i]));
                        fw.write(data[i]);
                        fw.close();
                    } catch (IOException e) {
                        gui_txt_info.setText(gui_txt_info.getText() + "Could not write file: " + "`" + install_repos.gcc_include_path + "openutils/returns/" + DownloadFile.get_file_name(urls[i]) + "`\nInstallation Failed `returns`.\n");
                        return;
                    }
                    gui_txt_info.setText(gui_txt_info.getText() + "File Written: " + "`" + install_repos.gcc_include_path + "openutils/returns/" + DownloadFile.get_file_name(urls[i]) + "`" + "\n");
                } catch (IOException e) {
                    gui_txt_info.setText(gui_txt_info.getText() + "Could not write file: " + "`" + install_repos.gcc_include_path + "openutils/returns/" + DownloadFile.get_file_name(urls[i]) + "`\nInstallation Failed `returns`.\n");
                    return;
                }
            }
            gui_txt_info.setText(gui_txt_info.getText() + "Installation Completed `returns`.\n");
        });
    }
}