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

public class OS_TYPE {
    public enum OS {
        LINUX, WINDOWS, MAC_OS
    }

    public static OS get_os() {
        OS os = null;
        String operating_system = System.getProperty("os.name").toLowerCase();
        if (operating_system.contains("win")) {
            os = OS.WINDOWS;
        } else if (operating_system.contains("nix") || operating_system.contains("nux")
                || operating_system.contains("aix")) {
            os = OS.LINUX;
        } else if (operating_system.contains("mac")) {
            os = OS.MAC_OS;
        }
        return os;
    }
/* UNUSED CODE SNIPPET
    public static int get_arch() {
        return switch (System.getProperty("os.arch").toLowerCase()) {
            case "64", "amd64" -> 64;
            case "32", "amd32" -> 32;
            default -> -1;
        };
    }
 */
}
