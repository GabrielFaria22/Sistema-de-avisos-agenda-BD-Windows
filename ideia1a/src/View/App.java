package View;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class App {

	@SuppressWarnings({ "unused", "resource" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leitor=new Scanner(System.in);
		Popup popup=new Popup();
		
		int tempo;
		
		System.out.println("Daqui quanto tempo quer a notificacao?");
		
		tempo=leitor.nextInt();
		
		try {
			TimeUnit.SECONDS.sleep(tempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		popup.acao();
		
		

	}

}
