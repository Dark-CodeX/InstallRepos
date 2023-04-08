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
