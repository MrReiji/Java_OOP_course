import java.io.*;
import java.nio.file.Paths;
import java.nio.file.Files;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class FileCopy{
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.out.println("Za mało argumentów wywołania programu !");
            System.exit(1);
        }

        File srcFile = new File(args[0]);
        File dstFile = new File(args[1]);

        if (!srcFile.exists()) {
            System.out.println("Plik " + srcFile.getName() + " nie istnieje !");
            System.exit(1);
        }
        if (srcFile.isDirectory()) {
            System.out.println(srcFile.getName() + " jest katalogiem !");
            System.exit(1);
        }
        if (!srcFile.canRead()) {
            System.out.println("Brak dostępu do pliku " + srcFile.getName() + " !");
            System.exit(1);
        }
        if (dstFile.exists() && !dstFile.canWrite()) {
            System.out.println("Nie można nadpisać pliku " + srcFile.getName() + " !");
            System.exit(1);
        }
        if (dstFile.isFile() && !dstFile.canWrite()) {
            System.out.println("Brak wymaganych uprawnień do zapisu pliku " + dstFile.getName() + " !");
            System.exit(1);
        }
        if (dstFile.isDirectory()) {
            if(!dstFile.canWrite()) {
                System.out.println("Brak uprawnień do katalogu " + dstFile.getName() + " !");
                System.exit(1);
            }
            dstFile = new File(Paths.get(dstFile.getName()) + "/" + srcFile.getName());
        }
        try {
            Files.copy(srcFile.toPath(), dstFile.toPath(), REPLACE_EXISTING);
        }
        catch (IOException e) {
            System.out.println("Błąd związany z: " + e.getMessage());
            System.exit(1);
        }
    }
}

