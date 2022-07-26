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

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

public class install_repos_controller {
    @FXML
    public Button gui_sstring_btn;
    @FXML
    public Button gui_vector_btn;
    @FXML
    public Button gui_map_btn;
    @FXML
    public Button gui_returns_btn;
    @FXML
    public Button gui_r_sstring_btn;
    @FXML
    public Button gui_r_vector_btn;
    @FXML
    public Button gui_r_map_btn;
    @FXML
    public Button gui_r_returns_btn;
    @FXML
    public GridPane gui_grid_pane;
    @FXML
    private TextArea gui_txt_info;

    @FXML
    protected void initialize() {
        gui_txt_info.setText(gui_txt_info.getText() + "\nGCC Include Path: => `" + install_repos.gcc_include_path
                + "`\nALWAYS RUN THIS APPLICATION UNDER "
                + ((OS_TYPE.get_os() == OS_TYPE.OS.WINDOWS) ? "ADMINISTRATOR PRIVILEGES." : "SUPERUSER PRIVILEGES.")
                + "\n\n");
    }

    @FXML
    protected void click_event_gui_sstring_btn() {
        fs.install("sstring", install_repos.gcc_include_path, Links.sstring_urls, gui_txt_info);
    }

    @FXML
    protected void click_event_gui_vector_btn() {
        fs.install("vector", install_repos.gcc_include_path, Links.vector_urls, gui_txt_info);
    }

    @FXML
    protected void click_event_gui_map_btn() {
        fs.install("map", install_repos.gcc_include_path, Links.map_urls, gui_txt_info);
    }

    @FXML
    protected void click_event_gui_returns_btn() {
        fs.install("returns", install_repos.gcc_include_path, Links.returns_urls, gui_txt_info);
    }

    @FXML
    protected void click_event_gui_sstring_r_btn() {
        fs.uninstall("sstring", install_repos.gcc_include_path, gui_txt_info);
    }

    @FXML
    protected void click_event_gui_vector_r_btn() {
        fs.uninstall("vector", install_repos.gcc_include_path, gui_txt_info);
    }

    @FXML
    protected void click_event_gui_map_r_btn() {
        fs.uninstall("map", install_repos.gcc_include_path, gui_txt_info);
    }

    @FXML
    protected void click_event_gui_returns_r_btn() {
        fs.uninstall("returns", install_repos.gcc_include_path, gui_txt_info);
    }
}