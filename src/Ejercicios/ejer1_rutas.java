package Ejercicios;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Scanner;


public class ejer1_rutas {

	/*
	 * Programa que realiza las tareas solicitadas:
	 * 
	 * Escribir  un  programa  en  Java  que  para  cualquier  ruta  indicada  por  el  usuario,muestre:
	 * 
	 *    Si el fichero existe o no
	 *    Si se trata de un directorio o de un fichero
	 *    En caso de ser un fichero, debe mostrar los siguientes datos:
	 *   	o Nombre
	 *   	o Tamaño
	 *   	o Permisos de lectura y escritura
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @autor Pedro Daniel Pérez Sánchez
	 * 
	 * @fecha 07/03/2019
	 * 
	 * */
	

	//###### Metodos de Utilidad #####
	
	
	//Metodo: pedirle datos al usuario
	public static String getDato(String text,int parametro) {
		/*
		 * Parametro 1: Metodo devuelve un numero dado por el usuario
		 * en el rango [0-4], lo uso para la opción del menu
		 * 
		 * Parametro 2: Devuelve la siguiente palabra introducida por el usuario
		 * 
		 * Parametro 3: Devuelve un DNI valido
		 * 
		 * Parametro 4: Devuelve varias palabras en un String
		 * 
		 * Parametro 5: Devuelve un valor numerico dado por el usuario en un string
		 * 
		 * El metodo muestra por pantalla el texto que le pasemos 
		 * devuelve un string con la salida validada según el parametro pasado
		 * 
		 * */
		
		
		//Variables locales del metodo
		String auxs = "-"; //Variable auxiliar que almacena un strings
		int aux = 0; //Variable auxiliar que almacena un valor entero
		boolean v = false; //Flag que marca si el valor es valido o no
		
		//Declaro el objeto Scanner
		Scanner t = new Scanner(System.in);
		
		switch(parametro) {
		case 1: //Valor a solicitar: Entero positivo del 1 al 5
			do {
				
				try {
					//Doy por supuesto que el valor introducido es correcto
					v = true; 
					
					//Mostrar texto pasado por pantalla
					System.out.print(text);
					//Pido un numero entero
					aux = t.nextInt();
					
					//Si el rango no es correcto, repetimos el while
					if(aux<0||aux>5) {
						System.out.println("Debes introducir un numero en el rango [0-4]");
						v=false;
					}
				}
				catch(Exception e){
					System.out.println("¡El caracter introducido no es valido!");
					t.next();
					v=false;
				}
			}while(!v);
			
			auxs = Integer.toString(aux);
			break;
		case 2: //Valor a solicitar: Palabra introducida por el usuario
			do {
				
				try {
					//Doy por supuesto que el valor introducido es correcto
					v = true; 
					
					//Mostrar texto pasado por pantalla
					System.out.println(text);
					//Pido una Palabra entre 3 y 15 caracteres
					auxs = t.next();
					
					//Si el rango no es correcto, repetimos el while
					if(auxs.length()<3||auxs.length()>15) {
						System.out.println("Debes introducir una palabra entre 3 y 15 caracteres");
						v=false;
					}
					//Si hay un numero, lo volvemos a pedir
					for (int i = 0; i < auxs.length(); i++) {
						if((auxs.charAt(i)>=48)&&(auxs.charAt(i)<=57)) {
							i=auxs.length();
							System.out.println("Debes introducir una palabra entre 3 y 15 caracteres, no numeros");
							v=false;
							
						}
					}
					
					
				}
				catch(Exception e){
					System.out.println("¡La palabra introducida no es valida!");
					t.next();
					v=false;
				}
			}while(!v);
			
			break;
		case 3: //Devuelve un DNI en String 
			do {
				
				try {
					//Doy por supuesto que el valor introducido es correcto
					v = true; 
					
					//Mostrar texto pasado por pantalla
					System.out.println(text);
					//Pido una Palabra entre 3 y 15 caracteres
					auxs = t.next();
					
					//Si el rango no es correcto, repetimos el while
					if(auxs.length()<8||auxs.length()>9) {
						System.out.println("Debes introducir un DNI(Sin letra) de 8 Numeros enteros");
						v=false;
					}
					//Si hay un caracter, lo volvemos a pedir
					for (int i = 0; i < auxs.length(); i++) {
						if((auxs.charAt(i)>=48)&&(auxs.charAt(i)<=57)) {
							v=true;
							//Numero correcto
							
						}else { //Hay un caracter
							System.out.println("Debes introducir un DNI(Sin letra) de 8 Numeros enteros");
							i=auxs.length();
							v=false;							
							
						}
					}
					
				}
				catch(Exception e){
					System.out.println("¡El numero introducido no es valido!!");
					t.next();
					v=false;
				}
			}while(!v);
			break;
		case 4: //Parametro 4: Devuelve varias palabras en un String 
			do {
				
				try {
					//Doy por supuesto que el valor introducido es correcto
					v = true; 
					
					//Mostrar texto pasado por pantalla
					System.out.println(text);
					//Guardo la siguiente linea completa
					auxs = t.nextLine();
					
					//Si el rango no es correcto, repetimos el while
					if(auxs.length()<2) {
						System.out.println("Debes introducir un minimo de 2 caracteres para este elemento");
						v=false;
					}
					
				}
				catch(Exception e){
					System.out.println("¡El texto introducida no es valido!");
					t.next();
					v=false;
				}
			}while(!v);
			
			break;
			
		case 5: //Parametro 5: Devuelve un valor numerico dado por el usuario en un string
			do {
				
				try {
					//Doy por supuesto que el valor introducido es correcto
					v = true; 
					
					//Mostrar texto pasado por pantalla
					System.out.println(text);
					//Guardo la siguiente linea completa
					aux = t.nextInt();
					
					//Si el rango no es correcto, repetimos el while
					if(aux<=-1) {
						System.out.println("Debes introducir un valor positivo");
						v=false;
					}
					
				}
				catch(Exception e){
					System.out.println("¡El valor introducido no es valido!");
					t.next();
					v=false;
				}
			}while(!v);
			
			auxs = Integer.toString(aux);
			
			break;
		
		}
		
		
		
		//Devuelvo un String
		return auxs;
	}
	
	public static String pesoFichero(File archivo) {
		
		//Variables locales
		DecimalFormat df = new DecimalFormat("#.00");
		float longitud=archivo.length();
		String resultado="0";
		
		
		if(longitud>1024000000)
			resultado = df.format(longitud/1024000000) + " Gb";
		else if(longitud>1024000)
			resultado =  df.format(longitud/1024000) + " Mb";
		else if(longitud>1024)
			resultado = df.format(longitud/1024) + " Kb";
		else
			resultado = df.format(longitud) + " bytes";
		
		
		return resultado;
	}
	
	
	//Metodo del programa
	private static void programaRuta() {
		
		//Variables del metodo
		File archivo = null;
		String ruta = "mi ruta";
		boolean fin = false;
		
		do {
			
			//Inicio del metodo
			ruta = getDato("Dame la ruta relativa o absoluta del fichero: ",4); //Pido mi ruta
			
			if(ruta=="salir")	fin=true;
			
			//Creo un objeto File con mi ruta para usar su clase
			try {
				archivo = new File(ruta);			
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			try {
				//Compruebo si existe
				if(archivo.exists()) {
					//Si existe compruebo si es un archivo o un directorio
					if (archivo.isDirectory()) {
						System.out.println("¡Pasaste la ruta de un directorio!");
					} else {
						//Doy por hecho que es un archivo
						//Muestro por pantalla nombre, tamaño y permisos
						System.out.println("¡Hemos encontrado el archivo! :D");
						System.out.println();
						System.out.println("Nombre: "+archivo.getName());
						System.out.println("Tamaño: "+pesoFichero(archivo));
						System.out.print("Permisos: ");
						if (archivo.canRead())		{System.out.print("r");}else {System.out.print("-");}
						if (archivo.canWrite())		{System.out.print("w");}else {System.out.print("-");}
						if(archivo.canExecute())	{System.out.print("x");}else {System.out.print("-");}
						System.out.println();
						System.out.println();
						System.out.println("Leyenda: r = Lectura, w = escritura, x = ejecución");
						
					}
				}else {
					System.out.println("No encontramos nada en esa ruta (>_<) ");
				}
			}catch(Exception r) {
				r.printStackTrace();
			}
			
			System.out.println();
			System.out.println("Escribe 'salir' para salir o vuelve a introducir una ruta");
			System.out.println();
		}while(fin==false);
		
		
		
	}
	
	public static void main(String[] args) {

		// CABECERA DEL PROGRAMA 
		System.out.println("+--------------------------------------+");
		System.out.println("|                                      |");
		System.out.println("|    Trabajando con Ficheros :D  #1    |");
		System.out.println("|                                      |");
		System.out.println("|  08/03/2019            By Zoroboak   |");
		System.out.println("+--------------------------------------+");
		System.out.println();
		System.out.println();		
		
		programaRuta();

	}

}
