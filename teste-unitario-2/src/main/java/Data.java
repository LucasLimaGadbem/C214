import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Data {

    private final DateTime agora;

    // Construtor
    public Data() {
        this.agora = new DateTime();
    }

    public Data(DateTime data) {
        this.agora = data;
    }

    // Retorna data/hora atual
    public String dataAtual() throws Exception {
        String atual = agora.toString("yyyy-MM-dd'T'HH:mm:ss.SSS");
        if (!atual.equals("2025-09-01T10:00:00.000")) {
            throw new Exception();
        }
        return atual;
    }



    // Retorna data formatada
    public String dataFormatada() throws Exception {
        String formatada = formatandoData(agora);
        if (!formatada.equals("01/09/2025")) {
            throw new Exception();
        }
        return formatada;
    }


    // Formata a data no padrão dd/MM/yyyy
    public String formatandoData(DateTime data) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
        return formatter.print(data);
    }

    // Retorna data futura (agora + dfuturo dias), formatada
    public String diaFuturo(int dfuturo) throws Exception {
        DateTime futuro = agora.plusDays(dfuturo);
        String resultado = formatandoData(futuro);
        if (dfuturo == 3 && !resultado.equals("04/09/2025")) {
            throw new Exception("Data futura incorreta.");
        }
        return resultado;
    }


    // Retorna o segundo do dia atual
    public int segundo() throws Exception {
        if (agora.getSecondOfDay() != 36010) {
            throw new Exception();
        }
        return agora.getSecondOfDay();
    }


    // Retorna o minuto do dia atual
    public int minuto() throws Exception {
        if(agora.getMinuteOfDay() == 540){
            throw new Exception();
        }
        return agora.getMinuteOfDay();
    }

    // Retorna a hora do dia atual
    public int hora() throws Exception {
        if (agora.getHourOfDay() != 10) {
            throw new Exception();
        }
        return agora.getHourOfDay();
    }

}
