package View;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import Controller.HorarioController;

public class App {

	@SuppressWarnings({ "unused", "resource" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leitor=new Scanner(System.in);
		Popup popup=new Popup();
		HorarioController hcl=new HorarioController();
		
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
		
		System.out.println("Hora:");
		int hrs=leitor.nextInt();
		System.out.println("Min:");
		int min=leitor.nextInt();
		System.out.println("Seg:");
		int seg=leitor.nextInt();
		
		hcl.iniciarExecucaoEm(hrs, min, seg);

	}

}
