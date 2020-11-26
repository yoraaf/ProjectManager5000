import com.jtattoo.plaf.bernstein.BernsteinLookAndFeel;
import javax.swing.*;
import java.sql.SQLOutput;

public class Main {

        public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
            //UIManager.setLookAndFeel(BernsteinLookAndFeel.class.getName());
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            runAllStarts();
            MainForm myform = new MainForm();
        }

        private static void runAllStarts(){
            Team.Companion.start();
            Staff.Companion.start();
            Project.Companion.start();
        }

}
