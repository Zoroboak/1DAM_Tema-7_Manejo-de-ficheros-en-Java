package Ejercicios.Examen_Clases1;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class examen {

	final static int N = 100;
	
	public static void main(String[] args) {

		int i = 0, aux = 0, ventas = -1, ganadores = -1;
		sorteo primitiva, bonoloto;
		
		boleto[] todos = new boleto[N];
				
		try{
			System.out.println("EXAMEN DE CLASES");
			System.out.print("Autor: " + sorteo.autor());
			System.out.println();
		}
		catch(Exception e){
			System.out.println("Error en los argumentos de entrada de comando");
		}
		
		int[] dia = new int[3];
		Date d = new Date();
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(d);
		dia[0] = c.get(Calendar.DAY_OF_MONTH)+1;
		dia[1] = c.get(Calendar.MONTH)+1;
		dia[2] = c.get(Calendar.YEAR);

		try{
			for(i = 0; i < (N/2); i++){
				todos[i] = new boleto();
			}
		}catch(Exception e){
			System.out.println("Fallo al crear boletos aleatorios");
		}
		try{
			for(i = 0; i < (N/2-1); i++){
				todos[i+50] = new boleto(numeros(), dia);
			}
		}catch(Exception e){
			System.out.println("Fallo al crear boletos con parámetros");
		}
		
		System.out.println("\nMostramos 10 boletos al azar");
		
		for(i = 0; i < 10; i++){
			aux = (int) (Math.random()*(N-1));
			todos[aux].mostrar_boleto();
			System.out.println();
		}
		
		System.out.println("\nGeneramos el sorteo del día");
		dia[0]--;
		try{
			primitiva = new sorteo("Primitiva", dia);
		
		}catch(Exception e){
			System.out.println("Fallo al crear el sorteo");
			primitiva = new sorteo();
		}
		
		try{
			ventas = boleto.vendidos(dia, todos);
		}catch(Exception e){
			System.out.println("Fallo al obtener los boletos vendidos");
		}		
		
		try{
			ganadores = primitiva.checkSorteo(todos, boleto.getVendidos());
		}catch(Exception e){
			System.out.println("Fallo al obtener los boletos ganadores");
		}
		
		try{
			sorteo.mostrarSorteo(primitiva, ganadores, ventas);
		}catch(Exception e){
			System.out.println("Fallo al mostrar el sorteo");
		}
		
		try{
			System.out.println();
			System.out.println("\nGeneramos el sorteo de mañana");
			dia[0]++;
			bonoloto = new sorteo("Bonoloto", dia);
			
			ventas = boleto.vendidos(dia, todos);
			ganadores = bonoloto.checkSorteo(todos, boleto.getVendidos());
			
			sorteo.mostrarSorteo(bonoloto, ganadores, ventas);
			
			System.out.println();
			System.out.println("Hago un ganador");
			int[] gano = bonoloto.getResultado();
			todos[99] = new boleto(gano, dia);
			
			ventas = boleto.vendidos(dia, todos);
			ganadores = bonoloto.checkSorteo(todos, boleto.getVendidos());
			
			sorteo.mostrarSorteo(bonoloto, ganadores, ventas);		
		}catch(Exception e){
			System.out.println("Fallo en el segundo caso");
		}
	}
	
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

}
