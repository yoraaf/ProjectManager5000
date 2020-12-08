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
