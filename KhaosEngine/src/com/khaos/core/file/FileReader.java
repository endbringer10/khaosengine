package com.khaos.core.file;

import com.khaos.core.data.Entry;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author endbringer10
 * @since 20151207
 * @idea need a second caret if entries have more then one value; have nextEntry() return a string with a caret
 * @note </settings> tag cases caret to not be at the end of the string
 */
public class FileReader {

    private static final String ENTRY_START = "<entry>";
    private static final String ENTRY_END = "</entry>";
    private static final String HEADER_START = "<meta>";
    private static final String HEADER_END = "</meta>";
    private static final String VALUE_START = "<value>";
    private static final String VALUE_END = "</value>";

    private final String raw;
    private int caret = 0;

    public FileReader(File source) throws IOException {
        raw = FileUtils.readFileToString(source);
    }

    public Entry next() {
        String next = this.nextEntry();

        if (next != null) {
            String header = this.nextHeader(next);
            String value = this.nextValue(next);

            if (header != null && value != null) {
                return new Entry(header, value);
            }
        }

        return null;
    }

    private String nextValue(String entry) {
        int start = entry.indexOf(VALUE_START) + VALUE_START.length();
        int end = entry.indexOf(VALUE_END);

        if (start != -1 && end != -1) {
            return entry.substring(start, end);
        }

        return null;
    }

    private String nextHeader(String entry) {
        int start = entry.indexOf(HEADER_START) + HEADER_START.length();
        int end = entry.indexOf(HEADER_END);

        if (start != -1 && end != -1) {
            return entry.substring(start, end);
        }

        return null;
    }

    private String nextEntry() {
        int start = raw.indexOf(ENTRY_START, caret);
        int end = raw.indexOf(ENTRY_END, caret) + ENTRY_END.length();
        int next = raw.indexOf(ENTRY_START, start + ENTRY_START.length());

        if (start != -1 && end != -1) {

            //An End tag is missing before the Start tag of the next entry, skip to the next entry
            if (next < end && next != -1) {
                start = next;
            }
            caret = end;
            return raw.substring(start, end);
        }

        caret = raw.length() - 1;
        return null;
    }

}//End Class
