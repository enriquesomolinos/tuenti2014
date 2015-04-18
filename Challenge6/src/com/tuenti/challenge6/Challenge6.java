package com.tuenti.challenge6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * The Class Challenge6.
 */
public class Challenge6 {

	
	public static void main(String[] args) throws IOException {

		
		//String keyPassPhrase = getKeyPassphrase();
		String keyPassPhrase = "JungleGreenInternationalRatIsRegular";
		final String host = "54.83.207.90";
		final int portNumber = 6969;
		
		//while (true) {
			Socket socket = new Socket(host, portNumber);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

			//System.out.println("server says:" + br.readLine());
			br.readLine();
			
			out.println("key|%s|%s\n");

			
		//}
	}

	public static String getKeyPassphrase() throws IOException{
		BufferedReader br;
		String line;

		br = new BufferedReader(new InputStreamReader(System.in));

		
		line = br.readLine();
		br.close();
		br = null;

		return line.trim();
	}
}
