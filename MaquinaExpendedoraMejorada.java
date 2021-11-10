public class MaquinaExpendedoraMejorada {
    
    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    // El n�mero de billetes vendidos
    private int numeroBilletesVendidos;
    // Billete con premio
    private boolean laMaquinaDaPremios;


    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino, boolean maquinaConPremio) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        numeroBilletesVendidos = 0;
        laMaquinaDaPremios = maquinaConPremio;
        
        }
    
    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }

    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if (cantidadIntroducida > 0) {
            balanceClienteActual = balanceClienteActual + cantidadIntroducida;
        }
        else {
            System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
        }        
    }

    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        int cantidadDeDineroQueFalta = precioBillete - balanceClienteActual;
        if (cantidadDeDineroQueFalta <= 0) {        
            // Simula la impresion de un billete
            System.out.println("##################");
            System.out.println("# Billete de tren:");
            System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
            System.out.println("# " + precioBillete + " euros.");
            System.out.println("##################");
            System.out.println();         
    
            // Actualiza el total de dinero acumulado en la maquina
            totalDineroAcumulado = totalDineroAcumulado + precioBillete;
            // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
            balanceClienteActual = balanceClienteActual - precioBillete;
            numeroBilletesVendidos = numeroBilletesVendidos +1 ;
            if (laMaquinaDaPremios == true){
                float billetePremiado = precioBillete * 0.1F;
                System.out.println("# Descuento del 10%  de cualquier producto de Mercadona"  + billetePremiado + " euros.");
            }
        }
        else {
           System.out.println("Necesitas introducir " + (cantidadDeDineroQueFalta) + " euros mas!" );
        }
    }
    
    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero() {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    } 
    
    /**
     * Todo el dinero que haya en la m�quina se vac�a
     */
    public int getVaciarDineroDeLaMaquina(){
        int variable=-1;
        if (balanceClienteActual == 0){
           int vaciarDineroDeLaMaquina = balanceClienteActual + totalDineroAcumulado;
            balanceClienteActual = 0;
            totalDineroAcumulado = 0;
            variable = totalDineroAcumulado;
           
        }
        else{ 
           System.out.println("No se vacio el dinero de la m�quina debido a que hay una operaci�n en curso");
        }
        return variable;
    }
    
    /**
     * Devuelve el n�mero de billetes vendidos desde el funcionamiento de la m�quina
     */
    public int getNumeroBilletesVendidos(){
        return numeroBilletesVendidos;
    }
    
    /**
     * Imprime por pantalla el n�mero de billetes vendidos desde la puesta en funcionamiento de la m�quina
     */
    public void imprimeNumeroBilletesVendidos(){
        System.out.println(numeroBilletesVendidos);
    }
    
    
}
