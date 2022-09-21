package cc.excalibur.designpatterns;

/**
 * @author Excalibur
 * @date 2022/7/21 11:17
 */
public abstract class FactoryMethod {
    public abstract Product factoryMethod();
    public void dosomething(){
        Product product=factoryMethod();
        // TODO: 2022/7/21

    }
}
