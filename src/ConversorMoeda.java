public class ConversorMoeda {

    public double converter(int opcao, double valor) {
        ApiService api = new ApiService();

        switch (opcao) {
            case 1: // USD para BRL
                return valor * api.getTaxa("USD", "BRL");
            case 2: // BRL para USD
                return valor * api.getTaxa("BRL", "USD");
            case 3: // USD para EUR
                return valor * api.getTaxa("USD", "EUR");
            case 4: // EUR para USD
                return valor * api.getTaxa("EUR", "USD");
            case 5: // USD para ARS
                return valor * api.getTaxa("USD", "ARS");
            case 6: // ARS para USD
                return valor * api.getTaxa("ARS", "USD");
            default:
                System.out.println("Opção inválida");
                return 0;
        }
    }
}