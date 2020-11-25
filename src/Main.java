import java.sql.SQLOutput;

public class Main {

        public static void main(String[] args){
            runAllStarts();
            MainForm myform = new MainForm();
            System.out.println("Hello World!");
            Hello test2 = new Hello();
            test2.test();



        }

        private static void runAllStarts(){
            Team.Companion.start();
            Staff.Companion.start();
            Project.Companion.start();
        }

}
