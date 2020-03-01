package comms;

import java.util.LinkedList;

public class ManagerTerminalBackend implements Runnable{
	private LinkedList<ClientTerminal> terminals;
	private TerminalServer server;
	
	public boolean running;
	
	public ManagerTerminalBackend() {
		server = new TerminalServer(5555);
		server.start();
		terminals = new LinkedList<ClientTerminal>();
	}
	
	public void run() {
		running = true;
		while (running) {
			//do stuff
		}
	}
	
	public void stop() {
		if (!running) {
			return;
		}
		server.stop();
		for (ClientTerminal terminal : terminals) {
			//end connection
		}
	}
}
