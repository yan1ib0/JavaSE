package cc.excalibur.jvm;

/**
 * @author Excalibur
 * @date 2022/5/24 18:36
 */
public class Test {
    private static int a=10;
    public static void main(String[] args) {
        int a=10;
        int b=20;
        int c=a+b;

        System.out.println(Test.class.getClassLoader());
        System.out.println(Test.class.getClassLoader().getParent());
        System.out.println(String.class.getClassLoader());
    }
}
