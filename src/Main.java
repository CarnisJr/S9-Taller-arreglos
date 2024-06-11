import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

    	int selector = 0;
    	
    	Parqueadero parqueadero = new Parqueadero();
    	
    	do {

    		System.out.println("1. Ingresar Auto");
    		System.out.println("2. Sacar Auto");
    		System.out.println("3. Mostrar dinero recaudado");
    		System.out.println("4. Mostrar puesto disponible");
    		System.out.println("5. Modificar Hora");
    		System.out.println("6. Modificar Tarifa");
    		System.out.println("7. Dar tiempo promedio");
    		System.out.println("8. Carro con mas de ocho horas");
    		System.out.println("9. Carros con mas de tres horas");
    		System.out.println("10. Carros con placa PB");
    		System.out.println("11. Vaciar parqueadero");

    		System.out.print("Ingresa la opcion que quieres realizar: ");
    		selector = scan.nextInt();
    		switch(selector) {

    		case 1:

    			ingresarCarro(parqueadero);
    		break;
    		
    		case 2:
    			
    			salidaCarro(parqueadero);
    		break;
    		
    		case 3:
    			
    			int ingresos = informarIngresosParqueadero(parqueadero);
    			System.out.println("Estos son los ingresos: " + ingresos);
    		break;
    		
    		case 4:
    			
    			puestosDisponibles(parqueadero);
    		break;
    		
    		case 5:

    			modificarHora(parqueadero);
    		break;
    		
    		case 6:

    			modificarTarifa(parqueadero);
    		break;
    		
    		case 7:

    			double tiempoPromedio = 0;
    			tiempoPromedio = parqueadero.darTiempoPromedio();
    			
    			System.out.println("El tiempo promedio es: " + tiempoPromedio);
    		break;

    		case 8:

    			Carro carroMasOchoHoras = parqueadero.carroMasOchoHoras();
    			
    			carroMasOchoHoras = parqueadero.carroMasOchoHoras();
    			if (carroMasOchoHoras != null) {

					System.out.println("El carro con la placa " + carroMasOchoHoras.darPlaca() + " ha pasado mas de ocho horas parqueado");
    		    } else {

    		        System.out.println("No hay ningún carro estacionado por más de ocho horas.");
    		    }
    		break;
    		
    		case 9:

    			ArrayList<Carro> listaCarrosMasTresHoras = new ArrayList<Carro>();
    			
    			listaCarrosMasTresHoras = parqueadero.darCarrosMasDeTresHorasPaqueados();
    			
    			for(Carro valorCarro : listaCarrosMasTresHoras) {
    				
    				System.out.println("El carro con placas " + valorCarro.darPlaca() + " esta parqueado mas de tres horas");
    			}
    			
    		break;
    		
    		case 10:

    			String mensaje = "";
    			mensaje = parqueadero.metodo1();
    			
    			System.out.println(mensaje);
    		break;

    		case 11:

    			String mensaje2 = "";
    			mensaje2 = parqueadero.metodo2();
    			
    			System.out.println(mensaje2);
    		break;

    		default:

    			System.out.println("No existe esta opcion");
    		break;
    		}
    		
    	}while(selector != 12);
    }
    
    public static void ingresarCarro(Parqueadero parqueadero) {
    	
		String matriculaCarro = "";

		System.out.println("Ingrese la placa del carro: ");
		matriculaCarro = scan.next();
		
		if(0 == parqueadero.entrarCarro(matriculaCarro)) {
			
			System.out.println("El carro se ingreso con exito");
		}
    }
    
    public static void salidaCarro(Parqueadero parqueadero) {
    	
		String matriculaCarro = "";
		int montoCancelar = 0;

		System.out.println("Ingrese la placa del carro: ");
		matriculaCarro = scan.next();
		montoCancelar = parqueadero.sacarCarro(matriculaCarro);
		
		if(montoCancelar > 0) {
			
			System.out.println("El monto a pagar para sacar el carro es: " + montoCancelar);
		}
    }
    
    public static int informarIngresosParqueadero(Parqueadero parqueadero) {
    
    	return parqueadero.darMontoCaja();
    }
    
    public static void puestosDisponibles(Parqueadero parqueadero) {

    	int numPuestoLibre = parqueadero.buscarPuestoLibre();
		if(numPuestoLibre > 0 ) {
			
			System.out.println("Si hay puestos libres: " + numPuestoLibre);
		}
    }
    
    public static void modificarHora(Parqueadero parqueadero) {
    	
		parqueadero.avanzarHora();
		System.out.println("Se avanzo la hora");
		System.out.println("Ahora son las: " + parqueadero.darHoraActual());
    }
    
    public static void modificarTarifa(Parqueadero parqueadero) {
    	
		int nuevaTarifa = 0;
		System.out.println("Ingrese la nueva tarifa: ");
		nuevaTarifa = scan.nextInt();
		parqueadero.cambiarTarifa(nuevaTarifa);
		System.out.println("La nueva tarifa del parqueadero es: " + parqueadero.darTarifa());
    }
}