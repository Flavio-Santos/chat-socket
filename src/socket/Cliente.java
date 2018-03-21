package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente{
	public static void main(String args[]){
		try {
			Socket s = new Socket("localhost", 3000);
			DataOutputStream saida = new DataOutputStream(s.getOutputStream());
			DataInputStream entrada = new DataInputStream(s.getInputStream());
			
			for (int i = 0; i < 100; i++) {
				saida.writeInt(i);
				System.out.println("Enviei: " + i);
				String em = entrada.readUTF();
				System.out.println("Recebi: " + i);
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
}
