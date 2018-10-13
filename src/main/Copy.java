package main;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.IOException;

/**
 * Class <b>Copy</b>
 *
 * @author Mykyta Frolov
 *
 * @version 1.0
 */
class Copy {
//    private static Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    private static Robot robot;

    static {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method <b>getCopy</b>: copies selected text
     *
     * @return copied string data from clipboard
     *
     */
    static String getCopy() throws IOException, UnsupportedFlavorException {
//        System.out.println("before: "+clipboard.getData(DataFlavor.stringFlavor));
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_C);
//        Thread.sleep(100);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_C);
//        System.out.println("Copy was completed");
//        System.out.println("after:  "+clipboard.getData(DataFlavor.stringFlavor));
        return (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
    }

    /**
     * Method <b>getDataFromClipboard</b>
     *
     * @return data from clipboard
     *
     */
    public static Object getDataFromClipboard() throws IOException, UnsupportedFlavorException {
       return Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
    }

}
