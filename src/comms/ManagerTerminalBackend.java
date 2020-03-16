package comms;

import java.util.LinkedList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mainMenu.swapManagament.Swap;

import javax.swing.*;

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
		server = new TerminalServer(30001);
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
		String[] elements = message.split(",");
		if (elements[0].compareTo("alert") == 0) {
			final JFrame parent = new JFrame();
			JPanel p = new JPanel();
			JButton button = new JButton();
			JLabel label=new JLabel();
			label.setText("Alert from terminal \"" + terminal.getName() + "\": " + elements[1]);

			button.setText("OK");
			p.add(label);
			p.add(button);

			parent.add(p);
			parent.setSize(300, 100);
			parent.setVisible(true);

			button.addActionListener(new java.awt.event.ActionListener() {
				@Override
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					parent.dispose();
				}
			});

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
	
	public void sendAlert(String message) {
		for (ClientTerminal terminal : terminals) {
			terminal.sendAlert(message);
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
