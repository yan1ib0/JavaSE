package cc.excalibur.base;

/**
 * @author Excalibur
 * @date 2022/5/11 21:33
 *  数据的隐式转换
 */
public class YinShiZhuanHuan {
    public static void main(String[] args) {
        byte a=127;
        byte b=127;
//        a=a+b;
        a+=b;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(a);
    }
}
