import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Class
 *
 * @author andrew
 * @date 2020/1/25
 */
public class TestNio2 {

    public static void main(String[] args) {

        Path path = Paths.get(".");

        System.out.println(path.getNameCount());

        System.out.println(path.getRoot());

        System.out.println(path.toAbsolutePath());

        System.out.println(path.toAbsolutePath().getNameCount());

        System.out.println(path.toAbsolutePath().getRoot());

        Path path2 = Paths.get("d:","a.txt");
        System.out.println(path2);


        //System.out.println(path.getName(3));
    }

}
