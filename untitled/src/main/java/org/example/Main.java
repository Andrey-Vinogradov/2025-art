package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            // Чтение JSON из файла
            Library[] libraries = mapper.readValue(new File("src/main/resources/catalog.txt"), Library[].class);

            // Вывод результата
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