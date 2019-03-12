//  Class with client code using TCP
import java.net.*;
import java.io.*;

public class ClientTCP {
	 public static void main ( String argv[] ) throws IOException {

		String sentence;
		String modifiedSentence;

		BufferedReader inFromUser = new BufferedReader 
				(new InputStreamReader (System.in) );
		
		Socket clientSocket = new Socket (argv[0],Integer.parseInt(argv[1]) );

		DataOutputStream outToServer = new DataOutputStream 
				(clientSocket.getOutputStream());

		BufferedReader inFromServer = new BufferedReader 
				(new InputStreamReader (clientSocket.getInputStream() ) );

        System.out.println ("Write sentence for server" + '\n' );
		sentence = inFromUser.readLine();
		outToServer.writeBytes(sentence + '\n');
		modifiedSentence = inFromServer.readLine();
		System.out.println ("From Server: " + modifiedSentence );
        clientSocket.close();

	 } //End main

} //End ClientTCP