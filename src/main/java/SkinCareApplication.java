import manager.CycleManager;
import manager.ProductManager;
import manager.TrayManager;

import java.awt.*;

public class SkinCareApplication {
    private static ProductManager pm;

    public static void main(String[] args) throws AWTException, InterruptedException {
        load();
        start();

        // TODO: save current state
//        save();
        stop();
    }

    private static void load() {
        // load products
        pm = ProductManager.getInstance();

        // TODO: Use configs
        // check if config exists
        // if so, load config
        // else create default config
    }

    private static void start() throws AWTException, InterruptedException {
        TrayManager.displayOnly("Skin Cycler", "Its the first day of your Skin Cycling Routine!");

        CycleManager cm = CycleManager.getInstance();

        while (true) {
            if (cm.alert()) {
                cm.displayRoutine();
                // wait 1 hour before checking again
                Thread.sleep(60 * 60 * 1000);
            } else {
                // 15 * seconds in minute times second = 15 minutes wait
                Thread.sleep(15 * 60 * 1000);
            }
        }
    }

    // TODO: Implement Saving State
//    private static void save() {
//
//    }

    private static void stop() throws AWTException {
        TrayManager.close();
    }

    // TODO: Use configs
//    private static void loadConfig() {
//
//    }
//
//    private static  void createConfig() {
//
//    }

}