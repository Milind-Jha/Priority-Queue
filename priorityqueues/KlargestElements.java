package priorityqueues;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KlargestElements {
    public static ArrayList<Integer> kLargest(int input[], int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<k;i++){
            pq.add(input[i]);
        }
        for(int i=k;i<input.length;i++){
            if(pq.isEmpty()){
                break;
            }
            int min = pq.peek();
            if(min<input[i]){
                pq.remove();
                pq.add(input[i]);
            }
        }
        ArrayList<Integer> output = new ArrayList<>();
        int limit = pq.size();
        for(int i=0;i< limit;i++){
            if(pq.isEmpty()){
                break;
            }
            int temp = pq.remove();
            output.add(temp);
        }
        return output;
    }
    public static void main(String [] args){
        int[] arr = {32,22,9,16,10,5,3,20,25,11,1,8,6};
        ArrayList<Integer> ans = kLargest(arr,4);
        for (int x=0;x< ans.size();x++ ) {
            System.out.println(ans.get(x));
        }
    }
}
