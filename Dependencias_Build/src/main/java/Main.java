import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        // Data e hora atual
        DateTime agora = new DateTime();
        System.out.println("Data e hora atual: " + agora);

        // Formatando a data
        DateTimeFormatter formatador = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
        String dataFormatada = agora.toString(formatador);
        System.out.println("Data e hora formatada: " + dataFormatada);

        // Adicionando dias
        DateTimeFormatter formatadorData = DateTimeFormat.forPattern("dd/MM/yyyy");
        DateTime daquiTresDias = agora.plusDays(1);
        System.out.println("Amanhã será dia: " + daquiTresDias.toString(formatadorData));
    }
}
