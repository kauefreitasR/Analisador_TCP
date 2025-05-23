/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package SubMenus;

import SubMenus.Calculos_sec;

/**
 *
 * @author freit
 */
import InterfaceGeral.Interface_E_Funcionamento_Geral;
import InterfaceGeral.Interface_E_Funcionamento_Geral;
import SubMenus.Calculos_sec;
import static SubMenus.Calculos_sec.ultimaSubnet;
import static SubMenus.Calculos_sec.ultimoIP;
import java.awt.Color;

public class Devices_sec extends javax.swing.JInternalFrame {

    /**
     * Creates new form Devices_sec
     */
    public Devices_sec() {
        initComponents();
        // Pega os valores diretamente das variáveis estáticas
        Subnet1.setText(Calculos_sec.ultimaSubnet != null ? Calculos_sec.ultimaSubnet : "");
        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu1 = new java.awt.PopupMenu();
        jPanel1 = new javax.swing.JPanel();
        erroIP1 = new javax.swing.JLabel();
        erroSubnet1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Subnet1 = new javax.swing.JTextField();
        Calcular1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        devices = new javax.swing.JTextArea();

        popupMenu1.setLabel("popupMenu1");

        setClosable(true);

        erroIP1.setText("     ");

        erroSubnet1.setText("         ");

        jLabel5.setText("Endereço Máscara");

        Subnet1.setText("   ");

        Calcular1.setText("Calcular");
        Calcular1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Calcular1ActionPerformed(evt);
            }
        });

        jLabel6.setText("Hosts:");

        devices.setColumns(20);
        devices.setRows(5);
        jScrollPane2.setViewportView(devices);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(80, 80, 80)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(erroIP1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(erroSubnet1, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)))
                            .addComponent(Subnet1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(0, 70, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Calcular1)))
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(erroIP1)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Subnet1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(erroSubnet1))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
                .addComponent(Calcular1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Calcular1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Calcular1ActionPerformed
        String textoSubnet = Subnet1.getText().trim();
        
        ultimaSubnet = textoSubnet;
        erroSubnet1.setText(" ");

        boolean erro = false;

        if(!Interface_E_Funcionamento_Geral.ValidationUtils.validarMascara(textoSubnet) || (!Interface_E_Funcionamento_Geral.ValidationUtils.validarValor(textoSubnet))){
            erroSubnet1.setText("Netmask inválida");
            erroSubnet1.setForeground(Color.red);
            erro = true;
        }
        if (erro) return;

        Interface_E_Funcionamento_Geral.IP ip = new Interface_E_Funcionamento_Geral.IP ("192.168.0.34");
        Interface_E_Funcionamento_Geral.Subnet subnet = new Interface_E_Funcionamento_Geral.Subnet ("192.168.0.34", textoSubnet);

        devices.setText("Numeros de Devices: " + subnet.getNumeroHostsValidos());
    }//GEN-LAST:event_Calcular1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Calcular1;
    private javax.swing.JTextField Subnet1;
    private javax.swing.JTextArea devices;
    private javax.swing.JLabel erroIP1;
    private javax.swing.JLabel erroSubnet1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.PopupMenu popupMenu1;
    // End of variables declaration//GEN-END:variables
}
