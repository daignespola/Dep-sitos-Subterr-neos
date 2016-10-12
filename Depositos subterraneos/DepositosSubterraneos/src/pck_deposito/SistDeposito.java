package pck_deposito;

import java.io.File;
import java.util.Locale;
import java.util.Scanner;

public class SistDeposito {
	private double[] vecSuperficie;
	private int[] vecProfundidad;
	private int cantDepositos;
	private double volumenSolicitado;

	public SistDeposito(String ruta) {
		Locale.setDefault(new Locale("en", "us"));
		Scanner sc = null;
		try {
			sc = new Scanner(new File(ruta));
			this.cantDepositos = sc.nextInt();
			this.vecSuperficie = new double[this.cantDepositos];
			this.vecProfundidad = new int[this.cantDepositos];
			for (int i = 0; i < cantDepositos; i++) {
				this.vecSuperficie[i] = sc.nextDouble();
				this.vecProfundidad[i] = sc.nextInt();
			}
			this.volumenSolicitado = sc.nextDouble();
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				sc.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public String resolverSistema(){
		double acum = 0;
		for (int i = 0; i < cantDepositos; i++) {
			acum+= vecSuperficie[i]* vecProfundidad[i];
		}		
		if(volumenSolicitado > acum)
			return "Rebasan :"+ (volumenSolicitado - acum);
		//calcula la cantidad de depositos utilizados
		//double profundidadMax = vecProfundidad[cantDepositos -1];
		
		for (int i = vecProfundidad[cantDepositos -1]; i >=0; i--) {
			
		}
		
		
		return "Hola";
	}
}
