# file: InstallReposGUI.py
# author: Tushar Chaurasia (Dark-CodeX)
# license: This file is licensed under the GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007. You may obtain a copy of this license at https://www.gnu.org/licenses/gpl-3.0.en.html.

import tkinter as tk
from tkinter import ttk


def install_selected():
    selected_item = combobox.get()
    textbox.configure(state="normal")
    textbox.insert(tk.END, f"Installing: {selected_item}\n")
    textbox.configure(state="disabled")


def uninstall_selected():
    selected_item = combobox.get()
    textbox.configure(state="normal")
    textbox.insert(tk.END, f"Uninstalling: {selected_item}\n")
    textbox.configure(state="disabled")


# Create the main window
window = tk.Tk()
window.title("InstallReposGUI")

# Create the textbox
textbox = tk.Text(window, height=10, state="disabled")
textbox.pack()

# Create the bottom section
bottom_frame = tk.Frame(window)
bottom_frame.pack()

# Create the combobox
items = ["sstring", "vector", "map", "optional", "array",
         "date-time", "heap-pair", "chunkio", "mthread"]
combobox = ttk.Combobox(bottom_frame, values=items, width=40)
combobox.set(items[0])
combobox.pack(side=tk.LEFT, padx=10)

# Create the install button
install_button = tk.Button(
    bottom_frame, text="Install", command=install_selected)
install_button.pack(side=tk.LEFT, padx=5)

# Create the uninstall button
uninstall_button = tk.Button(
    bottom_frame, text="Uninstall", command=uninstall_selected)
uninstall_button.pack(side=tk.LEFT, padx=5)

# Start the main event loop
window.mainloop()
