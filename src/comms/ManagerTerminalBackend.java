package comms;

import java.util.LinkedList;

import mainMenu.swapManagament.Swap;

public class ManagerTerminalBackend implements Runnable{
	private static ManagerTerminalBackend instance = null;
	
	public static ManagerTerminalBackend getInstance() {
		if (instance == null) {
			instance = new ManagerTerminalBackend();
		}
		return instance;
	}
	
	private LinkedList<ClientTerminal> terminals;
	private TerminalServer server;
	
	public boolean running;
	
	public ManagerTerminalBackend() {
		server = new TerminalServer(5555);
		terminals = new LinkedList<ClientTerminal>();
	}
	
	public void run() {
		server.start();
		running = true;
		while (running) {
			LinkedList<ClientTerminal> aliveClients = new LinkedList<ClientTerminal>();
			acceptNewClients();
			for (ClientTerminal terminal : terminals) {
				processClient(terminal);
				if (terminal.isRunning())
					aliveClients.add(terminal);
			}
			terminals = aliveClients;
			
		}
	}
	
	private void acceptNewClients() {
		ClientTerminal newClient = server.getClient();
		while (newClient != null) {
			terminals.add(newClient);
			newClient = server.getClient();
		}
	}
	
	private void processClient(ClientTerminal terminal) {
		LinkedList<String> remainingMessages = terminal.processMessages();
		for (String message : remainingMessages) {
			processMessage(message, terminal);
		}
	}
	
	private void processMessage(String message, ClientTerminal terminal) {
		String[] elements = message.split("");
		if (elements[0] == "alert") {
			System.out.println("Alert from terminal \"" + terminal.getName() + "\": " + elements[1]);
		}
	}
	
	public boolean sendSwap(String terminalName, Swap swap) {
		for (ClientTerminal terminal : terminals) {
			if (terminal.getName() == terminalName) {
				terminal.sendSwap(swap);
				return true;
			}
		}
		return false;
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
