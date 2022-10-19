import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Facade facade = new Facade();
        Scanner scnInt = new Scanner(System.in);
        Scanner scnStr = new Scanner(System.in);

        int userType;
        String name;
        String password;
        int nProductCategory;
        while (true) {
            System.out.println("Please enter 0 for Buyer or 1 for Seller");
            userType = scnInt.nextInt();
            if (userType == 0) {
                System.out.println("Enter User Name");
                name = scnStr.nextLine();
                System.out.println("Enter User Password");
                password = scnStr.nextLine();
                if (facade.login(name, password)) {
                    System.out.println("Successfully logged in");

                       facade.showProductLis();
                       facade.showUserProductList(name);
                    while(true) {
                       System.out.println("Enter 0 for add the product and 1 for delete the product");
                       int input = scnInt.nextInt();
                       if (input == 0) {
                               System.out.println("Enter the product name that you want to add to your list");
                               String productname = scnStr.nextLine();
                               if(facade.theProductList.contains(new Product(productname)))
                               {
                                   facade.addUserProductToList(name,new Product(productname));
                                   facade.showUserProductList(name);
                               }
                               else{
                                   System.out.println("Error!!! Please enter the product which showed in below list!!!!!!!!");
                                   facade.showProductLis();
                               }
                               

                       } else if (input == 1) {
                           System.out.println("Enter the product name that you want to delete");
                           String productname = scnStr.nextLine();
                           if(facade.getUserProductList(name).contains(new Product(productname)))
                           {
                               facade.deleteUserProductToList(name,productname);
                               facade.showUserProductList(name);
                           }
                           else{
                               System.out.println("Error!!! Please enter the product which showed in below list!!!!!!!!");
                               facade.showUserProductList(name);
                           }
                       }

                   }
                } else {
                    System.out.println("Invalid Credentials please try again");
                }
            } else if (userType == 1) {
                System.out.println("Enter User Name");
                name = scnStr.nextLine();
                System.out.println("Enter User Password");
                password = scnStr.nextLine();
                if (facade.login(name, password)) {
                    System.out.println("Successfully logged in");
                }
            } else {
                System.out.println("Invalid Credentials please try again");
            }

        }

    }
}
