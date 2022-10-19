public class ReminderVisitor extends NodeVisitor{

    @Override
    public void visitFacade(Facade facade) {
        System.out.println("Visited facade");
    }

    @Override
    public void visitTrading(Trading trading) {
        System.out.println("Visited trading");
    }

    @Override
    public void visitProduct(ClassProductList product) {
        System.out.println("Visited product");

    }
}
