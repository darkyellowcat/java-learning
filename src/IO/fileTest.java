package IO;

import java.io.File;

public class fileTest {
    public static void main(String[] args) {
        try{
            File f = new File("src/IO/fileTest.java");
            System.out.println("文件名："+f.getName());
            System.out.println("文件路径："+f.getPath());
            System.out.println("文件绝对路径："+f.getAbsolutePath());
            System.out.println(f.getParent().getClass());
            System.out.println(f.getParent());
            System.out.println(f.getParentFile().getClass());
            System.out.println(f.getParentFile());

            System.out.println("文件是否存在："+f.exists());
            System.out.println("文件是否是目录："+f.isDirectory());
            System.out.println("文件是否是文件："+f.isFile());
            System.out.println("文件是否可读："+f.canRead());
            System.out.println("文件是否可写："+f.canWrite());
            System.out.println("文件最后修改时间："+f.lastModified());

//            f.mkdir(); //创建单级目录
//            f.mkdirs(); //创建多级目录
//            f.delete(); //删除文件或目录
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
