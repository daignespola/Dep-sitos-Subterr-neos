package pck_deposito;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
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
	
	public List<String> resolverSistema(){
		double acum = 0;
		List<String> listaRes = new ArrayList<String>();
		
		for (int i = 0; i < cantDepositos; i++) {
			acum+= vecSuperficie[i]* vecProfundidad[i];
		}		
		if(volumenSolicitado > acum)
			listaRes.add("Rebasan :"+ (volumenSolicitado - acum));
		else 
			if(volumenSolicitado == acum){
				listaRes.add(""+cantDepositos);
				listaRes.add("0");
			}
			else{
				//calcula la cantidad de depositos utilizados
				acum = 0;
				double acumSup = 0;
				for (int i = 0; i < cantDepositos; i++) {
					acumSup+= vecSuperficie[i];
					double acumAnterior = acum;
					for (int j = 0; j <= i; j++) {
						if(i+1<cantDepositos)
							acum+= ((vecProfundidad[i]-vecProfundidad[i+1])*vecSuperficie[j]);
						else
							acum+=(vecProfundidad[i]*vecSuperficie[j]);
					}
					System.out.println("acum:"+acum);
					System.out.println("acumSup:"+acumSup);
					if (acum >=volumenSolicitado){
					//condición de corte, se va a pasar si usa otro tanque mas
						listaRes.add(""+(i+1));
						listaRes.add("" +(int)(vecProfundidad[i] - (Math.pow((volumenSolicitado - acumAnterior)/acumSup,1/(i+1)))));
						break;
					}
				}	
			}
		return listaRes;
	}
}
