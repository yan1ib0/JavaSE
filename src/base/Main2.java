package base;


/**
 * @author Excalibur_yan
 * @date 2022/1/2 12:23
 */
public class Main2 {
    public static final int LENGTH=5;
    public static final int SUM=32;
    public static void main(String[] args) {
        for(int i=0;i<SUM;i++){
            StringBuilder result= new StringBuilder(Integer.toBinaryString(i));
            String zero="0";
            if(result.length()!=LENGTH){
                int l=result.length();
                for(int j=0;j<LENGTH-l;j++){
                    result.insert(0, zero);
                }
            }
            System.out.println(result);
        }
    }
}
