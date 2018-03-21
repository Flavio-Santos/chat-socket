package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	public static void main(String args[]){
		try {
			InetAddress endereco_remoto;
			int porta_remota;
			ServerSocket serverSocket = new ServerSocket(3000);
			System.out.println("Esperando conexao....");

			Socket conexao = serverSocket.accept();
			System.out.println("Conexao aceita, esperando dados..");

			DataOutputStream saida = new DataOutputStream(conexao.getOutputStream());
			DataInputStream entrada = new DataInputStream(conexao.getInputStream());

			for (int i = 0; i < 100; i++) {
				int linha = entrada.readInt();
				System.out.println("entrei");
				saida.writeUTF("recebi seu dado: " + linha);
			}
			endereco_remoto = conexao.getInetAddress();
			porta_remota = conexao.getPort();
			
			System.out.println("Nome da maquina remota: " + endereco_remoto.getHostName());
			System.out.println("Ip da maquina remota: " + endereco_remoto.getHostAddress());
			System.out.println("Porta maquina remota; " + porta_remota);
			
			System.out.println("fim");
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	
}
