package priorityqueues;

public class InPlaceHeapSort {
    private static void downheapify(int[] arr, int start, int end) {
        int parentindex=start;
        int leftchildindex = 2*parentindex+1;
        int rightchildindex = 2*parentindex+2;
        while (leftchildindex<end){
            int minindex = parentindex;
            if(arr[leftchildindex]<arr[minindex]){
                minindex=leftchildindex;
            }
            if(rightchildindex<end&&arr[minindex]>arr[rightchildindex]){
                minindex=rightchildindex;
            }
            if(minindex==parentindex){
                break;
            }
            int temp = arr[parentindex];
            arr[parentindex] = arr[minindex];
            arr[minindex] = temp;
            parentindex = minindex;
            leftchildindex = 2*parentindex+1;
            rightchildindex = 2*parentindex+2;
        }
    }
    public static void heapSort(int[] arr) {
        int length = arr.length;
        for(int i=(length/2)-1;i>=0;i--){
            downheapify(arr,i,length);          //This is to create heap form given array
        }
        for(int i=length-1;i>=0;i--){
            int temp = arr[i];                       //Swap element at position i to first element
            arr[i] = arr[0];
            arr[0] = temp;

            downheapify(arr,0,i);            // then apply downheapify
        }
    }



    public static void main(String []args){
        int arr[]={4,7,3,2,8,9,6,1};
        heapSort(arr);
        for(int i:arr){
            System.out.println(i);
        }
    }
}
