package application.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

    public class FormValidationUtil {

        private final static Scanner sc = new Scanner(System.in);

        // ── Tipos básicos ──────────────────────────────────

        public static int validateInt(String prompt) {
            while (true) {
                try {
                    System.out.println(prompt);
                    int value = sc.nextInt();
                    sc.nextLine();
                    return value;
                } catch (InputMismatchException e) {
                    System.out.println("Entrada no válida. Por favor, ingrese un número entero.");
                    sc.nextLine();
                }
            }
        }

        public static double validateDouble(String prompt) {
            while (true) {
                try {
                    System.out.println(prompt);
                    double value = sc.nextDouble();
                    sc.nextLine();
                    return value;
                } catch (InputMismatchException e) {
                    System.out.println("Entrada no válida. Por favor, ingrese un número decimal.");
                    sc.nextLine();
                }
            }
        }

        public static boolean validateBoolean(String prompt) {
            while (true) {
                try {
                    System.out.println(prompt);
                    boolean value = sc.nextBoolean();
                    sc.nextLine();
                    return value;
                } catch (InputMismatchException e) {
                    System.out.println("Entrada no válida. Por favor, ingrese true o false.");
                    sc.nextLine();
                }
            }
        }

        public static String validateString(String prompt) {
            while (true) {
                System.out.println(prompt);
                String value = sc.nextLine().trim();
                if (!value.isEmpty()) {
                    return value;
                }
                System.out.println("Entrada no válida. Por favor, ingrese un texto no vacío.");
            }
        }

        // ── Fechas (LocalDate y LocalDateTime — usados en Ciclo, RegistroDiario,
        //           Prediccion, Usuario) ─────────────────────────────────────────

        public static LocalDate validateLocalDate(String prompt) {
            while (true) {
                try {
                    System.out.println(prompt + " (formato: AAAA-MM-DD)");
                    String value = sc.nextLine().trim();
                    return LocalDate.parse(value);
                } catch (DateTimeParseException e) {
                    System.out.println("Entrada no válida. Por favor, ingrese una fecha con formato AAAA-MM-DD.");
                }
            }
        }

        public static LocalDateTime validateLocalDateTime(String prompt) {
            while (true) {
                try {
                    System.out.println(prompt + " (formato: AAAA-MM-DDTHH:MM)");
                    String value = sc.nextLine().trim();
                    return LocalDateTime.parse(value);
                } catch (DateTimeParseException e) {
                    System.out.println("Entrada no válida. Por favor, ingrese fecha y hora con formato AAAA-MM-DDTHH:MM.");
                }
            }
        }
    }

