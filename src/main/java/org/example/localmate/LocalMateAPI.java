package org.example.localmate;

import java.io.*;

package org.example.chatbot;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class LocalMateAPI {

    // Set to false to test with full response at once
    private static final boolean STREAM = false;

    public static String sendPrompt(String prompt) {
        StringBuilder result = new StringBuilder();

        try {
            // Create JSON body
            JSONObject json = new JSONObject();
            json.put("model", "llama3");  // You can replace this with any model you want for eg "mistral"
            json.put("prompt", prompt);
            json.put("stream", STREAM);

            // Build the request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:11434/api/generate"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json.toString()))
                    .build();

            // Send request
            HttpClient client = HttpClient.newHttpClient();

            if (STREAM) {
                // Handle streaming response
                HttpResponse<InputStream> response = client.send(request, HttpResponse.BodyHandlers.ofInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(response.body()));
                String line;

                while ((line = reader.readLine()) != null) {
                    line = line.trim();
                    if (!line.isEmpty() && line.startsWith("{")) {
                        JSONObject chunk = new JSONObject(line);
                        if (chunk.has("response")) {
                            result.append(chunk.getString("response"));
                        }
                        if (chunk.optBoolean("done", false)) break;
                    }
                }
            } else {
                // Handle full static response
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                JSONObject obj = new JSONObject(response.body());
                result.append(obj.getString("response"));
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }

        return result.toString().trim();
    }
}
