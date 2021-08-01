package priorityqueues;

import java.util.PriorityQueue;

public class KthlargestElement {
    public static int kthLargest(int n, int[] input, int k) {

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
        return pq.peek();
    }
    public static void main(String [] args){
        int [] arr ={32,22,9,16,10,5,3,20,25,11,1,8,6};
        System.out.println(kthLargest(arr.length,arr,4));
    }
}
