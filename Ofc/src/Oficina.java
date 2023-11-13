
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class Oficina {
    public static void main(String[] args) {
        startCaminho(caminhoFila);
        lerId();
        menuGeral();
    }
    
    public static void menuGeral() {
        boolean holder = true;
        while (holder) {
            try{
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
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Insira um valor válido!");
            }
            }
        }
    
    public static void menuGestor() {
        boolean holder = true;
        while (holder) {
            int seletor = Integer.parseInt(JOptionPane.showInputDialog(null, "1-Registrar carro\n2-Alterar/Relatar observações\n3-Lista de clientes\n4-Lista de Espera\n5-Saldo\n6- Solicitar permissão para manutenção\n\n\n\n9-Voltar"));
            switch (seletor) {
                case 1:
                    addCar();
                    break;
                case 2:
                    editCar();
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
            try{
            int seletor = Integer.parseInt(JOptionPane.showInputDialog(null, "1-Acompanhar serviço\n2-Imprimir relatório\n3-Pagamento\n4-Requerer Comprovante de Pagamento\n5- Solicitações de Manutenção\n\n\n\n9-Voltar"));
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
                    break;
                }
            }
            catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Insira uma valor válido!");
            }
        }
    }
    
    public static void addCar() {
        boolean holder = true;
        while(holder == true){
        try{
        int seletor = Integer.parseInt(JOptionPane.showInputDialog(null,"1-Adicionar veículo\n2-Editar/Adicionar informações\n\n\n\n\n9-Voltar"));
        switch (seletor) {
            case 1:
                    RegCar addCarro = new RegCar();
                    addCarro.nomeCarro = JOptionPane.showInputDialog(null, "Informe o modelo do carro: ");
                    addCarro.marca = JOptionPane.showInputDialog(null, "Informe a marca do carro: ");
                    addCarro.ano = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o ano do carro: "));
                    addCarro.tipoServiço = Integer.parseInt(JOptionPane.showInputDialog(null, "Especifique os serviços as serem prestados:\n1- Alinhamento\n2-Balanceamento\n3-Revisão"));
                    
                    try{
                        if(iD < 10){
                            addTxt(addCarro);
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "O sistema atingiu o limite de carros por dia.");
                        }
                    }
                    catch(FileNotFoundException e){
                        JOptionPane.showMessageDialog(null, "Algum erro ocorreu.");
                    }
                    
                break;
            case 2:
                    
                break;
            case 9:
                holder = false;
                return;
            }
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Insira uma valor válido!");
            }
        }
    }

    public static void editCar() {
        File dir = new File(caminhoFila);
        String[] arquivosFila = dir.list();
        RegCar car = new RegCar();
        String exibir = "";
    
        if (arquivosFila != null && arquivosFila.length > 0) {
            for (int i = 0; i < arquivosFila.length; i++) {
                String input = arquivosFila[i].substring(0, arquivosFila[i].indexOf(".txt"));
    
                if (input != null && !input.isEmpty()) {
                    try {
                        int carNumber = Integer.parseInt(input);
                        car = lerCar(car, carNumber);
                        exibir = exibir + "\n" + input + car.nomeCarro;
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Erro ao converter o número do carro.");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não há carros registrados para editar.");
        }
        JOptionPane.showMessageDialog(null, exibir);
    }

    public static boolean addTxt(RegCar Carro) throws FileNotFoundException{
        lerId();
        PrintWriter pw = new PrintWriter(caminhoFila + (iD) + ".txt");
        pw.println(Carro.nomeCarro);
        pw.println(Carro.marca);
        pw.println(Carro.ano);
        pw.println(Carro.tipoServiço);
        pw.flush();
        pw.close();
        JOptionPane.showMessageDialog(null, "Veículo registrado com sucesso!");
        gravarId();
        return false;
    }
    
    private static void startCaminho(String caminhoFila) {
		File dir=new File(caminhoFila);
		if(!dir.exists()) {
			dir.mkdir();
		}
        File arquivo = new File("id.txt");
		if(!arquivo.exists()) {
			try {
				arquivo.createNewFile();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Algum erro ocorreu.");
				e.printStackTrace();
			}
        }
    }

    private static void gravarId() {
        PrintWriter pw;
		try {
            if((iD+1) <= 10){
            pw = new PrintWriter("id.txt");
			pw.println((iD+1));
			pw.flush();
			pw.close();
        }
        else{
            JOptionPane.showMessageDialog(null, "Não há mais espaço na fila para armazenar novos veículos.");
        }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	
	}

    private static void lerId() {
        try{
        BufferedReader br = new BufferedReader(new FileReader("id.txt"));
        String A = br.readLine();
        if(A == null){
            iD = 1;
        }
        else{
            iD = Integer.parseInt(A);
        }
        br.close();
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, "Não foi possível ler o arquivo.");
        }
    }

    private static RegCar lerCar(RegCar A, int B){
        try {
            File arquivo = new File(B + ".txt");
    
            // Verifica se o arquivo existe antes de tentar ler
            if (arquivo.exists()) {
                BufferedReader br = new BufferedReader(new FileReader(arquivo));
                A.nomeCarro = br.readLine();
                A.marca = br.readLine();
                A.ano = Integer.parseInt(br.readLine());
                A.tipoServiço = Integer.parseInt(br.readLine());
                br.close();
            } else {
                JOptionPane.showMessageDialog(null, "O arquivo não existe para o carro com número " + B);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro de entrada e saída.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "O arquivo contém dados inválidos para um carro.");
        }
    
        return A;
    }
    
    public static String caminhoFila = "Fila/";
    //Variável global da localização da fila/registro de carros.

    public static int iD = 0;
    //Variável global de identação do arquivo mais recente editado em sessão anterior.
}

//Logs:

//====================================================================================================//
//Atualização 1.1: 10 de Dezembro de 2023 - Sistema de Registros de Veículos
//Adição do Sistema de Registros de Carros
//====================================================================================================//

// -> Função de adicionar veículos com um limite de 10(a ser revisada na próxima atualização);

// -> Registrador de ID respectivo ao carro anterior registrado,
// mantendo a sessão atualizada (se você criou o registro "Carro 1", na próxima execução do programa,
// ele registrará o novo carro como "Carro 2", por exemplo.
// O mesmo vale caso só registre o novo carro sem sair da execução);
