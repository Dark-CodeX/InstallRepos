# file: downloader.py
# author: Tushar Chaurasia (Dark-CodeX)
# license: This file is licensed under the GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007. You may obtain a copy of this license at https://www.gnu.org/licenses/gpl-3.0.en.html.

import requests
import tkinter as tk

class downloader:
    @staticmethod
    def download_file(url: str, location: str, txt_box):
        response = requests.get(url)
        if response.status_code == 200:
            with open(location, 'wb') as file:
                file.write(response.content)
            return True
        else:
            if txt_box == None:
                print(f"err: could not download file '{url}'")
                return False
            else:
                txt_box.insert(tk.END, f"err: could not download the file '{url}'\n")
                return False
