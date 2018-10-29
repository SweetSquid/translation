package main;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;

/**
 * Class <b>Main</b>
 *
 * @author Mykyta Frolov
 *
 * @version 1.0
 */
public class Main {
    private static boolean run = true; //condition for loop
    private static String rawData = null;

    public static void main(String[] args) {
        GlobalKeyboardHook keyboardHook = new GlobalKeyboardHook(true); // use false here to switch to hook instead of raw input

        keyboardHook.addKeyListener(new GlobalKeyAdapter() { //add key listener
            @Override public void keyPressed(GlobalKeyEvent event) {
                if (event.isMenuPressed() && event.getVirtualKeyCode()!=0x58){ //0x58 equals X key  (Runs when alt+х pressed)
                    try {
                        rawData = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor); //get data raw data from clipboard
                        System.out.println("What was in clipboard:  " + rawData);
                        String newData = Copy.getCopy(); //get copied data
                        System.out.println("What was copied:  " + newData);
                        Notification.runNotification(newData); //start notification
                        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(rawData), null); //returning raw data
                        System.out.println("What came into clipboard: " + Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor));
                    } catch (Exception e) {
                        throw  new RuntimeException(e);
                    }
                }
            }
            @Override public void keyReleased(GlobalKeyEvent event) { }
        });

        try {
            while(run) Thread.sleep(128);
        } catch(InterruptedException e) { /* nothing to do here */ }
        finally { keyboardHook.shutdownHook(); }
    }
}

