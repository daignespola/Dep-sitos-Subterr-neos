package pck_tests;

import java.util.List;

import org.junit.Test;

import pck_deposito.SistDeposito;

public class SistDepositoTest {
	@Test
	public void Caso1(){
		SistDeposito sis = new SistDeposito("entradaCaso1.in");
		List<String> res = sis.resolverSistema();
		for (String linea : res) {
			System.out.println(linea);
		}
	}
}
