/**
 * @file install_repos_controller.java
 * @license This file is licensed under the GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007. You may obtain a copy of this license at https://www.gnu.org/licenses/gpl-3.0.en.html.
 * @version 1.1.0
 * @author Tushar Chaurasia (Dark-CodeX)
 */

package org.tusharchaurasia.installrepos.installrepos;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class install_repos_controller {
    @FXML
    private TextArea gui_txt_info;
    @FXML
    private ComboBox<String> gui_list;

    @FXML
    protected void initialize() {
        gui_txt_info.setText(gui_txt_info.getText() + "\nGCC Include Path: => `" + install_repos.gcc_include_path
                + "`\nALWAYS RUN THIS APPLICATION UNDER "
                + ((OS_TYPE.get_os() == OS_TYPE.OS.WINDOWS) ? "ADMINISTRATOR PRIVILEGES." : "SUPERUSER PRIVILEGES.")
                + "\n\n");
        gui_list.setItems(FXCollections.observableArrayList(Links.repos));
        gui_list.setValue("sstring");
    }

    @FXML
    protected void click_event_gui_install() {
        Object value = gui_list.getValue();
        if ("sstring".equals(value)) {
            fs.install(value.toString(), install_repos.gcc_include_path, Links.sstring_urls, gui_txt_info);
        } else if ("vector".equals(value)) {
            fs.install(value.toString(), install_repos.gcc_include_path, Links.vector_urls, gui_txt_info);
        } else if ("map".equals(value)) {
            fs.install(value.toString(), install_repos.gcc_include_path, Links.map_urls, gui_txt_info);
        } else if ("optional".equals(value)) {
            fs.install(value.toString(), install_repos.gcc_include_path, Links.optional_urls, gui_txt_info);
        } else if ("array".equals(value)) {
            fs.install(value.toString(), install_repos.gcc_include_path, Links.array_urls, gui_txt_info);
        } else if ("date-time".equals(value)) {
            fs.install(value.toString(), install_repos.gcc_include_path, Links.date_time_urls, gui_txt_info);
        } else if ("heap-pair".equals(value)) {
            fs.install(value.toString(), install_repos.gcc_include_path, Links.heap_pair_urls, gui_txt_info);
        } else if ("chunkio".equals(value)) {
            fs.install(value.toString(), install_repos.gcc_include_path, Links.chunkio_urls, gui_txt_info);
        } else if ("mthread".equals(value)) {
            fs.install(value.toString(), install_repos.gcc_include_path, Links.mthread_urls, gui_txt_info);
        }
    }

    @FXML
    protected void click_event_gui_uninstall() {
        fs.uninstall(gui_list.getValue(), install_repos.gcc_include_path, gui_txt_info);
    }
}