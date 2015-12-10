package com.khaos.game;

import com.khaos.system.SysLog;
import com.khaos.system.game.Errors;
import com.khaos.system.game.Messages;
import com.khaos.SettingsGame;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author endbr
 */
public class OnlineConnection extends Manager implements ManagerHook {

    private final LinkedBlockingQueue<Command> commands = new LinkedBlockingQueue<>();
    private volatile boolean running = true;
    private final SendThread send;
    private final ReceiveThread receive;

    public OnlineConnection(EngineHook engine) throws ServerConnectionException {
        try {
            Socket socket = new Socket(SettingsGame.HOST_IP.parseString(), SettingsGame.HOST_PORT.parseInteger());

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
