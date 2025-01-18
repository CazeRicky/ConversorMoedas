import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Cotacao {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/7af4165d55382d045ab6c78c/latest/";

    public double obterCotacao(String moedaBase, String moedaAlvo) {
        try {
            URL url = new URL(API_URL + moedaBase);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.setRequestMethod("GET");

            BufferedReader leitor = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            StringBuilder resposta = new StringBuilder();
            String linha;

            while ((linha = leitor.readLine()) != null) {
                resposta.append(linha);
            }
            leitor.close();

            String respostaTexto = resposta.toString();
            return extrairTaxaDeConversao(respostaTexto, moedaAlvo);
        } catch (Exception e) {
            System.out.println("Erro ao obter a cotação: " + e.getMessage());
            return -1;
        }
    }

    private double extrairTaxaDeConversao(String resposta, String moedaAlvo) {
        int inicio = resposta.indexOf(moedaAlvo) + 5;
        int fim = resposta.indexOf(",", inicio);
        String taxa = resposta.substring(inicio, fim);
        return Double.parseDouble(taxa);
    }
}
