package ae_3_criptografia;

import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;

public class cripto {
    private static String frase = "";
    public static void main(String[] args) {
       
        boolean interruptor = true;
        Scanner sc = new Scanner(System.in);
            while(interruptor){
                menu();
                
                int opcion = sc.nextInt();
                sc.nextLine();//limpiamos el buffer
                
                
            switch(opcion){
                case 1:
                        System.out.println("Vas a salir del programa");
                        interruptor=false;
                        continue;
                case 2:
                        opcion2(sc);
                        break;
                        
                case 3: 
                        System.out.println("Tu frase desenciptada es..."+ frase);
                        break;
            }
        }
        sc.close();
        System.out.println("Has salido del progrma");
     } 
    public static void menu(){
        System.out.println("#######MENU#######"
        +"\n Opcion 1: Salir del programa"
        +"\n Opcion 2: Encriptar la frase"
        +"\n Opcion 3: Desencriptar la frase");
    }
    public static void opcion2(Scanner sc){
        
            try {
                System.out.println("Introduce tu frase a encriptar");
                            
                            frase = sc.nextLine();
                            System.out.println("Tu frase es " + frase);
                // Se crea la generacion de la clave y la clave secreta

                KeyGenerator generador = KeyGenerator.getInstance("AES");
                SecretKey claveSecreta = generador.generateKey();
                // Se crea el cifrador y una estancia del cifrador AES
                Cipher cifrador = Cipher.getInstance("AES");

                //Se realiza la configuracion del cifrador para el modo de cifrado
                //con la instruccion (Cipher.ENCRYPT_MODE) y utilizando la palabra
                //secreta 'claveSecreta'

                cifrador.init(Cipher.ENCRYPT_MODE, claveSecreta);

                //Se utiliza SealedObject para cifrar el String frase, utilizando
                //el cifrador configurado anteriormente.

                SealedObject secreto = new SealedObject(frase, cifrador);

                //Se produce un objeto llamado 'secreto' que contiene el objeto
                // frase cifrado.

                //Se imprime por pantalla la frase original y encriptada

                System.out.println("Se imprime la palabra sin cifrar -------> " +frase);

                // Se imprime por pantalla la frase encriptada

                System.out.println("Se imprime por pantalla la palabra con metodo de cifrado simetrico AES -------> "+secreto);

            } 
        catch (Exception e) {
            System.out.println("Se ha producido un error");
        }
                        
    }
}
