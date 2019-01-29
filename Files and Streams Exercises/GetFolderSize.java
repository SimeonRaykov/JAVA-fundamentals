import java.io.File;


public class Main {

    public static void main(String[] args) {

        File folder = new File("C:\\Users\\Simeon\\Desktop\\Exercises Resources");
        long size = getFolderSize(folder);
        System.out.println("Folder size: " + size);
    }

    public static long getFolderSize(File folder) {
        long length = 0;
        File[] files = folder.listFiles();

        int count = files.length;

        for (int i = 0; i < count; i++) {
            if (files[i].isFile()) {
                length += files[i].length();
            } else {
                length += getFolderSize(files[i]);
            }
        }
        return length;
    }
}
