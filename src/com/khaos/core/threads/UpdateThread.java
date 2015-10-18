/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khaos.core.threads;

import com.khaos.core.Localized;
import com.khaos.core.connection.ConnectionHook;
import com.khaos.core.data.packets.UpToDatePacket;
import com.khaos.core.gui.Progress;

/**
 *
 * @author endbr
 */
public class UpdateThread extends Thread {

    private final Progress progress;
    private final ConnectionHook hook;

    public UpdateThread(ConnectionHook hook) {
        progress = new Progress(Localized.UPDATING.getLocalized());
        progress.init();
        this.hook = hook;
    }

    @Override
    public void run() {

        /*try {
            FileUtils.copyURLToFile(new URL("http://sourceforge.net/projects/filehosting/files/0_0_15.7z"), new File(FileSystem.FOLDER_DOWNLOADS.getPath() + "0_0_15.7z"));
        } catch (IOException ex) {
            Logger.getLogger(UpdateThread.class.getName()).log(Level.SEVERE, null, ex);
        }*/

        progress.dispose();
        hook.process(new UpToDatePacket());
    }

}//End Class
