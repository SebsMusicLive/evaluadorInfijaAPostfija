    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package evaluadorExpresionesAritmeticas;

/**
 *
 * @author ASUS
 */
public class ClienteEvaluador {
    public static void main(String[] args) throws Exception {
        Evaluador ev = new Evaluador();
       
        System.out.println(ev.transformar("2+4/5*(5-3)^5^4"));
        //System.out.println(ev.print());
    }
}
