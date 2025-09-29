import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DataTest {

    private Data dataFixa;
    private Data dataErrada;
    private Data dataSegundo;
    private DateTime data2025_09_01;

    @Before
    public void setup() {
        data2025_09_01 = new DateTime(2025, 9, 1, 10, 0); // 1 set 2025, 10h00
        DateTime data2025_09_01_segundo = new DateTime(2025, 9, 1, 10, 0, 10); // 1 set 2025, 10h00m10s
        DateTime data2025_10_01 = new DateTime(2025, 10, 1, 9, 0); // 1 out 2025, 9h00
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
        dataErrada.dataAtual();
    }

    @Test
    public void testDataFormatadaCerto() throws Exception {
        assertEquals("01/09/2025", dataFixa.dataFormatada());
    }

    @Test(expected = Exception.class)
    public void testDataFormatadaErrado() throws Exception {
        dataErrada.dataFormatada();
    }

    @Test
    public void testDiaFuturoCerto() throws Exception {
        assertEquals("04/09/2025", dataFixa.diaFuturo(3));
    }

    @Test(expected = Exception.class)
    public void testDiaFuturoErrado() throws Exception {
        dataErrada.diaFuturo(3);
    }

    @Test
    public void testMinutoCerto() throws Exception {
        assertEquals(600, dataFixa.minuto()); // 10h00 => 600 minutos
    }

    @Test(expected = Exception.class)
    public void testMinutoErrado() throws Exception {
        dataErrada.minuto();
    }

    @Test
    public void testHoraCerto() throws Exception {
        assertEquals(10, dataFixa.hora());
    }

    @Test(expected = Exception.class)
    public void testHoraErrado() throws Exception {
        dataErrada.hora();
    }

    @Test
    public void testSegundoCerto() throws Exception {
        assertEquals(36010, dataSegundo.segundo());
    }

    @Test(expected = Exception.class)
    public void testSegundoErrado() throws Exception {
        dataFixa.segundo();
    }

    @Test
    public void testAnoCerto() throws Exception {
        assertEquals(2025, dataFixa.ano());
    }

    @Test(expected = Exception.class)
    public void testAnoErrado() throws Exception {
        dataErrada.ano();
    }

    @Test
    public void testMesCerto() throws Exception {
        assertEquals(9, dataFixa.mes());
    }

    @Test(expected = Exception.class)
    public void testMesErrado() throws Exception {
        dataErrada.mes();
    }

    @Test
    public void testDiaDoMesCerto() throws Exception {
        assertEquals(1, dataFixa.diaDoMes());
    }

    @Test(expected = Exception.class)
    public void testDiaDoMesErrado() throws Exception {
        dataErrada.diaDoMes();
    }

    @Test
    public void testDiaDaSemanaCerto() throws Exception {
        assertEquals("Monday", dataFixa.diaDaSemana());
    }

    @Test(expected = Exception.class)
    public void testDiaDaSemanaErrado() throws Exception {
        dataErrada.diaDaSemana();
    }

    @Test
    public void testIsFimDeSemanaFalse() {
        assertFalse(dataFixa.isFimDeSemana());
    }

    @Test
    public void testIsAntesDe() {
        assertTrue(dataFixa.isAntesDe(dataErrada));
    }

    @Test
    public void testIsDepoisDe() {
        assertTrue(dataErrada.isDepoisDe(dataFixa));
    }
}
