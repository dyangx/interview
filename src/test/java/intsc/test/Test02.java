package intsc.test;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Vector;

public class Test02 {
    public static void main(String[] args) {
        File file = new File("/opt/file/IMG_1577.HEIC");
        System.out.println(saveToImgByBytes(file,"./xxxx.jpg"));

    }

    public static boolean saveToImgByBytes(File imgFile, String imgPath){
        boolean stateInt = true;
        if(imgFile.length() > 0){
            try {
                File file=new File(imgPath);//可以是任何图片格式.jpg,.png等
                FileOutputStream fos=new FileOutputStream(file);

                FileInputStream fis = new FileInputStream(imgFile);
                byte[] b = new byte[1024];
                int nRead = 0;
                while ((nRead = fis.read(b)) != -1) {
                    fos.write(b, 0, nRead);
                }
                fos.flush();
                fos.close();
                fis.close();
            } catch (Exception e) {
                stateInt = false;
                e.printStackTrace();
            }
        }
        return stateInt;
    }
}
