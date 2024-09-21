import java.io.InputStream;
import java.io.OutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class AppPngToJpg2 {
    public static void main(String[] args) {
        String pathIn = "src/imgOrig2.png";
        String pathOut = "src/imgCop2.jpg";

        File fileIn = new File(pathIn);
        long sizeIn = fileIn.length(); // Obter o tamanho do arquivo de entrada
        System.out.println("Tamanho do arquivo de entrada: " + sizeIn + " bytes");

        int read = 0;
        byte[] length = new byte[1024];

        try (InputStream in = new FileInputStream(pathIn);
             OutputStream out = new FileOutputStream(pathOut)) {
            while ((read = in.read(length)) != -1) {out.write(length, 0, read);}
            System.out.println("Processo finalizado!");
            File fileOut = new File(pathOut);
            long sizeOut = fileOut.length();
            System.out.println("Tamanho do arquivo de saída: " + sizeOut + " bytes");
        } catch (IOException e) {System.out.println("Erro ao copiar o arquivo: " + e.getMessage());}
    }
}
