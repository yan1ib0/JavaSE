package cc.excalibur.designpatterns;

/**
 * @author Excalibur
 * @date 2022/7/21 11:20
 */
public class ConcreteFactory extends FactoryMethod{
    @Override
    public Product factoryMethod() {
        return new ConcreteProduct();
    }
}
