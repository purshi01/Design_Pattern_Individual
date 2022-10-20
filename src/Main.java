import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Facade facade = new Facade(new MeatProductMenu(),new ProduceProductMenu());

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
                if (facade.login(name, password,userType)) {
                    System.out.println("Successfully logged in");

                    facade.showMenu();
                    while(true){
                    System.out.println("Enter 0 to display Meat Product menu, 1 to Produce Product menu and 2 to add the product in your list ");
                    int productMenu = scnInt.nextInt();
                    if (productMenu == 0) {
                        facade.meatProductMenu.ShowMenu();
                    } else if (productMenu == 1) {
                        facade.produceProductMenu.ShowMenu();
                    } else if (productMenu == 2) {
                        break;

                    } else {
                        System.out.println("Invalid entry !!!!!!!!!!!!");
                    }
                }
                    facade.showUserProductList(name);
                    while(true) {
                       System.out.println("Enter 0 to add the product and 1 to delete the product ");
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
                                   facade.showMenu();
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
                       } else {
                           System.out.println("Invalid entry !!!!!!!!!!!!");
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
                if (facade.login(name, password,userType)) {
                    System.out.println("Successfully logged in");
                }else {
                    System.out.println("Invalid Credentials please try again");
                }
            } else {
                System.out.println("Invalid user type please try again");
            }

        }

    }
}
