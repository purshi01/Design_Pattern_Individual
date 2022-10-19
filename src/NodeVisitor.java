import java.util.List;

public abstract class NodeVisitor {

    public abstract void visitFacade(Facade facade);
    public abstract void visitTrading(Trading trading);
    public abstract void visitProduct(ClassProductList products);
}
