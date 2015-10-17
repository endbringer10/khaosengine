package com.khaos.core.threads;

import com.khaos.core.Localized;
import com.khaos.core.gui.Progress;
import com.khaos.core.system.Errors;
import com.khaos.core.system.SysLog;
import javax.swing.JPanel;

/**
 *
 * @author endbr
 */
public class WaitThread extends Thread {

    private final Progress progress;
    private final int wait;

    public WaitThread() {
        progress = new Progress(Localized.LOADING.getLocalized());
        progress.init();

        this.wait = 500;
    }

    public WaitThread(int wait) {
        progress = new Progress(Localized.LOADING.getLocalized());
        progress.init();

        this.wait = wait;
    }

    public WaitThread(JPanel panel, String title) {
        progress = new Progress(panel, title);
        progress.init();

        this.wait = 500;
    }

    public WaitThread(JPanel panel, String title, int wait) {
        progress = new Progress(panel, title);
        progress.init();

        this.wait = wait;
    }

    @Override
    public synchronized void run() {
        try {
            this.wait(wait);
        } catch (InterruptedException ex) {
            SysLog.err(Errors.SPLASH_INTERRUPT, ex);
        }

        progress.dispose();
    }

    @Override
    public void interrupt() {
        super.interrupt();
        progress.dispose();
    }

}//End Class
