package ocr;

/**
 *
 * @author ahmad al kisswani
 */
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import net.sourceforge.tess4j.TesseractException;
import ocr.util.OCRClass;

public class Ocr {

    public static void main(String[] args) throws IOException, TesseractException {

        OCRClass object = new OCRClass();

        object.getmicr( ImageIO.read( new File("C:\\Users\\User1\\Desktop\\test image\\test oco code.jpg")));
    }

}
