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

public class ManagerTerminalBackend implements Runnable{
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
			
			Stage dialog = new Stage();
			VBox dialogVbox = new VBox(20);
			Button btn=new Button();

			dialogVbox.getChildren().add(new Label("Alert from terminal \"" + terminal.getName() + "\": " + elements[1]));
			dialogVbox.getChildren().add(btn);
			btn.setText("OK");
			btn.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					dialog.close();
				}
			});
			Scene dialogScene = new Scene(dialogVbox, 400, 200);
			dialog.setScene(dialogScene);
			dialog.show();
			//System.out.println("Alert from terminal \"" + terminal.getName() + "\": " + elements[1]);
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
