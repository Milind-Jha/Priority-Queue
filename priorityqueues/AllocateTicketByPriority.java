package priorityqueues;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class AllocateTicketByPriority {
    public static int buyTicket(int input[], int k) {
        Queue<Integer> index = new LinkedList<>();      
        PriorityQueue<Integer> priority = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<input.length;i++){
            index.add(i);               //Queue of index 0,1,2,3,4....input.length
            priority.add(input[i]);     //PriorityQueue of priorities from maximum to minimum
        }                               //ex:-if input = {11,7,8,12,9,8} , priority= {12,11,9,8,8,7}
        int count = 0;                  
        boolean complete = false;
        while (!complete){
            if(priority.peek()==input[index.peek()]){       
                count++;
                if(index.peek()==k){
                    complete=true;
                }
                priority.remove();
                index.remove();
            }
            else{
                index.add(index.remove());
            }
        }
        return count;
        }

    public static void main(String[] args){
        int[] arr = {8,12,8,9,8,7};
        System.out.println(buyTicket(arr,2)) ;
    }
}
