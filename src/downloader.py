# file: downloader.py
# author: Tushar Chaurasia (Dark-CodeX)
# license: This file is licensed under the GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007. You may obtain a copy of this license at https://www.gnu.org/licenses/gpl-3.0.en.html.

import requests


class downloader:
    @staticmethod
    def download_file(url: str, location: str):
        response = requests.get(url)
        if response.status_code == 200:
            with open(location, 'wb') as file:
                file.write(response.content)
            return True
        else:
            print(f"err: could not download file '{url}'")
            return False
