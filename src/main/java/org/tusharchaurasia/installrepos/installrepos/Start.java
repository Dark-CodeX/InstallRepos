/**
 * @file Start.java
 * @license This file is licensed under the GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007. You may obtain a copy of this license at https://www.gnu.org/licenses/gpl-3.0.en.html.
 * @version 1.1.0
 * @author Tushar Chaurasia (Dark-CodeX)
 */

package org.tusharchaurasia.installrepos.installrepos;

import java.io.IOException;

public class Start {
    public static void main(String[] args) {
        try {
            install_repos.main(args);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
