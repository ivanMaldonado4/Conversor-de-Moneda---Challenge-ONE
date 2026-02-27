import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConversorMonedas {

    private static final String API_KEY = "089f0f74c758f5e4016498b7";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcion = 0;

        System.out.println("=== Conversor de Monedas ===");

        while (opcion != 3) {

            System.out.println("Menu:");
            System.out.println("1-Convertir moneda");
            System.out.println("2-Mostrar codigos disponibles");
            System.out.println("3-Salir");
            System.out.print("Opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();

            if (opcion == 1) {

                System.out.print("Moneda base: ");
                String base = sc.nextLine().toUpperCase();

                System.out.print("Moneda destino: ");
                String destino = sc.nextLine().toUpperCase();

                System.out.print("Monto: ");
                double monto = sc.nextDouble();
                sc.nextLine();

                convertir(base, destino, monto);

            } else if (opcion == 2) {

                mostrarCodigos();

            } else if (opcion == 3) {

                System.out.println("Saliendo...");

            } else {

                System.out.println("Opcion invalida");
            }
        }

        sc.close();
    }

    private static void convertir(String base, String destino, double monto) {

        try {

            HttpClient client = HttpClient.newHttpClient();

            String url = BASE_URL + API_KEY + "/latest/" + base;

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                System.out.println("Error al consultar la API");
                return;
            }

            Gson gson = new Gson();
            JsonObject json = gson.fromJson(response.body(), JsonObject.class);

            JsonObject rates = json.getAsJsonObject("conversion_rates");

            if (!rates.has(destino)) {
                System.out.println("Moneda no encontrada");
                return;
            }

            double tasa = rates.get(destino).getAsDouble();
            double resultado = monto * tasa;

            System.out.println(monto + " " + base + " = " + resultado + " " + destino);

        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    private static void mostrarCodigos() {

        try {

            HttpClient client = HttpClient.newHttpClient();

            String url = BASE_URL + API_KEY + "/codes";

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                System.out.println("Error al consultar la API");
                return;
            }

            Gson gson = new Gson();
            JsonObject json = gson.fromJson(response.body(), JsonObject.class);

            JsonArray codigos = json.getAsJsonArray("supported_codes");

            for (int i = 0; i < codigos.size(); i++) {
                JsonArray item = codigos.get(i).getAsJsonArray();
                System.out.println(item.get(0).getAsString() + " - " + item.get(1).getAsString());
            }

        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}