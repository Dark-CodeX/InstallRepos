/**
 * @file install_repos.java
 * @license This file is licensed under the GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007. You may obtain a copy of this license at https://www.gnu.org/licenses/gpl-3.0.en.html.
 * @version 1.1.0
 * @author Tushar Chaurasia (Dark-CodeX)
 */

package org.tusharchaurasia.installrepos.installrepos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class install_repos extends Application {
    public static String gcc_include_path = "";

    @Override
    public void start(Stage stage) throws IOException {
        try {
            TextInputDialog td = new TextInputDialog();
            td.setHeaderText("Enter GCC include path or any path to install repos:");
            td.setContentText("Path:");
            td.setResizable(false);
            Optional<String> result = td.showAndWait();
            result.ifPresent(name -> gcc_include_path = name);
            gcc_include_path = fs.make_path(gcc_include_path);
            td.close();
            if (gcc_include_path.length() == 0) {
                System.err.println("err: could not get any path.");
                System.exit(1);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        FXMLLoader fxmlLoader = new FXMLLoader(install_repos.class.getResource("gui_install_repos.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 320);
        stage.setTitle("Install Repos");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) throws IOException {
        launch(args);
    }
}