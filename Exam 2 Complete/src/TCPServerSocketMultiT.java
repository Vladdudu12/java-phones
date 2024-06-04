import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class TCPServerSocketMultiT {
	private ServerSocket serverSocket;
	private int port = 50001;
	private File f;
	private VectThread vt;
	
	public TCPServerSocketMultiT(int port) throws Exception{
		serverSocket = new ServerSocket(port);
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
	public void setFileName(String newFName) {
		if(newFName != null) {
			f = new File(newFName);
		}
		else {
			f = null;
		}
	}
	
	public void startTCPServer() throws IOException{
		while(true) {
			Socket socket = serverSocket.accept();
			Runnable runnable = () -> {
				try {
					InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
					BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
					ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
					
					vt = new VectThread(f.getAbsolutePath());
					List<ElectronicDevices> led = vt.getPhoneList();
					
					String line;
					while((line = bufferedReader.readLine()) != null){
						if(line.equals("EXIT")) {
							socket.close();
							return;
						}
						else if(line.equals("GETFILE")) {
							objectOutputStream.writeObject(led);
							objectOutputStream.flush();
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			};
			runnable.run();
		}
	}
	
	
}
