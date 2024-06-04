import java.io.IOException;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServerSocket implements AutoCloseable{
	private DatagramSocket socket;
	private int bindPort;
	
	public UDPServerSocket() throws SocketException{
		bindPort = 60001;
	}
	
	 public int getBindPort() {
		 return bindPort;
	 }
	 
	
	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
