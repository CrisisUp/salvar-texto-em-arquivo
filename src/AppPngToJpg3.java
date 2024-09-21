import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class AppPngToJpg3 {
    public static void main(String[] args) {
        String pathIn = "src/imgOrig1.png";
        String pathOut = "src/imgCop1.jpg";

        File outputFile = new File(pathOut);
        if (outputFile.exists()) {
            System.out.println("\nO arquivo de saída já existe. Deseja sobrescrever? (s/n)");
            try (Scanner scanner = new Scanner(System.in)) {
                String resposta = scanner.nextLine().toLowerCase();
                if (!resposta.equals("s")) {
                    System.out.println("Operação cancelada.");
                    return;
                }
            }
        }

        try (FileInputStream inFile = new FileInputStream(pathIn);
             FileOutputStream outFile = new FileOutputStream(pathOut)) {
            byte[] buffer = new byte[inFile.available()];
            long totalBytes = inFile.available();
            long bytesCopied = 0;
            int bytesRead;
            while ((bytesRead = inFile.read(buffer)) != -1) {
                outFile.write(buffer, 0, bytesRead);
                bytesCopied += bytesRead;
                System.out.println("Copiando... " + (bytesCopied * 100 / totalBytes) + "%");
            }
            System.out.println("Processo finalizado!");

            File fileIn = new File(pathIn);
            long sizeIn = fileIn.length();
            System.out.println("Tamanho do arquivo de entrada: " + sizeIn + " bytes");
            
            File fileOut = new File(pathOut);
            long sizeOut = fileOut.length();
            System.out.println("Tamanho do arquivo de saída: " + sizeOut + " bytes");
        } catch (IOException e) {System.out.println("Erro ao copiar o arquivo: " + e.getMessage());}
    }
}

