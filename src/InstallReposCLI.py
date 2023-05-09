# file: InstallReposCLI.py
# author: Tushar Chaurasia (Dark-CodeX)
# license: This file is licensed under the GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007. You may obtain a copy of this license at https://www.gnu.org/licenses/gpl-3.0.en.html.

import fs

if __name__ == "__main__":
    installation_path = str(input("Enter installation path: "))
    print(f"Installation Path = '{installation_path}'")

    while True:
        print("Which GitHub repository you want to uninstall:\n\t" +
              "-1. sstring [`https://www.github.com/Dark-CodeX/sstring.git`]\n\t" +
              "-2. vector [`https://www.github.com/Dark-CodeX/vector.git`]\n\t" +
              "-3. map [`https://www.github.com/Dark-CodeX/map.git`]\n\t" +
              "-4. optional [`https://www.github.com/Dark-CodeX/optional.git`]\n\t" +
              "-5. array [`https://www.github.com/Dark-CodeX/array.git`]\n\t" +
              "-6. date-time [`https://www.github.com/Dark-CodeX/date-time.git`]\n\t" +
              "-7. heap-pair [`https://www.github.com/Dark-CodeX/heap-pair.git`]\n\t" +
              "-8. chunkio [`https://www.github.com/Dark-CodeX/chunkio.git`]\n\t" +
              "-9. mthread [`https://www.github.com/Dark-CodeX/mthread.git`]\n\t" +
              " 0. Exits the application.")

        print("Which GitHub repository you want to install:\n\t" +
              " 1. sstring [`https://www.github.com/Dark-CodeX/sstring.git`]\n\t" +
              " 2. vector [`https://www.github.com/Dark-CodeX/vector.git`]\n\t" +
              " 3. map [`https://www.github.com/Dark-CodeX/map.git`]\n\t" +
              " 4. optional [`https://www.github.com/Dark-CodeX/optional.git`]\n\t" +
              " 5. array [`https://www.github.com/Dark-CodeX/array.git`]\n\t" +
              " 6. date-time [`https://www.github.com/Dark-CodeX/date-time.git`]\n\t" +
              " 7. heap-pair [`https://www.github.com/Dark-CodeX/heap-pair.git`]\n\t" +
              " 8. chunkio [`https://www.github.com/Dark-CodeX/chunkio.git`]\n\t" +
              " 9. mthread [`https://www.github.com/Dark-CodeX/mthread.git`]\n\n" +
              "<option number>: ")
        opt = int(input(""))

        if opt == 0:
            break
        # uninstallation
        elif opt == -1:
            fs.fs.uninstall_repo("sstring", installation_path)
        elif opt == -2:
            fs.fs.uninstall_repo("vector", installation_path)
        elif opt == -3:
            fs.fs.uninstall_repo("map", installation_path)
        elif opt == -4:
            fs.fs.uninstall_repo("optional", installation_path)
        elif opt == -5:
            fs.fs.uninstall_repo("array", installation_path)
        elif opt == -6:
            fs.fs.uninstall_repo("date-time", installation_path)
        elif opt == -7:
            fs.fs.uninstall_repo("heap-pair", installation_path)
        elif opt == -8:
            fs.fs.uninstall_repo("chunkio", installation_path)
        elif opt == -9:
            fs.fs.uninstall_repo("mthread", installation_path)
        # installation
        elif opt == 1:
            fs.fs.install_repo("sstring", installation_path)
        elif opt == 2:
            fs.fs.install_repo("vector", installation_path)
        elif opt == 3:
            fs.fs.install_repo("map", installation_path)
        elif opt == 4:
            fs.fs.install_repo("optional", installation_path)
        elif opt == 5:
            fs.fs.install_repo("array", installation_path)
        elif opt == 6:
            fs.fs.install_repo("date-time", installation_path)
        elif opt == 7:
            fs.fs.install_repo("heap-pair", installation_path)
        elif opt == 8:
            fs.fs.install_repo("chunkio", installation_path)
        elif opt == 9:
            fs.fs.install_repo("mthread", installation_path)
