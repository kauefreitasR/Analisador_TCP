/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package SubMenus;

/**
 *
 * @author freit
 */
import InterfaceGeral.Interface_E_Funcionamento_Geral;
import SubMenus.Calculos_sec;
import static SubMenus.Calculos_sec.ultimaSubnet;
import static SubMenus.Calculos_sec.ultimoIP;
import java.awt.Color;
public class NumeroHosts_sec extends javax.swing.JInternalFrame {
        public NumeroHosts_sec() {
        initComponents();
        // Pega os valores diretamente das variáveis estáticas
        IP1.setText(Calculos_sec.ultimoIP != null ? Calculos_sec.ultimoIP : "");
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

        erroIP = new javax.swing.JLabel();
        erroSubnet = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        IP = new javax.swing.JTextField();
        Subnet = new javax.swing.JTextField();
        Calcular = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Resultado = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        erroIP1 = new javax.swing.JLabel();
        erroSubnet1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        IP1 = new javax.swing.JTextField();
        Subnet1 = new javax.swing.JTextField();
        Calcular1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        HminHmax = new javax.swing.JTextArea();

        erroIP.setText("     ");

        erroSubnet.setText("         ");

        jLabel1.setText("Endereço IP:");

        jLabel2.setText("Endereço Netmask:");

        IP.setText("   ");
        IP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IPActionPerformed(evt);
            }
        });

        Subnet.setText("   ");

        Calcular.setText("Calcular");
        Calcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalcularActionPerformed(evt);
            }
        });

        jLabel3.setText("Endereço de Rede:");

        Resultado.setColumns(20);
        Resultado.setRows(5);
        jScrollPane1.setViewportView(Resultado);

        setClosable(true);

        erroIP1.setText("     ");

        erroSubnet1.setText("         ");

        jLabel4.setText("Endereço IP");

        jLabel5.setText("Endereço Máscara");

        IP1.setText("   ");
        IP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IP1ActionPerformed(evt);
            }
        });

        Subnet1.setText("   ");

        Calcular1.setText("Calcular");
        Calcular1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Calcular1ActionPerformed(evt);
            }
        });

        jLabel6.setText("Hosts:");

        HminHmax.setColumns(20);
        HminHmax.setRows(5);
        jScrollPane2.setViewportView(HminHmax);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(Subnet1, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                            .addComponent(IP1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(erroIP1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(erroSubnet1, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(0, 77, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Calcular1)))
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(IP1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(erroIP1))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Subnet1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(erroSubnet1)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                .addComponent(Calcular1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IPActionPerformed

    private void CalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalcularActionPerformed
        String textoIP = IP1.getText().trim();
        String textoSubnet = Subnet1.getText().trim();

        ultimoIP = textoIP;
        ultimaSubnet = textoSubnet;

        erroIP1.setText(" ");
        erroSubnet1.setText(" ");

        boolean erro = false;

        if(!Interface_E_Funcionamento_Geral.ValidationUtils.validarIP(textoIP) || (!Interface_E_Funcionamento_Geral.ValidationUtils.validarValor(textoIP))) {
            erroIP1.setText( "IP inválido!");
            erroIP1.setForeground(Color.red);
            erro = true;
        }

        if(!Interface_E_Funcionamento_Geral.ValidationUtils.validarMascara(textoSubnet) || (!Interface_E_Funcionamento_Geral.ValidationUtils.validarValor(textoSubnet))){
            erroSubnet1.setText("Netmask inválida");
            erroSubnet1.setForeground(Color.red);
            erro = true;
        }
        if (erro) return;

        Interface_E_Funcionamento_Geral.IP ip = new Interface_E_Funcionamento_Geral.IP (textoIP);
        Interface_E_Funcionamento_Geral.Subnet subnet = new Interface_E_Funcionamento_Geral.Subnet (textoIP, textoSubnet);
    }//GEN-LAST:event_CalcularActionPerformed

    private void IP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IP1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IP1ActionPerformed

    private void Calcular1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Calcular1ActionPerformed
        String textoIP = IP.getText().trim();
        String textoSubnet = Subnet.getText().trim();

        ultimoIP = textoIP;
        ultimaSubnet = textoSubnet;

        erroIP.setText(" ");
        erroSubnet.setText(" ");

        boolean erro = false;

        if(!Interface_E_Funcionamento_Geral.ValidationUtils.validarIP(textoIP) || (!Interface_E_Funcionamento_Geral.ValidationUtils.validarValor(textoIP))) {
            erroIP.setText( "IP inválido!");
            erroIP.setForeground(Color.red);
            erro = true;
        }

        if(!Interface_E_Funcionamento_Geral.ValidationUtils.validarMascara(textoSubnet) || (!Interface_E_Funcionamento_Geral.ValidationUtils.validarValor(textoSubnet))){
            erroSubnet.setText("Netmask inválida");
            erroSubnet.setForeground(Color.red);
            erro = true;
        }
        if (erro) return;

        Interface_E_Funcionamento_Geral.IP ip = new Interface_E_Funcionamento_Geral.IP (textoIP);
        Interface_E_Funcionamento_Geral.Subnet subnet = new Interface_E_Funcionamento_Geral.Subnet (textoIP, textoSubnet);

        HminHmax.setText("Hosts Máximas: " + subnet.getHostMax() + "\n\n" + "Hosts mínimas: " + subnet.getHostMin());
    }//GEN-LAST:event_Calcular1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Calcular;
    private javax.swing.JButton Calcular1;
    private javax.swing.JTextArea HminHmax;
    private javax.swing.JTextField IP;
    private javax.swing.JTextField IP1;
    private javax.swing.JTextArea Resultado;
    private javax.swing.JTextField Subnet;
    private javax.swing.JTextField Subnet1;
    private javax.swing.JLabel erroIP;
    private javax.swing.JLabel erroIP1;
    private javax.swing.JLabel erroSubnet;
    private javax.swing.JLabel erroSubnet1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
