import java.util.List;

public class Facade {

    private int UserType;
    Product theSelectedProduct;
    private int nProductCategory;
    List<Product> theProductList;
    Person thePerson;

    public boolean login() {
        return true;
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
        return new Product();
    }

    public void productOperation() {

    }
}
