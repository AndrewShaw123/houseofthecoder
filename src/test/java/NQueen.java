import java.util.Arrays;

/**
 * Class
 *
 * @author andrew
 * @date 2020/2/1
 */
public class NQueen {

    public int nums = 0;

    public static int[] result;

    private int n;

    public NQueen(int n){
        this.n = n;
        this.result = new int[n+1];
    }

    public void backtrace(int row){

        if(row > n){
            nums++;
        }else{
            for(int col = 1;col <= n ;col++){
                result[row] = col;
                if(place(row)){
                    backtrace(row+1);
                }
            }
        }
    }

    private boolean place(int col){

        for(int i = 1;i< col;i++){
            if(Math.abs(col - i)==Math.abs(result[col]-result[i])||result[col]==result[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println("N Queen...");
        NQueen q = new NQueen(8);
        q.backtrace(1);
        System.out.println("total way ->"+q.nums);

    }

}
