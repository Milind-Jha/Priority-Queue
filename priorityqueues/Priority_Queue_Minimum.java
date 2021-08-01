package priorityqueues;

import java.util.ArrayList;

public class Priority_Queue_Minimum<T> {            //root is minimum

    private ArrayList<Element<T>> priorityQueueHeap; //ArrayList of Elements
    public Priority_Queue_Minimum(){

        priorityQueueHeap = new ArrayList<>();
    }
    public void insert(T data,int priority){
        Element entry = new Element(data,priority);
        int childindex= priorityQueueHeap.size()-1;
        int parentindex= (childindex-1)/2;

    while (childindex>0) {
            if (priorityQueueHeap.get(childindex).priority < priorityQueueHeap.get(parentindex).priority) {
                Element<T> temp = priorityQueueHeap.get(childindex);
                priorityQueueHeap.set(childindex, priorityQueueHeap.get(parentindex));
                priorityQueueHeap.set(parentindex, temp);
                childindex = parentindex;
                parentindex = (childindex - 1) / 2;
        } else {
                return;
            }
        }
    }
    public T removeMinimum() throws PriorityQueueEmptyException{
            if(isEmpty()){
                throw new PriorityQueueEmptyException();
            }
            Element<T> remove = priorityQueueHeap.get(priorityQueueHeap.size()-1);
            T ans = remove.data;

            priorityQueueHeap.set(0,priorityQueueHeap.get(priorityQueueHeap.size()-1));
            priorityQueueHeap.remove(priorityQueueHeap.size()-1);

            int parentindex=0;
            int leftchildindex=2*parentindex+1;
            int rightchildindex = 2*parentindex+2;

            while (leftchildindex<priorityQueueHeap.size())
            {
                int minindex=parentindex;
                if(priorityQueueHeap.get(leftchildindex).priority<priorityQueueHeap.get(minindex).priority){
                    minindex=leftchildindex;
                }
                if(rightchildindex<priorityQueueHeap.size() && priorityQueueHeap.get(minindex).priority>priorityQueueHeap.get(rightchildindex).priority){
                    minindex=rightchildindex;
                }
                if(minindex==parentindex){
                    break;
                }
                Element<T> temp = priorityQueueHeap.get(minindex);
                priorityQueueHeap.set(minindex,priorityQueueHeap.get(parentindex));
                priorityQueueHeap.set(parentindex,temp);
                parentindex=minindex;
                leftchildindex=2*parentindex+1;
                rightchildindex=2*parentindex+2;
            }
            return ans;
        }


    public T getMinimum() throws PriorityQueueEmptyException {
        if(!isEmpty()){
            return priorityQueueHeap.get(0).data;
        }
        else{
            throw new PriorityQueueEmptyException();
        }

    }
    public boolean isEmpty(){
        if(priorityQueueHeap.size()==0){
            return true;
        }
        return false;
    }
    public int getSize(){
        return priorityQueueHeap.size();
    }
}
