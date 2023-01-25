/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Metier.M_Service;
import Model.PrixService;
import java.util.ArrayList;

/**
 *
 * @author antonio
 */
public class Main {
    public static void main(String[] args) {
        try {
            ArrayList<PrixService> list = new M_Service().getAll_PrixService();
            System.out.println(list.size());
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
    }
}
