public class Buyer extends Person {

    @Override
    public void showMenu() {

    }

    @Override
    public ProductMenu CreateProductMenu(int productType) throws Exception {
        switch (productType) {

            case 0:
                productMenu = new MeatProductMenu();
                break;
            case 1:
                productMenu = new ProduceProductMenu();
                break;
            default:
                productMenu = null;

        }
        return productMenu;
    }
}
