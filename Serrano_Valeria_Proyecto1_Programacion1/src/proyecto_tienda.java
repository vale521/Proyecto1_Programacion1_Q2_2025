
package proyect1;
import java.util.Scanner;
public class proyecto_tienda {
//Valeria Serrano 25511083
    public static void main(String[] args) {
        // TODO code application logic here
          Scanner lea =new Scanner(System.in);
    lea.useDelimiter ("\n");
    //
    //Declarar variables de caja
    int opcion=0 ;
    String preguntaCierre = "no";
    String preguntaAbrir = "no";
    String preguntaIngresar;
    boolean habilitarCaja=false;
    boolean sesion=true;
    boolean cajaFueCerrada=false;
    //dinero
    double efectivoCaja = 0;
    double efectivoDeposito = 0;
    double efectivoIngresado = 0;
    //ventas
    double subtotal = 0;
    double totalVentas = 0;
    double totalCompras = 0;
    //contadores de ventas y compras
    int num_ventas =0;
    int num_compras =0;
    double volumen_ventas=0;
    double volumen_compras=0;
    //contadores de cantidad total de kg
    double Cant_Codigo1_Total = 0;
    double Cant_Codigo2_Total= 0;
    double Cant_Codigo3_Total= 0;
    double Cant_Codigo4_Total= 0;
    //contadores de productos comprados a proveedor
    double azucar_comprada=0;
    double avena_comprada=0;
    double trigo_comprado=0;
    double maiz_comprado=0;
    //mayor ganancia venta
    double mayorGananciaVenta=0;
    String descripcionVenta="";
    //mayor gasto compra
    double mayorGastoCompra=0;
    String descripcionCompra="";    
    
    do
    {//se repite hasta salir
    System.out.println("\n=============================================================================================================");  
    System.out.println("-------------------------------------------- BIENVENIDO A TIENDA --------------------------------------------");    
    System.out.println("---------------------------------------------  MENÚ PRINCIPAL  ---------------------------------------------");
    System.out.println("Elige una de las siguientes opciones: \n    1) Abrir Caja \n    2) Venta \n    3) Compra \n    4) Reportes \n    5) Cierre de Caja \n    6)Salir");
    do
    {
    System.out.print("Opción: ");
    if (lea.hasNextInt())// para ver si opcion es un numero
    {
    opcion =lea.nextInt();
        if (opcion<1 || opcion>6)// si lo es, ver si no esta en el rango del menu
        {
            System.out.println("Opción no válida. \nIngrese una opción de MENÚ PRINCIPAL.");
        }
    }else// sino es un numero 
    {
        System.out.println("Error. \nIngresar opción válida del MENÚ PRINCIPAL (Sin simbolos o letras).");
        System.out.println("Intentalo nuevamente.");
        lea.next();//limpiar bufer
        opcion=0;//igualo a cero para que vuelva a hacer el while
    }
    }while (opcion<1 || opcion>6);
    System.out.println("=============================================================================================================");  
    
    switch (opcion) 
    {
    
        case 1:
        //variable de validación de efectivo
            
        // ver como hacer para que si se abre caja nueva se reinicien los datos
        System.out.println("\n=============================================================================================================");
        System.out.println("------------------------------------------ BIENVENIDO A ABRIR CAJA ------------------------------------------");         
        if (habilitarCaja == true) //proceso cuando habilitar caja es true
        {
            System.out.println("----------------------------------------- LA CAJA YA ESTÁ ABIERTA. ------------------------------------------");
            System.out.print("¿Desea ingresar más efectivo? (si/no): ");
            preguntaIngresar = lea.next();
            if (preguntaIngresar.equalsIgnoreCase("si") || preguntaIngresar.equalsIgnoreCase("s"))
            {
                do
                {
                    do
                    {
                    System.out.print("¿Cuánto efectivo desea ingresar? ");
                        if (lea.hasNextDouble()) //ver si es double
                        {
                            efectivoIngresado = lea.nextDouble();
                            if (efectivoIngresado <= 0) //si es asi ver si no supera es 0
                            {
                            System.out.println("----------------------------------- DEBE INGRESAR UNA CANTIDAD MAYOR A 0. -----------------------------------");
                            efectivoIngresado = 0;//iguala a cero para continuar el while
                            }
                        }
                        else //no es un numero
                        {
                            System.out.println("------------------------------------------ DEBE INGRESAR UN NÚMERO. -----------------------------------------");
                            lea.next();// descarta la entrada invalida cuando no es un numero(limpiar bufer)
                            efectivoIngresado = 0;//iguala a cero para continuar el while
                        }
                    } while (efectivoIngresado <= 0);//hacer mientras efectivo sea menor igual a 0
                    
                    efectivoCaja += efectivoIngresado;//suma los efectivos ingresados a caja
                    System.out.println("Efectivo en caja: Lps. " + String.format("%.2f", efectivoCaja));
                    do
                    {
                        System.out.print("¿Desea ingresar más efectivo? (si/no): ");
                        preguntaIngresar = lea.next(); //para ver si quiere ingresar mas efectivo sino ahi termina y muestra efectivo caja del dia

                        if (!preguntaIngresar.equalsIgnoreCase("si") && !preguntaIngresar.equalsIgnoreCase("s") //si no es igual a esta opciones se imprime opcion no valida y vuelve a preguntar
                                && !preguntaIngresar.equalsIgnoreCase("no") && !preguntaIngresar.equalsIgnoreCase("n"))
                        {
                            System.out.println("--------------------------------------------- OPCIÓN NO VÁLIDA. ---------------------------------------------");
                            System.out.println("INTENTA CON: (si/s) o (no/n)");
                        }

                    } while (!preguntaIngresar.equalsIgnoreCase("si") && !preguntaIngresar.equalsIgnoreCase("s")
                            && !preguntaIngresar.equalsIgnoreCase("no") && !preguntaIngresar.equalsIgnoreCase("n"));

                } while (preguntaIngresar.equalsIgnoreCase("si") || preguntaIngresar.equalsIgnoreCase("s"));
                
                System.out.println("-------------------------------------------------------------------------------------------------------------");
                System.out.println("EFECTIVO EN CAJA DEL DÍA: Lps. " + String.format("%.2f", efectivoCaja));
            }
            else// si dice no solo se vuelve a proyectar cuanto tiene en caja
            {
                System.out.println("-------------------------------------------------------------------------------------------------------------");
                System.out.println("EFECTIVO EN CAJA DEL DÍA: Lps. " + String.format("%.2f", efectivoCaja));
            }
        } 
        else //si no esta abierta caja despues del cierre
        {
            if (cajaFueCerrada) // Si fue cerrada anteriormente, no pide efectivo
            {
                habilitarCaja = true;
                cajaFueCerrada = false;
                System.out.println("=============================================================================================================");
                System.out.println("------------------------- CAJA REABIERTA. Todos los contadores han sido reiniciados. ------------------------");
                System.out.println("EFECTIVO EN CAJA DEL DÍA: Lps. " + String.format("%.2f", efectivoCaja));
                // Reiniciar contadores y acumuladores
                subtotal = 0; totalVentas = 0;  totalCompras = 0;  mayorGananciaVenta = 0; num_ventas=0;
                num_compras=0;volumen_ventas=0; volumen_compras=0; mayorGastoCompra = 0;
                descripcionVenta = ""; descripcionCompra = "";
            }
            else // Primera vez que se abre la caja (inicio del sistema)
            {
                System.out.print("¿Desea abrir la caja? (si/no): ");
                preguntaAbrir = lea.next();

                if (preguntaAbrir.equalsIgnoreCase("si") || preguntaAbrir.equalsIgnoreCase("s")) 
                {
                    System.out.println("-------------------------------------------------------------------------------------------------------------");
                    do 
                    {
                        do 
                        {//se repite proceso de cuando caja esta abierta
                            System.out.print("¿Cuánto efectivo desea ingresar? ");

                            if (lea.hasNextDouble()) 
                            {
                                efectivoIngresado = lea.nextDouble();

                                if (efectivoIngresado <= 0) 
                                {
                                System.out.println("----------------------------------- DEBE INGRESAR UNA CANTIDAD MAYOR A 0. -----------------------------------");
                                efectivoIngresado = 0;
                                }
                            } 
                            else 
                            {
                                System.out.println("----------------------------------------- DEBE INGRESAR UN NÚMERO. ------------------------------------------");
                                lea.next();
                                efectivoIngresado = 0;
                            }

                        } while (efectivoIngresado <= 0);

                        efectivoCaja += efectivoIngresado;
                        System.out.println("Efectivo en caja: Lps. " + String.format("%.2f", efectivoCaja));
                        do 
                        {
                        System.out.print("¿Desea ingresar más efectivo? (si/no): ");
                        preguntaIngresar = lea.next();

                            if (!preguntaIngresar.equalsIgnoreCase("si") && !preguntaIngresar.equalsIgnoreCase("s") &&
                                !preguntaIngresar.equalsIgnoreCase("no") && !preguntaIngresar.equalsIgnoreCase("n")) 
                            {
                            System.out.println("--------------------------------------------- OPCIÓN NO VÁLIDA ----------------------------------------------");
                            System.out.println("INTENTA CON: (si/s) o (no/n)");
                            }

                        } while (!preguntaIngresar.equalsIgnoreCase("si") && !preguntaIngresar.equalsIgnoreCase("s") &&
                                 !preguntaIngresar.equalsIgnoreCase("no") && !preguntaIngresar.equalsIgnoreCase("n"));

                    } while (preguntaIngresar.equalsIgnoreCase("si") || preguntaIngresar.equalsIgnoreCase("s"));

                    habilitarCaja = true;
                    System.out.println("-------------------------------------------------------------------------------------------------------------");
                    System.out.println("Caja abierta correctamente. Efectivo actual: Lps. " + String.format("%.2f", efectivoCaja));
                } 
                else if (preguntaAbrir.equalsIgnoreCase("no") || preguntaAbrir.equalsIgnoreCase("n")) 
                {
                    System.out.println("------------------------------------------- LA CAJA NO SE ABRIÓ ---------------------------------------------");
                    habilitarCaja = false;
                } 
                else //si es diferente a si o no se regresa al menu para que el usuario vuelva a intentar desde el comienzo
                {
                    System.out.println("---------------------------------------------- OPCIÓN NO VÁLIDA ---------------------------------------------");
                    System.out.println("--------------------------------- Intenta otra vez desde el MENÚ PRINCIPAL. ---------------------------------");
                }
            }
        }
        System.out.println("=============================================================================================================");

        break;
        case 2:
            // declarar e inicializar variables
            String tipo_Venta;
            String preguntaComprar;
            String producto = ""; 
            String volverAcomprar="";
            int codigoProducto_Venta =0;
            double KilogramosComprados = 0;
            //contadores de cantidad  de kg
            double Cant_Codigo1 = 0;
            double Cant_Codigo2= 0;
            double Cant_Codigo3= 0;
            double Cant_Codigo4= 0;
            //variables de facturaciòn
            double precio = 0;
            double descuento=0;
            double impuesto;
            double total=0;
            if (habilitarCaja==true && (azucar_comprada>0 || avena_comprada>0 || trigo_comprado>0 || maiz_comprado>0))
            {
            System.out.println("\n=============================================================================================================");                
            System.out.println("--------------------------------------------- BIENVENIDO VENTAS ---------------------------------------------");
            System.out.println("=============================================================================================================");                
            System.out.println("\n=============================================================================================================");                
            System.out.println("---------------------------------------------- TIPO DE CLIENTE ----------------------------------------------");
            System.out.println("Elige un tipo de cliente: \n    a) Tipo A (Puede comprar cualquier producto) \n    b) Tipo B (Puede comprar solo el  producto con código 1,2,3)  \n    c) Tipo C (Puede solo el  producto con código ");
            
            do
            {
            System.out.print("\nIngrese Tipo de Cliente (a,b,c): ");  //preguntas tipo prooveedor (tipo_Compra)          
            if (lea.hasNext("[a-zA-Z]+")) //ver si las entradas son solamente letras
            {
            tipo_Venta =lea.next(); //true pasa a leer
                    //para ver si esta entrada no es igual a "a","b" y "c", manda es mensaje y luego vuelve a pregunar el tipo.Sino ya no se repite y continua es proceso normal.
                if (!tipo_Venta.equalsIgnoreCase("a") && !tipo_Venta.equalsIgnoreCase("b") && !tipo_Venta.equalsIgnoreCase("c"))
                {
                        System.out.println("Opción no válida. \nIngrese una opción de MENÚ TIPO VENTAS.");
                        System.out.println("Intentalo nuevamente. ");
                        tipo_Venta =""; //reinicia el tipo_Venta para que vuelva a entrar en el while  
                }
            }
            else //si incluye simbolos, espacios o numeros pasa a else
            {
                    System.out.println("Error. \nIngresar opción válida del MENÚ TIPO VENTAS (Sin simbolos, espacios o numeros).");
                    System.out.println("Intentalo nuevamente. ");
                    lea.next();
                    tipo_Venta =""; //reinicia el tipo_Venta para que vuelva a entrar en el while  
            }
            }while (!tipo_Venta.equalsIgnoreCase("a") && !tipo_Venta.equalsIgnoreCase("b") && !tipo_Venta.equalsIgnoreCase("c") ); //repetir si tipo_Venta no es igual a "a","b" y "c".
            System.out.println("=============================================================================================================");                

            do
            {
            if (tipo_Venta.equalsIgnoreCase("a") || tipo_Venta.equals("1") )
            {
                do
                {
                System.out.println("\n=============================================================================================================");                
                System.out.println("---------------------------------------- MENÚ DE PRODUCTOS (TIPO A) -----------------------------------------");
                System.out.println("=============================================================================================================");                
                System.out.println("Elige una de las siguientes opciones: -- Código -- -- Producto -- -- Precio Venta -- -- Cantidad Existente--");
                System.out.println("                                            1          Azúcar           Lps.  30              "+azucar_comprada+" Kg.");
                System.out.println("                                            2           Avena            Lps.  25              "+avena_comprada+" Kg.");
                System.out.println("                                            3           Trigo            Lps.  32              "+trigo_comprado+" Kg.");
                System.out.println("                                            4           Maíz            Lps.  20               "+maiz_comprado+" Kg.");
                
                System.out.print("Ingrese código del producto: ");
                codigoProducto_Venta = lea.nextInt();
                
                if (codigoProducto_Venta==1 || codigoProducto_Venta==2 || codigoProducto_Venta==3 || codigoProducto_Venta==4) //si es uno de estos productos continua
                {
                if (codigoProducto_Venta==1) 
                {   
                    boolean cantidadPermitida=false; //se repite miestras sea false
                    do
                    {
                    if (azucar_comprada==0) //si es igual a cero no hay disponible
                    {
                        System.out.println("No hay azucar disponible en el inventario.");
                        System.out.println("subtotal:  "+subtotal);                        
                        break;
                    }  
                    else //en otro caso preguntar cuanto quiere
                    {
                        
                    System.out.println("¿Cuántos kilogramos desea comprar? ");
                        if (lea.hasNextDouble())// si es double
                        {
                        KilogramosComprados = lea.nextDouble(); //darle lo ingresado a kgcomprados

                            if (KilogramosComprados<=0)//kg menor o igual a 0 error
                            {
                                KilogramosComprados=0;
                                System.out.println("Error. Cantidad no válida. Intenta con un número mayor a 0.");
                            } 
                            else if (KilogramosComprados>azucar_comprada) //kg menor a cuanto se compro del producto error
                            {
                                KilogramosComprados=0;
                                System.out.println("Lo sentimos. No hay suficiente producto en inventario.");
                                break;
                            }
                            else //en otro caso si lo permite y realiza el proceso de compra
                            {
                                cantidadPermitida=true;
                                Cant_Codigo1 = Cant_Codigo1 + KilogramosComprados;
                                precio= 30;
                                azucar_comprada -= KilogramosComprados;//restar los kg a los kg comprados del stock
                                subtotal += KilogramosComprados * precio;
                                double ganancia=KilogramosComprados * precio;//almacena solo la ganancia de esa compra
                                if (ganancia>mayorGananciaVenta)//ver si ganancia es mayor mayorgananciaventa entonces se convierte en mayor ganancia venta junto con que producto es
                                {
                                    mayorGananciaVenta=ganancia;
                                    descripcionVenta="Azucar";
                                }
                            }
                        }
                        else // si no es double error
                        {
                            System.out.println("Error. Debe de ingresar un número.");
                            lea.next();
                            KilogramosComprados=0;
                        }
                    }
                    } while (cantidadPermitida==false); //permanece false mientras ingrese valor equivocado a kg

                } 
                else if (codigoProducto_Venta ==2) //mismo proceso del codigo1
                {
                    boolean cantidadPermitida=false;
                    do
                    {
                    if (avena_comprada==0)
                    {
                        System.out.println("No hay avena disponible en el inventario.");
                        break;
                    }  
                    else
                    {
                        
                    System.out.println("¿Cuántos kilogramos desea comprar? ");
                    
                        if (lea.hasNextDouble())
                        {
                        KilogramosComprados = lea.nextDouble();

                            if (KilogramosComprados<=0)
                            {
                                KilogramosComprados=0;
                                System.out.println("Error. Cantidad no válida. Intenta con un número mayor a 0.");
                            } 
                            else if (KilogramosComprados>avena_comprada)
                            {
                                KilogramosComprados=0;
                                System.out.println("Lo sentimos. No hay suficiente producto en inventario.");
                                break;
                            }
                            else
                            {
                                cantidadPermitida=true;
                                Cant_Codigo2 = Cant_Codigo2 + KilogramosComprados;
                                precio= 25;
                                avena_comprada -= KilogramosComprados;
                                subtotal += KilogramosComprados * precio;
                                double ganancia=KilogramosComprados * precio;
                                if (ganancia>mayorGananciaVenta)
                                {
                                    mayorGananciaVenta=ganancia;
                                    descripcionVenta="Avena";
                                }
                            }
                        }
                        else
                        {
                            System.out.println("Error. Debe de ingresar un número.");
                            lea.next();
                            KilogramosComprados=0;
                        }
                        
                    }
                    } while (cantidadPermitida==false);
                } 
                else if (codigoProducto_Venta ==3) //mismo proceso del codigo1
                {
                    boolean cantidadPermitida=false;
                    do
                    {
                    if (trigo_comprado==0)
                    {
                        System.out.println("No hay trigo disponible en el inventario.");
                        break;
                    }  
                    else
                    {  
                    System.out.println("¿Cuántos kilogramos desea comprar? ");
                    
                        if (lea.hasNextDouble())
                        {
                        KilogramosComprados = lea.nextDouble();

                            if (KilogramosComprados<=0)
                            {
                                KilogramosComprados=0;
                                System.out.println("Error. Cantidad no válida. Intenta con un número mayor a 0.");
                            } 
                            else if (KilogramosComprados>trigo_comprado)
                            {
                                KilogramosComprados=0;
                                System.out.println("Lo sentimos. No hay suficiente producto en inventario.");
                                System.out.println("subtotal:  "+subtotal);
                                break;
                            }
                            else
                            {
                                cantidadPermitida=true;
                                Cant_Codigo3 = Cant_Codigo3 + KilogramosComprados;
                                precio= 32;
                                trigo_comprado -= KilogramosComprados;
                                subtotal += KilogramosComprados * precio;
                                double ganancia=KilogramosComprados * precio;
                                if (ganancia>mayorGananciaVenta)
                                {
                                    mayorGananciaVenta=ganancia;
                                    descripcionVenta="Trigo";
                                }
                            }
                        }
                        else
                        {
                            System.out.println("Error. Debe de ingresar un número.");
                            lea.next();
                            KilogramosComprados=0;
                        }
                    }
                    } while (cantidadPermitida==false);
                } 
                else if (codigoProducto_Venta ==4) //mismo proceso del codigo1
                {
                    boolean cantidadPermitida=false;
                    do
                    {
                    if (maiz_comprado==0)
                    {
                        System.out.println("No hay maiz disponible en el inventario.");
                        break;
                    }  
                    else
                    {  
                    System.out.println("¿Cuántos kilogramos desea comprar? ");
                        if (lea.hasNextDouble())
                        {
                        KilogramosComprados = lea.nextDouble();

                            if (KilogramosComprados<=0)
                            {
                                KilogramosComprados=0;
                                System.out.println("Error. Cantidad no válida. Intenta con un número mayor a 0.");
                            } 
                            else if (KilogramosComprados>maiz_comprado)
                            {
                                KilogramosComprados=0;
                                System.out.println("Lo sentimos. No hay suficiente producto en inventario para venta.");
                                break;
                            }
                            else
                            {
                                cantidadPermitida=true;
                                Cant_Codigo4 = Cant_Codigo4+ KilogramosComprados;
                                precio= 20;
                                maiz_comprado -= KilogramosComprados;
                                subtotal += KilogramosComprados * precio;
                                double ganancia= KilogramosComprados * precio;
                                if (ganancia>mayorGananciaVenta)
                                {
                                    mayorGananciaVenta=ganancia;
                                    descripcionVenta="Maiz";
                                }
                            }
                        }
                        else
                        {
                            System.out.println("Error. Debe de ingresar un número.");
                            lea.next();
                            KilogramosComprados=0;
                            subtotal += KilogramosComprados * precio;
                        }
                        
                    }
                    } while (cantidadPermitida==false);
                    
                } 
                else 
                {
                    System.out.println("Código no válido.");
                }
                    System.out.println("¿Desea comprar otro producto? (si/no)");
                    volverAcomprar= lea.next();
                }       
            }while (volverAcomprar.equalsIgnoreCase("si") || volverAcomprar.equals("Si") || volverAcomprar.equals("sI") || volverAcomprar.equalsIgnoreCase("s"));
            
            } 
            else if (tipo_Venta.equalsIgnoreCase("b") || tipo_Venta.equalsIgnoreCase("2") )
            {
                do
                {
                System.out.println("\n=============================================================================================================");                
                System.out.println("---------------------------------------- MENÚ DE PRODUCTOS (TIPO B) -----------------------------------------");
                System.out.println("=============================================================================================================");                
                System.out.println("Elige una de las siguientes opciones: -- Código -- -- Producto -- -- Precio Venta -- -- Cantidad Existente--");
                System.out.println("                                            1          Azúcar           Lps.  30              "+azucar_comprada+" Kg.");
                System.out.println("                                            2           Avena            Lps.  25              "+avena_comprada+" Kg.");
                System.out.println("                                            3           Trigo            Lps.  32             "+trigo_comprado+" Kg.");
                //se hace lo mismo que en el ipo a solo exeptuando codigo4
                System.out.print("Ingrese código del producto: ");
                codigoProducto_Venta = lea.nextInt();
                if (codigoProducto_Venta==1 || codigoProducto_Venta==2 || codigoProducto_Venta==3) 
                {
                // descripción codigo, nombre, precio
                if (codigoProducto_Venta ==1) 
                {
                    boolean cantidadPermitida=false;
                    do
                    {
                    if (azucar_comprada==0)
                    {
                        System.out.println("No hay azucar disponible en el inventario.");
                        break;
                    }  
                    else
                    { 
                    System.out.println("¿Cuántos kilogramos desea comprar? ");
                        if (lea.hasNextDouble())
                        {
                        KilogramosComprados = lea.nextDouble();
                            if (KilogramosComprados<=0)
                            {
                                KilogramosComprados=0;
                                System.out.println("Error. Cantidad no válida. Intenta con un número mayor a 0.");
                            } 
                            else if (KilogramosComprados>azucar_comprada)
                            {
                                KilogramosComprados=0;
                                System.out.println("Lo sentimos. No hay suficiente producto en inventario.");
                                break;
                            }
                            else
                            {
                                cantidadPermitida=true;
                                Cant_Codigo1 = Cant_Codigo1 + KilogramosComprados;
                                precio= 30;
                                azucar_comprada -= KilogramosComprados;
                                subtotal += KilogramosComprados * precio;
                                double ganancia=KilogramosComprados * precio;
                                if (ganancia>mayorGananciaVenta)
                                {
                                    mayorGananciaVenta=ganancia;
                                    descripcionVenta="Azucar";
                                }
                            }
                        }
                        else
                        {
                            System.out.println("Error. Debe de ingresar un número.");
                            lea.next();
                            KilogramosComprados=0;
                        }
                    }
                    } while (cantidadPermitida==false);

                } 
                else if (codigoProducto_Venta ==2) 
                {
                    boolean cantidadPermitida=false;
                    do
                    {
                    if (avena_comprada==0)
                    {
                        System.out.println("No hay avena disponible en el inventario.");
                        break;
                    }  
                    else
                    {
                    System.out.println("¿Cuántos kilogramos desea comprar? ");
                        if (lea.hasNextDouble())
                        {
                        KilogramosComprados = lea.nextDouble();
                            if (KilogramosComprados<=0)
                            {
                                KilogramosComprados=0;
                                System.out.println("Error. Cantidad no válida. Intenta con un número mayor a 0.");
                            } 
                            else if (KilogramosComprados>avena_comprada)
                            {
                                KilogramosComprados=0;
                                System.out.println("Lo sentimos. No hay suficiente producto en inventario.");
                                break;
                            }
                            else
                            {
                                cantidadPermitida=true;
                                Cant_Codigo2= Cant_Codigo2 + KilogramosComprados;
                                precio= 25;
                                avena_comprada -= KilogramosComprados;
                                subtotal += KilogramosComprados * precio;
                                double ganancia=KilogramosComprados * precio;
                                if (ganancia>mayorGananciaVenta)
                                {
                                    mayorGananciaVenta=ganancia;
                                    descripcionVenta="Avena";
                                }
                            }
                        }
                        else
                        {
                            System.out.println("Error. Debe de ingresar un número.");
                            lea.next();
                            KilogramosComprados=0;
                        }
                    }
                    } while (cantidadPermitida==false);
                } 
                else if (codigoProducto_Venta ==3) 
                {
                    boolean cantidadPermitida=false;
                    do
                    {
                    if (trigo_comprado==0)
                    {
                        System.out.println("No hay trigo disponible en el inventario.");
                        break;
                    }  
                    else
                    {  
                    System.out.println("¿Cuántos kilogramos desea comprar? ");
                    
                        if (lea.hasNextDouble())
                        {
                        KilogramosComprados = lea.nextDouble();
                            if (KilogramosComprados<=0)
                            {
                                KilogramosComprados=0;
                                System.out.println("Error. Cantidad no válida. Intenta con un número mayor a 0.");
                            } 
                            else if (KilogramosComprados>trigo_comprado)
                            {
                                KilogramosComprados=0;
                                System.out.println("Lo sentimos. No hay suficiente producto en inventario.");
                                break;
                            }
                            else
                            {
                                cantidadPermitida=true;
                                Cant_Codigo3 = Cant_Codigo3 + KilogramosComprados;
                                precio= 32;
                                trigo_comprado -= KilogramosComprados;
                                subtotal += KilogramosComprados * precio;
                                double ganancia=KilogramosComprados * precio;
                                if (ganancia>mayorGananciaVenta)
                                {
                                    mayorGananciaVenta=ganancia;
                                    descripcionVenta="Trigo";
                                }                            
                            }
                        }
                        else
                        {
                            System.out.println("Error. Debe de ingresar un número.");
                            lea.next();
                            KilogramosComprados=0;
                            
                        }
                    }
                    } while (cantidadPermitida==false);
                    
                } 
                else if (codigoProducto_Venta ==4) 
                {
                    System.out.println("No puede comprar este producto.");
                } 
                else 
                {
                    System.out.println("Código no válido.");
                }

            System.out.println("¿Desea comprar otro producto? (si/no)");
            volverAcomprar= lea.next();
            }
            }while (volverAcomprar.equalsIgnoreCase("si") || volverAcomprar.equals("Si") || volverAcomprar.equals("sI") || volverAcomprar.equals("s"));
           
            } 
            else if (tipo_Venta.equalsIgnoreCase("c")|| tipo_Venta.equalsIgnoreCase("3") )
            {   //se hace lo mismo que en el tipo a solo para codigo4
                System.out.println("\n=============================================================================================================");                
                System.out.println("---------------------------------------- MENÚ DE PRODUCTOS (TIPO C) -----------------------------------------");
                System.out.println("=============================================================================================================");                
                System.out.println("Elige una de las siguientes opciones: -- Código -- -- Producto -- -- Precio Venta -- -- Cantidad Existente--");
                System.out.println("                                            4           Maíz            Lps.  20               "+maiz_comprado+" Kg.");
                do
                {
                    System.out.print("Ingrese código del producto: ");
                    codigoProducto_Venta = lea.nextInt();
                    if (codigoProducto_Venta==1 || codigoProducto_Venta==2 || codigoProducto_Venta==3) 
                    {
                    System.out.println("No puede comprar este producto.");
                    } 
                    else if (codigoProducto_Venta ==4) 
                    {
                    boolean cantidadPermitida=false;
                    do
                    {
                    if (maiz_comprado==0)
                    {
                        System.out.println("No hay maiz disponible en el inventario.");
                        break;
                    }  
                    else
                    {  
                    System.out.println("¿Cuántos kilogramos desea comprar? ");
                        if (lea.hasNextDouble())
                        {
                        KilogramosComprados = lea.nextDouble();

                            if (KilogramosComprados<=0)
                            {
                                KilogramosComprados=0;
                                System.out.println("Error. Cantidad no válida. Intenta con un número mayor a 0.");
                            } 
                            else if (KilogramosComprados>maiz_comprado)
                            {
                                KilogramosComprados=0;
                                System.out.println("Lo sentimos. No hay suficiente producto en inventario para venta.");
                                break;
                            }
                            else
                            {
                                cantidadPermitida=true;
                                Cant_Codigo4 = Cant_Codigo4+ KilogramosComprados;
                                precio= 20;
                                maiz_comprado -= KilogramosComprados;
                                subtotal += KilogramosComprados * precio;
                                double ganancia=KilogramosComprados * precio;
                                if (ganancia>mayorGananciaVenta)
                                {
                                    mayorGananciaVenta=ganancia;
                                    descripcionVenta="Maiz";
                                }
                            }
                        }
                        else
                        {
                            System.out.println("Error. Debe de ingresar un número.");
                            lea.next();
                            KilogramosComprados=0;
                        }
                    }
                    } while (cantidadPermitida==false);

                    } 
                    else 
                    {
                        System.out.println("Código no válido.");
                    }
                        System.out.println("¿Desea comprar otro producto? (si/no)");
                        volverAcomprar= lea.next();
            }while (volverAcomprar.equalsIgnoreCase("si") || volverAcomprar.equals("Si") || volverAcomprar.equals("sI") || volverAcomprar.equalsIgnoreCase("s"));
            } 
            else 
            {
                System.out.println("Tipo no válido");// validacion_tipo=false;
            }
        }while (volverAcomprar.equalsIgnoreCase("si") || volverAcomprar.equals("Si") || volverAcomprar.equals("sI") || volverAcomprar.equalsIgnoreCase("s"));
         //Calcular descuento
        if (subtotal >1000 && subtotal <= 5000)
        {
            descuento = subtotal * 0.05;
        }
        if (subtotal >5000)
        {
            descuento = subtotal * 0.10;
        }
        if (subtotal <1000)
        {
            descuento = 0;
        }
        //calcular impuesto
        impuesto = subtotal*0.07;
        //calcular total
        total=subtotal + impuesto - descuento;
        //sumar total a efectivo en caja
        efectivoCaja += total;
            if (subtotal>0)
            {
            //FACTURACIÓN
            System.out.println("=============================================================================================================");                
            System.out.println("---------------------------------------  FACTURA DE CLIENTE(TIPO "+tipo_Venta.toUpperCase()+")  ----------------------------------------");
            //DESCRIPCIÓN
            System.out.println("------ Cantidad ----- ----- Producto ----- ----- Precio Unitario ----- ----- Subtotal -------");
            //ifs para imprimir que productos se compraron
            if (Cant_Codigo1>0)
            {
                System.out.println("       "+ Cant_Codigo1+ "             Azúcar             "+30.0 +"             "+ Cant_Codigo1*30.0);
            }
            if (Cant_Codigo2>0)
            {
                System.out.println("        "+ Cant_Codigo2+ "             Avena             "+25.0 +"             "+ Cant_Codigo2*25.0);
            }
            if (Cant_Codigo3>0)
            {
                System.out.println("       "+ Cant_Codigo3+ "              Trigo             "+32.0 +"             "+ Cant_Codigo3*32.0);
            }
            if (Cant_Codigo4>0)
            {
                System.out.println("       "+ Cant_Codigo4+ "               Maíz             "+20.0 +"             "+ Cant_Codigo4*20.0);
            }
            //Print Subtotal
            System.out.println("Subtotal: Lps." + String.format("%.2f",subtotal)); //String.format("%.2f",)para reducir decimales
            //Print Total
            System.out.println("Impuesto (7%): lps. " + String.format("%.2f",impuesto)); //String.format("%.2f",)para reducir decimales
            //Print Descuento
            System.out.println("Descuento: Lps."+ String.format("%.2f",descuento)); //String.format("%.2f",)para reducir decimales
            //Print Total
            System.out.println("Total a pagar: Lps."+ String.format("%.2f",total)); //String.format("%.2f",)para reducir decimales
            //Gracias
            System.out.println("------------------------------------------- GRACIAS POR TU COMPRA -------------------------------------------");
            //contador de ventas
            num_ventas++; 
            //volumen ventas
            volumen_ventas+= total;
            //contadores de cantidad total de kg
            Cant_Codigo1_Total += Cant_Codigo1;
            Cant_Codigo2_Total += Cant_Codigo2;
            Cant_Codigo3_Total += Cant_Codigo3;
            Cant_Codigo4_Total += Cant_Codigo4;
            }
            else// si subtotal no es mayor a 0 no se puede realizar la compra    
            {
                System.out.println("--------------------------------------- NO SE PUDO REALIZAR LA VENTA ----------------------------------------");
            }
        }
        else
        {   
            if (habilitarCaja==true && azucar_comprada==0 && avena_comprada==0 && trigo_comprado==0 && maiz_comprado==0)//si la caja esta abierta y todos los valores estan en 0 imprime insufiente compras
            {
            System.out.println("--------------------- COMPRAS INSUFICIENTES. Ve a opción 3(compras) y luego regresas. ----------------------");             
            }
            else if (habilitarCaja==false && (azucar_comprada>0 || avena_comprada>0 || trigo_comprado>0 || maiz_comprado>0))//si la caja esta cerrada y hay alguna compra de producto para la venta se imprime caja cerrada
            {
            System.out.println("------------------------------- CAJA CERRADA. Ve a opción 1 para abrir caja. -------------------------------"); 
            }
            else //si la caja esta cerrada y todos los valores estan en 0 imprime insufiente compras y que la caja esta cerrada
            {
            System.out.println("--------------------- COMPRAS INSUFICIENTES. Ve a opción 3(compras) y luego regresas. ----------------------");             
            System.out.println("------------------------------- CAJA CERRADA. Ve a opción 1 para abrir caja. -------------------------------"); 
            }
        }    
        System.out.println("=============================================================================================================");
        break;
        case 3:
            //declarar e inicializar variables
            String comprarAproveedor;
            String tipo_Compra="";
            int codigoProducto_Compra=0;
            int codigoProductoInicial=0;
            double Cant_Codigo1_Compras = 0;
            double Cant_Codigo2_Compras = 0;
            double Cant_Codigo3_Compras = 0;
            double Cant_Codigo4_Compras = 0;
            double KilogramosComprados_Compras =0;
            double precio_Compra=0;
            double total_Compra=0;
            boolean producto_valido;
            boolean primerCompra =true;
            System.out.println("\n=============================================================================================================");   
                if (habilitarCaja==true && efectivoCaja>=18)
                {
                System.out.println("------------------------------------------- BIENVENIDO A COMPRAS --------------------------------------------");  
                System.out.println("=============================================================================================================");   

                System.out.println("\n=============================================================================================================");   
                System.out.println("---------------------------------------------- TIPO DE PROOVEDOR --------------------------------------------");
                System.out.println("=============================================================================================================");   
                System.out.println("Elige una de los siguientes tipos: \n    a) Tipo A  \n    b) Tipo B  \n    c) Tipo C ");
                do
                {
                System.out.print("\nIngrese Tipo de Proveedor (a,b,c): ");  //preguntas tipo prooveedor (tipo_Compra)          
                if (lea.hasNext("[a-zA-Z]+")) //ver si las entradas son solamente letras
                {
                tipo_Compra =lea.next(); //true pasa a leer
                    //para ver si esta entrada no es igual a "a","b" y "c", manda es mensaje y luego vuelve a pregunar el tipo.Sino ya no se repite y continua es proceso normal.
                    if (!tipo_Compra.equalsIgnoreCase("a") && !tipo_Compra.equalsIgnoreCase("b") && !tipo_Compra.equalsIgnoreCase("c"))
                    {
                        System.out.println("Opción no válida. \nIngrese una opción de MENÚ TIPO COMPRAS.");
                        System.out.println("Intentalo nuevamente. ");
                        tipo_Compra =""; //reinicia el tipo_compra para que vuelva a entrar en el while  
                    }
                }
                else //si incluye simbolos, espacios o numeros pasa a else
                {
                    System.out.println("Error. \nIngresar opción válida del MENÚ TIPO COMPRAS (Sin simbolos, espacios o numeros).");
                    System.out.println("Intentalo nuevamente. ");
                    lea.next();
                    tipo_Compra =""; //reinicia el tipo_compra para que vuelva a entrar en el while  
                }
                }while (!tipo_Compra.equalsIgnoreCase("a") && !tipo_Compra.equalsIgnoreCase("b") && !tipo_Compra.equalsIgnoreCase("c") ); //repetir si tipo_compra no es igual a "a","b" y "c".
                System.out.println("\n=============================================================================================================");  
                if (tipo_Compra.equalsIgnoreCase("a") || tipo_Compra.equals("1"))
                {
                producto_valido=false; 
                    do
                    {
                    System.out.println("-------------------------------------  MENÚ DE PRODUCTOS (PROVEEDOR A) --------------------------------------");
                    System.out.println("=============================================================================================================");  
                    System.out.println("Elige una de las siguientes opciones:   ----- Código -----   ----- Producto -----   ----- Precio Compra -----");
                    System.out.println("                                                1                    Azúcar                 Lps.  25");
                    System.out.println("                                                4                     Maíz                  Lps.  18");
                    System.out.println("\nEfectivo Disponible en Caja: "+ efectivoCaja);
                    System.out.print("Ingrese código del producto: ");
                    codigoProducto_Compra = lea.nextInt();
                    if (codigoProducto_Compra==1 || codigoProducto_Compra==4)
                    {    //es este paso se debe comprar solo un tipo de producto asi que el do while lo utilizo para que si desea comprar al proveedor solo deje comprar el mismo codigo que ingrese la primera vez
                        producto_valido=true;
                       if (primerCompra==true) 
                       {
                        codigoProductoInicial=codigoProducto_Compra;
                        primerCompra=false;
                       }
                       if (codigoProducto_Compra == codigoProductoInicial)
                       {
                        System.out.print("¿Cuántos kilogramos desea comprar?: ");
                        KilogramosComprados_Compras = lea.nextDouble();                   
                        if (KilogramosComprados_Compras > 0) {
                            if (codigoProducto_Compra==1) 
                            {
                                precio_Compra= 25;
                                codigoProductoInicial = codigoProducto_Compra;
                                double evaluacionCompra= KilogramosComprados_Compras *precio_Compra; //la variable solo se utiliza para saber si supera o no el efectivo caja
                                //si la evalucion es mayor al efectivo se resetean a 0 los kg
                                if (evaluacionCompra>efectivoCaja)  // si la evaluacion supera el efectivocaja no se puede comprar
                                {   
                                    System.out.println("\n-------------------------  LA COMPRA SUPERA EL EFECTIVO DE CAJA. ------------------------");
                                    System.out.println("EFECTIVO DISPONIBLE CAJA:   Lps. " + String.format("%.2f",efectivoCaja));
                                    KilogramosComprados_Compras=0; 
                                }
                                else //en otro caso se suma cant de codigo1 en compras
                                {
                                Cant_Codigo1_Compras += KilogramosComprados_Compras;//acumulador de cant de azucar
                                double gasto= KilogramosComprados_Compras * precio_Compra;
                                if (gasto>mayorGastoCompra) //ver si gasto es mayor al mayogastocompra si es asi se convierte en mayor gasto compra esto se proyecta en reportes
                                {
                                    mayorGastoCompra=gasto;
                                    descripcionCompra="Azucar";
                                }
                                } 
                            } 
                            else if (codigoProducto_Compra ==4) //repite lo mismo que cuando codigoproductocompra ==1
                            {
                                precio_Compra= 18;
                                codigoProductoInicial = codigoProducto_Compra;
                                double evaluacionCompra= KilogramosComprados_Compras *precio_Compra;
                                //si la evalucion es mayor al efectivo se resetean a 0 los kg
                                if (evaluacionCompra>efectivoCaja) 
                                {
                                    System.out.println("\n-------------------------  LA COMPRA SUPERA EL EFECTIVO DE CAJA. ------------------------");
                                    System.out.println("EFECTIVO DISPONIBLE CAJA:   Lps. " + String.format("%.2f",efectivoCaja));
                                    KilogramosComprados_Compras=0; 
                                }
                                else
                                {
                                Cant_Codigo4_Compras += KilogramosComprados_Compras;//acumulador de cant de maiz
                                double gasto= KilogramosComprados_Compras * precio_Compra;
                                if (gasto>mayorGastoCompra)
                                {
                                    mayorGastoCompra=gasto;
                                    descripcionCompra="Maiz";
                                }
                                } 
                            }
                            total_Compra += KilogramosComprados_Compras * precio_Compra; //total de la suma del precio*kg
                        }else 
                        {
                            System.out.println("Error. Cantidad no válida. Intenta con un número mayor a 0.");
                        }
                    }
                    else
                    {
                        System.out.println("Solo se puede comprar el mismo tipo de producto en factura. \nSi desea comprar otro tipo termine la factura.");
                    }
                }
                else
                {
                    System.out.println("Proveedor no vende dicho producto.");
                }
                System.out.println("¿Desea comprar volver a comprar al proveedor? (si/no)");
                comprarAproveedor= lea.next();    
                } while(comprarAproveedor.equalsIgnoreCase("si"));  
                }
                else if (tipo_Compra.equalsIgnoreCase("b") || tipo_Compra.equals("2"))
                {
                    do
                    {
                    System.out.println("-------------------------------------  MENÚ DE PRODUCTOS (PROVEEDOR B) --------------------------------------");
                    System.out.println("=============================================================================================================");  
                    System.out.println("Elige una de las siguientes opciones:   ----- Código -----   ----- Producto -----   ----- Precio Compra -----");
                    System.out.println("                                                2                    Avena                  Lps.  20");
                    System.out.println("                                                3                    Trigo                  Lps.  30");
                    System.out.println("\nEfectivo Disponible en Caja: "+ efectivoCaja);
                    System.out.print("Ingrese código del producto: ");
                    codigoProducto_Compra = lea.nextInt();
                    //mismos pasos que menu de proveedor a solo que cuando codigoproductocompra es igual a 2 o 3
                        if (codigoProducto_Compra==2 || codigoProducto_Compra==3)
                       {
                        producto_valido=true;

                       if (primerCompra==true)
                       {
                        codigoProductoInicial=codigoProducto_Compra;
                        primerCompra=false;
                       }
                        if (codigoProducto_Compra == codigoProductoInicial)
                       {
                        System.out.print("¿Cuántos kilogramos desea comprar?: ");
                        KilogramosComprados_Compras = lea.nextDouble();      
                        if (KilogramosComprados_Compras > 0) {
                            if (codigoProducto_Compra==2) 
                            { 
                                precio_Compra= 20;
                                codigoProductoInicial = codigoProducto_Compra;
                                double evaluacionCompra= KilogramosComprados_Compras *precio_Compra;                        
                                //si la evalucion es mayor al efectivo se resetean a 0 los kg
                                if (evaluacionCompra>efectivoCaja) 
                                {
                                    System.out.println("\n-------------------------  LA COMPRA SUPERA EL EFECTIVO DE CAJA. ------------------------");
                                    System.out.println("EFECTIVO DISPONIBLE CAJA:   Lps. " + String.format("%.2f",efectivoCaja));
                                    KilogramosComprados_Compras=0; 
                                }
                                else
                                {
                                Cant_Codigo2_Compras += KilogramosComprados_Compras;//acumulador de cant de Avena --Proveedor B
                                double gasto= KilogramosComprados_Compras * precio_Compra;
                                    if (gasto>mayorGastoCompra)
                                    {
                                        mayorGastoCompra=gasto;
                                        descripcionCompra="Avena --Proveedor B";
                                    }
                                }  
                            } 
                            else if (codigoProducto_Compra ==3) 
                            {
                                precio_Compra= 30;
                                codigoProductoInicial = codigoProducto_Compra;// para ver si el codigo anterior coicide con con el que se ingresa denuevo, se hace por si se le olvido comprar alguna cantidad de producto
                                double evaluacionCompra= KilogramosComprados_Compras *precio_Compra;
                                if (evaluacionCompra>efectivoCaja) 
                                {
                                    System.out.println("\n-------------------------  LA COMPRA SUPERA EL EFECTIVO DE CAJA. ------------------------");
                                    System.out.println("EFECTIVO DISPONIBLE CAJA:   Lps. " + String.format("%.2f",efectivoCaja));
                                    KilogramosComprados_Compras=0; 
                                }
                                else
                                {
                                Cant_Codigo3_Compras += KilogramosComprados_Compras;//acumulador de cant de trigo 
                                double gasto= KilogramosComprados_Compras * precio_Compra;
                                    if (gasto>mayorGastoCompra)
                                    {
                                        mayorGastoCompra=gasto;
                                        descripcionCompra="Trigo";
                                    }
                                } 
                            } 
                            total_Compra += KilogramosComprados_Compras * precio_Compra;//total de la suma del precio*kg
                        }
                        else
                        {
                            System.out.println("Error. Cantidad no válida. Intenta con un número mayor a 0.");
                        }   
                       }
                        else
                        {
                            System.out.println("Solo se puede comprar el mismo tipo de producto en factura. \nSi desea comprar otro tipo termine la factura.");
                        }
                    }
                    else
                    {
                        System.out.println("Proveedor no vende dicho Producto");//DETERMINA QUE EL CODIGO NO ES EL CORRECTO
                    }
                    System.out.println("¿Desea comprar volver a comprar al proveedor? (si/no)");//PREGUNTA SI QUIERE COMPRAR AL PROVEEDOR MAS PRODUCTO SI ES ASI SOLO DEJARA INGRESAR EL MISMO CODGO
                    comprarAproveedor= lea.next();
                    } while(comprarAproveedor.equalsIgnoreCase("si"));
                }
                else if (tipo_Compra.equalsIgnoreCase("c") || tipo_Compra.equals("3"))
                {
                    System.out.println("-------------------------------------  MENÚ DE PRODUCTOS (PROVEEDOR B) --------------------------------------");
                    System.out.println("=============================================================================================================");  
                    System.out.println("Elige una de las siguientes opciones:   ----- Código -----   ----- Producto -----   ----- Precio Compra -----");
                    System.out.println("                                                2                    Avena                  Lps.  22");
                    System.out.println("\nEfectivo Disponible en Caja: "+ efectivoCaja);
                    do
                    {
                    System.out.print("Ingrese código del producto: ");
                    codigoProducto_Compra = lea.nextInt();
                    //mismos pasos que menu de proveedor a solo que cuando codigoproductocompra es igual a 2
                        if (codigoProducto_Compra==2) 
                        {   
                            System.out.println("¿Cuántos kilogramos desea comprar? ");
                            KilogramosComprados_Compras = lea.nextDouble();
                            precio_Compra= 22;
                            double evaluacionCompra= KilogramosComprados_Compras *precio_Compra;
                            //si la evalucion es mayor al efectivo se resetean a 0 los kg
                            if (evaluacionCompra>efectivoCaja) 
                            {
                                    System.out.println("\n-------------------------  LA COMPRA SUPERA EL EFECTIVO DE CAJA. ------------------------");
                                    System.out.println("EFECTIVO DISPONIBLE CAJA:   Lps. " + String.format("%.2f",efectivoCaja));
                                KilogramosComprados_Compras=0; 
                            }
                            else
                            {
                            Cant_Codigo2_Compras += KilogramosComprados_Compras;//acumulador de cant de Avena --Proveedor C
                            double gasto= KilogramosComprados_Compras * precio_Compra;
                                if (gasto>mayorGastoCompra)
                                {
                                    mayorGastoCompra=gasto;
                                    descripcionCompra="Avena --Proveedor C";
                                }                        
                            }  
                        } 
                        else 
                        {
                        System.out.println("Proveedor no vende dicho Producto");
                        }
                    System.out.println("\n¿Desea comprar volver a comprar al proveedor? (si/no)");
                    comprarAproveedor= lea.next();
                    total_Compra += KilogramosComprados_Compras * precio_Compra;
                    } while(comprarAproveedor.equalsIgnoreCase("si") );
                }
                else 
                {
                    System.out.println("Tipo no válido");
                }
                if (total_Compra<= efectivoCaja && total_Compra>0)
                { //facturacion cuando se puede efectuar la compra
                System.out.println("\n=============================================================================================================");  
                System.out.println("---------------------------------------------- COMPRA VÁLIDA   ---------------------------------------------");
                System.out.println("\n=============================================================================================================");  
                System.out.println("-------------------------------------------- FACTURA DE PROVEEDOR -------------------------------------------");
                System.out.println("---------------------------------------------  PROVEEDOR TIPO "+ tipo_Compra.toUpperCase()+"  --------------------------------------------");
                //DESCRIPCIÓN
                System.out.println("------ CANTIDAD ----- ----- PRODUCTO ----- ----- PRECIO UNITARIO ----- ----------------- TOTAL --------------");
                System.out.println("--------------------- -------------------- --------------------------- --------------------------------------");                
                
                if (Cant_Codigo1_Compras>0)
                {
                    System.out.println("           "+ Cant_Codigo1_Compras+ "              Azúcar                    "+25.0 +"                          "+ Cant_Codigo1_Compras*25.0+" kg. ");
                }
                else if (Cant_Codigo2_Compras>0 && (tipo_Compra.equalsIgnoreCase("b")))
                {
                    System.out.println("           "+ Cant_Codigo2_Compras+ "               Avena                    "+20.0 +"                         "+ Cant_Codigo2_Compras*20.0+" kg. ");
                }
                else if (Cant_Codigo2_Compras>0 && (tipo_Compra.equalsIgnoreCase("c")))
                {
                    System.out.println("           "+ Cant_Codigo2_Compras+ "               Avena                    "+22.0 +"                        "+ Cant_Codigo2_Compras*22.0+" kg. ");
                }
                else if (Cant_Codigo3_Compras>0)
                {
                    System.out.println("           "+ Cant_Codigo3_Compras+ "               Trigo                    "+30.0 +"                       "+ Cant_Codigo3_Compras*30.0+" kg. ");
                }   
                else if (Cant_Codigo4_Compras>0)
                {
                    System.out.println("           "+ Cant_Codigo4_Compras+ "                Maíz                    "+18.0 +"                      "+ Cant_Codigo4_Compras*18.0+" kg. ");
                }
                System.out.println("--------------------- -------------------- --------------------------- --------------------------------------");//tipo de proveedor
                System.out.println("TOTAL A PAGAR A PROVEEDOR:  Lps. " + String.format("%.2f",total_Compra));
                System.out.println("--------------------------------------  Compra con exito. Feliz día!! --------------------------------------");
                System.out.println("\n=============================================================================================================");  
                System.out.println("\nEFECTIVO ANTES DE COMPRA:   Lps. " + String.format("%.2f",efectivoCaja));
                System.out.println("EFECTIVO DESCONTADO:        Lps. " + String.format("%.2f",total_Compra));
                efectivoCaja -=total_Compra;// restar total compra a caja
                    if (efectivoCaja==0) //POR SI CAJA QUEDA EN CERO SE MENCIONA QUE QUEDO EN CERO 
                    {
                    System.out.println("\nSu compra es exitosa. \nSin embargo, su caja quedó vacía, procure hacer ventas(2) o ingresar mas dinero en caja(3).");
                    }
                System.out.println("TOTAL EFECTIVO CAJA:        Lps. " + String.format("%.2f",efectivoCaja));
                //contador de compras
                num_compras++;
                //contador de total en compras
                volumen_compras+= total_Compra;    
                } 
                else //no se pudo compra por falta de pisto en caja
                {
                System.out.println("\n-------------------------------------------   COMPRA NO VÁLIDA    ------------------------------------------");
                System.out.println("--------------------------- Lo sentimos,compra cancelada. Fondos Insuficientes. ----------------------------");
                }
                //contadores de productos comprados
                azucar_comprada +=Cant_Codigo1_Compras;
                avena_comprada  +=Cant_Codigo2_Compras;
                trigo_comprado  +=Cant_Codigo3_Compras;
                maiz_comprado   +=Cant_Codigo4_Compras; 
            }   
            else
            {
                if  (efectivoCaja<18 && habilitarCaja==true)
                {//cuando caja si esta abierta pero efectivo en caja no es igual o supera los 18 lempiras por lo que no puede comprar nada
                    System.out.println("\n------------------------------- Fondos Insuficientes para comprar productos. -------------------------------");
                }
                else if  (efectivoCaja<18 && habilitarCaja==false)
                {// efectivo en caja es igual o supera los 18 lempiras pero caja si esta cerrada
                    System.out.println("\n------------------------------- Caja Cerrada. Ve a opción 1 para Abrir Caja. -------------------------------");
                }
            }
            System.out.println("=============================================================================================================");  
        break;
        
        case 4:
            System.out.println("\n=============================================================================================================");  
            System.out.println("------------------------------------------- BIENVENIDO A REPORTES -------------------------------------------");
            if (habilitarCaja==true)
            {
            //calculos de reportes
            double margenGanancias= volumen_ventas-volumen_compras;
            double valorMedioVentas= volumen_ventas/num_ventas;
            double valorMedioCompras= volumen_compras/num_compras;    
            System.out.println("\n=============================================================================================================");  
            System.out.println("--------------------------------------------- PRODUCTO EN STOCK ---------------------------------------------");
            System.out.println("-------------------------------------------------------------------------------------------------------------");  
            //stock compras sube cuanto hay de cada producto, en compras lo resta y en cierre muestra cantidad que queda             //calculos
            System.out.println("\nCantidad de azucar existente: " + azucar_comprada);  
            System.out.println("Cantidad de avena existente:  " + avena_comprada); 
            System.out.println("Cantidad de trigo existente:  " + trigo_comprado);    
            System.out.println("Cantidad de maiz existente:   " + maiz_comprado);   
            System.out.println("\n-------------------------------------------------------------------------------------------------------------");  
            //efectivo del dia
            System.out.println("--------------------------------------------------- CAJA ----------------------------------------------------");
            System.out.println("-------------------------------------------------------------------------------------------------------------");  
            System.out.println("\nEfectivo en caja del día: " + String.format("%.2f", efectivoCaja));
            System.out.println("\n-------------------------------------------------------------------------------------------------------------");  
            //Mostrar ventas y compras del dia
            System.out.println("------------------------------ NUMERO DE VENTAS Y COMPRAS REALIZADAS EN EL DIA ------------------------------");
            System.out.println("-------------------------------------------------------------------------------------------------------------");  
            System.out.println("Numero de Ventas realizadas:  "+ num_ventas);
            System.out.println("Numero deCompras realizadas: "+ num_compras);
            System.out.println("\n-------------------------------------------------------------------------------------------------------------");  
            //VOLUMEN VENTAS Y COMPRAS
            System.out.println("----------------------------- VOLUMEN DE VENTAS Y COMPRAS REALIZADAS EN EL DIA ------------------------------");
            System.out.println("-------------------------------------------------------------------------------------------------------------");  
            System.out.println("\nVolumen Ventas:   " + String.format("%.2f",volumen_ventas));
            System.out.println("Volumen Compras:  " + String.format("%.2f",volumen_compras));
            System.out.println("\n-------------------------------------------------------------------------------------------------------------");  
            //margen de ganancias
            System.out.println("-------------------------------------------- MARGEN DE GANANCIAS --------------------------------------------");
            System.out.println("-------------------------------------------------------------------------------------------------------------");  
            System.out.println("\nMargen de ganancias: " + String.format("%.2f",margenGanancias));
            System.out.println("\n-------------------------------------------------------------------------------------------------------------");  
            //valor medio 
            System.out.println("-------------------------------------- VALOR MEDIO DE VENTAS Y COMPRAS --------------------------------------");
            System.out.println("-------------------------------------------------------------------------------------------------------------");  
            //valor medio Ventas
            System.out.println("\nValor Medio Ventas:  " + String.format("%.2f",valorMedioVentas));
            //valor medio Compras
            System.out.println("Valor Medio Compras: " + String.format("%.2f",valorMedioCompras));
            System.out.println("\n-------------------------------------------------------------------------------------------------------------");  
            // La venta con mayor ganancia realizada y la compra con más gasto efectuada.  
            System.out.println("----------------------------------------- VENTA CON MAYOR GANANCIAS -----------------------------------------");
            System.out.println("Venta con mayor ganacia: "+ descripcionVenta +"(Ganancia: Lps. "+ mayorGananciaVenta+") ");
            System.out.println("------------------------------------------ COMPRA CON MAYOR GASTOS ------------------------------------------");
            System.out.println("Compra con mayor gasto: "+ descripcionCompra +"(Gasto:    Lps. "+ mayorGastoCompra+") ");
            System.out.println("\n-------------------------------------------------------------------------------------------------------------");  
            System.out.println("--------------------------------------------- PRODUCTO ESTRELLA ---------------------------------------------");//producto estrella 
            //determinar cual cant de producto es mayor 
            double numMayorVentas = Cant_Codigo1_Total;
            // encontrar el valor mayor
            if (Cant_Codigo2_Total > numMayorVentas)  //evalua cada estructura if por separado si es false no hace nada
            {
                numMayorVentas = Cant_Codigo2_Total;
            }

            if (Cant_Codigo3_Total > numMayorVentas)
            {
                numMayorVentas = Cant_Codigo3_Total;
            }

            if (Cant_Codigo4_Total > numMayorVentas)
            {
                numMayorVentas = Cant_Codigo4_Total;
            }
            int conteo = 0;// contar cuántos productos tienen ese mismo valor
            if (Cant_Codigo1_Total == numMayorVentas)
            {
                conteo++;
            }
            if (Cant_Codigo2_Total == numMayorVentas)
            {
                conteo++;
            }
            if (Cant_Codigo3_Total == numMayorVentas)
            {
                conteo++;
            }
            if (Cant_Codigo4_Total == numMayorVentas)
            {
                conteo++;
            }
            if (conteo > 1)// mostrar resultados // evalua todos y si es true imprime los articulos estrellas que son iguales 
            {
                System.out.println("Hay varios productos que tienen el mismo número de ventas: " + numMayorVentas + " kg.");
                System.out.println("Detalles:");
                if (Cant_Codigo1_Total == numMayorVentas)
                {
                    System.out.println("- Azúcar: " + Cant_Codigo1_Total + " kg");
                }
                if (Cant_Codigo2_Total == numMayorVentas)
                {
                    System.out.println("- Avena:  " + Cant_Codigo2_Total + " kg");
                }
                if (Cant_Codigo3_Total == numMayorVentas)
                {
                    System.out.println("- Trigo:  " + Cant_Codigo3_Total + " kg");
                }
                if (Cant_Codigo4_Total == numMayorVentas)
                {
                    System.out.println("- Maíz:   " + Cant_Codigo4_Total + " kg");
                }
            }
            else // evalua 1 y solo imprime 1 articulo estrella
            {
                if (Cant_Codigo1_Total == numMayorVentas)
                {
                    System.out.println("Producto con más ventas: Azúcar (" + Cant_Codigo1_Total + " kg)");
                }
                else if (Cant_Codigo2_Total == numMayorVentas)
                {
                    System.out.println("Producto con más ventas: Avena (" + Cant_Codigo2_Total + " kg)");
                }
                else if (Cant_Codigo3_Total == numMayorVentas)
                {
                    System.out.println("Producto con más ventas: Trigo (" + Cant_Codigo3_Total + " kg)");
                }
                else if (Cant_Codigo4_Total == numMayorVentas)
                {
                    System.out.println("Producto con más ventas: Maíz (" + Cant_Codigo4_Total + " kg)");
                }
            }
            System.out.println("\n-------------------------------------------------------------------------------------------------------------");  
        }
        else
        {
            System.out.println("\n------------------------------- Caja Cerrada. Ve a opción 1 para Abrir Caja. -------------------------------");
        }
        System.out.println("=============================================================================================================");  
        break;
        case 5:
            //declarar variables e inicializarlas
            boolean depositoValido=false; 
            System.out.println("\n=============================================================================================================");  
            System.out.println("----------------------------------------- BIENVENIDO CIERRE DE CAJA -----------------------------------------");
            if (habilitarCaja==false)
            {//cuando habilitar caja esta cerrada
            System.out.println("\n----------------------------------------- LA CAJA YA ESTA CERRADA. ------------------------------------------");
            System.out.println("=============================================================================================================");  
            }
            else
            {
                System.out.println("¿Desea cerrar la caja? (si/no)"); //pregunta de cierre
                preguntaCierre = lea.next();
                while (!depositoValido)
                {
                    if (preguntaCierre.equalsIgnoreCase("si")) 
                    {
                    double efectivoDisponible = efectivoCaja* 0.60;//calculo de 60% que puede depositar
                    System.out.println("--------------------------------------------- DEPOSITO A BANCO ----------------------------------------------");
                    System.out.println("=============================================================================================================");  
                    System.out.println("\nDebe depositar al banco. \nPuedes depositar hasta el 60% max.");
                    System.out.println("EFECTIVO EN CAJA:        Lps. " + String.format("%.2f",efectivoCaja));
                    System.out.println("MAXIMO A DEPOSITAR:      Lps. " + String.format("%.2f",efectivoDisponible));
                    System.out.print("¿Cuánto efectivo desea depositar? Lps. ");
                    efectivoDeposito = lea.nextDouble();
                        if (efectivoDeposito>0 && efectivoDeposito <= efectivoDisponible)
                        {// si cumple condicion se puede efectuar el cierre
                        efectivoCaja = efectivoCaja - efectivoDeposito;
                        depositoValido=true;
                        System.out.println("\nCIERRE DE CAJA CON: Lps. " + String.format("%.2f",efectivoCaja));
                        System.out.println("=============================================================================================================");  
                        habilitarCaja = false;//la caja estara cerrada y no permitira abrir ninguna de las opciones
                        cajaFueCerrada=true;//señal de que la caja fue cerrada
                        //aqui termina
                        }
                        else 
                        {//volvera porque el deposito no fue valido
                        System.out.println("La cantidad que ingresaste es mayor al 60% o es menor igual a 0. \n Deposito no permitido. Intentalo de nuevo.");   
                        }
                    }
                    else
                    {
                    System.out.println("\n-------------------------------------------- LA CAJA NO SE CERRÓ. -------------------------------------------");//si le da no o un caracter equivocado no se cierra
                    System.out.println("=============================================================================================================");  
                    break;
                    }
                }// cierra hasta que deposito sea valido
        }
        break;    
        case 6://salir 
            System.out.println("\n=============================================================================================================");  
            System.out.println("--------------------------------------------- BIENVENIDO SALIDA ---------------------------------------------");
            System.out.println("BBYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");  
            System.out.println("Luuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuhhhhhhh yyyyyeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeewwwwwwww!!!!!!!!!!!!!");
            System.out.println("=============================================================================================================");  
            sesion=false;
        break;
        default:
        break;
    }
    }while (sesion==true);
    }
}
