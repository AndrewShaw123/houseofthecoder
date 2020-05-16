import java.util.Arrays;

/**
 * 最小堆
 *
 * @author andrew
 * @date 2020/2/5
 */
public class TestHeap {


    /**
     * 向上调整（添加新元素）
     *
     * @param arr 最小堆
     * @param length 数组长度
     * @return 调整后的数组
     */
    public static int[] upAdjust(int[] arr , int length){

        int child = length - 1;
        int parent = (child-1)/2;
        int temp = arr[child];

        while(child > 0 && temp < arr[parent]){
            arr[child] = arr[parent];
            child = parent;
            parent = (child-1)/2;
        }

        arr[child] = temp;

        return arr;
    }

    /**
     * 下沉操作（删除一个元素==删除第一个元素，把最后一个元素移到根，再使用下沉操作调整）
     *
     * @param arr 最小堆
     * @param parent 要下沉元素的下标
     * @param length 数组长度
     * @return
     */
    public static int[] downAdjust(int[] arr , int parent , int length){

        int temp = arr[parent];
        int child = parent*2 + 1;
        while(child < length){
            if(child + 1 < length && arr[child] > arr[child + 1]){
                child++;
            }

            if(temp <= arr[child]){
                break;
            }

            arr[parent] = arr[child];
            parent = child;
            child = parent*2 + 1;
        }

        arr[parent] = temp;

        return arr;
    }

    public static int[] buildHeap(int[] arr , int length){

        for(int i = (length - 2) / 2; i >= 0; i--){
            arr = downAdjust(arr,i,length);
        }

        return arr;
    }

    /**
     * 堆排序
     * @param arr
     * @param length
     * @return
     */
    public static int[] heapSort(int[] arr , int length){

        for(int i = (length-2)/2;i>=0;i--){
            arr = downAdjust(arr,i,length);
        }

        for(int i = length -1 ;i >= 1;i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            arr = downAdjust(arr,0,i);
        }
        return arr;
    }


    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {

        /*int[] arr = new int[]{1,2,3,4,5,6,7,8,9,0};
        int[] result = upAdjust(arr, arr.length);
        System.out.println(Arrays.toString(result))*/;

        int[] arr = new int[]{3,6,2,5,9,1,4,8,7};
        int[] result = heapSort(arr, arr.length);
        System.out.println(Arrays.toString(result));

    }





}
