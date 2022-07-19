

import java.util.HashMap;


public class Test {

		void Test() throws Exception {
			
		}
		
		
		private void card() {
			 HashMap<Integer,Integer> map = new HashMap<>();
		        map.put(0,2021);
		        map.put(1,2021);
		        map.put(2,2021);
		        map.put(3,2021);
		        map.put(4,2021);
		        map.put(5,2021);
		        map.put(6,2021);
		        map.put(7,2021);
		        map.put(8,2021);
		        map.put(9,2021);
		        int i=1;
		        boolean flag=false;
		        for(;;i++) {
		        	int num=i;
		        	while(true) {
		        		int temp=num%10;
		        		if (map.get(temp)<=0) {
							flag=true;
							break;
						}
		        		map.put(temp, map.get(temp)-1);
		        		num/=10;
		        		if (num==0) {
							break;
						}
		        	}
		        	if (flag) {
						break;
					}
		        }
		        System.out.println(i-1);
		}
}
