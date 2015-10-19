package com.khaos.core.connection;

import com.khaos.core.EngineHook;
import com.khaos.core.data.commands.Command;
import com.khaos.core.data.packets.Packet;
import com.khaos.core.data.commands.LoginCommand;
import com.khaos.core.data.packets.CommandNotSupportedPacket;
import com.khaos.core.data.packets.ValidLoginPacket;
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

    public OfflineConnection(EngineHook engine) {
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
                    //packets.add(this.execute(command));
                    packets.add(command.process());
                } catch (InterruptedException ex) {
                    SysLog.err(Errors.THREAD_RUNNING, ex);
                }

            }

            running = false;
        }

        /*private Packet execute(Command command) {
         if (command instanceof LoginCommand) {
         return new ValidLoginPacket();
         }

         return new CommandNotSupportedPacket();
         }*/
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
                    //parent.process(packet);
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
