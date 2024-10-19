import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

import javax.swing.*;

public class ExchangeRateAPI {
    private static final String API_KEY = "88205a9b2432d602ae3b4dba"; // Aqui coloco mi API Key para que funcione correctamente

    public static double obtenerTasaDeCambio(String monedaOrigen, String monedaDestino) {
        double tasaDeCambio = 0;
        try {
            String endpoint = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + monedaOrigen + "/" + monedaDestino;
            System.out.println("Endpoint: " + endpoint); // Mensaje de depuración
            URL url = new URL(endpoint);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            if (connection.getResponseCode() == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Imprimir la respuesta JSON completa
                String jsonResponse = response.toString();
                System.out.println("Respuesta JSON: " + jsonResponse); // Mensaje de depuración

                // Procesar la respuesta JSON
                JSONObject json = new JSONObject(jsonResponse);
                if (json.has("conversion_rate")) { // Verificar si 'conversion_rate' está presente
                    tasaDeCambio = json.getDouble("conversion_rate");
                } else {
                    System.out.println("No se encontró la tasa en la respuesta.");
                    JOptionPane.showMessageDialog(null, "No se encontró la tasa de cambio en la respuesta.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                System.out.println("Error en la conexión: " + connection.getResponseCode());
                JOptionPane.showMessageDialog(null, "Error en la conexión: " + connection.getResponseCode(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tasaDeCambio;
    }
}