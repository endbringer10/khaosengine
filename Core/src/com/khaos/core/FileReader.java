package com.khaos.core;

import com.khaos.system.core.Files;
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

    private final String raw;
    private int caret = 0;

    public FileReader(dFile source) throws IOException {
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
        int start = entry.indexOf(Files.VALUE_START) + Files.VALUE_START.length();
        int end = entry.indexOf(Files.VALUE_END);

        if (start != -1 && end != -1) {
            return entry.substring(start, end);
        }

        return null;
    }

    private String nextHeader(String entry) {
        int start = entry.indexOf(Files.HEADER_START) + Files.HEADER_START.length();
        int end = entry.indexOf(Files.HEADER_END);

        if (start != -1 && end != -1) {
            return entry.substring(start, end);
        }

        return null;
    }

    private String nextEntry() {
        int start = raw.indexOf(Files.ENTRY_START, caret);
        int end = raw.indexOf(Files.ENTRY_END, caret) + Files.ENTRY_END.length();
        int next = raw.indexOf(Files.ENTRY_START, start + Files.ENTRY_START.length());

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
