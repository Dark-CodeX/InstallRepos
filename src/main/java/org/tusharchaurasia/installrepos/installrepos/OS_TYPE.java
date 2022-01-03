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

    public static int get_arch() {
        return switch (System.getProperty("os.arch").toLowerCase()) {
            case "64", "amd64" -> 64;
            case "32", "amd32" -> 32;
            default -> -1;
        };
    }
}
