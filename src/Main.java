import java.sql.SQLOutput;

public class Main {

        public static void main(String[] args){
            runAllStarts();
            MainForm myform = new MainForm();
        }

        private static void runAllStarts(){
            Team.Companion.start();
            Staff.Companion.start();
            Project.Companion.start();
        }

}
