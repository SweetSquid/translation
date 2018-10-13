package main;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Class <b>Notification</b>
 *
 * @author Mykyta Frolov
 *
 * @version 1.0
 *
 */
class Notification extends Thread{

    /**
     * Method <b>displayTray</b>: displays the word translation
     *
     * @param word The word that will be displayed
     *
     */
    private static void displayTray(String word) throws AWTException, IOException {
        Image image = Toolkit.getDefaultToolkit().createImage("name.png");
        final TrayIcon ti = new TrayIcon(image, "Tray Demo");
        final SystemTray st = SystemTray.getSystemTray();
        st.add(ti);
        ti.displayMessage("Translation", Translation.tranlate(word), TrayIcon.MessageType.NONE);  //displays notification window
        SwingUtilities.invokeLater(() -> { //every 2 seconds destroying notification window
            try {
                Thread.sleep(2000);
                st.remove(ti);
            } catch (InterruptedException ignored) {}
        });
    }

    /**
     * Method <b>runNotification</b>: runs notification
     *
     * @param word The word that will be displayed
     *
     */
    static void runNotification(String word) throws IOException, AWTException {
        if (SystemTray.isSupported()) {
            Notification.displayTray(word);
        } else {
            System.err.println("System tray not supported!");
        }
    }
}