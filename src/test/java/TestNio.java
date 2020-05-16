import javax.print.attribute.standard.PrinterResolution;
import java.io.*;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
/**
 * Class
 *
 * @author andrew
 * @date 2020/1/25
 */
public class TestNio {

    public static void main(String[] args) {

        File file = new File("d:/a.txt");
        File outfile = new File("d:/b.txt");

        try {
            FileInputStream is = new FileInputStream(file);
            FileChannel inChannel = is.getChannel();

            FileOutputStream fo = new FileOutputStream(outfile);
            FileChannel outChannel = fo.getChannel();


            MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
            System.out.println("-------------");
            System.out.println(buffer.toString());
            System.out.println("-------------");
            outChannel.write(buffer);

            buffer.clear();
            Charset charset = Charset.forName("UTF-8");
            CharsetDecoder decoder = charset.newDecoder();
            CharBuffer charBuffer = decoder.decode(buffer);
            System.out.println(charBuffer);

            /*
            SortedMap<String, Charset> stringCharsetSortedMap = Charset.availableCharsets();
            Set<String> values = stringCharsetSortedMap.keySet();
            Iterator<String> iterator = values.iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next());
            }
            */
        } catch (FileNotFoundException e) {
            System.out.println("file not found error");
        } catch (IOException e) {
            System.out.println("io error");
        }

    }

}
