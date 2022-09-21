package cc.excalibur.designpatterns;

/**
 * @author Excalibur
 * @date 2022/7/21 11:11
 * 简单工厂  提供一个创建对象的通用接口 不项客户端暴露内部细节
 */
public class SimpleFactory {
    public Product getInstance(Class arg){
        // 逻辑 选择实现类
        return new ConcreteProduct();
    }
}
