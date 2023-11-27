import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class Oficina {
    
    //Main
    public static void main(String[] args) {
        startCaminho(caminhoFila);
        lerId();
        menuGeral();
    }
    

 //                       Blocos dos Principais Menus
 ///////////////////////////////////////////////////////////////////////////////
    
    private static void menuGeral() {
        boolean segurador = true;
        //Variável controladora do loop while.

        while (segurador) {
            
            try{
            int seletor = 0;
            String strSeletor = JOptionPane.showInputDialog(null, "1-Menu do Gestor\n2-Menu do Cliente\n\n\n\n\n9-Sair");
            if(strSeletor == null){
                //Condicional caso o usuário selecione cancelar;
                //Clicar em cancelar envia uma valor null para a String strSeletor.

                seletor = 9;
            }else{
            seletor = Integer.parseInt(strSeletor);
            }
            if ((seletor < 1 || seletor > 2) && (seletor != 9)) {
                throw new IllegalArgumentException();
                //Lança exceção em caso de número maior do que as opções ou formato de dado inválido.
                
            }
            switch (seletor) {
                case 1:
                    menuGestor();
                    //Chamada do menu do gestor.

                    break;
                case 2:
                    menuCliente();
                    //Chamada do menu do cliente.

                    break;
                case 9 :
                    segurador = false;
                    //Fim do laço.

                    break;
                }
            }
            catch(IllegalArgumentException e){
                JOptionPane.showMessageDialog(null, "Insira um valor válido (apenas números)!");
                //Local onde a exceção é trada se necessário.
                
            }
            }
        }
    
    private static void menuGestor() {
        boolean segurador = true;
        //Variável controladora do loop while.

        while (segurador) {
            
            try{
            int seletor = 0;
            String strSeletor = JOptionPane.showInputDialog(null, "1-Registrar carro\n2-Alterar/Relatar observações\n3-Lista de Espera\n\n\n\n9-Voltar");
            if(strSeletor == null){
                seletor = 9;
                //Condicional caso o usuário selecione cancelar;
                //Clicar em cancelar envia uma valor null para a String strSeletor.

            }else{
                seletor = Integer.parseInt(strSeletor);
            }
            if ((seletor < 1 || seletor > 3) && (seletor != 9)) {
                throw new IllegalArgumentException();
                //Lança exceção em caso de número maior do que as opções ou formato de dado inválido.
                
            }
            switch (seletor) {
                case 1:
                    registraCar();
                    //Chamada do metódo de registro de carro.

                    break;
                case 2:
                    editCar();
                    //Chamada do metódo de edição de carros registrados.

                    break;
                case 3:
                    listClient();
                    //Chamada do método de listagem dos clientes e contatos.

                    break;
                case 9:
                    segurador = false;
                    //Fim do laço.

                    break;
                    }
                }catch(IllegalArgumentException e){
                    JOptionPane.showMessageDialog(null, "Insira um caracter válido (Apenas números)!");
                    //Local onde a exceção é trada se necessário.

                }
            }
        }

    private static void menuCliente() {
        boolean segurador = true;
        //Variável controladora do loop while.

        while(segurador == true){
            
            try{
            int seletor = 0;
            String strSeletor = JOptionPane.showInputDialog(null, "1- Acompanhar serviço\n2- Comprovantes\n3- Solicitações de Requerimento\n4- Tabela de Preços\n\n\n\n9-Voltar");
            if(strSeletor == null){
                seletor = 9;
                //Condicional caso o usuário selecione cancelar;
                //Clicar em cancelar envia uma valor null para a String strSeletor.

            }else{
            seletor = Integer.parseInt(strSeletor);
            }
            if ((seletor < 1 || seletor > 4) && (seletor != 9)) {
                throw new IllegalArgumentException();
                //Lança exceção em caso de número maior do que as opções ou formato de dado inválido.
                
            }
            switch (seletor) {
                case 1:
                    acompanhaServico();
                    //Chamada do método de acompanhamento do serviço.

                    break;
                case 2:
                    imprimeComprovantes();
                    //Chamada do método de impressão de comprovantes.
                    
                    break;
                case 3:
                    aprovExceps();
                    //Chamada do método de aprovação de falhas excepcionais;

                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Alinhamento: R$50,00\nBalanceamento: R$50,00\nRevisão: R$25,00\nServiço Excepcional: R$ 50,00\n\n\n*Valor das peças utilizadas na manutenção excepcional por conta do cliente.");
                    //Exibe uma simples tabela de preços.

                    break;
                case 9:
                segurador = false;
                //Fim do laço;

                    break;
                }
            }
            catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Insira uma valor válido (apenas números)!");
            //Local onde a exceção é trada se necessário.

            }
        }
    }


 //                          Blocos de Escrita de Dados
 ///////////////////////////////////////////////////////////////////////////////

    private static void editCar() {
    boolean segurador = true;
    while(segurador == true){
        String A = listCar();
        String strSeletor = JOptionPane.showInputDialog(null, "1-Editar dados base\n2-Alterar status\n3-Criar requerimento\n4-Deletar aquivo\n9-Voltar");
        int seletor = 0;
        if(strSeletor == null){
            seletor = 9;
        }else{
            seletor = Integer.parseInt(strSeletor);
        }
        try{
        
        switch (seletor) {
            case 1:
                RegCar carOri = new RegCar();
                int seleCar1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Selecione o carro:\n" + A));
                lerCar(seleCar1, carOri);
                PrintWriter pw1 = new PrintWriter(caminhoFila + seleCar1 + ".txt");
                pw1.println(JOptionPane.showInputDialog("Insira o modelo do carro:"));
                pw1.println(JOptionPane.showInputDialog("Insira a marca do carro:"));
                pw1.println(JOptionPane.showInputDialog("Insira o ano do carro:"));
                pw1.println(JOptionPane.showInputDialog("Insira o tipo de serviço:"));
                pw1.println(carOri.necessidadeRequerimento);
                pw1.println(Integer.toString(carOri.status));
                pw1.println(JOptionPane.showInputDialog("Insira o nome do cliente: "));
                pw1.println(JOptionPane.showInputDialog("Insira o número de telefone: "));
                pw1.flush();
                pw1.close();
                JOptionPane.showMessageDialog(null, "Operação realizada com sucesso!");
                break;
            case 2:
                int seleCar2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Selecione o carro:\n" + A));
                RegCar seguradorCart = new RegCar();
                BufferedReader br = new BufferedReader(new FileReader(caminhoFila + seleCar2 + ".txt"));
                seguradorCart.nomeCarro = br.readLine();
                seguradorCart.marca = br.readLine();
                seguradorCart.ano = Integer.parseInt(br.readLine());
                seguradorCart.tipoServiço = Integer.parseInt(br.readLine());
                seguradorCart.necessidadeRequerimento = br.readLine();
                seguradorCart.status = Integer.parseInt(JOptionPane.showInputDialog(null, "Atualize o serviço:\n0-Em espera\n1-Em execução\n2-Concluído"));
                seguradorCart.nomeCliente = br.readLine();
                seguradorCart.numTel = br.readLine();
                br.close();
                PrintWriter pw2 = new PrintWriter(caminhoFila + seleCar2 + ".txt");
                pw2.println(seguradorCart.nomeCarro);
                pw2.println(seguradorCart.marca);
                pw2.println(seguradorCart.ano);
                pw2.println(seguradorCart.tipoServiço);
                pw2.println(seguradorCart.necessidadeRequerimento);
                pw2.println(seguradorCart.status);
                pw2.println(seguradorCart.nomeCliente);
                pw2.println(seguradorCart.numTel);
                pw2.flush();
                pw2.close();
                JOptionPane.showMessageDialog(null, "Operação realizada com sucesso!");
                break;
                case 3:
                int seleCar3 = Integer.parseInt(JOptionPane.showInputDialog(null, "Selecione o carro:\n" + A));
                File savReq = new File(caminhoReq + seleCar3 + ".txt/");
                PrintWriter pw = new PrintWriter(savReq);
                pw.print(JOptionPane.showInputDialog(null, "Insira a condição de falha: "));
                pw.flush();
                pw.close();
                JOptionPane.showMessageDialog(null, "Operação realizada com sucesso!");
                break;
            case 4:
                int seleCar4 = Integer.parseInt(JOptionPane.showInputDialog(null, "Selecione o carro:\n" + A));
                File delete = new File(caminhoFila + seleCar4 + ".txt/");
                delete.delete();
                organizador();
                break;
            case 9:
                segurador = false;
                break;
            }
        }catch(NumberFormatException | IOException e){
            JOptionPane.showMessageDialog(null, "Insira um valor válido (apenas números)!");
        }
    }
}

    private static void registraCar() {
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
                        int iD = lerId();
                        if(iD < 10){
                            PrintWriter pw = new PrintWriter(caminhoFila + (iD) + ".txt");
                            pw.println(addCarro.nomeCarro);
                            pw.println(addCarro.marca);
                            pw.println(addCarro.ano);
                            pw.println(addCarro.tipoServiço);
                            pw.println("segurador");
                            pw.println(addCarro.status);
                            pw.println(addCarro.nomeCliente);
                            pw.println(addCarro.numTel);
                            pw.flush();
                            pw.close();
                            JOptionPane.showMessageDialog(null, "Veículo registrado com sucesso!");
                            organizador();
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

    private static void imprimeComprovantes() {
            boolean segurador = true;
            while (segurador) {
                try {
                    int seletor = 0;
                    String strSeletor = JOptionPane.showInputDialog(null, "1- Imprimir Boleto\n2- Imprimir Relatório\n\n\n\n9-Voltar");
                    if (strSeletor == null) {
                        seletor = 9;
                    } else {
                        seletor = Integer.parseInt(strSeletor);
                    }
                    switch (seletor) {
                        case 1:
                            int carroNum = Integer.parseInt(JOptionPane.showInputDialog("Selecione o veículo:\n" + listCar()));
                            int valLiq = 0;
                            int valExt = 0;
                            RegCar carroSelec = new RegCar();
                            carroSelec = lerCar(carroNum, carroSelec);
                            PrintWriter pw = new PrintWriter(caminhoRel + "Boleto" + (carroNum) + ".txt");
                            pw.println("====================================================");
                            pw.println("====================================================");
                            pw.println("Auto-Mecânica Souza & Rocha | " + java.time.LocalDate.now());
                            pw.println("====================================================");
                            pw.println("Dados dos Clientes: ");
                            pw.println(" ");
                            pw.println("Nome: " + carroSelec.nomeCliente + " | " + "Telefone: " + carroSelec.numTel);
                            pw.println("====================================================");
                            pw.println("Descrição dos Serviços:");
                            pw.println(" ");
                            pw.println("Nome: " + carroSelec.nomeCarro + " | " + "Ano: " + carroSelec.ano + " | " + "Marca: " + carroSelec.marca);
                            if(carroSelec.tipoServiço == 12 || carroSelec.tipoServiço == 21){
                                pw.println("Alinhamento e Balanceamento");
                                valLiq = 100;
                            }else{
                                if(carroSelec.tipoServiço == 13 || carroSelec.tipoServiço == 31){
                                    pw.println("Alinhamento e Revisão.");
                                    valLiq = 75;
                            }else{
                                if(carroSelec.tipoServiço == 23 || carroSelec.tipoServiço == 21){
                                    pw.println("Balanceamento e Revisão.");
                                    valLiq = 75;
                                }else{
                                    if(carroSelec.tipoServiço == 123 || carroSelec.tipoServiço == 132 || carroSelec.tipoServiço == 213 || carroSelec.tipoServiço == 231 || carroSelec.tipoServiço == 312 || carroSelec.tipoServiço == 321){
                                        pw.println("Alinhamento, Balanceamento e Revisão.");
                                        valLiq = 125;
                                    }else{
                                        switch (carroSelec.tipoServiço) {
                                            case 1:
                                                pw.println("Alinhamento.");
                                                valLiq = 50;
                                                break;
                                            case 2:
                                                pw.println("Balanceamento.");
                                                valLiq = 50;
                                                break;
                                            case 3:
                                                pw.println("Revisão");
                                                valLiq = 25;
                                                break;
                                        }
                                    }
                                    }
                                }
                            }
                            if(!"segurador".equals(carroSelec.necessidadeRequerimento)){
                                pw.println("Extras: Sim");
                                valExt = 50;
                                
                            }else{
                                pw.println("Extras: Não");
                            }
                            pw.println(" ");
                            pw.println("====================================================");
                            pw.println("====================================================");
                            pw.println("Valor Líquido: R$" + valLiq + " | " + "Extras: R$" + valExt + " | " + "Total: R$" + (valLiq + valExt));
                            pw.println("====================================================");
                            pw.flush();
                            pw.close();
                            JOptionPane.showMessageDialog(null, "O boleto foi gerado com sucesso.");
                            break;
                            case 2:
                            int carroNum2 = Integer.parseInt(JOptionPane.showInputDialog("Selecione o veículo:\n" + listCar()));
                            RegCar carroSelec2 = new RegCar();
                            carroSelec2 = lerCar(carroNum2, carroSelec2);
                            PrintWriter pw2 = new PrintWriter(caminhoRel + "Relatório" + (carroNum2) + ".txt");
                            pw2.println("====================================================");
                            pw2.println("====================================================");
                            pw2.println("Auto-Mecânica Souza & Rocha | " + java.time.LocalDate.now());
                            pw2.println("====================================================");
                            pw2.println("Descrição dos Serviços:");
                            pw2.println(" ");
                            pw2.println("Nome: " + carroSelec2.nomeCarro + " | " + "Ano: " + carroSelec2.ano + " | " + "Marca: " + carroSelec2.marca);
                            if(carroSelec2.tipoServiço == 12 || carroSelec2.tipoServiço == 21){
                                pw2.println("Alinhamento e Balanceamento");
                            }else{
                                if(carroSelec2.tipoServiço == 13 || carroSelec2.tipoServiço == 31){
                                    pw2.println("Alinhamento e Revisão.");
                            }else{
                                if(carroSelec2.tipoServiço == 23 || carroSelec2.tipoServiço == 21){
                                    pw2.println("Balanceamento e Revisão.");
                                }else{
                                    if(carroSelec2.tipoServiço == 123 || carroSelec2.tipoServiço == 132 || carroSelec2.tipoServiço == 213 || carroSelec2.tipoServiço == 231 || carroSelec2.tipoServiço == 312 || carroSelec2.tipoServiço == 321){
                                        pw2.println("Alinhamento, Balanceamento e Revisão.");
                                    }else{
                                        switch (carroSelec2.tipoServiço) {
                                            case 1:
                                                pw2.println("Alinhamento.");
                                                break;
                                            case 2:
                                                pw2.println("Balanceamento.");
                                                break;
                                            case 3:
                                                pw2.println("Revisão");
                                                break;
                                        }
                                    }
                                    }
                                }
                            }
                            if(!"segurador".equals(carroSelec2.necessidadeRequerimento)){
                                pw2.println("\nServiço Extra: " + carroSelec2.necessidadeRequerimento);
                            }else{
                                pw2.println("Extras: Não houve serviço extra");
                            }
                            pw2.println(" ");
                            pw2.println("====================================================");
                            pw2.flush();
                            pw2.close();
                            JOptionPane.showMessageDialog(null, "O relatório foi gerado com sucesso.");
                            break;
                        case 9:
                            segurador = false;
                            break;
                    }
                } catch (NumberFormatException | IOException e) {
                    JOptionPane.showMessageDialog(null, "Insira um valor válido (apenas números)!");
                }
            }
        }

    private static void aprovExceps(){
            try{
            String A = listCar();
            int b = Integer.parseInt(JOptionPane.showInputDialog(null, "Selecione o veículo: " + A));
            File necReq = new File(caminhoReq + b + ".txt/");
            if(necReq.exists()){
                
                RegCar carReq = new RegCar();
                lerCar(b, carReq);
                BufferedReader br = new BufferedReader(new FileReader(necReq));
                carReq.necessidadeRequerimento = br.readLine();
                br.close();
                int c = Integer.parseInt(JOptionPane.showInputDialog(null, "Falha Excepcional: " + carReq.necessidadeRequerimento + "\nDeseja autorizar a manutenção extra?\n1-Sim\n2-Não"));
                if(c == 1){
                PrintWriter pw = new PrintWriter(caminhoFila + b + ".txt/");
                pw.println(carReq.nomeCarro);
                pw.println(carReq.marca);
                pw.println(carReq.ano);
                pw.println(carReq.tipoServiço);
                pw.println(carReq.necessidadeRequerimento);
                pw.println(carReq.status);
                pw.println(carReq.nomeCliente);
                pw.println(carReq.numTel);
                pw.flush();
                pw.close();
                JOptionPane.showMessageDialog(null, "A manutenção será realizada e o valor \nextra será adicionado a fatura do serviço.");
                }else{
                    necReq.delete();
                    JOptionPane.showMessageDialog(null, "Você recusou o serviço excepcional e a solicitação foi apagada.");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Arquivo inexistente.");
            }
        }catch (IOException e){
            JOptionPane.showMessageDialog(null, "Algum erro ocorreu.");
        }
    }

    private static void acompanhaServico() {
        
        try {
            Boolean pend = false;
            String A = listCar();
            int idServico = Integer.parseInt(JOptionPane.showInputDialog(null, "\nSelecione o serviço a ser acompanhado:\n" + A));
            BufferedReader br = new BufferedReader(new FileReader(caminhoFila + idServico + ".txt"));
            RegCar carro = new RegCar();
            carro.nomeCarro = br.readLine();
            carro.marca = br.readLine();
            carro.ano = Integer.parseInt(br.readLine());
            carro.tipoServiço = Integer.parseInt(br.readLine());
            String exibServ = "";
            if(carro.tipoServiço == 12 || carro.tipoServiço == 21){
                exibServ = "Alinhamento e Balanceamento";
            }else{
                if(carro.tipoServiço == 13 || carro.tipoServiço == 31){
                    exibServ = "Alinhamento e Revisão";
            }else{
                if(carro.tipoServiço == 23 || carro.tipoServiço == 21){
                    exibServ = "Balanceamento e Revisão";
                }else{
                    if(carro.tipoServiço == 123 || carro.tipoServiço == 132 || carro.tipoServiço == 213 || carro.tipoServiço == 231 || carro.tipoServiço == 312 || carro.tipoServiço == 321){
                        exibServ = "Alinhamento, Balanceamento \ne Revisão.";
                    }else{
                        switch (carro.tipoServiço) {
                            case 1:
                                exibServ = "Alinhamento.";
                                break;
                            case 2:
                                exibServ = "Balanceamento.";
                                break;
                            case 3:
                                exibServ = "Revisão";
                                break;
                        }
                    }
                    }
                }
            }
            carro.necessidadeRequerimento = br.readLine();
            File necReq = new File(caminhoReq + idServico + ".txt/");
            if(necReq.exists()){
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
                    "Tipo de Serviço: " + exibServ + "\n" +
                    "Falha excepcional: Sim" + "\n" +
                    "Status do serviço: " + statReal);
            }else{
                JOptionPane.showMessageDialog(null, "Detalhes do Serviço:\n\n" +
                "Modelo do Carro: " + carro.nomeCarro + "\n" +
                "Marca: " + carro.marca + "\n" +
                "Ano: " + carro.ano + "\n" +
                "Tipo de Serviço: " + exibServ + "\n" +
                "Falha excepcional: Não" + "\n" +
                "Status do serviço: " + statReal);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Número de serviço inválido.");
        }
    }

    private static String listCar() {
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

    private static int lerId() {
        int iD = 0;
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
        return iD;
    }

    private static RegCar lerCar(int i, RegCar contPass){
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
    
    private static void listClient() {
        RegCar contClient = new RegCar();
        File dir = new File(caminhoFila);
        String[] listaDir = dir.list();
        String listExibir = "";
        for (int i = 0; i < listaDir.length; i++) {
            lerCar((i+1), contClient);
            listExibir = listExibir + (i+1) + "- " + "Carro: " + contClient.nomeCarro + " - "+ "Cliente: " + contClient.nomeCliente + " - " + "Tel: " + contClient.numTel + "\n";
        }
        JOptionPane.showMessageDialog(null, listExibir);
    }

 //                   Caminhos (Constantes e Inicializador)
 ///////////////////////////////////////////////////////////////////////////////

    private static void startCaminho(String caminhoFila) {
        
        //Inicializando pasta "Relatório".
        File dirRel=new File(caminhoRel);
        if(!dirRel.exists()) {
            dirRel.mkdir();
        }
        ///////////////////////////////////////

        //Inicializando pasta "Fila".
        File dirFila=new File(caminhoFila);
        if(!dirFila.exists()) {
            dirFila.mkdir();
        }
        ///////////////////////////////////////

        //Inicializando a pasta "Requerimentos"
        File dirReq=new File(caminhoReq);
        if(!dirReq.exists()) {
            dirReq.mkdir();
        }
        ///////////////////////////////////////

        //Criando arquivo "id.txt".
        File arquivo = new File("id.txt");
        
        //Verifica se arquivo NÃO existe.
        if(!arquivo.exists()) {
            //Criação de arquivo caso condicional if seja verdadeira (não há arquivo criado).

            try {
                arquivo.createNewFile();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Algum erro ocorreu.");
                e.printStackTrace();
                //Tratamento de erro.

            }
            //Fim da condicional.
            ///////////////////////////////////////
        }
        
    }
    private static final String caminhoRel  = "Relatórios/";
    private static final String caminhoFila = "Fila/";
    private static final String caminhoReq = "Requerimentos/";



 //                                Organizador
 ///////////////////////////////////////////////////////////////////////////////
    private static void organizador(){
        File dir = new File(caminhoFila);
        String[] listR = dir.list();
        for(int i = 0; i < listR.length; i++){
            File selecCar = new File(caminhoFila + listR[i]);
            File orgCar = new File(caminhoFila + (i+1) + ".txt");
            selecCar.renameTo(orgCar);
        }
        try{
            File sobscreveId = new File("id.txt");
            PrintWriter pw = new PrintWriter(sobscreveId);
            pw.print((listR.length + 1));
            pw.flush();
            pw.close();
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Algum erro ocorreu.");
        }
    }

}
