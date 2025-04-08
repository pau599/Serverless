/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.github.cdimascio.dotenv.Dotenv;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

/**
 *
 * @author Carolina
 */
public class ServiceGeneradorIA {
    
    private static final Dotenv dotenv = Dotenv.load();
    private static final String API_KEY = dotenv.get("API_KEY");

    private static final String API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-pro:generateContent";
    private static final HttpClient httpClient = HttpClient.newHttpClient();
    private static final Gson gson = new Gson();

    public static String generarContenido(String mensaje) {
        JsonObject requestBody = new JsonObject();
        JsonObject content = new JsonObject();
        JsonObject part = new JsonObject();
        part.addProperty("text", mensaje);
        content.add("parts", gson.toJsonTree(new JsonObject[]{part}));
        requestBody.add("contents", gson.toJsonTree(new JsonObject[]{content}));

        try {
            URI apiUri = URI.create(API_URL);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(apiUri)
                    .header("Content-Type", "application/json")
                    .header("x-goog-api-key", API_KEY)
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody.toString()))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                JSONObject jsonObj = new JSONObject(response.body());
                return jsonObj.getJSONArray("candidates")
                        .getJSONObject(0)
                        .getJSONObject("content")
                        .getJSONArray("parts")
                        .getJSONObject(0)
                        .getString("text");
            } else {
                return " Error " + response.statusCode() + ": " + response.body();
            }
        } catch (IOException | InterruptedException e) {
            return " Error al conectar con la IA: " + e.getMessage();
        }
    }
    
}
