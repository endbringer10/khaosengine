package com.khaos.core.threads;

import com.khaos.core.Localized;
import com.khaos.core.connection.Connection;
import com.khaos.core.data.commands.GameInitCommand;
import com.khaos.core.gui.frame.Progress;

/**
 *
 * @author endbr
 */
public class UpdateThread extends Thread {

    private final Progress progress;
    private final Connection connection;

    public UpdateThread(Connection connection) {
        progress = new Progress(Localized.UPDATING.getLocalized());
        progress.init();
        this.connection = connection;
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
        connection.addCommand(new GameInitCommand());
        //new UpToDatePacket().process(hook);
    }

}//End Class
