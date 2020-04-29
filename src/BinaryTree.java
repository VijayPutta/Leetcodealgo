import java.util.*;


public class BinaryTree {
	public static void main(String[] args){
		reachthenumberwithminsteps();
	}

	private static void reachthenumberwithminsteps() {
		// TODO Auto-generated method stub
		int number = Arrayutil.getNumber(),
				temp = 0;
		Queue q = new LinkedList();
		q.add(0);
		int count = 0;
		int queuesize = 0;
		while(!q.isEmpty()){
			temp = (int)q.poll();
			System.out.println(temp+"temp");
		        if(temp == number){
		        	System.out.println(count);
		        	return;
		        }
		        queuesize++;
		        System.out.println(queuesize+"queuesize");
		        System.out.println(count+"queuesize");
		        if(queuesize == Math.pow(2, count)){
		            count++;
		        	queuesize = 0;
		        }
		        System.out.println("hello");
				q.add(temp-count);
				q.add(temp+count);
				System.out.println(temp-count);
				System.out.println(temp+count);
		}

	}
}
