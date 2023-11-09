import javax.swing.JOptionPane;

public class Oficina {
    public static void main(String[] args) {
        menuGeral();
    }
    public static void menuGeral(){
        int Seletor = Integer.parseInt(JOptionPane.showInputDialog(null, "1-Menu do Gestor\n2-Menu do Cliente\n\n\n\n\n9-Sair"));
        int holder = 0;
        while(holder == 0){
        switch (Seletor) {
            case 1:
                menuGestor();
                break;
            case 2:
                menuCliente();
                break;
            case 9:
                break;
            }
        }
    }
    public static void menuGestor() {
        int seletor = Integer.parseInt(JOptionPane.showInputDialog(null, "1-Registrar/Alterar registro de carro\n2-Relatar observações\n3-Lista de clientes\n4-Lista de Espera\n5-Saldo\n6- Solicitar permissão para manutenção\n\n\n\n9-Sair"));
        int holder = 0;
        while(holder == 0){
            switch (seletor) {
                case 1:
                    editCar();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 9:
                menuGeral();
                    break;
            }
        }
    }
    public static void menuCliente() {
        int seletor = Integer.parseInt(JOptionPane.showInputDialog(null, "1-Acompanhar serviço\n2-Imprimir relatório\n3-Pagamento\n4-Requerer Comprovante de Pagamento\n5- Solicitações de Manutenção\n\n\n\n9-Sair"));
        int holder = 0;
        while(holder == 0){
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
                menuGeral();
                    break;
            }
        }
    }
    
    public static void editCar() {
        int seletor = Integer.parseInt(JOptionPane.showInputDialog(null,"1-Adicionar veículo\n2-Editar/Adicionar informações\n\n\n\n\n9-Sair"));
        RegCar addCarro = new RegCar();
        addCarro.nomeCarro = JOptionPane.showInputDialog(null, "Informe o modelo do carro: ");
        addCarro.marca = JOptionPane.showInputDialog(null, "Informe a marca do carro: ");
        addCarro.ano = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o modelo do carro: "));
        addCarro.tipoServiço = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o modelo do carro: "));
    }
}
