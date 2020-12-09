/**
 * @author Raaf van Nieuwkerk & Joshua Roles
 * Some notes about the program:
 * We used the NetBeans Swing GUI generator for most of our gui
 * We left in the editor fold sections so that it is easy to hide the generated code, since this is less important
 * Occasionally we added a couple lines within that folded area, but nothing too noteworthy
 *
 */

import javax.swing.*;
import com.bulenkov.darcula.DarculaLaf;

public class Main {
        public static ImageIcon imageIcon = new ImageIcon(Main.class.getResource("img/icon.png"));
        public static void main(String[] args) {
            try {
                UIManager.setLookAndFeel(DarculaLaf.class.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            runAllStarts();
            MainForm myform = new MainForm();
        }
        private static void runAllStarts(){
            Team.Companion.start();
            Staff.Companion.start();
            Project.Companion.start();
        }
}
