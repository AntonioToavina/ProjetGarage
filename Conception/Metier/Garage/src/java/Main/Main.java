/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import metier.M_Service;

/**
 *
 * @author ITU
 */
public class Main {
    public static void main(String [] args) {
        M_Service ms = new M_Service();
        double rs = ms.revientSalarial("Vidange");
        System.out.println(rs);
    }
}
