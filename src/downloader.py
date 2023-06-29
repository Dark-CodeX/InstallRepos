# file: downloader.py
# author: Tushar Chaurasia (Dark-CodeX)
# license: This file is licensed under the GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007. You may obtain a copy of this license at https://www.gnu.org/licenses/gpl-3.0.en.html.

import urllib.request
import urllib.error
import tkinter as tk


class downloader:
    @staticmethod
    def download_file(url: str, location: str, txt_box):
        response = urllib.request.urlopen(url)
        if response.status == 200:
            try:
                with open(location, "wb") as file:
                    file.write(response.read())
                return True
            except Exception as e:
                print(f"err: could not save the file at {location}: {str(e)}")
                return False
        else:
            if txt_box == None:
                print(f"err: could not download file '{url}'")
                return False
            else:
                txt_box.insert(
                    tk.END, f"err: could not download the file '{url}'\n")
                return False
