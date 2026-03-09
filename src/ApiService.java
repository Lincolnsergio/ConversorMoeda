import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiService {

    private static final String API_KEY = "95dbc8533cb1c85d4d28b30d";  // substitua pela sua chave

    public double getTaxa(String base, String destino) {
        try {
            String urlStr = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + base;

            URL url = new URL(urlStr);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conexao.getInputStream()));

            String inputLine;
            StringBuilder conteudo = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                conteudo.append(inputLine);
            }

            in.close();

            String json = conteudo.toString();

            // Extração simples da taxa de câmbio no JSON (pode melhorar depois)
            String busca = "\"" + destino + "\":";
            int inicio = json.indexOf(busca) + busca.length();
            int fim = json.indexOf(",", inicio);

            String taxaStr = json.substring(inicio, fim);
            return Double.parseDouble(taxaStr);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}