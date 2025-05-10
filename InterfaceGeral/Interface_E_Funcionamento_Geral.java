package InterfaceGeral;

// chama importações 
import SubMenus.Devices_sec;
import SubMenus.NumeroHosts_sec;
import SubMenus.NumeroRede_sec;
import SubMenus.TipoRede_sec;
import SubMenus.ClasseRede_sec;
import SubMenus.Calculos_sec;
import SubMenus.Abrir_calculo_salvo_sec;
import SubMenus.Convercao_sec;
import SubMenus.Edit_calculos_sec;
import SubMenus.Exportar_calculo_sec;
import SubMenus.Salvar_calculo_sec;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author Kauê Freitas e Sofia Leal
 */

//inicia prorama 
public class Interface_E_Funcionamento_Geral extends javax.swing.JFrame {
    //declara IP e define um
    public static class IP {
        private String endereco;
        private String binario;
        
        public IP (String endereco) {
            this.endereco = endereco;
            this.binario = BinaryUtils.converterParaBinario(endereco);
        }
        
        // Getters
        public String getEndereco() { return endereco; }
        public String getBinario() { return binario; }
    }
    //cria método para converção em binário (e outros métodos que exijam cálculo ou binarização)
    public static class BinaryUtils {
        public static String converterParaBinario(String to_bin) {
            String[] octetos = to_bin.split("\\.");
            StringBuilder binario = new StringBuilder();
            
            for (String octeto : octetos) {
                int octetoInt = Integer.parseInt(octeto);
                String octetoBin = String.format("%8s", Integer.toBinaryString(octetoInt))
                                  .replace(' ', '0');
                binario.append(octetoBin).append(".");
            }

            return binario.substring(0, binario.length() - 1);
            }
        //cria método para descobrir Wildcard a paritr da máscara
        public static String calcularWildcard(String mascaraDecimal) {
        String[] octetos = mascaraDecimal.split("\\.");
        StringBuilder wildcard = new StringBuilder();

        for (String octeto : octetos) {
            int wildcardOcteto = 255 - Integer.parseInt(octeto);
            wildcard.append(wildcardOcteto).append(".");
        }

        return wildcard.substring(0, wildcard.length() - 1); // Remove o último "."
        }
        //cria método para definir o Endereço de Rede a partir do IP e macara (binários)
        public static String calcularEnderecoRede(String ipDecimal, String mascaraDecimal) {
        // Converte IP e máscara para binário (sem pontos)
        String ipBinario = converterParaBinario(ipDecimal).replace(".", "");
        String mascaraBinario = converterParaBinario(mascaraDecimal).replace(".", "");

        // Aplica AND bit a bit
        StringBuilder enderecoRedeBinario = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            char bitIP = ipBinario.charAt(i);
            char bitMascara = mascaraBinario.charAt(i);
            enderecoRedeBinario.append((bitIP == '1' && bitMascara == '1') ? '1' : '0');
        }

        // Converte o binário de volta para decimal (insere pontos a cada 8 bits)
        return binarioParaDecimal(enderecoRedeBinario.toString());
        }

        public static String binarioParaDecimal(String binario) {
            StringBuilder decimal = new StringBuilder();
            for (int i = 0; i < 32; i += 8) {
                String octetoBin = binario.substring(i, i + 8);
                decimal.append(Integer.parseInt(octetoBin, 2)).append(".");
            }
            return decimal.substring(0, decimal.length() - 1); // Remove o último "."
        }

        public static String calcularBroadcast(String enderecoRede, String wildcard) {
        // Remove os pontos e converte para arrays de inteiros
        int[] redeOctetos = Arrays.stream(enderecoRede.split("\\."))
                                  .mapToInt(Integer::parseInt)
                                  .toArray();
        int[] wildcardOctetos = Arrays.stream(wildcard.split("\\."))
                                      .mapToInt(Integer::parseInt)
                                      .toArray();

        // Calcula o OR bit a bit para cada octeto
        StringBuilder broadcast = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int octetoBroadcast = redeOctetos[i] | wildcardOctetos[i];
            broadcast.append(octetoBroadcast).append(".");
        }

        return broadcast.substring(0, broadcast.length() - 1); // Remove o último "."
        }

    }
    // métodos para validações
    public static class ValidationUtils {
        public static boolean validarValor(String to_bin) {
            return to_bin.matches("^\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}$");
            }
            //cria método para validação do formato 4 octetos de uma máscara e um IP
        public static boolean validarIP(String IPbinario){
            String[] octetos = IPbinario.split("\\.");

            // Percorre cada octeto do IP
            for (String octeto : octetos) {
                // Verifica se o octeto tem zeros à esquerda
                if (octeto.startsWith("0") && octeto.length() > 1) {
                    return false; // Retorna false se houver zeros à esquerda
                }

                try {
                    // Converte o octeto para inteiro
                    int valor = Integer.parseInt(octeto);

                    // Verifica se o valor está no intervalo permitido (0-255)
                    if (valor < 0 || valor > 255) {
                        return false; // Retorna false se o valor do octeto for inválido
                    }
                } catch (NumberFormatException e) {
                    // Exibe uma mensagem de erro caso o octeto não seja um número válido
                    return false; // Retorna false se houver erro na conversão
                }
            }

            // Retorna true se todos os octetos forem válidos
            return true;
        }
        //cria método para validação exclusiva de mascaras
        public static boolean validarMascara(String mascaraDecimal) {
        if (!validarValor(mascaraDecimal)) return false;

        String binario = BinaryUtils.converterParaBinario(mascaraDecimal).replace(".", "");
        boolean encontrouZero = false;

        for (char bit : binario.toCharArray()) {
            if (bit == '1' && encontrouZero) {
                return false;
            } else if (bit == '0') {
                encontrouZero = true;
            }
        }
        return true;
        }
    }
    //cria métodos para a Subnet (e descobrir outros valores
    public static class Subnet {
    private String enderecomask;
    private String binariomask;
    private int cidr;
    private String wildcard;
    private String wildcardBinario;
    private String enderecoRede;
    private String enderecoRedeBinario;
    private String broadcast;
    private String broadcastBinario;
    
        public Subnet(String ip, String mascara) {
            this.enderecomask = mascara;
            this.binariomask = BinaryUtils.converterParaBinario(mascara);
            this.cidr = CIDRUtils.calcularCIDR(binariomask.replace(".", ""));
            this.wildcard = BinaryUtils.calcularWildcard(mascara);
            this.wildcardBinario = BinaryUtils.converterParaBinario(this.wildcard);
            this.enderecoRede = BinaryUtils.calcularEnderecoRede(ip, mascara);
            this.enderecoRedeBinario = BinaryUtils.converterParaBinario(this.enderecoRede);
            this.broadcast = BinaryUtils.calcularBroadcast(enderecoRede, wildcard);
            this.broadcastBinario = BinaryUtils.converterParaBinario(this.broadcast);
        }

        public void exportarResultados(IP ip, String formato, String caminho) throws IOException {
        switch (formato.toLowerCase()) {
            case "csv":
                Exportador.exportarParaCSV(this, ip, caminho);
                break;
            case "txt":
                Exportador.exportarParaTXT(this, ip, caminho);
                break;
            case "xml":
                Exportador.exportarParaXML(this, ip, caminho);
                break;
            default:
                throw new IllegalArgumentException("Formato não suportado: " + formato);
        }
    }
        public String getEnderecomask() { return enderecomask; }
        public String getBinariomask() { return binariomask; }
        public int getCidr() { return cidr; }
        public String getWildcard() { return wildcard; }
        public String getWildcardBinario() { return wildcardBinario; }
        public String getEnderecoRede() { return enderecoRede; }
        public String getEnderecoRedeBinario() { return enderecoRedeBinario; }
        public String getBroadcast() { return broadcast; }
        public String getBroadcastBinario() { return broadcastBinario; }
        public String getTipoRede(){
        int primeiroOcteto = Integer.parseInt(enderecoRede.split("\\.")[0]);
            
            if (primeiroOcteto == 127){
                return "Loopback";
            }
            if (primeiroOcteto == 169){
                return "APIPA";
            }
            if (primeiroOcteto >= 1 && primeiroOcteto <= 126) {
                return "Privada, usada para redes grandes.";
            } else if (primeiroOcteto >= 128 && primeiroOcteto <= 191) {
                return "Privada, usada para redes médias.";
            } else if (primeiroOcteto >= 192 && primeiroOcteto <= 223) {
                return "Privada, usada para redes pequenas.";
            } else if (primeiroOcteto >= 224 && primeiroOcteto <= 239) {
                return "(Multicast)";
            } else if (primeiroOcteto >= 240 && primeiroOcteto <= 255) {
                return "(Experimental)";
            } else {
                return "Desconhecida";
            }
        }
        
        public String getClasseRede() {
        int primeiroOcteto = Integer.parseInt(enderecoRede.split("\\.")[0]);
            
            if (primeiroOcteto == 127){
                return "Loopback";
            }
            if (primeiroOcteto == 169){
                return "APIPA";
            }
            if (primeiroOcteto >= 1 && primeiroOcteto <= 126) {
                return "A";
            } else if (primeiroOcteto >= 128 && primeiroOcteto <= 191) {
                return "B";
            } else if (primeiroOcteto >= 192 && primeiroOcteto <= 223) {
                return "C";
            } else if (primeiroOcteto >= 224 && primeiroOcteto <= 239) {
                return "D";
            } else if (primeiroOcteto >= 240 && primeiroOcteto <= 255) {
                return "E";
            } else {
                return "Desconhecida";
            }
        }
        
        public String getHostMin() {
        String[] octetos = enderecoRede.split("\\.");
        octetos[3] = String.valueOf(Integer.parseInt(octetos[3]) + 1);
        return String.join(".", octetos);
        }

        public String getHostMinBinario() {
            return BinaryUtils.converterParaBinario(getHostMin());
        }

        public String getHostMax() {
        String[] octetos = broadcast.split("\\.");
        octetos[3] = String.valueOf(Integer.parseInt(octetos[3]) - 1);
        return String.join(".", octetos);
        }

        public String getHostMaxBinario(){
            return BinaryUtils.converterParaBinario(getHostMax());
        }

        public int getNumeroHostsValidos() {
        return (int) (Math.pow(2, 32 - cidr) - 2);
        }
    }
    
    public static class CIDRUtils {
        public static int calcularCIDR(String binariomask){
            int count = 0;
            for (int i = 0; i < binariomask.length(); i++){
                char c = binariomask.charAt(i);
                if (c == '1'){
                    count++;
                }else if (c == '0'){
                    break;
                }
            }    
            return count;
        }
    }

    public static class Exportador {
        public static void exportarParaCSV(Subnet subnet, IP ip, String caminhoArquivo) throws IOException {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo))) {
                writer.write("Campo,Decimal,Binário\n");
                writer.write("IP," + ip.getEndereco() + "," + ip.getBinario() + "\n");
                writer.write("Netmask," + subnet.getEnderecomask() + "," + subnet.getBinariomask() + "\n");
                writer.write("CIDR,/," + subnet.getCidr() + "\n");
                writer.write("Wildcard," + subnet.getWildcard() + "," + subnet.getWildcardBinario() + "\n");
                writer.write("Network," + subnet.getEnderecoRede() + "," + subnet.getEnderecoRedeBinario() + "\n");
                writer.write("Classe,," + subnet.getClasseRede() + "\n");
                writer.write("Broadcast," + subnet.getBroadcast() + "," + subnet.getBroadcastBinario() + "\n");
                writer.write("HostMin," + subnet.getHostMin() + "," + subnet.getHostMinBinario() + "\n");
                writer.write("HostMax," + subnet.getHostMax() + "," + subnet.getHostMaxBinario() + "\n");
                writer.write("Hosts Válidos,," + subnet.getNumeroHostsValidos() + "\n");
            }
        }

        public static void exportarParaTXT(Subnet subnet, IP ip, String caminhoArquivo) throws IOException {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo))) {
                writer.write("=== IP ===\n");
                writer.write("Decimal: " + ip.getEndereco() + "\n");
                writer.write("Binário: " + ip.getBinario() + "\n");

                writer.write("\n=== Máscara de Sub-rede ===\n");
                writer.write("Decimal: " + subnet.getEnderecomask() + "\n");
                writer.write("Binário: " + subnet.getBinariomask() + "\n");
                writer.write("CIDR: /" + subnet.getCidr() + "\n");

                writer.write("\n=== Wildcard ===\n");
                writer.write("Decimal: " + subnet.getWildcard() + "\n");
                writer.write("Binário: " + subnet.getWildcardBinario() + "\n");

                writer.write("\n=== Endereço de Rede ===\n");
                writer.write("Decimal: " + subnet.getEnderecoRede() + "\n");
                writer.write("Binário: " + subnet.getEnderecoRedeBinario() + "\n");
                writer.write("Classe: " + subnet.getClasseRede() + "\n");

                writer.write("\n=== Broadcast ===\n");
                writer.write("Decimal: " + subnet.getBroadcast() + "\n");
                writer.write("Binário: " + subnet.getBroadcastBinario() + "\n");

                writer.write("\n=== HostMin ===\n");
                writer.write("Decimal: " + subnet.getHostMin() + "\n");
                writer.write("Binário: " + subnet.getHostMinBinario() + "\n");

                writer.write("\n=== HostMax ===\n");
                writer.write("Decimal: " + subnet.getHostMax() + "\n");
                writer.write("Binário: " + subnet.getHostMaxBinario() + "\n");

                writer.write("\n=== Total ===\n");
                writer.write("Hosts Válidos: " + subnet.getNumeroHostsValidos() + "\n");
            }
        }

        public static void exportarParaXML(Subnet subnet, IP ip, String caminhoArquivo) throws IOException {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo))) {
                writer.write("<rede>\n");
                writer.write("  <ip decimal=\"" + ip.getEndereco() + "\" binario=\"" + ip.getBinario() + "\"/>\n");
                writer.write("  <netmask decimal=\"" + subnet.getEnderecomask() + "\" binario=\"" + subnet.getBinariomask() + "\"/>\n");
                writer.write("  <cidr>" + subnet.getCidr() + "</cidr>\n");
                writer.write("  <wildcard decimal=\"" + subnet.getWildcard() + "\" binario=\"" + subnet.getWildcardBinario() + "\"/>\n");
                writer.write("  <network decimal=\"" + subnet.getEnderecoRede() + "\" binario=\"" + subnet.getEnderecoRedeBinario() + "\"/>\n");
                writer.write("  <classe>" + subnet.getClasseRede() + "</classe>\n");
                writer.write("  <broadcast decimal=\"" + subnet.getBroadcast() + "\" binario=\"" + subnet.getBroadcastBinario() + "\"/>\n");
                writer.write("  <hostmin decimal=\"" + subnet.getHostMin() + "\" binario=\"" + subnet.getHostMinBinario() + "\"/>\n");
                writer.write("  <hostmax decimal=\"" + subnet.getHostMax() + "\" binario=\"" + subnet.getHostMaxBinario() + "\"/>\n");
                writer.write("  <hosts_validos>" + subnet.getNumeroHostsValidos() + "</hosts_validos>\n");
                writer.write("</rede>");
            }
        }
    }
    
    private static int calculosAbertos = 0;

    public static void atualizarMenuEditar(boolean adicionar) {
        calculosAbertos += adicionar ? 1 : -1;
        Editar_prin.setVisible(calculosAbertos > 0);

        if (calculosAbertos < 0) {
            calculosAbertos = 0;
        }
    }
    public Interface_E_Funcionamento_Geral() {
        initComponents();  
        Editar_prin.setVisible(false);
    }
    
    /**
     * Creates new form Interfacederedes
     */

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Painel_principal = new javax.swing.JDesktopPane();
        Barra_de_menu = new javax.swing.JMenuBar();
        Calcular_prin = new javax.swing.JMenu();
        calculos_sec = new javax.swing.JMenuItem();
        Editar_prin = new javax.swing.JMenu();
        Edit_calculos_sec = new javax.swing.JMenuItem();
        Conversao_sec = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        Analise_prin = new javax.swing.JMenu();
        TipoRede_sec = new javax.swing.JMenuItem();
        ClasseRede_sec = new javax.swing.JMenuItem();
        NumeroRede_sec = new javax.swing.JMenuItem();
        NumeroHosts = new javax.swing.JMenuItem();
        Devices_sec = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout Painel_principalLayout = new javax.swing.GroupLayout(Painel_principal);
        Painel_principal.setLayout(Painel_principalLayout);
        Painel_principalLayout.setHorizontalGroup(
            Painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 683, Short.MAX_VALUE)
        );
        Painel_principalLayout.setVerticalGroup(
            Painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 415, Short.MAX_VALUE)
        );

        Calcular_prin.setText("Calcular");
        Calcular_prin.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                Calcular_prinHierarchyChanged(evt);
            }
        });
        Calcular_prin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Calcular_prinActionPerformed(evt);
            }
        });

        calculos_sec.setText("calculos");
        calculos_sec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculos_secActionPerformed(evt);
            }
        });
        Calcular_prin.add(calculos_sec);

        Barra_de_menu.add(Calcular_prin);

        Editar_prin.setText("Editar");
        Editar_prin.setActionCommand("Editar_prin");
        Editar_prin.setName("Editar_prin"); // NOI18N
        Editar_prin.setRequestFocusEnabled(false);
        Editar_prin.setRolloverEnabled(false);
        Editar_prin.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                Editar_prinAncestorMoved(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                Editar_prinAncestorRemoved(evt);
            }
        });

        Edit_calculos_sec.setText("Cálculos");
        Edit_calculos_sec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Edit_calculos_secActionPerformed(evt);
            }
        });
        Editar_prin.add(Edit_calculos_sec);

        Conversao_sec.setText("Conversão");
        Conversao_sec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Conversao_secActionPerformed(evt);
            }
        });
        Editar_prin.add(Conversao_sec);
        Editar_prin.add(jSeparator1);

        Barra_de_menu.add(Editar_prin);
        Editar_prin.getAccessibleContext().setAccessibleName("");

        Analise_prin.setText("Análise");
        Analise_prin.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                Analise_prinAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        TipoRede_sec.setText("Tipo de Rede");
        TipoRede_sec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TipoRede_secActionPerformed(evt);
            }
        });
        Analise_prin.add(TipoRede_sec);

        ClasseRede_sec.setText("Classe de Rede");
        ClasseRede_sec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClasseRede_secActionPerformed(evt);
            }
        });
        Analise_prin.add(ClasseRede_sec);

        NumeroRede_sec.setText("Numerro de Rede");
        NumeroRede_sec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumeroRede_secActionPerformed(evt);
            }
        });
        Analise_prin.add(NumeroRede_sec);

        NumeroHosts.setText("Número de Hosts");
        NumeroHosts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumeroHostsActionPerformed(evt);
            }
        });
        Analise_prin.add(NumeroHosts);

        Devices_sec.setText("Devices");
        Devices_sec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Devices_secActionPerformed(evt);
            }
        });
        Analise_prin.add(Devices_sec);

        Barra_de_menu.add(Analise_prin);

        setJMenuBar(Barra_de_menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Painel_principal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Painel_principal)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void calculos_secActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculos_secActionPerformed
        // TODO add your handling code here:
        
        Calculos_sec calculos = new Calculos_sec();
        Painel_principal.add(calculos);
        calculos.setVisible(true);
        atualizarMenuEditar(true);
    }//GEN-LAST:event_calculos_secActionPerformed

    private void Conversao_secActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Conversao_secActionPerformed
        // TODO add your handling code here:
        
        Convercao_sec Convert = new Convercao_sec();
        Painel_principal.add(Convert);
        Convert.setVisible(true);
    }//GEN-LAST:event_Conversao_secActionPerformed

    private void Edit_calculos_secActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Edit_calculos_secActionPerformed
            // Verifica se há dados calculados
        if (SubMenus.Calculos_sec.ultimoIP == null || SubMenus.Calculos_sec.ultimaSubnet == null) {
            JOptionPane.showMessageDialog(this, 
                "Calcule primeiro um IP e Subnet!", 
                "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Edit_calculos_sec edit = new Edit_calculos_sec();
        edit.setVisible(true);
        Painel_principal.add(edit);
    }//GEN-LAST:event_Edit_calculos_secActionPerformed

    private void ClasseRede_secActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClasseRede_secActionPerformed
        // TODO add your handling code here:
        
        ClasseRede_sec Analise = new ClasseRede_sec();
        Painel_principal.add(Analise);
        Analise.setVisible(true);
    }//GEN-LAST:event_ClasseRede_secActionPerformed

    private void Editar_prinAncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_Editar_prinAncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_Editar_prinAncestorMoved

    private void Editar_prinAncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_Editar_prinAncestorRemoved
        // TODO add your handling code here:
    }//GEN-LAST:event_Editar_prinAncestorRemoved

    private void Analise_prinAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_Analise_prinAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_Analise_prinAncestorAdded

    private void Calcular_prinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Calcular_prinActionPerformed

    }//GEN-LAST:event_Calcular_prinActionPerformed

    private void Calcular_prinHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_Calcular_prinHierarchyChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_Calcular_prinHierarchyChanged

    private void TipoRede_secActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TipoRede_secActionPerformed
        TipoRede_sec TipoRede_sec = new TipoRede_sec();
        Painel_principal.add(TipoRede_sec);
        TipoRede_sec.setVisible(true);
    }//GEN-LAST:event_TipoRede_secActionPerformed

    private void NumeroRede_secActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NumeroRede_secActionPerformed
        NumeroRede_sec NumeroRede = new NumeroRede_sec();
        Painel_principal.add(NumeroRede);
        NumeroRede.setVisible(true);
        
    }//GEN-LAST:event_NumeroRede_secActionPerformed

    private void NumeroHostsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NumeroHostsActionPerformed
        NumeroHosts_sec hosts = new NumeroHosts_sec();
        Painel_principal.add(hosts);
        hosts.setVisible(true);
    }//GEN-LAST:event_NumeroHostsActionPerformed

    private void Devices_secActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Devices_secActionPerformed
        Devices_sec devices = new Devices_sec();
        Painel_principal.add(devices);
        devices.setVisible(true);
    }//GEN-LAST:event_Devices_secActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface_E_Funcionamento_Geral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Interface_E_Funcionamento_Geral().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Analise_prin;
    private javax.swing.JMenuBar Barra_de_menu;
    private javax.swing.JMenu Calcular_prin;
    private javax.swing.JMenuItem ClasseRede_sec;
    private javax.swing.JMenuItem Conversao_sec;
    private javax.swing.JMenuItem Devices_sec;
    private javax.swing.JMenuItem Edit_calculos_sec;
    private static javax.swing.JMenu Editar_prin;
    private javax.swing.JMenuItem NumeroHosts;
    private javax.swing.JMenuItem NumeroRede_sec;
    private javax.swing.JDesktopPane Painel_principal;
    private javax.swing.JMenuItem TipoRede_sec;
    private javax.swing.JMenuItem calculos_sec;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
