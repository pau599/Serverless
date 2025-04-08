/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ia;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import org.json.JSONObject;
import io.github.cdimascio.dotenv.Dotenv;

public class GeneradorIA {
   
    private static final Dotenv dotenv = Dotenv.load();
    private static final String API_KEY = dotenv.get("API_KEY");

    private static final String API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-pro:generateContent";
    private static final HttpClient httpClient = HttpClient.newHttpClient();
    private static final Gson gson = new Gson();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nMenú:");
            System.out.println("1. Crear contenido con IA");
            System.out.println("2. Salir");
            System.out.print("Elige una opción: ");
            
            int option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    createContent(scanner);
                    break;
                case 2:
                    exit = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
            }
        }
        scanner.close();
    }

    private static void createContent(Scanner scanner) {
        System.out.print("Ingresa tu mensaje para la IA: ");
        String message = scanner.nextLine();
        JsonObject requestBody = new JsonObject();
        JsonObject content = new JsonObject();
        JsonObject part = new JsonObject();
        part.addProperty("text", message);
        content.add("parts", gson.toJsonTree(new JsonObject[]{part}));
        requestBody.add("contents", gson.toJsonTree(new JsonObject[]{content}));

        try {
            URI apiUri = URI.create(API_URL);
            System.out.println("Enviando solicitud a: " + apiUri); 

            HttpRequest request = HttpRequest.newBuilder()
                .uri(apiUri)
                .header("Content-Type", "application/json")
                .header("x-goog-api-key", API_KEY)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody.toString()))
                .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                JSONObject jsonObj = new JSONObject(response.body());
                String respuestaIA = jsonObj.getJSONArray("candidates")
                    .getJSONObject(0)
                    .getJSONObject("content")
                    .getJSONArray("parts")
                    .getJSONObject(0)
                    .getString("text");

                System.out.println("\n🔹 Respuesta de la IA:");
                System.out.println(respuestaIA);
            } else {
                System.out.println("Error: " + response.statusCode() + " - " + response.body());
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al conectar con la IA: " + e.getMessage());
        }
    }
}


