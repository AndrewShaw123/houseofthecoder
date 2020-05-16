import java.util.ArrayList;
import java.util.List;

/**
 * Class
 *
 * @author andrew
 * @date 2020/2/2
 */
public class testString {

    public static void main(String[] args) {



        String str = "a1b2";

        String substring = str.substring(0, 1);

        System.out.println(substring);

        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        /*list.remove(list.size()-1);*/
        list.remove(new Integer(3));
        System.out.println(list);


        /*boolean[] flags = new boolean[str.length()];
        StringBuilder s = new StringBuilder(str);
        System.out.println(str.substring(0,2)+((Character)str.charAt(2)).toString().toUpperCase()+str.substring(3));*/

    }

    List<String> result = new ArrayList<String>();

    public List<String> letterCasePermutation(String S) {
        backtrack(S,0);
        return result;
    }

    public void backtrack(String str,int pos){

        if(pos==str.length()){
            result.add(str);
        }else{
            char c = str.charAt(pos);
            if (Character.isDigit(c)) {
                backtrack(str,pos+1);
            }else{
                str = str.substring(0,pos)+((Character)str.charAt(pos)).toString().toUpperCase()+str.substring(pos+1);
                backtrack(str,pos+1);
                str = str.substring(0,pos)+((Character)str.charAt(pos)).toString().toLowerCase()+str.substring(pos+1);
                backtrack(str,pos+1);
            }
        }

    }

}
