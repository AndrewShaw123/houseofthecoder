import java.util.Arrays;

/**
 * TestHeap2 Class
 *
 * @author andrew
 * @date 2020/5/15
 */
public class TestHeap2 {


    public static int[] downAdjust(int[] arr , int parent , int length){

        int temp = arr[parent];
        int child = parent*2 + 1;
        while(child < length){
            if(child + 1 < length && arr[child] < arr[child + 1]){
                child++;
            }

            if(temp > arr[child]){
                break;
            }

            arr[parent] = arr[child];
            parent = child;
            child = parent*2 + 1;
        }

        arr[parent] = temp;

        return arr;
    }

    public static void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,6,2,5,9,1,4,8,7};
        for(int i = arr.length/2-1; i >= 0; i--){
            downAdjust(arr,i,arr.length);
        }


        for(int j = arr.length-1; j > 0; j--){
            swap(arr,0,j);//将堆顶元素与末尾元素进行交换
            downAdjust(arr,0,j);//重新对堆进行调整
        }

        System.out.println(Arrays.toString(arr));
    }


}
