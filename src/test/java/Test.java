import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class
 *
 * @author andrew
 * @date 2020/3/2
 */
public class Test{

    public static void main(String[] args) {

        List<User> list = new ArrayList<User>(10);
        System.out.println(list.toString());
        list.set(5,new User("as"));
        System.out.println(list.toString());

    }

}
