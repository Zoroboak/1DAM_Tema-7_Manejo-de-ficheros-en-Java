package Ejercicios.Examen_Clases1;

import java.text.DecimalFormat;


public class sorteo {
	
	final static double premio_inicial = 1050.20;
	
	// ATRIBUTOS
	private String nombre = "Sorteo";
	private int[] fecha = {01, 01, 2019};
	private double premio = premio_inicial;
	private int[] resultado = {0, 0, 0, 0, 0};
	
	
	// CONSTRUCTORES
	public sorteo(String name, int[] dia){
		this.nombre = name;
		
		for(int i = 0; i < 3; i++){
			this.fecha[i] = dia[i];
		}
		
		this.premio = premio_inicial;
		
		this.resultado = numeros();
	}
	
	public sorteo() {
		
	}

	// METODOS
	private static int[] numeros(){
		boolean ok = true;
		int i, j, aux = 0;
		int[] n = new int[5];
		
		for(i = 0; i < 5; i++){
			if(i > 0){
				do{
					ok = true;
					aux = (int)((Math.random()*50)+1);
					for(j = 0; j < i; j++){
						if(aux == n[i])	ok = false;
					}
				}while(ok == false);
				n[i] = aux;
			}
			else{
				n[i] = (int)((Math.random()*50)+1);
			}
		}	
		
		return n;
	}
	
	public static void mostrarSorteo(sorteo jugado, int ganadores, int vendidos){
		
		DecimalFormat formato = new DecimalFormat("#.00");
		
		System.out.println("Nombre del Sorteo: " + jugado.nombre);
		System.out.println("Fecha de celebración: " + jugado.fecha[0] + "/" + jugado.fecha[1] + "/" + jugado.fecha[2]);
		System.out.print("Números agraciados: ");
		for(int i = 0; i < 5; i++){
			System.out.print(jugado.resultado[i] + " ");
		}
		System.out.println("\nBoletos Vendidos: " + vendidos);
		System.out.println("Boletos Acertantes: " + ganadores);
		if(ganadores != 0)
			System.out.println("Premio Repartido: " + formato.format(jugado.premio) + "€") ;
		else
			System.out.println("Premio Acumulado: " + formato.format(jugado.premio) + "€");
	}
	
	public int checkSorteo(boleto[] jugados, int boletos){
		int ganadores = 0, i, j, k, cont;
		int[] dia = new int[3];
		int[] num = new int[5];
		
		for(i = 0; i < boletos; i++){
			dia = jugados[i].getFecha();
			if((this.fecha[2] == dia[2])&&(this.fecha[1] == dia[1])&&(this.fecha[0] == dia[0])){
				num = jugados[i].getNumeros();
				cont = 0;
				for(j = 0; j < 5; j++){
					for(k = 0; k < 5; k++){
						if(this.resultado[j] == num[k]){
							cont++;
						}
					}
				}
				if(cont == 5) ganadores++;
			}
		}
		
		if(ganadores == 0)	this.premio += premio_inicial;	
		
		return ganadores;		
	}
	
	public int[] getResultado(){
		return this.resultado;
	}
	
	public static String autor(){
		return "Alejandro Fernández Blanco";
	}

}
