import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Facade {

    private int UserType;
    Product theSelectedProduct;
    private int nProductCategory;
    List<Product> theProductList;
    ClassProductList classProductList;
    Person thePerson;
    Login login;
    String userProduct[];

    public Facade(int userType, Product theSelectedProduct, int nProductCategory, Person thePerson) throws Exception {
        UserType = userType;
        this.theSelectedProduct = theSelectedProduct;
        this.nProductCategory = nProductCategory;
        this.thePerson = thePerson;

    }

    public Facade() throws Exception {
        login = new Login();
        classProductList = new ClassProductList();
        theProductList = classProductList.getProductList();

    }

    public void showProductLis(){
        System.out.println("List of products");
        String leftAlignFormat = "| %-15s | %-15s |%n";

        System.out.format("+-----------------+------+%n");
        System.out.format("| Product Category   | Product name |%n");
        System.out.format("+-----------------+------+%n");
        for (Product product : theProductList) {
            System.out.format(leftAlignFormat, product.getProductCategory(), product.getProductName());
        }

        System.out.format("+-----------------+------+%n");
    }
    public void showUserProductList(String name) throws Exception {
        System.out.println("List of your products");
        String leftAlignFormat2 = "| %-15s | %-15s |%n";

        System.out.format("+-----------------+------+%n");
        System.out.format("| User name   | Product name |%n");
        System.out.format("+-----------------+------+%n");
        for (Product product : classProductList.userProductUserList.get(name)) {
            System.out.format(leftAlignFormat2, name, product.getProductName());
        }

        System.out.format("+-----------------+------+%n");

    }
    public List<Product> getUserProductList(String name){
        return classProductList.userProductUserList.get(name);
    }
    public void addUserProductToList(String user, Product product) throws Exception {
        classProductList.addUserProductToList(user,product);
    }
    public void deleteUserProductToList(String user, String productName) throws Exception {
        classProductList.deleteUserProductToList(user,productName);
    }
    public boolean login(String name,String password) {
        return login.login(name,password);
    }

    public void addTrading() {

    }

    public void viewTrading() {

    }

    public void decideBidding() {

    }

    public void discussBidding() {

    }

    public void submitBidding() {

    }

    public void remind() {


    }

    public void createUser(UserInfoItem userInfoItem) {

    }

    public void createProductList() {

    }

    public void attachProductToUser() {

    }

    public Product selectProduct() {
        return this.theSelectedProduct;
    }

    public void productOperation() {

    }

    public void accept(NodeVisitor nodeVisitor) {
        nodeVisitor.visitFacade(this);
    }
}
