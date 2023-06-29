# file: links.py
# author: Tushar Chaurasia (Dark-CodeX)
# license: This file is licensed under the GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007. You may obtain a copy of this license at https://www.gnu.org/licenses/gpl-3.0.en.html.

class repos_links:
    sstring_urls = [
        "https://raw.githubusercontent.com/Dark-CodeX/openutils/main/sstring/sstring_boolean.hh",
        "https://raw.githubusercontent.com/Dark-CodeX/openutils/main/sstring/sstring_class.hh",
        "https://raw.githubusercontent.com/Dark-CodeX/openutils/main/sstring/sstring_conversion.hh",
        "https://raw.githubusercontent.com/Dark-CodeX/openutils/main/sstring/sstring_crypto.hh",
        "https://raw.githubusercontent.com/Dark-CodeX/openutils/main/sstring/sstring_cstring.hh",
        "https://raw.githubusercontent.com/Dark-CodeX/openutils/main/sstring/sstring_ctor.hh",
        "https://raw.githubusercontent.com/Dark-CodeX/openutils/main/sstring/sstring_find.hh",
        "https://raw.githubusercontent.com/Dark-CodeX/openutils/main/sstring/sstring_formatting.hh",
        "https://raw.githubusercontent.com/Dark-CodeX/openutils/main/sstring/sstring.hh",
        "https://raw.githubusercontent.com/Dark-CodeX/openutils/main/sstring/sstring_io.hh",
        "https://raw.githubusercontent.com/Dark-CodeX/openutils/main/sstring/sstring_iterators.hh",
        "https://raw.githubusercontent.com/Dark-CodeX/openutils/main/sstring/sstring_lexer_split.hh",
        "https://raw.githubusercontent.com/Dark-CodeX/openutils/main/sstring/sstring_manipulation.hh",
        "https://raw.githubusercontent.com/Dark-CodeX/openutils/main/sstring/sstring_memory.hh",
        "https://raw.githubusercontent.com/Dark-CodeX/openutils/main/sstring/sstring_metrics.hh",
        "https://raw.githubusercontent.com/Dark-CodeX/openutils/main/sstring/sstring_operators.hh",
        "https://raw.githubusercontent.com/Dark-CodeX/openutils/main/sstring/sstring_remove.hh",
        "https://raw.githubusercontent.com/Dark-CodeX/openutils/main/sstring/sstring_replace.hh",
        "https://raw.githubusercontent.com/Dark-CodeX/openutils/main/sstring/sstring_set_get_append.hh",
        "https://raw.githubusercontent.com/Dark-CodeX/openutils/main/sstring/sstring_static.hh"]

    vector_urls = [
        "https://raw.githubusercontent.com/Dark-CodeX/openutils/main/vector/vector.hh"]

    map_urls = [
        "https://raw.githubusercontent.com/Dark-CodeX/openutils/master/map/map.hh"]

    optional_urls = [
        "https://raw.githubusercontent.com/Dark-CodeX/openutils/master/optional/optional.hh"]

    array_urls = [
        "https://raw.githubusercontent.com/Dark-CodeX/openutils/master/array/array.hh"]

    date_time_urls = [
        "https://raw.githubusercontent.com/Dark-CodeX/openutils/main/date-time/date.hh",
        "https://raw.githubusercontent.com/Dark-CodeX/openutils/main/date-time/time.hh"]

    heap_pair_urls = [
        "https://raw.githubusercontent.com/Dark-CodeX/openutils/master/heap-pair/heap-pair.hh"]

    chunkio_urls = [
        "https://raw.githubusercontent.com/Dark-CodeX/openutils/main/chunkio/chunkio_bytes_reader.hh",
        "https://raw.githubusercontent.com/Dark-CodeX/openutils/main/chunkio/chunkio_lines_reader.hh",
        "https://raw.githubusercontent.com/Dark-CodeX/openutils/main/chunkio/chunkio_writer.hh"]

    mthread_urls = [
        "https://raw.githubusercontent.com/Dark-CodeX/openutils/main/mthread/mthread.hh"]

    @staticmethod
    def get_urls(url: str):
        if url == "sstring":
            return repos_links.sstring_urls
        elif url == "vector":
            return repos_links.vector_urls
        elif url == "map":
            return repos_links.map_urls
        elif url == "optional":
            return repos_links.optional_urls
        elif url == "array":
            return repos_links.array_urls
        elif url == "date-time":
            return repos_links.date_time_urls
        elif url == "heap-pair":
            return repos_links.heap_pair_urls
        elif url == "chunkio":
            return repos_links.chunkio_urls
        elif url == "mthread":
            return repos_links.mthread_urls
        else:
            return None
