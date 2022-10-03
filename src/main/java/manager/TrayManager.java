package manager;

import domain.Product;
import domain.Routine;

import java.awt.*;
import java.awt.TrayIcon.MessageType;
import java.awt.event.*;
import java.util.List;

public class TrayManager {

    private static SystemTray tray;
    private static TrayIcon icon;

    private final static String LISTENING = "SkinCycleApplication:listening";
    private final static String PAUSED = "SkinCycleApplication:paused";

    private static void start() throws AWTException {
        if(!SystemTray.isSupported()) {
            throw new AWTException("Unsupported System Tray");
        }

        tray = SystemTray.getSystemTray();
        Image image = Toolkit.getDefaultToolkit().createImage("src\\main\\resources\\icon.png");
        TrayIcon ico = new TrayIcon(image, "Skin Care Application");
        ico.setImageAutoSize(true);

        ActionListener al = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(!e.getActionCommand().equalsIgnoreCase(LISTENING)) return;
                try {
                    displaySteps();
                } catch (AWTException ex) {
                    throw new RuntimeException(ex);
                }
            }
        };

        ico.setActionCommand("SkinCareApplication");
        ico.addActionListener(al);

        ico.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    displayTray("Skin Care App", "Did you want to see your routine again?\nClick me to see your steps again!\nOr Click a step to see Instructions!");
                } catch (AWTException ex) {
                    throw new RuntimeException(ex);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });

        tray.add(ico);
        icon = ico;
    }

    public static void displayTray(String caption, String text) throws AWTException {
        if(tray == null || icon == null) {
            start();
        }

        icon.displayMessage(caption, text, MessageType.NONE);
    }

    public static void close() throws AWTException {
        if(tray == null) {
            throw new AWTException("Tray missing");
        }

        tray.remove(icon);
        icon = null;
        tray = null;
    }

    public static void displayOnly(String caption, String text) throws AWTException {
        if(tray == null || icon == null) {
            start();
        }

        pauseListen();
        icon.displayMessage(caption, text, MessageType.INFO);
        listen();
    }

    private static void listen() throws AWTException {
        if(tray == null) {
            throw new AWTException("Tray missing");
        }

        System.out.println("Icon now listening!");

        tray.remove(icon);
        icon.setActionCommand(LISTENING);
        tray.add(icon);
    }

    private static void pauseListen() throws  AWTException {
        if(tray == null) {
            throw new AWTException("Tray missing");
        }

        System.out.println("Pausing Icon listener");

        tray.remove(icon);
        icon.setActionCommand(PAUSED);
        tray.add(icon);
    }

    private static void displaySteps() throws AWTException {
        if(tray == null) {
            throw new AWTException("Tray missing");
        }

        pauseListen();

        CycleManager cm = CycleManager.getInstance();
        Routine r = cm.getCurrentRoutine();

        List<Product> list = r.getRoutineOrder();

        for(int i = 1; i <= list.size(); i++) {
            String step = String.format("Step %s:", i);
            String instr = "";
            if(i == 1) {
                instr = "First, let's apply your %s";
            } else if(i > 1 && i < list.size()) {
                instr = "Next, we'll use %s";
            } else {
                instr = "Finally, go ahead and put on your %s";
            }

            displayTray(step, String.format(instr, list.get(i-1).getName()));
        }

        listen();
    }

}