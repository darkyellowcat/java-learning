package IO;

import java.io.*;

public class streamTest {
    public static void main(String[] args) {
        File f = new File("Test.txt" );
        if(!f.exists()){
            try{
                f.createNewFile();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        //以字节为单位
        FileInputStream fis = null;
        try{
            fis = new FileInputStream(f);
            byte[] b = new byte[1024];
            int len;
            while((len = fis.read(b)) != -1){
                String s = new String(b,0,len);
                System.out.println(s);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            try{
                if(fis != null){
                    fis.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(f, true);
            String s = "Hello, World!\n";
            byte[] b = s.getBytes();
            fos.write(b);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            try{
                if(fos != null){
                    fos.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    //以字符为单位
    public class readWrite{
        FileReader fr = null;
        FileOutputStream fos = null;
        FileWriter fw = null;
        FileInputStream fis = null;
        public void readFile(String filePath){
            try {
                fis = new FileInputStream(filePath);
                byte[] b = new byte[1024];
                int len;
                while((len = fis.read(b)) != -1){
                    String s = new String(b,0,len);
                    System.out.println(s);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            try{
                fr = new FileReader(filePath);
                char[] c = new char[1024];
                int len;
                while((len = fr.read(c)) != -1){
                    String s = new String(c,0,len);
                    System.out.println(s);
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                try{
                    if(fr != null){
                        fr.close();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
