package unused;

import com.khaos.core.system.ConsoleTextArea;

/**
 *
 * @author endbringer10
 * @since 20151025
 */
public class LogUpdater {

    private ConsoleTextArea console = new ConsoleTextArea();

    public LogUpdater() {

    }

    public void append(String text) {
        console.append(text);
    }

}//End Class
