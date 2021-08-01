package priorityqueues;

public class CheckMaximumHeap {
    public static boolean checkMaxHeap(int arr[]) {
        int parentindex=0;
        int leftchildindex=1;
        int rightchildindex=2;

        while (leftchildindex<arr.length){
            if(arr[parentindex]<arr[leftchildindex]){
                return false;
            }
            if(rightchildindex<arr.length&&arr[rightchildindex]>arr[parentindex]){
                return false;
            }
            parentindex++;
            leftchildindex=2*parentindex+1;
            rightchildindex=2*parentindex+2;
        }
        return true;
    }
    public static void main(String[] args){
        int [] arr ={7,6,5,4,3,2,11};
        System.out.println(checkMaxHeap(arr));
    }
}
