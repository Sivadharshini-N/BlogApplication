import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BlogSystem bs = new BlogSystem();

        while(true){
            System.out.println("Blog Application");
            System.out.println("1.Login\n2.Register\n3.Exit");
            int option = sc.nextInt();

            switch (option){
                case 1:{
                    bs.login();
                }
                case 2:{
                    bs.register();
                }
                default:{
                    System.out.println("Exiting the system");
                    System.exit(1);
                }
            }
        }



    }
}