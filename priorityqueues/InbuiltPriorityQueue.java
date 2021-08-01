package priorityqueues;

import java.util.PriorityQueue;

public class InbuiltPriorityQueue {
        public static void main(String[] args){
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
            int [] arr = {2,5,1,4,7,3,87};
            for(int i=0;i< arr.length;i++){
                priorityQueue.add(arr[i]);
            }

//            priorityQueue.remove();
            for(int j:priorityQueue){
                System.out.println(j);
            }

            System.out.println("\n");

            for(int i=0;i< arr.length;i++){
                System.out.println(priorityQueue.remove());
            }
            System.out.println("\n");

            for(int i=0;i< arr.length;i++){
                priorityQueue.add(arr[i]);
            }

            while(!priorityQueue.isEmpty()){
                System.out.println(priorityQueue.poll());
            }
        }

}
