import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DataTest {

    private Data dataFixa;
    private Data dataErrada;
    private Data dataSegundo;
    private DateTime data2025_09_01;

    @Before
    public void setup() {
        data2025_09_01 = new DateTime(2025, 9, 1, 10, 0); // 1 set 2025, 10h00
        DateTime data2025_09_01_segundo = new DateTime(2025, 9, 1, 10, 0, 10); // 1 set 2025, 10h00m10s
        DateTime data2025_10_01 = new DateTime(2025, 10, 1, 9, 0); // 1 set 2025, 9h00
        dataFixa = new Data(data2025_09_01);
        dataErrada = new Data(data2025_10_01);
        dataSegundo = new Data(data2025_09_01_segundo);
    }

    @Test
    public void testDataAtualCerto() throws Exception {
        assertEquals(data2025_09_01.toString("yyyy-MM-dd'T'HH:mm:ss.SSS"), dataFixa.dataAtual());
    }

    @Test(expected = Exception.class)
    public void testDataAtualErrado() throws Exception {
        setup();
        dataErrada.dataAtual();
    }

    @Test
    public void testDataFormatadaCerto() throws Exception {
        setup();
        assertEquals("01/09/2025", dataFixa.dataFormatada());
    }

    @Test(expected = Exception.class)
    public void testDataFormatadaErrado() throws Exception {
        setup();
        dataErrada.dataFormatada();
    }

    @Test
    public void testDiaFuturoCerto() throws Exception {
        setup();
        // 3 dias depois de 01/09/2025 => 04/09/2025
        String futuro = dataFixa.diaFuturo(3);
        assertEquals("04/09/2025", futuro);
    }

    @Test(expected = Exception.class)
    public void testDiaFuturoErrado() throws Exception {
        setup();
        // 3 dias depois de 01/09/  2025 => 04/09/2025
        dataErrada.diaFuturo(3);
    }

    @Test
    public void testMinutoCerto() throws Exception {
        setup();
        // 10h00 é o minuto 10 * 60 = 600
        assertEquals(600, dataFixa.minuto());
    }

    @Test(expected = Exception.class)
    public void testMinutoErrado() throws Exception {
        setup();
        dataErrada.minuto();
    }

    @Test
    public void testHoraCerto() throws Exception {
        setup();
        // Hora deve ser 10 (como configurado)
        assertEquals(10, dataFixa.hora());
    }

    @Test(expected = Exception.class)
    public void testHoraErrado() throws Exception {
        setup();
        // Hora deve ser 9
        dataErrada.hora();
    }

    @Test
    public void testSegundoCerto() throws Exception {
        setup();
        // 10h00m10s = 10*3600 + 10 = 36010 segundos desde meia-noite
        assertEquals(36010, dataSegundo.segundo());
    }

    @Test(expected = Exception.class)
    public void testSegundoErrado() throws Exception {
        setup();
        dataFixa.segundo();
    }
}
