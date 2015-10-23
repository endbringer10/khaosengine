package newclass;

import com.khaos.core.data.GameData;
import javax.swing.JInternalFrame;

/**
 *
 * @author endbr
 */
public interface EngineGUI {

    public void init();

    public void start();

    public void openInternalFrame(JInternalFrame frame);

    public GameData getGuiData();

}
