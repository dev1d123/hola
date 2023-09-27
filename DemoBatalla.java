import graphics.*;
import java.util.*;
public class DemoBatalla {
    public static void main(String [] args){
 		Nave [] misNaves = new Nave[10];
 		Scanner sc = new Scanner(System.in);
 		String nomb, col;
 		int fil, punt;
 		boolean est;

 		for (int i = 0; i < misNaves.length; i++) {
			System.out.println("Nave " + (i+1));
			System.out.print("Nombre: ");
			nomb = sc.next();
			System.out.println("Fila ");
			fil = sc.nextInt();
			System.out.print("Columna: ");
			col = sc.next();
			System.out.print("Estado: ");
			est = sc.nextBoolean();
			System.out.print("Puntos: ");
			punt = sc.nextInt();

			misNaves[i] = new Nave(); 

			misNaves[i].setNombre(nomb);
			misNaves[i].setFila(fil);
			misNaves[i].setColumna(col);
			misNaves[i].setEstado(est);
			misNaves[i].setPuntos(punt);
		} 
		System.out.println("\nNaves creadas:");
		Build prueba = new Build();
		prueba.printAll(misNaves);
		mostrarNaves(misNaves);
		System.out.println("Ingrese un nombre para buscar: ");
		String nombreBuscar = sc.next();
		mostrarPorNombre(misNaves, nombreBuscar);
		System.out.println("Ingrese un puntaje maximo para buscar: ");
		int puntajeBuscar = sc.nextInt();
		mostrarPorPuntos(misNaves, puntajeBuscar);
		System.out.println("\nNave con mayor número de puntos: " + mostrarMayorPuntos(misNaves));
		System.out.println("Areglo desordenado: ");
		Nave[] arrUnsorted = unsort(misNaves);
		mostrarNaves(arrUnsorted);


	}
	//Método para mostrar todas las naves
	public static void mostrarNaves(Nave [] flota){
		int i = 1;
		for(Nave n: flota){
			System.out.println("Nave " + i);
			System.out.println(n);
			i++;
		}
	}

	//Método para mostrar todas las naves de un nombre que se pide por teclado
	public static void mostrarPorNombre(Nave [] flota, String target){
		boolean isFind = false;
		for(int i = 0; i < flota.length; i++){
			if(flota[i].getNombre().equals(target)){
				isFind = true;
				System.out.println(flota[i]);
				break;
			}
		}
		if(!isFind){
			System.out.println("No se encontro la nave");
		}
	}

	//Método para mostrar todas las naves con un número de puntos inferior o igual
	//al número de puntos que se pide por teclado
	public static void mostrarPorPuntos(Nave [] flota, int lim){
		for(int i = 0; i < flota.length; i++){
			if(flota[i].getPuntos() <= lim){
				System.out.println(flota[i]);
			}
		}
	}

	//Método que devuelve la Nave con mayor número de Puntos
	public static Nave mostrarMayorPuntos(Nave [] flota){
		int max = flota[0].getPuntos();
		int maxIndex = 0;
		for(int i = 0; i < flota.length; i++){
			max = Math.max(max, flota[i].getPuntos());
			if(max == flota[i].getPuntos()){
				maxIndex = i;
			}
		}
		return (flota[maxIndex]);
	}
	//Crear un método que devuelva un nuevo arreglo de objetos con todos los objetos previamente ingresados
	//pero aleatoriamente desordenados
	public static Nave[] unsort(Nave[] flota){
		Nave[] sol = new Nave[flota.length];
		boolean[] pos = new boolean[flota.length];
		for(int i = 0; i < flota.length; i++){
			int nAle = (int)(Math.random()*flota.length);
			while(pos[nAle]){
				nAle = (int)(Math.random()*flota.length);
			}
			pos[nAle] = true;
			sol[nAle] = new Nave(flota[i].getNombre(), flota[i].getFila(), flota[i].getColumna(), flota[i].getEstado(), flota[i].getPuntos());
		}
		return sol;
	}
}

