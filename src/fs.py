# file: fs.py
# author: Tushar Chaurasia (Dark-CodeX)
# license: This file is licensed under the GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007. You may obtain a copy of this license at https://www.gnu.org/licenses/gpl-3.0.en.html.

import shutil
import downloader
import links
import os
import tkinter as tk


class fs:
    @staticmethod
    def delete_folder(loc: str, txt_box):
        try:
            shutil.rmtree(loc)
            return True
        except OSError as e:
            if txt_box == None:
                print(f"err: '{e.filename}': {e.strerror}")
                return False
            else:
                txt_box.insert(tk.END, f"err: '{e.filename}': {e.strerror}\n")
                return False

    def create_directory(path: str, txt_box):
        try:
            os.makedirs(path)
            return True
        except OSError as e:
            if txt_box == None:
                print(f"err: '{e.filename}': {e.strerror}")
                return False
            else:
                txt_box.insert(tk.END, f"err: '{e.filename}': {e.strerror}\n")
                return False

    @staticmethod
    def get_file_name(url: str):
        if '/' in url:
            return url[url.rindex('/'):len(url)]
        else:
            return None

    @staticmethod
    def install_repo(package_name: str, location: str, txt_box):
        new_loc = location + "/openutils/" + package_name
        if fs.create_directory(new_loc, txt_box) == False:
            exit(1)
        else:
            urls = links.repos_links.get_urls(package_name)
            if (urls == None):
                print(f"err: invalid package name '{package_name}'")
                exit(1)
            else:
                for i in urls:
                    if txt_box == None:
                        print(f"Downloading '{i}'")
                    else:
                        txt_box.insert(tk.END, f"Downloading '{i}'\n")
                    if downloader.downloader.download_file(i, new_loc + fs.get_file_name(i), txt_box) == False:
                        exit(1)
                    else:
                        if txt_box == None:
                            print(f"File '{i}' downloaded successfully")
                        else:
                            txt_box.insert(tk.END, f"File '{i}' downloaded successfully\n")
                if txt_box == None:
                    print(f"'{package_name}' installed successfully")
                else:
                    txt_box.insert(tk.END, f"'{package_name}' installed successfully\n")


    @staticmethod
    def uninstall_repo(package_name: str, location: str, txt_box):
        if fs.delete_folder(location + "/openutils/" + package_name, txt_box) == False:
            exit(1)
        else:
            if txt_box == None:
                print(f"'{package_name}' uninstalled successfully")
            else:
                txt_box.insert(
                    tk.END, f"'{package_name}' uninstalled successfully\n")
