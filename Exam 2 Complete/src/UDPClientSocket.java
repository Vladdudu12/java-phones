import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPClientSocket implements AutoCloseable{
	private DatagramSocket socket;
	private int bindPort = 60001;
	
	public UDPClientSocket() throws SocketException{
		socket = new DatagramSocket();
	}
	
	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
