import java.net.*;
import java.io.*;
class Client
{
	Socket s = null;
	DataInputStream in = null;
	DataOutputStream out = null;

	Client(String addr , int port) throws Exception
	{
		
			s = new Socket(addr , port);
			System.out.println("Connected");

			in = new DataInputStream(System.in);

			out = new DataOutputStream(s.getOutputStream());

			String message = new String();
			while(!message.equals("over"))
			{
				message = in.readLine();
				out.writeUTF(message);
			}
		
	}
	public static void main(String args[]) throws Exception
	{
			new Client("127.0.0.1" , 8000);
	}

}