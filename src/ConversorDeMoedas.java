public class ConversorDeMoedas {
    private final Cotacao cotacao;

    public ConversorDeMoedas() {
        this.cotacao = new Cotacao();
    }

    public double converter(int opcao, double valor) {
        double taxa = 0;

        switch (opcao) {
            case 1:
                taxa = cotacao.obterCotacao("USD", "BRL");
                break;
            case 2:
                taxa = cotacao.obterCotacao("EUR", "BRL");
                break;
            case 3:
                taxa = cotacao.obterCotacao("GBP", "BRL");
                break;
            case 4:
                taxa = cotacao.obterCotacao("JPY", "BRL");
                break;
            case 5:
                taxa = cotacao.obterCotacao("BRL", "USD");
                break;
            case 6:
                taxa = cotacao.obterCotacao("AUD", "BRL");
                break;
            case 7:
                taxa = cotacao.obterCotacao("CAD", "BRL");
                break;
            case 8:
                taxa = cotacao.obterCotacao("CHF", "BRL");
                break;
            case 9:
                taxa = cotacao.obterCotacao("CNY", "BRL");
                break;
            case 10:
                taxa = cotacao.obterCotacao("BRL", "EUR");
                break;
            default:
                return -1; // Opção inválida
        }

        return valor * taxa;
    }
}
