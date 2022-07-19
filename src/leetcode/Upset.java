package exam2;

import java.util.ArrayList;
import java.util.Random;

//Stop the word
// GC 垃圾回收
//  YoungGC  FullGC
//  （1） 引用计数法 Python用的  不支持循环依赖
//
public class Upset {
    public static void main(String[] args) {

        ArrayList l=new ArrayList();
        ArrayList list=new ArrayList();
        for(Integer i=1;i<=52;i++){
            l.add(i);
        }
        System.out.println(l);
      while (!l.isEmpty()){
            Random r=new Random();
            int a=r.nextInt(l.size());
            list.add(l.remove(a));

       }
        System.out.write(86);
        System.out.println(list);
    }
}
