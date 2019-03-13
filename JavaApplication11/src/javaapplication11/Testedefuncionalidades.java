/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication11;

import java.util.Random;

/**
 *
 * @author DELL
 */
public class Testedefuncionalidades {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String V[]= new String[40];
       
        String teste = "101010101";
        double number = Double.parseDouble(teste);
        System.out.println("The number is:" + number);
        int m[]=new int[21];
        int i,j;
            for(i=0;i<11;i++){
              
                m[i]=i;
                //m[i]=(int) (Math.random() * 100);
            }
               j=-1;
               int x,y,z=0;
               for(i=0;i<11;i++){
                   
                   if(i %3 == 0){
                        j++;
                        System.out.println("\nx:"+m[j]);
                         j++;
                        System.out.println("\ny:"+m[j]);
                         j++;
                        System.out.println("\nz:"+m[j]);
                        
                    }
                   

                }
    }

}    

