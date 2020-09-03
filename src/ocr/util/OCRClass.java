package ocr.util;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

/**
 *
 * @author ahmad al kisswany
 */
public class OCRClass {

    BufferedImage imag;
    String OcrType="mcr";

    public void setOcrType(String OcrType) {
        this.OcrType = OcrType;
    }

    public String getOcrType() {
        return OcrType;
    }

    public OCRClass() {

    }

    public BufferedImage getImag() {
        return imag;
    }

    public void setImag(BufferedImage imag) {
        this.imag = imag;
    }

    public String getmicr(BufferedImage imag) throws TesseractException {
        String text = null;

        Tesseract instance = Tesseract.getInstance();
        //instance.setLanguage("eng");
        instance.setLanguage(OcrType);
        instance.setDatapath(System.getProperty("user.dir") + "/tessdata");

        // the path of your tess data folder
        // inside the extracted file
        text = instance.doOCR(imag);
        StringBuilder input1 = new StringBuilder();
        input1.append(text);
        text = input1.reverse().toString();
        String[] lines = text.split("\\r?\\n");
        text = lines[2];
        StringBuilder input2 = new StringBuilder();
        input2.append(text);
        text = input2.reverse().toString();

        return text;
    }

    public BufferedImage scaleImage(int WIDTH, int HEIGHT, BufferedImage imageName) {
        BufferedImage bi = null;
        try {
            bi = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = (Graphics2D) bi.createGraphics();
            g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
            g2d.drawImage(imageName, 0, 0, WIDTH, HEIGHT, null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return bi;
    }

}
