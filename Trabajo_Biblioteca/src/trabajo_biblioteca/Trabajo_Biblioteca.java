package trabajo_biblioteca;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author solrac97g
 */
    public class Trabajo_Biblioteca {
    public static Scanner Leer = new Scanner(System.in);
    public static ArrayList<Libro>Inventario = new ArrayList();
    private static Libro Auxiliar;
    public static void main(String[] args) {
    
    int o;
       
     do{
        o = Menu();
         switch (o) {
             case 1:
                 Ingresos();
                 break;
             case 2:
                 Movimiento();
                 break;
             case 3:
                 Disponibilidad();
                 break;
             case 4:
                 Actualizar();
                 break;
             case 5:
                 Eliminar();
                 break;
             case 6:
                 Listar();
                 break;
             case 7:
                 System.out.println("Salir");
                 break;
                 
             default:
                 System.out.println("no valido");
                 break;
         }
         
     }while(o != 7);
       
    }
    
    public static int Menu(){
        int op;
        System.out.println("==============MENU PRINCIPAL=============");
        System.out.println("1.Ingresos");
        System.out.println("2.Movimientos");
        System.out.println("3.Disponibilidad");
        System.out.println("4.Actualizar Libro");
        System.out.println("5.Eliminar Libro");
        System.out.println("6.Listado");
        System.out.println("7.Salir");
        System.out.println("===========================================");
        System.out.print("Elija una opcion: ");
        op = Leer.nextInt();
        return op;        
    }
    //============================INGRESOS======================================
    public static void Ingresos(){
       String op;
       do{
                    Auxiliar = new Libro();
                    int nr = Inventario.size()+1;// Indica el numero de registros
                    System.out.println("==================INGRESOS==================");
                   //----------------------------NUMERO DE REGISTROS--------------------
                    System.out.println("Numero de Registro: "+nr);
                   
                    int t= 0;
                    int aedicion;
                    int x = 0;
                    //---------------------------REGISTRO DEL CODIGO--------------------
                    do {
                        //El codigo no se debe repetir y debe presentar solo 5 caracteres
                        System.out.println("Codigo de libro: ");
                        String cod = Leer.next();
                        if (cod.length() == 5){
                            
                                    int pos = -1;
                            pos = BuscarCodigo(cod);
                                 if (pos == -1){
                                     Auxiliar = new Libro();
                                     Auxiliar.setCodigo(cod);
                                     Auxiliar.setEstado(1);//El valor es 1 por ue eso seria el estado libre
                                      Auxiliar.setNRegistro(nr);// se guarda el numero de registro
                                     t++;
                                 }
                                 else{
                                     System.out.println("El Codigo ya esta registrado");
                                 }

                        }
                        else{
                            System.out.println("El Codigo debe ser de 5 caracteres");
                        }
                    } while (t==0);
                    //------------------------------------------------------------------
                    System.out.print("Titulo de libro: ");
                    Auxiliar.setTitulo(Leer.next());
                    System.out.print("Autor de libro: ");
                    Auxiliar.setAutor(Leer.next());
                    System.out.print("Editorial: ");
                    Auxiliar.setEditorial(Leer.next());
                do{
                            System.out.print("Año de edicion(entre 1900 y 2017): ");
                            aedicion = Leer.nextInt();
                            if(aedicion>1900 && aedicion<2017 ){
                                Auxiliar.setA_edicion(aedicion);
                                x++;

                            }
                            else{
                                System.out.println("El anio debe tener 4 digistos y estar entre 1900 y 2016");
                              

                            }
                }while(x==0);


                    Inventario.add(Auxiliar);
                    System.out.println("=========================================");
                    System.out.println("Desea ingresar otro libro?(S/N)");
                    op = Leer.next();
       }while(op.equalsIgnoreCase("S"));
   //========================BUSCAR================================================
    }
    public static int BuscarCodigo(String Codigo) {
    int pos = -1;
        for (int i = 0;i < Inventario.size();i++){
            Auxiliar = new Libro();
            Auxiliar = Inventario.get(i);
            if (Auxiliar.getCodigo().compareTo(Codigo)== 0){
                pos = i;
                break;
            }
        }
    return pos;        
    }
    //==========================MOVIMIENTO======================================
    public static void Movimiento(){
        String cod;
        String ops;
        int pos;
        int op;
        Auxiliar = new Libro();
        System.out.println("===========MOVIMIENTO==================");
        //ingresar un codigo de libro,buscarlo a ver si no se repite,si el codigo no se encuentra,si el codigo esta ingresado mostrar el tiutlo y el autor,estado/fecha de devolucion
        do{
        System.out.println("Ingresar codigo: ");
        cod = Leer.next();
        pos = BuscarCodigo(cod);
        if(pos == -1){
            System.out.println("Libro no existente");
        }
        else{
             Auxiliar = new Libro();
             Auxiliar = Inventario.get(pos);
            System.out.println("Titulo: "+Auxiliar.getTitulo());
            System.out.println("Autor: "+Auxiliar.getAutor());
            switch (Auxiliar.getEstado()) {
                case 1:
                    System.out.println("Estado: Libre");
                    break;
                case 2:
                    System.out.println("Estado: Domicilio");
                    break;
                case 3:
                    System.out.println("Estado: En Sala");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }
        System.out.println("Desea mover el libro:");
        System.out.println("1.Desea prestarlo(Domicilio)");
        System.out.println("2.Desea prestarlo(Sala) ");
        System.out.println("3.Desea devolverlo");
        System.out.println("Ingrese opcion: ");
        op = Leer.nextInt();
        switch (op) {
            case 1:
                System.out.println("Ingrese fecha de devolucion(DD-MM-AA): ");
                Auxiliar.setF_devolucion(Leer.next());
                Auxiliar.setEstado(2);
                break;
            case 2:
                System.out.println("Disfrute su libro");
                Auxiliar.setEstado(3);
                break;
            case 3:
                System.out.println("Gracias por su responsabilidad");
                Auxiliar.setEstado(1);
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }
            System.out.println("Desea registrar otro movimiento(S/N):");
            ops = Leer.next();
        }while(ops.equalsIgnoreCase("S"));
    }
    public static void Disponibilidad(){
         String cod;
        int pos;
        int op;
        String op2;
        System.out.println("===========DISPONIBILIDAD==================");
        //ingresar un codigo de libro,buscarlo a ver si no se repite,si el codigo no se encuentra,si el codigo esta ingresado mostrar el tiutlo y el autor,estado/fecha de devolucion
       do{
            System.out.println("Ingresar codigo: ");
            cod = Leer.next();
            pos = BuscarCodigo(cod);
            if(pos == -1){
                System.out.println("Libro no existente");
            }
            else{
                 Auxiliar = new Libro();
                 Auxiliar = Inventario.get(pos);
                System.out.println("Titulo: "+Auxiliar.getTitulo());
                System.out.println("Autor: "+Auxiliar.getAutor());
                switch (Auxiliar.getEstado()) {
                    case 1:
                        System.out.println("Estado: Libre");
                        break;
                    case 2:
                        System.out.println("Estado: Domicilio");
                        System.out.println("Fecha de devolucion: "+Auxiliar.getF_devolucion());
                        break;
                    case 3:
                        System.out.println("Estado: En Sala");
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }
            }
            System.out.println("Desea consultar otro(S,N)");
             op2=Leer.next();
       }while(op2.equalsIgnoreCase("S"));
     
    }
    public static void Actualizar(){
        System.out.println("=============ACTUALIZAR============");
        String cod;
        int pos;
        String op;
        String op2;
        String op3;
        String op4;
    do{
        System.out.println("Ingrese codigo: ");
        cod = Leer.next();
        pos = BuscarCodigo(cod);
        if(pos == -1){
            System.out.println("Libro no registrado");
        }
        else{
            Auxiliar = new Libro();
            Auxiliar = Inventario.get(pos);
            System.out.println("Titulo: "+Auxiliar.getTitulo());
            System.out.println("Desea actualizar Titulo(S/N)");
            op = Leer.next();
            if(op.equalsIgnoreCase("S")){
                System.out.print("Ingrese nuevo titulo: ");
                Auxiliar.setTitulo(Leer.next());
            }
            else{
                System.out.println("ok");
            }
            System.out.println("Autor: "+Auxiliar.getAutor());           
            System.out.println("Desea actualizar Autor(S/N)");
            op2 = Leer.next();
            if(op2.equalsIgnoreCase("S")){
                System.out.println("Ingrese nuevo Autor: ");
                Auxiliar.setAutor(Leer.next());
            }
            System.out.println("Estado: "+Auxiliar.getEstado());
            if(Auxiliar.getEstado()==2){
                System.out.println("Fecha: "+Auxiliar.getF_devolucion());
            }
            
            System.out.println("Desea actualizar Estado(S/N):");
            op3 = Leer.next();
            if(op3.equalsIgnoreCase("S")){
                int est;
                System.out.println("Ingreso nuevo estado:");
                System.out.println("1.libre");
                System.out.println("2.Domicilio");
                System.out.println("3.Sala");
                System.out.print("Ingrese opcion: ");
                est = Leer.nextInt();
                Auxiliar.setEstado(est);
                if(Auxiliar.getEstado()==2){
                    System.out.println("Actualizar Fecha de devolucion(DD-MM-AA): ");
                    Auxiliar.setF_devolucion(Leer.next());
                }
            }
                  
        }
        System.out.println("Desea actualizar otro libro(SI/NO):");
        op4 = Leer.next();
    }while(op4.equalsIgnoreCase("S"));
    }
    public  static void Eliminar(){
        String cod;
        int pos;
        String des;
        System.out.println("==========ELIMINAR============");
        System.out.println("Ingresar codigo: ");
        cod = Leer.next();
        pos = BuscarCodigo(cod);
        if(pos == -1){
            System.out.println("No se econtro libro");
        }
        else if(Auxiliar.getEstado()== 1){
            Auxiliar = new Libro();
            Auxiliar = Inventario.get(pos);
            System.out.println("Informacion del libro");
            System.out.println("Titulo: "+Auxiliar.getTitulo());
            System.out.println("Autor: "+Auxiliar.getAutor());
            System.out.println("Estado: "+Auxiliar.getEstado());
            System.out.println("Desea eliminar libro?(S/N)");
            des = Leer.next();
            if(des.equalsIgnoreCase("S")){
            Inventario.remove(pos);
            }
            else{
                System.out.println("no eliminado");
            }
            
        }
        
        
        
    }
    public static void Listar(){
        System.out.println("==============================================================LISTAR===============================================================");
        String Estado = " ";
       for(int i=0;i<Inventario.size();i++){
           
           Auxiliar = new Libro();
           Auxiliar = Inventario.get(i);
              System.out.println("registro\t\tCodigo\t\tTitulo\t\tAutor\t\tAnio de Edicion\t\tEditorial\t\tEstado");
            switch (Auxiliar.getEstado()) {
                case 1:
                    {
                        Estado = "Libre";
                        break;
                    }
                case 2:
                    {
                        Estado = "Domicilio";
                        break;
                    }
                case 3:
                    {
                        Estado = "Sala";
                        break;
                    }
                default:
                    break;
            }
              System.out.println(Auxiliar.getNRegistro()+"\t\t\t"+Auxiliar.getCodigo()+"\t\t"+Auxiliar.getTitulo()+"\t\t"+Auxiliar.getAutor()+"\t\t"+Auxiliar.getA_edicion()+"\t\t\t"+Auxiliar.getEditorial()+"\t\t\t"+Estado);
       }
        System.out.println("==========================================================================================================================================");
    }
    
}
