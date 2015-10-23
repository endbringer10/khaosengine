package com.khaos.core.connection;

import com.khaos.core.EngineHook;
import com.khaos.core.Settings;
import com.khaos.core.data.commands.Command;
import com.khaos.core.data.packets.Packet;
import com.khaos.core.exception.ServerConnectionException;
import com.khaos.core.system.Errors;
import com.khaos.core.system.Messages;
import com.khaos.core.system.SysLog;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author endbr
 */
public class OnlineConnection implements Connection {

    private final LinkedBlockingQueue<Command> commands = new LinkedBlockingQueue<>();
    private volatile boolean running = true;
    private final SendThread send;
    private final ReceiveThread receive;

    public OnlineConnection(EngineHook engine) throws ServerConnectionException {
        try {
            Socket socket = new Socket(Settings.HOST_IP.parseString(), Settings.HOST_PORT.parseInt());

            send = new SendThread(new ObjectOutputStream(socket.getOutputStream()));
            receive = new ReceiveThread(new ObjectInputStream(socket.getInputStream()), engine);
        } catch (IOException ex) {
            SysLog.err(Errors.SERVER_CONNECTION, ex);
            throw new ServerConnectionException(ex);
        }
        SysLog.log(Messages.CONNECTED_TO_SERVER);
    }

    @Override
    public void start() {
        send.start();
        receive.start();
    }

    @Override
    public void addCommand(Command command) {
        commands.add(command);
    }

    private class SendThread extends Thread {

        private final ObjectOutputStream out;

        public SendThread(ObjectOutputStream out) {
            this.out = out;
        }

        @Override
        public void run() {

            while (running) {
                try {
                    Command command = commands.take();
                    out.writeObject(command);
                    out.flush();
                } catch (IOException | InterruptedException ex) {
                    SysLog.err(Errors.THREAD_RUNNING, ex);
                }
            }

            this.close();
        }

        @Override
        public void interrupt() {
            super.interrupt();
            this.close();
        }

        private void close() {
            running = false;
            try {
                out.close();
            } catch (IOException ex) {
                SysLog.err(Errors.THREAD_STOP, ex);
            }
        }

    }//End Class

    private class ReceiveThread extends Thread {

        private final ObjectInputStream in;
        private final EngineHook engine;

        public ReceiveThread(ObjectInputStream in, EngineHook engine) {
            this.in = in;
            this.engine = engine;
        }

        @Override
        public void run() {
            while (running) {
                try {
                    Packet packet = (Packet) (in.readObject());
                    packet.process(engine);
                } catch (ClassNotFoundException | IOException ex) {
                    SysLog.err(Errors.THREAD_RUNNING, ex);
                }
            }

            this.close();
        }

        @Override
        public void interrupt() {
            super.interrupt();
            this.close();
        }

        private void close() {
            running = false;
            try {
                in.close();
            } catch (IOException ex) {
                SysLog.err(Errors.THREAD_STOP, ex);
            }
        }

    }//End CLass

}
