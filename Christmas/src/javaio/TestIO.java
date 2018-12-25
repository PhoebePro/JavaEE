package javaio;

import java.io.*;


public class TestIO {

    private void fileIO() throws IOException {
        String fileName = "/home/mafuliang/Documents"+File.separator+"阿姨.md";
        File file = new File(fileName);
        InputStream inputStream = new FileInputStream(file);
        byte[] b = new byte[(int)file.length()];
        for(int i = 0;i < b.length;i++){
            b[i] = (byte)inputStream.read();
        }
        inputStream.close();
        System.err.println(new String(b));
    }

    private void fileIOb() throws  IOException{
        String fileName = "/home/mafuliang/Documents"+File.separator+"阿姨.md";
        File file = new File(fileName);
        InputStream inputStream = new FileInputStream(file);
        byte[] b = new byte[1024];
        int count = 0;
        int temp = 0;
        while((temp = inputStream.read()) !=(-1)){
            b[count++] = (byte)temp;
        }
        byte[] newB= new byte[count];
        System.arraycopy(b,0,newB,0,count);//数组复制的方法，第一个参数是源数组，第二个参数是复制开始的位置，第二个参数是目标数组，第四个参数是粘贴开始的位置，第五个参数是复制的长度
        inputStream.close();
        System.err.println(new String(newB));
    }

    private void fileCreate() throws IOException{
        String fileName = "/home/mafuliang"+File.separator+"test.md";
        File file = new File(fileName);
        file.createNewFile();
        file.setWritable(true);
    }

    private void fileWrite(String filePath,String oldStr,String newStr) throws IOException{
        File file = new File(filePath);
        long fileLength = file.length();
        byte[] fileContext = new byte[(int)fileLength];
        FileInputStream in = null;
        PrintWriter out = null;
        try {
            in = new FileInputStream(filePath);
            in.read(fileContext);
            String str = new String(fileContext, "utf-8");
            str = str.replace(oldStr, newStr);
            out = new PrintWriter(filePath);
            out.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
                out.flush();
                out.close();
                in.close();
        }
    }

    public static void main(String[] args) throws IOException{
        String fileName = "/home/mafuliang"+File.separator+"test.md";
        TestIO t = new TestIO();
        t.fileIO();
//        t.fileIOb();
//        t.fileCreate();
    }

}
