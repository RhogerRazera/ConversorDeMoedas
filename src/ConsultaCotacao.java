public class ConsultaCotacao {

    private final String chaveAPI;
    private String chaveAPI = "cbdafc9cb147493ba4574810";
    private String codigoMoedaOrigem;
    private String codigoMoedaDestino;
    private double taxaDeCambio;

    public ConsultaCotacao(String chaveAPI) {
        this.chaveAPI = chaveAPI;

        public double getTaxaDeCambio() {
            return taxaDeCambio;
        }

        public double taxaDeCambio (String codigoMoedaInicial, String codigoMoedaFinal) {
            try {
                String linkApi = "https://v6.exchangerate-api.com/v6/" + chaveAPI + "/pair/" + codigoMoedaInicial + "/" + codigoMoedaFinal;
                public void setCodigoMoedaOrigem(String codigoMoedaOrigem) {
                    this.codigoMoedaOrigem = codigoMoedaOrigem;
                }

                public void setCodigoMoedaDestino(String codigoMoedaDestino) {
                    this.codigoMoedaDestino = codigoMoedaDestino;
                }

                public String getCodigoMoedaOrigem() {
                    return codigoMoedaOrigem;
                }

                public String getCodigoMoedaDestino() {
                    return codigoMoedaDestino;
                }

                public double calcularTaxaDeCambio (String codigoMoedaInicial, String codigoMoedaFinal) {
                    String url = "https://v6.exchangerate-api.com/v6/" + chaveAPI + "/pair/" + codigoMoedaOrigem + "/" + codigoMoedaDestino;
                    JsonObject jsonResponse = null;
                    try {
                        HttpClient client = HttpClient.newHttpClient();
                        HttpRequest request = HttpRequest.newBuilder()
                                .uri(URI.create(linkApi))
                                .uri(URI.create(url))
                                .build();

                        HttpResponse<String> response = client
                                .send(request, HttpResponse.BodyHandlers.ofString());

                        Gson gson = new Gson();
                        JsonObject jsonResponse = gson.fromJson(response.body(), JsonObject.class);
                        return jsonResponse.get("conversion_rate").getAsDouble();
                    } catch (Exception e){
                        throw new RuntimeException("Erro na aplicação. Não foi possivel obter a taxa de câmbio.");
                        jsonResponse = gson.fromJson(response.body(), JsonObject.class);
                        return taxaDeCambio = jsonResponse.get("conversion_rate").getAsDouble();
                    } catch (Exception e) {
                        System.out.println("Erro na aplicação. Não foi possivel obter a taxa de câmbio.");
                    }
                    return taxaDeCambio;
                }
            }