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
            int Seletor = 0;
            String strSeletor = JOptionPane.showInputDialog(null, "1-Menu do Gestor\n2-Menu do Cliente\n\n\n\n\n9-Sair");
            if(strSeletor == null){
                Seletor = 9;
            }else{
            Seletor = Integer.parseInt(strSeletor);
            }
            switch (Seletor) {
                case 1:
                    menuGestor();
                    break;
                case 2:
                    menuCliente();
                    break;
                case 9 :
                    holder = false;
                    break;
                }
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Insira um valor válido (apenas números)!");
            }
            }
        }
    
    public static void menuGestor() {
        boolean holder = true;
        while (holder) {
            
            try{
            int seletor = 0;
            String strSeletor = JOptionPane.showInputDialog(null, "1-Registrar carro\n2-Alterar/Relatar observações\n3-Lista de clientes\n4-Lista de Espera\n5-Saldo\n6- Solicitar permissão para manutenção\n\n\n\n9-Voltar");
            if(strSeletor == null){
                seletor = 9;
            }else{
                seletor = Integer.parseInt(strSeletor);
            }
            switch (seletor) {
                case 1:
                    addCar();
                    break;
                case 2:
                    String listFila = listCar();
                    editCar(listFila);
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
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Insira um caracter válido (Apenas números)!");
                }
            }
        }

    public static void menuCliente() {
        boolean holder = true;
        while(holder == true){
            
            try{
            int seletor = 0;
            String strSeletor = JOptionPane.showInputDialog(null, "1-Acompanhar serviço\n2-Imprimir relatório\n3-Pagamento\n4-Requerer Comprovante de Pagamento\n5- Solicitações de Manutenção\n\n\n\n9-Voltar");
            if(strSeletor == null){
                seletor = 9;
            }else{
            seletor = Integer.parseInt(strSeletor);
            }
            switch (seletor) {
                case 1:
                    acompanhaServico();
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
            JOptionPane.showMessageDialog(null, "Insira uma valor válido (apenas números)!");
            }
        }
    }

    public static void acompanhaServico() {
        try {
            // Solicita o número do ID do serviço a ser acompanhado
            int idServico = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o número do serviço a ser acompanhado: "));
    
            // Monta o caminho do arquivo com base no ID do serviço
            String caminhoArquivo = caminhoFila + idServico + ".txt";
    
            // Cria um BufferedReader para ler o arquivo
            BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo));
    
            // Lê as informações do arquivo
            RegCar carro = new RegCar();
            carro.nomeCarro = br.readLine();
            carro.marca = br.readLine();
            carro.ano = Integer.parseInt(br.readLine());
            carro.tipoServiço = Integer.parseInt(br.readLine());
    
            // Fecha o BufferedReader
            br.close();
    
            // Exibe as informações do veículo
            JOptionPane.showMessageDialog(null, "Detalhes do Serviço:\n\n" +
                    "Modelo do Carro: " + carro.nomeCarro + "\n" +
                    "Marca: " + carro.marca + "\n" +
                    "Ano: " + carro.ano + "\n" +
                    "Tipo de Serviço: " + carro.tipoServiço);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Número de serviço inválido.");
        }
    }

    private static void editCar(String A) {
        boolean holder = true;
        while(holder == true){
            String strSeletor = JOptionPane.showInputDialog(null, "1-Editar dados base\n2-Criar requerimento\n9-Voltar");
            int seletor = 0;
            if(strSeletor == null){
                seletor = 9;
            }else{
                seletor = Integer.parseInt(strSeletor);
            }
            try{
                int seleCar = 0;
            switch (seletor) {
                case 1:
                    seleCar = Integer.parseInt(JOptionPane.showInputDialog(null, "Selecione o carro:\n" + A));
                    PrintWriter pw1 = new PrintWriter(caminhoFila + seleCar + ".txt");
                    pw1.println(JOptionPane.showInputDialog("Insira o modelo do carro:"));
                    pw1.println(JOptionPane.showInputDialog("Insira a marca do carro:"));
                    pw1.println(JOptionPane.showInputDialog("Insira o ano do carro:"));
                    pw1.println(JOptionPane.showInputDialog("Insira o tipo de serviço:"));
                    pw1.flush();
                    pw1.close();
                    JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!");
                    break;
                case 2:
                    seleCar = Integer.parseInt(JOptionPane.showInputDialog(null, "Selecione o carro:\n" + A));
                    RegCar holderCar = new RegCar();
                    BufferedReader br = new BufferedReader(new FileReader(caminhoFila + seleCar + ".txt"));
                    holderCar.nomeCarro = br.readLine();
                    holderCar.marca = br.readLine();
                    holderCar.ano = Integer.parseInt(br.readLine());
                    holderCar.tipoServiço = Integer.parseInt(br.readLine());
                    holderCar.necessidadeRequerimento = JOptionPane.showInputDialog(null, "Insira a condição do requerimento: ");
                    br.close();
                    PrintWriter pw2 = new PrintWriter(caminhoFila + seleCar + ".txt");
                    pw2.println(holderCar.nomeCarro);
                    pw2.println(holderCar.marca);
                    pw2.println(holderCar.ano);
                    pw2.println(holderCar.tipoServiço);
                    pw2.println("Condição de Requerimento: " + holderCar.necessidadeRequerimento);
                    pw2.flush();
                    pw2.close();
                    break;
                case 9:
                    holder = false;
                    break;
                }
            }catch(NumberFormatException | IOException e){
                JOptionPane.showMessageDialog(null, "Insira um valor válido (apenas números)!");
            }
        }
    }

    public static void addCar() {
        boolean holder = true;
        while(holder == true){
        String strSeletor = JOptionPane.showInputDialog(null,"1-Adicionar veículo\n\n\n\n\n9-Voltar");
        int seletor;
        if(strSeletor == null){
        seletor = 9;
        }else{
            seletor = Integer.parseInt(strSeletor);
        }

        try{
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
            case 9:
                holder = false;
                return;
            }
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Insira um valor válido (apenas números)!");
            }
        }
    }

    public static String listCar() {
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
                        exibir = exibir + "\n" + input + " " + car.nomeCarro;
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Erro ao converter o número do carro.");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não há carros registrados para editar.");
        }
        return exibir;
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
            
            File arquivo = new File(caminhoFila + B + ".txt");
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
