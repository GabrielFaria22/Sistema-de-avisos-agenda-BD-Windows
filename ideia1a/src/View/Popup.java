package View;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.net.MalformedURLException;

public class Popup {
	
	
	Popup _this=this;
	
	public void acao() {
		if (SystemTray.isSupported()) {
            try{
                _this.displayTray();
            }catch(AWTException ex){
                
            }catch(MalformedURLException ex){
            
            }
        } else {
            System.err.println("System tray not supported!");
        }
	}
	
	public void displayTray() throws AWTException, MalformedURLException {
        //Obtain only one instance of the SystemTray object
        SystemTray tray = SystemTray.getSystemTray();

        //If the icon is a file
        Image image = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Faria\\Downloads\\IMG\\2.png");
        //Alternative (if the icon is on the classpath):
        //Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon.png"));

        TrayIcon trayIcon = new TrayIcon(image, "Java AWT Tray Demo");
        //Let the system resize the image if needed
        trayIcon.setImageAutoSize(true);
        //Set tooltip text for the tray icon
        trayIcon.setToolTip("System tray icon demo");
        tray.add(trayIcon);

        trayIcon.displayMessage("Reuniao das 10", "Acionistas e CEO", MessageType.ERROR);
    }

}
