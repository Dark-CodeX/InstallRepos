/**
 * @file module-info.java
 * @license This file is licensed under the GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007. You may obtain a copy of this license at https://www.gnu.org/licenses/gpl-3.0.en.html.
 * @version 1.1.0
 * @author Tushar Chaurasia (Dark-CodeX)
 */

module org.tusharchaurasia.installrepos.installrepos {
    requires transitive javafx.controls;
    requires transitive javafx.fxml;

    opens org.tusharchaurasia.installrepos.installrepos to javafx.fxml;

    exports org.tusharchaurasia.installrepos.installrepos;
}