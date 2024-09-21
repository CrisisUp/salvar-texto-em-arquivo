import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Scanner;

public class ImageConverter {
    public static void main(String[] args) {
        String pathIn = "src/imgOrig1.png";
        String pathOut = "src/imgCop1.jpg";
        //int quality = 80; // Qualidade da imagem JPEG (0-100) ????

        // Verifica se o arquivo de saída já existe e confirma a sobrescrita
        if (confirmOverwrite(pathOut)) {
            try (FileInputStream in = new FileInputStream(pathIn);
                 FileOutputStream out = new FileOutputStream(pathOut)) {
                BufferedImage image = ImageIO.read(in);
                ImageIO.write(image, "jpg", out);
                System.out.println("Conversão realizada com sucesso!");
            } catch (IOException e) {
                System.err.println("Erro ao converter imagem: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("Operação cancelada.");
        }
    }

    private static boolean confirmOverwrite(String pathOut) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("O arquivo de saída já existe. Deseja sobrescrever? (s/n)");
        String resposta;
        do {
            resposta = scanner.nextLine().toLowerCase();
        } while (!resposta.equals("s") && !resposta.equals("n"));
        scanner.close();
        return resposta.equals("s");
    }
}