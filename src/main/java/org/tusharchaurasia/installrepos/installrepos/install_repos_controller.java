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
        } else if ("returns".equals(value)) {
            fs.install(value.toString(), install_repos.gcc_include_path, Links.returns_urls, gui_txt_info);
        } else if ("set".equals(value)) {
            fs.install(value.toString(), install_repos.gcc_include_path, Links.set_urls, gui_txt_info);
        } else if ("array".equals(value)) {
            fs.install(value.toString(), install_repos.gcc_include_path, Links.array_urls, gui_txt_info);
        } else if ("date-time".equals(value)) {
            fs.install(value.toString(), install_repos.gcc_include_path, Links.date_time_urls, gui_txt_info);
        }
    }

    @FXML
    protected void click_event_gui_uninstall() {
        fs.uninstall(gui_list.getValue(), install_repos.gcc_include_path, gui_txt_info);
    }
}