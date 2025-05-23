package SubMenus;

import InterfaceGeral.Interface_E_Funcionamento_Geral;
import static SubMenus.Calculos_sec.ultimoIP;
import java.awt.Color;

public class TipoRede_sec extends javax.swing.JInternalFrame {
    public TipoRede_sec() {
        initComponents();
        // Pega os valores diretamente das variáveis estáticas
        IP.setText(Calculos_sec.ultimoIP != null ? Calculos_sec.ultimoIP : "");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        popupMenu1 = new java.awt.PopupMenu();
        popupMenu2 = new java.awt.PopupMenu();
        popupMenu3 = new java.awt.PopupMenu();
        popupMenu4 = new java.awt.PopupMenu();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        IP = new javax.swing.JTextField();
        ipTipo = new javax.swing.JTextField();
        Analisar = new javax.swing.JButton();
        erroIP = new javax.swing.JLabel();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        popupMenu1.setLabel("popupMenu1");

        popupMenu2.setLabel("popupMenu2");

        popupMenu3.setLabel("popupMenu3");

        popupMenu4.setLabel("popupMenu4");

        setClosable(true);

        jLabel1.setText("Digite endereço IP:");

        jLabel2.setText("Tipo de Rede:");

        IP.setText("   ");
        IP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IPActionPerformed(evt);
            }
        });

        ipTipo.setText("      ");
        ipTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ipTipoActionPerformed(evt);
            }
        });

        Analisar.setText("Analisar");
        Analisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnalisarActionPerformed(evt);
            }
        });

        erroIP.setText("        ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Analisar)
                .addGap(29, 29, 29))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(IP)
                    .addComponent(ipTipo, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(erroIP, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IP, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(erroIP, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ipTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(Analisar)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IPActionPerformed

    private void ipTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ipTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ipTipoActionPerformed

    private void AnalisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnalisarActionPerformed
        String textoIP = IP.getText().trim();
        
        ultimoIP = textoIP;

        erroIP.setText(" ");

        boolean erro = false;

        if(!Interface_E_Funcionamento_Geral.ValidationUtils.validarIP(textoIP) || (!Interface_E_Funcionamento_Geral.ValidationUtils.validarValor(textoIP))) {
            erroIP.setText( "IP inválido!");
            erroIP.setForeground(Color.red);
            erro = true;
        }
        if (erro) return;
        
        Interface_E_Funcionamento_Geral.IP ip = new Interface_E_Funcionamento_Geral.IP (textoIP);
        Interface_E_Funcionamento_Geral.Subnet subnet = new Interface_E_Funcionamento_Geral.Subnet (textoIP, "255.255.255.0");
        
        ipTipo.setText ("Rede" + subnet.getTipoRede());
    }//GEN-LAST:event_AnalisarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Analisar;
    private javax.swing.JTextField IP;
    private javax.swing.JLabel erroIP;
    private javax.swing.JTextField ipTipo;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private java.awt.PopupMenu popupMenu1;
    private java.awt.PopupMenu popupMenu2;
    private java.awt.PopupMenu popupMenu3;
    private java.awt.PopupMenu popupMenu4;
    // End of variables declaration//GEN-END:variables
}
