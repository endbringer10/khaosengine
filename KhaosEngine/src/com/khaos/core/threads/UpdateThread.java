package com.khaos.core.threads;

import com.khaos.core.EngineHook;
import com.khaos.core.Localized;
import com.khaos.core.data.commands.GameInitCommand;
import com.khaos.core.gui.frame.Progress;

/**
 *
 * @author endbr
 */
public class UpdateThread extends Thread {

    private final Progress progress;
    private final EngineHook engine;

    public UpdateThread(EngineHook engine) {
        progress = new Progress(Localized.UPDATING.getLocalized());
        progress.init();
        this.engine = engine;
    }

    @Override
    public void run() {

        /*try {
         FileUtils.copyURLToFile(new URL("http://sourceforge.net/projects/filehosting/files/0_0_15.7z"), new File(FileSystem.FOLDER_DOWNLOADS.getPath() + "0_0_15.7z"));
         } catch (IOException ex) {
         Logger.getLogger(UpdateThread.class.getName()).log(Level.SEVERE, null, ex);
         }*/
        progress.dispose();
        //hook.process(new UpToDatePacket());
        engine.getConnection().addCommand(new GameInitCommand());
        //new UpToDatePacket().process(hook);
    }

}//End Class
