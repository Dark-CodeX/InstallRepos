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
        }
    }

    @FXML
    protected void click_event_gui_uninstall() {
        fs.uninstall(gui_list.getValue(), install_repos.gcc_include_path, gui_txt_info);
    }
}