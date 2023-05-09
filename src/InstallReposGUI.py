# file: InstallReposGUI.py
# author: Tushar Chaurasia (Dark-CodeX)
# license: This file is licensed under the GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007. You may obtain a copy of this license at https://www.gnu.org/licenses/gpl-3.0.en.html.

import tkinter as tk
from tkinter import ttk
from tkinter import simpledialog
import fs


def get_input_via_prompt():
    result = simpledialog.askstring("Input Path", "Enter installation path:")
    if result:
        return result
    else:
        print("err: no location was entered")
        exit(1)


installation_path = get_input_via_prompt()


def install_selected():
    selected_item = combobox.get()
    textbox.configure(state="normal")
    fs.fs.install_repo(selected_item, installation_path, textbox)
    textbox.configure(state="disabled")


def uninstall_selected():
    selected_item = combobox.get()
    textbox.configure(state="normal")
    fs.fs.uninstall_repo(selected_item, installation_path, textbox)
    textbox.configure(state="disabled")


window = tk.Tk()
window.title("InstallReposGUI")
window.maxsize(500, 200)
window.minsize(500, 200)

textbox = tk.Text(window, height=10, state="disabled")
textbox.pack()

bottom_frame = tk.Frame(window)
bottom_frame.pack()

combobox = ttk.Combobox(bottom_frame, values=[
                        "sstring", "vector", "map", "optional", "array", "date-time", "heap-pair", "chunkio", "mthread"], width=40, state='readonly')
combobox.set("sstring")
combobox.pack(side=tk.LEFT, padx=10)

install_button = tk.Button(
    bottom_frame, text="Install", command=install_selected)
install_button.pack(side=tk.LEFT, padx=5)

uninstall_button = tk.Button(
    bottom_frame, text="Uninstall", command=uninstall_selected)
uninstall_button.pack(side=tk.LEFT, padx=5)

window.mainloop()
