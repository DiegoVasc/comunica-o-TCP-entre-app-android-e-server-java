
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class Trabalhosdrefatorado extends javax.swing.JFrame {
    static Socket s;
    static ServerSocket ss;
    static InputStreamReader isr;
    static BufferedReader br;
    static String mensagem = "";
    static ArrayList<String> acelerometro = new ArrayList();
    static String dados;//campo que recebera os valores da mensagem para separar no array de String acelerometro_dados
    static String acelerometro_dados[] = new String[2000];//array onde armazena os dados separados
 
    static ArrayList<Double> numx = new ArrayList<Double>();
    static ArrayList<Double> numy = new ArrayList<Double>();
    static ArrayList<Double> numz = new ArrayList<Double>();
    //static double[] numy = new double[650];
   // static double[] numz = new double[650];
    
    /**
     * Creates new form MyServerFrame
     */
    public Trabalhosdrefatorado() {
        initComponents();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Trabalhosdrefatorado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Trabalhosdrefatorado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Trabalhosdrefatorado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Trabalhosdrefatorado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Trabalhosdrefatorado().setVisible(true);
            }
        });
     
        try {
            ss = new ServerSocket(6000);
            while(true){
            s = ss.accept();
            isr = new InputStreamReader(s.getInputStream());
            br = new BufferedReader(isr);
            mensagem = br.readLine();
           
            acelerometro.add(mensagem);//arraylist onde recebera o pacote de com os dados do android app
            int n = acelerometro.size();//pega o tamanho do arraylist para ultilizar no "for" a seguir
            for(int i=0;i<n;i++){
                dados=acelerometro.get(i);//recebe os dados sem separar-los
                acelerometro_dados = dados.split(" ");//separa os dados recebidos da variavel "dados" para separar onde a quebra de linha(space)
                 //System.out.printf(acelerometro.get(i));//printa na saida os dados recebidos
            
            }
            int j=-1;//variavel auxiliar para mostra os dados
            int i;
              int x,y,z;
              x= y = z=-1;
           for(i=0;i<acelerometro_dados.length;i++){
                if(i %3 == 0){
                    j++;
                   
                    numx.add(Double.parseDouble(acelerometro_dados[j]));
                   
                    // System.out.println("\nx:"+acelerometro_dados[j]);
                    jTextArea1.append("\nx:" + acelerometro_dados[j]);
                                 
                    j++;
                    numy.add(Double.parseDouble(acelerometro_dados[j])); 
                    
                    jTextArea1.append("\ny:" + acelerometro_dados[j]);
                    //System.out.println("\ny:"+acelerometro_dados[j]);
                    
                    j++;
                   
                    numz.add(Double.parseDouble(acelerometro_dados[j])); 
                    
                    jTextArea1.append("\nz:" + acelerometro_dados[j]);
                   // System.out.println("\nz:"+acelerometro_dados[j]);
                    jTextArea1.append("\n");
                    
                    //System.out.println(numy[y]+"\n");
                   // System.out.println(numz[z]+"\n");
                   // System.out.println("\n");
                    
                    

                } 
            }
   
           

           // System.out.println(mensagem);// onde mostrava inicialmente a mensagem inicial na saida(teste de saida) 
            
            //jTextArea1.append(mensagem); // printa na tela jtextArea as informações recebidas.
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
