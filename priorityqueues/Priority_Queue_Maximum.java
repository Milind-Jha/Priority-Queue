package priorityqueues;

import java.util.ArrayList;

public class Priority_Queue_Maximum {

    ArrayList<Integer> heap;        //Integer of priority without any value

    public Priority_Queue_Maximum(){
        heap= new ArrayList<>();

    }
    boolean isEmpty() {
        if(heap.isEmpty()){
            return true;
        }
        else
            return false;
    }

    int getSize() {
        return heap.size();
    }

    int getMax() throws PriorityQueueEmptyException {
        if(!heap.isEmpty()){
            return heap.get(0);
        }
        else {
            throw new PriorityQueueEmptyException();
        }

    }

    void insert(int element) {
        heap.add(element);
        int childindex = heap.size()-1;
        int parentindex = (childindex-1)/2;
        while (childindex>0){
            if(heap.get(childindex)>heap.get(parentindex)){
                int temp = heap.get(childindex);
                heap.set(childindex,heap.get(parentindex));
                heap.set(parentindex,temp);
                childindex=parentindex;
                parentindex=(childindex-1)/2;
            }
            else{
                return;
            }
        }
    }

    int removeMax() throws PriorityQueueEmptyException {
        if(heap.isEmpty()){
            throw  new PriorityQueueEmptyException();
        }
        else{

            int output = heap.get(0);
            heap.set(0,heap.get(heap.size()-1));
            heap.remove(heap.size()-1);
            int parentindex =0;
            int leftchildindex= 2*parentindex+1;
            int rightchildindex = 2*parentindex+2;
            while (leftchildindex<heap.size()){
                int maxindex = parentindex;
                if(heap.get(leftchildindex)>heap.get(maxindex)){
                   maxindex=leftchildindex;
                }
                if(rightchildindex<heap.size() && heap.get(rightchildindex)>heap.get(maxindex)){
                    maxindex = rightchildindex;
                }
                if(maxindex==parentindex){
                    break;
                }
                int temp = heap.get(parentindex);
                heap.set(parentindex,heap.get(maxindex));
                heap.set(maxindex,temp);

                parentindex=maxindex;
                leftchildindex=2*parentindex+1;
                rightchildindex=2*parentindex+2;
            }
            return output;
        }
    }
}
