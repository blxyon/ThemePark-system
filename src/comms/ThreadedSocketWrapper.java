package comms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadedSocketWrapper implements Runnable{
	private Socket socket = null;
	private BufferedReader in = null;
	private BufferedWriter out = null;
	
	private BlockingQueue<String> messages;
	
	private boolean running = false;
	
	public ThreadedSocketWrapper(Socket socket) {
		this.socket = socket;
		messages = new LinkedBlockingQueue<String>();
		try {
			in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
		} catch (IOException e) {
			System.out.println("Could not create streams for the socket");
			System.out.println(e);
			stop();
		}
	}
	
	private void acceptMessage() {
		try {
			String message = in.readLine();
			if (message == null) {
				stop();
				return;
			}
			messages.add(message);
		} catch (IOException e){
			System.out.println("Error while accepting a message");
			System.out.println(e);
		}
	}
	
	public String readMessage() {
		if (messages.isEmpty()) {
			return null;
		}
		return messages.remove();
	}
	
	public void writeMessage(String message) throws IOException {
		out.write(message);
		out.newLine();
	}
	
	public boolean hasMessages() {
		return !messages.isEmpty();
	}
	
	public void run() {
		running = true;
		while (running) {
			acceptMessage();
		}
	}
	
	public void stop() {
		if (running) {
			running = false;
			cleanup();
		}
	}
	
	private void cleanup() {
		try {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
			socket.close();
		} catch (IOException e) {
			System.out.println("Exception occured when cleaning up a socket");
			System.out.println(e);
		}
	}
}
