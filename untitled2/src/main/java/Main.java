import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class Main {
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        ObjectMapper mapper = new ObjectMapper();


        try {
            // Чтение JSON из ресурсов
            InputStream inputStream = Main.class.getResourceAsStream("/catalog.txt");
            if (inputStream == null) {
                throw new RuntimeException("Файл catalog.txt не найден в resources!");
            }

            Library[] libraries = mapper.readValue(inputStream, Library[].class);
            printLibraryCatalog(libraries);

        } catch (Exception e) {
            System.err.println("Произошла ошибка:");
            e.printStackTrace();
        }
    }

    private static void printLibraryCatalog(Library[] libraries) {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║                        КАТАЛОГ КНИГ                    ║");
        System.out.println("╠══════════════════════════════╦═════════════════════════╣");
        System.out.println("║          Автор               ║           Книга         ║");
        System.out.println("╠══════════════════════════════╬═════════════════════════╣");

        for (Library lib : libraries) {
            System.out.printf("║ %-28s ║ %-23s ║%n",
                    lib.getNameAuthor(),
                    lib.getNameBook());
        }

        System.out.println("╚══════════════════════════════╩═════════════════════════╝");
        System.out.println("Всего книг в каталоге: " + libraries.length);
    }
}