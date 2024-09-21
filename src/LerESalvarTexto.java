import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class LerESalvarTexto {
    public static void main(String[] args) {
        String path = "src/texto/file.txt";
        writeFile(path);
        System.out.println("_________________________________");
        readFile(path);
    }

    public static void writeFile(String path) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileWriter fw = new FileWriter(path)) {
                System.out.println("Entre com seu texto: ");
                String data;
                do {
                    data = reader.readLine();
                    data += "\n";
                    if (data.equals("stop\n")) break;
                    fw.write(data);
                } while (true);
        } catch (SecurityException e) {
            System.out.println("Erro: Sem permissão para gravar no arquivo.");
        } catch (FileNotFoundException e) {
            System.out.println("Erro: Arquivo não encontrado.");
        } catch (IOException e) {
            System.out.println("Erro o escrever no arquivo: " + e.getMessage());
        }
    }

    public static void readFile(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String data;
            while ((data = reader.readLine()) != null) {System.out.println(data);}
        } catch (FileNotFoundException e) {
            System.out.println("Erro: Arquivo não encontrado.");
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

}

    