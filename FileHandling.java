import java.io.*;

class FileHandling
{
    public static void main(String args[]) throws Exception
    {
        FileInputStream fin = new FileInputStream("in.txt");
        FileOutputStream fout = new FileOutputStream("out.txt");

        byte bytes[] = new byte[1024];
        int count;

        while((count = fin.read(bytes)) != -1)
        {
            fout.write(bytes, 0, count);
        }

        fin.close();
        fout.close();

        System.out.println("File copied successfully.");
    }
}