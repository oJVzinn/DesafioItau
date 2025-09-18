package com.github.ojvzinn.desafioitau;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;

@SpringBootTest
class DesafioItauApplicationTests {

    @Test
    public void listTransactions() {
        try {
            URL url = new URL("http://localhost:8080/estatistica");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            System.out.println(connection.getResponseCode());
            try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
                String responseLine;
                StringBuilder response = new StringBuilder();
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }

                System.out.println(response);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void clearTransactions() {
        try {
            URL url = new URL("http://localhost:8080/transacao");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("DELETE");
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            System.out.println(connection.getResponseCode());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void createTransaction() {
        try {
            URL url = new URL("http://localhost:8080/transacao");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setDoOutput(true);

            JSONObject sendTransaction = new JSONObject();
            sendTransaction.put("valor", 640.35);
            sendTransaction.put("dataHora", OffsetDateTime.now());

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = sendTransaction.toString().getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            System.out.println(conn.getResponseCode());
            try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
                String responseLine;
                StringBuilder response = new StringBuilder();
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }

                System.out.println(response);
            }
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }

}
