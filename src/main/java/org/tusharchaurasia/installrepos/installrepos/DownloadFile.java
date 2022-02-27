/*
MIT License

Copyright (c) 2021 Tushar Chaurasia

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

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadFile {
    public static String get_file_name(String url) {
        StringBuilder x = new StringBuilder();
        int ind = url.lastIndexOf('/') + 1;
        for (int i = ind; i < url.length(); i++)
            x.append(url.charAt(i));
        return x.toString();
    }

    public static String Download(String location) {
        URL url = null;
        try {
            url = new URL(location);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        StringBuilder x = new StringBuilder();
        try {
            byte[] data = url.openStream().readAllBytes();
            for (byte datum : data)
                x.append((char) datum);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return x.toString();
    }
}
