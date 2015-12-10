package com.khaos.game;

import com.khaos.system.SysLog;
import com.khaos.system.game.Errors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author endbr
 */
public class OfflineConnection extends Manager implements ManagerHook {

    private final LinkedBlockingQueue<Command> commands = new LinkedBlockingQueue<>();
    private final LinkedBlockingQueue<Packet> packets = new LinkedBlockingQueue<>();
    private volatile boolean running = true;
    private final ExecuteThread execute;
    private final ProcessThread process;
    private final Database database;

    public OfflineConnection(EngineHook engine) {
        database = new Database();
        this.execute = new ExecuteThread();
        this.process = new ProcessThread(engine);
    }

    @Override
    public void start() {
        this.execute.start();
        this.process.start();
    }

    @Override
    public void addCommand(Command command) {
        commands.add(command);
    }

    private class ExecuteThread extends Thread {

        @Override
        public void run() {
            while (running) {
                try {
                    Command command = commands.take();
                    packets.add(command.process(database));
                } catch (InterruptedException ex) {
                    SysLog.err(Errors.THREAD_RUNNING, ex);
                }

            }

            running = false;
        }

        @Override
        public void interrupt() {
            super.interrupt();
            running = false;
        }
    }//End Class

    private class ProcessThread extends Thread {

        private final EngineHook engine;

        public ProcessThread(EngineHook parent) {
            this.engine = parent;
        }

        @Override
        public void run() {
            while (running) {
                try {
                    Packet packet = packets.take();
                    packet.process(engine);
                } catch (InterruptedException ex) {
                    SysLog.err(Errors.THREAD_RUNNING, ex);
                }
            }

            running = false;
        }

        @Override
        public void interrupt() {
            super.interrupt();
            running = false;
        }

    }//End CLass

}//End Class
