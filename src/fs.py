# file: fs.py
# author: Tushar Chaurasia (Dark-CodeX)
# license: This file is licensed under the GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007. You may obtain a copy of this license at https://www.gnu.org/licenses/gpl-3.0.en.html.

import shutil
import downloader
import links
import os


class fs:
    @staticmethod
    def delete_folder(loc: str):
        try:
            shutil.rmtree(loc)
            return True
        except OSError as e:
            print(f"err: {e.filename}: {e.strerror}")
            return False

    def create_directory(path: str):
        try:
            os.makedirs(path)
            return True
        except OSError as e:
            print(f"Error: {e.filename} - {e.strerror}")
            return False

    @staticmethod
    def get_file_name(url: str):
        if '/' in url:
            return url[url.rindex('/'):len(url)]
        else:
            return None

    @staticmethod
    def install_repo(package_name: str, location: str):
        new_loc = location + "/openutils/" + package_name
        if fs.create_directory(new_loc) == False:
            exit(1)
        else:
            urls = links.repos_links.get_urls(package_name)
            if (urls == None):
                print(f"err: invalid package name '{package_name}'")
                exit(1)
            else:
                for i in urls:
                    print(f"Downloading '{i}'")
                    if downloader.downloader.download_file(i, new_loc + fs.get_file_name(i)) == False:
                        exit(1)
                    else:
                        print(f"File '{i}' downloaded successfully")
                print(f"'{package_name}' installed successfully")

    @staticmethod
    def uninstall_repo(package_name: str, location: str):
        if fs.delete_folder(location + "/openutils/" + package_name) == False:
            exit(1)
        else:
            print(f"'{package_name}' uninstalled successfully")
