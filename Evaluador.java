/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package evaluadorExpresionesAritmeticas;

/**
 *
 * @author ASUS
 */
public class Evaluador {

    PilaLista<String> operadores = new PilaLista<>();

    public String transformar(String expresionInfija) throws Exception {
        String rta = "";

        for (int i = 0; i < expresionInfija.length(); i++) {
            char lt = expresionInfija.charAt(i);
            String oper = String.valueOf(lt).trim();

            switch (oper) {
                case "+", "-", "/", "*", "^", "(", ")" ->
                    rta += devolverOperadores(oper);
                default ->
                    rta += oper;
            }

        }

        while (!operadores.estaPilaVacia()) {
            rta += operadores.pop();
        }

        return rta;
    }

    public String devolverOperadores(String operador) throws Exception {
        String rta = "";
        if (operadores.estaPilaVacia()) {
            operadores.push(operador);
        } else {
            String oper = (String) operadores.obtenerCimaPila();

            if ("(".equals(operador)) {
                operadores.push(operador);
            } else if (")".equals(operador)) {
                while (!operadores.obtenerCimaPila().equals("(")) {
                    rta += operadores.pop();
                }
                operadores.pop();
            } else if (prioridad(operador) > prioridad(oper)) {
                operadores.push(operador);
            } else {
                while (prioridad(operador) <= prioridad(oper)) {
                    rta += operadores.pop();
                    if (operadores.estaPilaVacia()) {
                        break;
                    }
                    oper = (String) operadores.obtenerCimaPila();
                }
                operadores.push(operador);
            }
        }

        return rta;
    }

    public int prioridad(String operador) {
        int prio;
        switch (operador) {
            case "+", "-" ->
                prio = 1;
            case "*", "/" ->
                prio = 2;
            case "^" ->
                prio = 3;
            default ->
                prio = 0;
        }
        return prio;
    }

}
