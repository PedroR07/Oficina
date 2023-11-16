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
            String strSeletor = JOptionPane.showInputDialog(null, "1-Registrar carro\n2-Alterar/Relatar observações\n3-Lista de Espera\n5-Saldo\n\n\n\n9-Voltar");
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
                    editCar();
                    break;
                case 3:
                    listClient();
                    break;
                case 4:
                    // Adicionar código para a opção 5
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
            Boolean pend = false;
            String A = listCar();
            int idServico = Integer.parseInt(JOptionPane.showInputDialog(null, "\nSelecione o serviço a ser acompanhado: " + A));
            BufferedReader br = new BufferedReader(new FileReader(caminhoFila + idServico + ".txt"));
            RegCar carro = new RegCar();
            carro.nomeCarro = br.readLine();
            carro.marca = br.readLine();
            carro.ano = Integer.parseInt(br.readLine());
            carro.tipoServiço = Integer.parseInt(br.readLine());
            carro.necessidadeRequerimento = br.readLine();
            if(!"holder".equals(carro.necessidadeRequerimento)){
                pend =  true;
            }
            carro.status = Integer.parseInt(br.readLine());
            carro.nomeCliente = br.readLine();
            carro.numTel = br.readLine();
    
            br.close();
            String statReal = "";
            switch (carro.status) {
                case 0:
                    statReal = "Em espera.";
                    break;
                case 1:
                    statReal = "Em execução.";
                    break;
                case 2:
                    statReal = "Finalizado.";
                    break;
            }
    
            // Exibe as informações do veículo
            if(pend == true){
            JOptionPane.showMessageDialog(null, "Detalhes do Serviço:\n\n" +
                    "Modelo do Carro: " + carro.nomeCarro + "\n" +
                    "Marca: " + carro.marca + "\n" +
                    "Ano: " + carro.ano + "\n" +
                    "Tipo de Serviço: " + carro.tipoServiço + "\n" +
                    "Você tem pedidos pendentes de requerimento!" + "\n" +
                    "Status do serviço: " + statReal);
            }else{
                JOptionPane.showMessageDialog(null, "Detalhes do Serviço:\n\n" +
                "Modelo do Carro: " + carro.nomeCarro + "\n" +
                "Marca: " + carro.marca + "\n" +
                "Ano: " + carro.ano + "\n" +
                "Tipo de Serviço: " + carro.tipoServiço + "\n" +
                "Você não tem pedidos pendentes de requerimento!" + "\n" +
                "Status do serviço: " + statReal);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Número de serviço inválido.");
        }
    }

    private static void editCar() {
        boolean holder = true;
        while(holder == true){
            String A = listCar();
            String strSeletor = JOptionPane.showInputDialog(null, "1-Editar dados base\n2-Alterar status\n3-Criar requerimento\n9-Voltar");
            int seletor = 0;
            if(strSeletor == null){
                seletor = 9;
            }else{
                seletor = Integer.parseInt(strSeletor);
            }
            try{
            
            switch (seletor) {
                case 1:
                    int seleCar1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Selecione o carro:\n" + A));
                    PrintWriter pw1 = new PrintWriter(caminhoFila + seleCar1 + ".txt");
                    pw1.println(JOptionPane.showInputDialog("Insira o modelo do carro:"));
                    pw1.println(JOptionPane.showInputDialog("Insira a marca do carro:"));
                    pw1.println(JOptionPane.showInputDialog("Insira o ano do carro:"));
                    pw1.println(JOptionPane.showInputDialog("Insira o tipo de serviço:"));
                    pw1.println("holder");
                    pw1.println(JOptionPane.showInputDialog("Insira o status do serviço: "));
                    pw1.println(JOptionPane.showInputDialog("Insira o nome do cliente: "));
                    pw1.println(JOptionPane.showInputDialog("Insira o número de telefone: "));
                    pw1.flush();
                    pw1.close();
                    JOptionPane.showMessageDialog(null, "Operação realizada com sucesso!");
                    break;
                case 2:
                    int seleCar2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Selecione o carro:\n" + A));
                    RegCar holderCart = new RegCar();
                    BufferedReader br = new BufferedReader(new FileReader(caminhoFila + seleCar2 + ".txt"));
                    holderCart.nomeCarro = br.readLine();
                    holderCart.marca = br.readLine();
                    holderCart.ano = Integer.parseInt(br.readLine());
                    holderCart.tipoServiço = Integer.parseInt(br.readLine());
                    holderCart.necessidadeRequerimento = br.readLine();
                    holderCart.status = Integer.parseInt(JOptionPane.showInputDialog(null, "Atualize o serviço:\n0-Em espera\n1-Em execução\n2-Concluído"));
                    holderCart.nomeCliente = br.readLine();
                    holderCart.numTel = br.readLine();
                    br.close();
                    PrintWriter pw2 = new PrintWriter(caminhoFila + seleCar2 + ".txt");
                    pw2.println(holderCart.nomeCarro);
                    pw2.println(holderCart.marca);
                    pw2.println(holderCart.ano);
                    pw2.println(holderCart.tipoServiço);
                    pw2.println(holderCart.necessidadeRequerimento);
                    pw2.println(holderCart.status);
                    pw2.println(holderCart.nomeCliente);
                    pw2.println(holderCart.numTel);
                    pw2.flush();
                    pw2.close();
                    JOptionPane.showMessageDialog(null, "Operação realizada com sucesso!");
                    break;
                    case 3:
                    int seleCar3 = Integer.parseInt(JOptionPane.showInputDialog(null, "Selecione o carro:\n" + A));
                    RegCar holderCar2 = new RegCar();
                    BufferedReader br2 = new BufferedReader(new FileReader(caminhoFila + seleCar3 + ".txt"));
                    holderCar2.nomeCarro = br2.readLine();
                    holderCar2.marca = br2.readLine();
                    holderCar2.ano = Integer.parseInt(br2.readLine());
                    holderCar2.tipoServiço = Integer.parseInt(br2.readLine());
                    holderCar2.necessidadeRequerimento = br2.readLine();
                    holderCar2.status = Integer.parseInt(br2.readLine());
                    holderCar2.nomeCliente = br2.readLine();
                    holderCar2.numTel = br2.readLine();
                    br2.close();
                
                    // Solicite a edição do requerimento
                    PrintWriter pw3 = new PrintWriter(caminhoFila + seleCar3 + ".txt");
                    pw3.println(holderCar2.nomeCarro);
                    pw3.println(holderCar2.marca);
                    pw3.println(holderCar2.ano);
                    pw3.println(holderCar2.tipoServiço);
                    pw3.println(JOptionPane.showInputDialog("Insira o requerimento: "));
                    pw3.println(holderCar2.status);
                    pw3.println(holderCar2.nomeCliente);
                    pw3.println(holderCar2.numTel);
                    pw3.flush();
                    pw3.close();
                    JOptionPane.showMessageDialog(null, "Operação realizada com sucesso!");
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
        try{
                    RegCar addCarro = new RegCar();
                    addCarro.nomeCarro = JOptionPane.showInputDialog(null, "Informe o modelo do carro: ");
                    addCarro.marca = JOptionPane.showInputDialog(null, "Informe a marca do carro: ");
                    addCarro.ano = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o ano do carro: "));
                    addCarro.tipoServiço = Integer.parseInt(JOptionPane.showInputDialog(null, "Especifique os serviços as serem prestados:\n1-Alinhamento\n2-Balanceamento\n3-Revisão"));
                    addCarro.status = Integer.parseInt(JOptionPane.showInputDialog(null, "O pedido já entrará em execução?\n0-Não\n1-Sim"));
                    addCarro.nomeCliente = JOptionPane.showInputDialog(null, "Informe o nome do cliente:");
                    addCarro.numTel = JOptionPane.showInputDialog(null, "Informe o telefone do cliente:");
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
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Insira um valor válido (apenas números)!");
        }
        }

        public static String listCar() {
            File dir = new File(caminhoFila);
            String[] arquivosFila = dir.list();
            RegCar car = new RegCar();
            StringBuilder exibir = new StringBuilder();
        
            try {
                if (arquivosFila != null && arquivosFila.length > 0) {
                    for (int i = 0; i < arquivosFila.length; i++) {
                        File arquivo = new File(caminhoFila + (i+1) + ".txt");
        
                        if (arquivo.exists()) {
                            BufferedReader br = new BufferedReader(new FileReader(arquivo));
                            car.nomeCarro = br.readLine();
                            car.marca = br.readLine();
                            car.ano = Integer.parseInt(br.readLine());
                            car.tipoServiço = Integer.parseInt(br.readLine());
                            car.necessidadeRequerimento = br.readLine();
                            car.status = Integer.parseInt(br.readLine());
                            car.nomeCliente = br.readLine();
                            car.numTel = br.readLine();
        
                            exibir.append(i+1).append("- ").append(car.nomeCarro).append("\n");
        
                            br.close();
                        } else {
                            // Arquivo não existe
                            exibir.append((i+1)).append("- Arquivo não encontrado\n");
                        }
                    }
                } else {
                    // Nenhum arquivo na pasta
                    exibir.append("Nenhum carro registrado.\n");
                }
            } catch (IOException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Erro ao ler os arquivos.");
                e.printStackTrace();
            }
        
            return exibir.toString();
        }

    public static boolean addTxt(RegCar Carro) throws FileNotFoundException{
        lerId();
        PrintWriter pw = new PrintWriter(caminhoFila + (iD) + ".txt");
        pw.println(Carro.nomeCarro);
        pw.println(Carro.marca);
        pw.println(Carro.ano);
        pw.println(Carro.tipoServiço);
        pw.println("holder");
        pw.println(Carro.status);
        pw.println(Carro.nomeCliente);
        pw.println(Carro.numTel);
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

    public static RegCar pegaContato(int i, RegCar contPass){
        File arquivo = new File(caminhoFila + i + ".txt");
        try{
        BufferedReader br = new BufferedReader(new FileReader(arquivo));
        contPass.nomeCarro = br.readLine();
        contPass.marca = br.readLine();
        contPass.ano = Integer.parseInt(br.readLine());
        contPass.tipoServiço= Integer.parseInt(br.readLine());
        contPass.necessidadeRequerimento = br.readLine();
        contPass.status = Integer.parseInt(br.readLine());
        contPass.nomeCliente = br.readLine();
        contPass.numTel = br.readLine();
        br.close();
        }
        catch (IOException e){
            JOptionPane.showMessageDialog(null, "Algum erro ocorreu.");
        }
        return contPass;
    }

    public static void listClient() {
        RegCar contClient = new RegCar();
        File dir = new File(caminhoFila);
        String[] listaDir = dir.list();
        String listExibir = "";
        for (int i = 0; i < listaDir.length; i++) {
            pegaContato((i+1), contClient);
            listExibir = listExibir + (i+1) + "- " + contClient.nomeCarro + " - " + contClient.nomeCliente + " - " + contClient.numTel + "\n";
        }
        JOptionPane.showMessageDialog(null, listExibir);
    }
    
    
    public static String caminhoFila = "Fila/";
    //Variável global da localização da fila/registro de carros.

    public static int iD = 0;
    //Variável global de identação do arquivo mais recente editado em sessão anterior.
}

//Logs:

//====================================================================================================//
//Atualização (Beta) 1.2: 14 de Dezembro de 2023 - Sistema de Edição de Dados e Acompanhamento Por Parte Cliente
//Adição do Sistema de Edição de Dados e Acompanhamento Por Parte do Cliente
//====================================================================================================//

// -> Tratamento de erros para todos os menus;

// -> Limitador de registro de ID até 10;

// -> Implementação de um sistema de acompanhamento por parte do usuário;

// -> Sistema de edição dos carros registrados, incluindo estado do serviço e pedidos de requerimento;