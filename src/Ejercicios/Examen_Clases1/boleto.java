package Ejercicios.Examen_Clases1;

import java.util.*;


public class boleto {

	private static int boletos = 0;
	
	// ATRIBUTOS
	private int[] numeros = {0, 0, 0, 0, 0};
	private int[] fecha = {01, 01, 2019};
	
	// CONSTRUCTORES
	public boleto (){
		boolean ok = true;
		int i, j, aux = 0;
		
		for(i = 0; i < 5; i++){
			if(i > 0){
				do{
					ok = true;
					aux = (int)((Math.random()*50)+1);
					for(j = 0; j < i; j++){
						if(aux == this.numeros[i])	ok = false;
					}
				}while(ok == false);
				this.numeros[i] = aux;
			}
			else{
				this.numeros[i] = (int)((Math.random()*50)+1);
			}
		}
		
		Date d = new Date();
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(d);
		this.fecha[0] = c.get(Calendar.DAY_OF_MONTH);
		this.fecha[1] = c.get(Calendar.MONTH)+1;
		this.fecha[2] = c.get(Calendar.YEAR);
		
		boletos++;
	}
	
	public boleto(int[] num, int[] dia){
		
		for(int i = 0; i < 5; i++){
			if(i<3){
				this.fecha[i] = dia[i];
			}
			this.numeros[i] = num[i];
		}
		
		boletos++;
	}
	
	public int[] getFecha(){
		return this.fecha;
	}
	
	public int[] getNumeros(){
		return this.numeros;
	}
	
	public static int getVendidos(){
		return boletos;
	}
	
	public void mostrar_boleto(){
		System.out.print("Los numeros del boleto son: ");
		for(int i = 0; i < 5; i++){
			System.out.print(this.numeros[i] + " ");
		}
		System.out.println();
		
		System.out.println("La fecha del sorteo es: " + this.fecha[0] + "/" + this.fecha[1] + "/" + this.fecha[2]);
	}
	
	public static int vendidos(int[] dia, boleto[] todos){
		int total = 0;
		
		for(int i = 0; i < boletos; i++){
			if((todos[i].fecha[2] == dia[2])&&(todos[i].fecha[1] == dia[1])&&(todos[i].fecha[0] == dia[0])){
				total++;
			}
		}		
		
		return total;
	}
}
