package com.khaos.core.connection;

import com.khaos.core.data.comm.Command;
import com.khaos.core.data.comm.Packet;
import com.khaos.core.data.comm.commands.LoginCommand;
import com.khaos.core.data.comm.packets.CommandNotSupportedPacket;
import com.khaos.core.data.comm.packets.ValidLoginPacket;
import com.khaos.core.system.Errors;
import com.khaos.core.system.SysLog;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author endbr
 */
public class OfflineConnection implements Connection {

    private final LinkedBlockingQueue<Command> commands = new LinkedBlockingQueue<>();
    private final LinkedBlockingQueue<Packet> packets = new LinkedBlockingQueue<>();
    private volatile boolean running = true;
    private final ExecuteThread execute;
    private final ProcessThread process;

    public OfflineConnection(ConnectionHook parent) {
        this.execute = new ExecuteThread();
        this.process = new ProcessThread(parent);
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
                    packets.add(this.execute(command));
                } catch (InterruptedException ex) {
                    SysLog.err(Errors.THREAD_RUNNING, ex);
                }

            }

            running = false;
        }

        private Packet execute(Command command) {
            if (command instanceof LoginCommand) {
                return new ValidLoginPacket();
            }

            return new CommandNotSupportedPacket();
        }

        @Override
        public void interrupt() {
            super.interrupt();
            running = false;
        }
    }//End Class

    private class ProcessThread extends Thread {

        private final ConnectionHook parent;

        public ProcessThread(ConnectionHook parent) {
            this.parent = parent;
        }

        @Override
        public void run() {
            while (running) {
                try {
                    Packet packet = packets.take();
                    parent.process(packet);
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
