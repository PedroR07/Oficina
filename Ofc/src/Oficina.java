import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class Oficina {
    public static void main(String[] args) {
        inicializar(caminhoFila);
        menuGeral();
    }
    public static void menuGeral() {
        boolean holder = true;
        while (holder) {
            int Seletor = Integer.parseInt(JOptionPane.showInputDialog(null, "1-Menu do Gestor\n2-Menu do Cliente\n\n\n\n\n9-Sair"));
            switch (Seletor) {
                case 1:
                    menuGestor();
                    break;
                case 2:
                    menuCliente();
                    break;
                case 9:
                    holder = false;
                    break;
            }
        }
    }
    
    public static void menuGestor() {
        boolean holder = true;
        while (holder) {
            int seletor = Integer.parseInt(JOptionPane.showInputDialog(null, "1-Registrar/Alterar registro de carro\n2-Relatar observações\n3-Lista de clientes\n4-Lista de Espera\n5-Saldo\n6- Solicitar permissão para manutenção\n\n\n\n9-Sair"));
            switch (seletor) {
                case 1:
                    editCar();
                    break;
                case 2:
                    // Adicionar código para a opção 2
                    break;
                case 3:
                    // Adicionar código para a opção 3
                    break;
                case 4:
                    // Adicionar código para a opção 4
                    break;
                case 5:
                    // Adicionar código para a opção 5
                    break;
                case 6:
                    // Adicionar código para a opção 6
                    break;
                case 9:
                    holder = false;
                    break;
            }
        }
    }
    public static void menuCliente() {
        boolean holder = true;
        while(holder == true){
            int seletor = Integer.parseInt(JOptionPane.showInputDialog(null, "1-Acompanhar serviço\n2-Imprimir relatório\n3-Pagamento\n4-Requerer Comprovante de Pagamento\n5- Solicitações de Manutenção\n\n\n\n9-Sair"));
            switch (seletor) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 9:
                holder = false;
                menuGeral();
                    break;
            }
        }
    }
    
    public static void editCar() {
        boolean holder = true;
        while(holder == true){
        int seletor = Integer.parseInt(JOptionPane.showInputDialog(null,"1-Adicionar veículo\n2-Editar/Adicionar informações\n\n\n\n\n9-Sair"));
        switch (seletor) {
            case 1:
                    RegCar addCarro = new RegCar();
                    addCarro.nomeCarro = JOptionPane.showInputDialog(null, "Informe o modelo do carro: ");
                    addCarro.marca = JOptionPane.showInputDialog(null, "Informe a marca do carro: ");
                    addCarro.ano = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o ano do carro: "));
                    addCarro.tipoServiço = Integer.parseInt(JOptionPane.showInputDialog(null, "Especifique os serviços as serem prestados:\n1- Alinhamento\n2-Balanceamento\n3-Revisão"));
                    
                    try{
                    addTxt(addCarro);
                    }
                    catch(FileNotFoundException e){
                        JOptionPane.showMessageDialog(null, "Algum erro ocorreu.");
                    }
                    
                break;
        
            case 9:
                holder = false;
                return;
        }
        }
    }

    public static boolean addTxt(RegCar Carro) throws FileNotFoundException{
        int id = 1;
        PrintWriter pw = new PrintWriter(caminhoFila + id + ".txt");
        pw.println(Carro.nomeCarro);
        pw.println(Carro.marca);
        pw.println(Carro.ano);
        pw.println(Carro.tipoServiço);
        pw.flush();
        pw.close();
        JOptionPane.showMessageDialog(null, "Veículo registrado com sucesso!");
        return false;
    }
    private static void inicializar(String caminhoFila) {
		File dir=new File(caminhoFila);
		if(!dir.exists()) {
			dir.mkdir();
		}
	}
    public static String caminhoFila = "Fila/";
    public static String caminhoCtts = "Contatos/";

}
