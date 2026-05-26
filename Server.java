import java.net.*;
import java.io.*;
class Server
{
	Socket s= null;
	ServerSocket ss = null;
	DataInputStream in = null;
	Server(int port) throws Exception
	{
		
			ss = new ServerSocket(port);
			System.out.println("Server started");

			s = ss.accept();
			System.out.println("Client acceptd");

			in = new DataInputStream(new BufferedInputStream(s.getInputStream()));
			String m = new String();
			while(!m.equals("over"))
			{
					m = in.readUTF();
					System.out.println(m);
			}
			s.close();
			in.close();
			System.out.println("Connection closed");

		
	}
	public static void main(String args[]) throws Exception
	{
		new Server(8000);
	}
}