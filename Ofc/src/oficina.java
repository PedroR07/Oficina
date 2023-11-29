import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class oficina {
    
//                                  Main
 ///////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        startCaminho(caminhoFila);
        lerId();
        menuGeral();
    }
    

 //                       Bloco dos Principais Menus
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
            String strSeletor = JOptionPane.showInputDialog(null, "1-Registrar carro\n2-Alterar/Relatar observações\n3-Lista de Espera\n4-Ver ficha dos carros\n\n\n\n9-Voltar");
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
                case 4:
                    acompanhaServico();
                    //Chama método de leitura de serviço.

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
            String strSeletor = JOptionPane.showInputDialog(null, "1- Acompanhar serviço\n2- Comprovantes\n3- Falhas Excepcionais\n4- Tabela de Preços\n\n\n\n9-Voltar");
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
            JOptionPane.showMessageDialog(null, "Insira um valor válido (apenas números)!");
            //Local onde a exceção é trada se necessário.

            }
        }
    }


 //                          Bloco de Escrita de Dados
 ///////////////////////////////////////////////////////////////////////////////

    private static void editCar() {
    //Bloco para verificar se há conteudo para edição na psta.
    File dirFila = new File(caminhoFila);
    String[] arqFilas = dirFila.list();
    
    if(arqFilas.length != 0){
    //////////////////////////////////////////////////////////

    boolean segurador = true;
    //Controlador do loop.
    while(segurador == true){
        

        String A = listCar();
        String strSeletor = JOptionPane.showInputDialog(null, "1-Editar dados\n2-Alterar status do serviço\n3-Reportar falha excepcional\n4-Excluir registro de veículo\n\n\n\n9-Voltar");
        int seletor = 0;
        if(strSeletor == null){
            seletor = 9;
        }else{
            seletor = Integer.parseInt(strSeletor);
        }
        if ((seletor < 1 || seletor > 4) && (seletor != 9)) {
                throw new IllegalArgumentException();
                //Lança exceção em caso de número maior do que as opções ou formato de dado inválido.
                
            }
            try{
        switch (seletor) {
            
            case 1:
                regCar carroOriginal1 = new regCar();
                int carSelec1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Selecione o carro:\n" + A));
                
                lerCar(carSelec1, carroOriginal1); //Obtém os dados do carro que serão alterados.

                PrintWriter pw1 = new PrintWriter(caminhoFila + carSelec1 + ".txt");
                
                //Alteração dos dados.
                pw1.println(JOptionPane.showInputDialog("Insira o modelo do carro:"));
                pw1.println(JOptionPane.showInputDialog("Insira a marca do carro:"));
                pw1.println(JOptionPane.showInputDialog("Insira o ano do carro:"));
                pw1.println(JOptionPane.showInputDialog("Insira o tipo de serviço:"));
                pw1.println(carroOriginal1.necessidadeRequerimento);
                pw1.println(Integer.toString(carroOriginal1.status));
                pw1.println(JOptionPane.showInputDialog("Insira o nome do cliente: "));
                pw1.println(JOptionPane.showInputDialog("Insira o número de telefone: "));
                pw1.println(carroOriginal1.idReq);
                pw1.flush();
                pw1.close();

                JOptionPane.showMessageDialog(null, "Operação realizada com sucesso!"); //Sucesso.
                break;
            
            case 2:
                regCar carroOriginal2 = new regCar();
                int carSelec2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Selecione o carro:\n" + A));
                
                lerCar(carSelec2, carroOriginal2); //Lê dados do carro original.
                carroOriginal2.status = Integer.parseInt(JOptionPane.showInputDialog(null, "Atualize o estado do serviço:\n0-Em espera\n1-Em execução\n2-Concluído"));
                //Atualiza o status

                PrintWriter pw2 = new PrintWriter(caminhoFila + carSelec2 + ".txt");
                
                //Altera os dados.
                pw2.println(carroOriginal2.nomeCarro);
                pw2.println(carroOriginal2.marca);
                pw2.println(carroOriginal2.ano);
                pw2.println(carroOriginal2.tipoServiço);
                pw2.println(carroOriginal2.necessidadeRequerimento);
                pw2.println(carroOriginal2.status);
                pw2.println(carroOriginal2.nomeCliente);
                pw2.println(carroOriginal2.numTel);
                pw2.println(carroOriginal2.idReq);
                pw2.flush();
                pw2.close();

                JOptionPane.showMessageDialog(null, "Operação realizada com sucesso!"); //Sucesso
                break;

            case 3:
                regCar carroOriginal3 = new regCar();
                int carSelec3 = Integer.parseInt(JOptionPane.showInputDialog(null, "Selecione o carro:\n" + A));
                lerCar(carSelec3, carroOriginal3); //Lê o carro original.

                File salvaReq = new File(caminhoReq + carSelec3 + ".txt/");
                PrintWriter pw = new PrintWriter(salvaReq);
                pw.print(JOptionPane.showInputDialog(null, "Descreva a falha: "));
                pw.flush();
                pw.close();
                
                PrintWriter pwriter = new PrintWriter(caminhoFila + carSelec3 + ".txt/");
                
                //Reescreve os dados do carro.
                pwriter.println(carroOriginal3.nomeCarro);
                pwriter.println(carroOriginal3.marca);
                pwriter.println(carroOriginal3.ano);
                pwriter.println(carroOriginal3.tipoServiço);
                pwriter.println(carroOriginal3.necessidadeRequerimento);
                pwriter.println(carroOriginal3.status);
                pwriter.println(carroOriginal3.nomeCliente);
                pwriter.println(carroOriginal3.numTel);
                pwriter.println(carSelec3); //Adiciona o id relativo ao documento em que a falha está escrita;
                pwriter.flush();
                pwriter.close();
                
                JOptionPane.showMessageDialog(null, "Operação realizada com sucesso!"); //Sucesso
                break;
            case 4:
                //Lê carro.
                int carroSelec4 = Integer.parseInt(JOptionPane.showInputDialog(null, "Selecione o carro:\n" + A));
                regCar carroOriginal4 = new regCar();
                lerCar(carroSelec4, carroOriginal4);
                
                //Deleta o carro e seu respectivo requerimento.
                File deleteCarro = new File(caminhoFila + carroSelec4 + ".txt/");
                File deleteReq = new File(caminhoReq + carroOriginal4.idReq + ".txt/");
                deleteCarro.delete();
                deleteReq.delete();

                organizador(); //Organiza a pasta
                if(arqFilas.length != 0){
                    menuGestor();
                    //Te joga novamente no menu do gestor caso não há carros para editar.
                }
                break;
            case 9:
                segurador = false;
                //Fim do laço.

                break;
            }
        }catch(NumberFormatException | IOException e){
            JOptionPane.showMessageDialog(null, "Insira um valor válido (apenas números)!");
            //Exceção caso valor inserido seja inválido.
            
        }
        }
    }else{
        JOptionPane.showMessageDialog(null, "Não há carros na fila.");
        //Pasta vazia.
    }
}
    private static void registraCar() {
        try{
            int iD = lerId();
                    
                    //Limita a fila em 9.
                    if(iD < 10){
                    regCar addCarro = new regCar();
                    //Inserção de dados;
                    addCarro.nomeCarro = JOptionPane.showInputDialog(null, "Informe o modelo do carro: ");
                    addCarro.marca = JOptionPane.showInputDialog(null, "Informe a marca do carro: ");
                    addCarro.ano = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o ano do carro: "));
                    addCarro.tipoServiço = Integer.parseInt(JOptionPane.showInputDialog(null, "Especifique os serviços as serem prestados:\n1-Alinhamento\n2-Balanceamento\n3-Revisão"));
                    addCarro.status = Integer.parseInt(JOptionPane.showInputDialog(null, "O pedido já entrará em execução?\n0-Não\n1-Sim"));
                    addCarro.nomeCliente = JOptionPane.showInputDialog(null, "Informe o nome do cliente: ");
                    addCarro.numTel = JOptionPane.showInputDialog(null, "Informe o telefone do cliente: ");
                    addCarro.idReq = "0"; //Valor padrão = não há falhas excepcionais.
                    
                        
                    PrintWriter pw = new PrintWriter(caminhoFila + (iD) + ".txt");
                            
                    //Escritura de dados.
                    pw.println(addCarro.nomeCarro);
                    pw.println(addCarro.marca);
                    pw.println(addCarro.ano);
                    pw.println(addCarro.tipoServiço);
                            
                    pw.println("segurador");
                    //Segurador, ou placeholder. Segura a posição no documento até posterior alteração.
                            
                    pw.println(addCarro.status);
                    pw.println(addCarro.nomeCliente);
                    pw.println(addCarro.numTel);
                    pw.println(addCarro.idReq);
                    pw.flush();
                    pw.close();
                            
                    JOptionPane.showMessageDialog(null, "Veículo registrado com sucesso!"); //Sucesso
                    organizador(); //Organiza a pasta.
                        }else{
                            JOptionPane.showMessageDialog(null, "O sistema atingiu o limite de carros por dia.");
                            //Já tem nove carros na fila.
                        }
                    }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, "Insira um valor válido (apenas números)!");
            //Trata erros de inserção incorreta de dados.
        }
    }
    private static void imprimeComprovantes() {
            
        //Bloco para verificar se há conteudo para edição na psta.
        File dirFila = new File(caminhoFila);
        String[] arqFilas = dirFila.list();
        
        if(arqFilas.length != 0){
        //////////////////////////////////////////////////////////
        
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
                    if ((seletor < 1 || seletor > 2) && (seletor != 9)) {
                    throw new IllegalArgumentException();
                    //Lança exceção em caso de número maior do que as opções ou formato de dado inválido.
                    }
                    switch (seletor) {
                        case 1:
                            int carroNum = Integer.parseInt(JOptionPane.showInputDialog("Selecione o veículo:\n" + listCar()));
                            int valLiq = 0;
                            int valExt = 0;
                            
                            //Verifica se o carro selecionado existe na pasta.
                            File verifCar = new File(caminhoFila + carroNum + ".txt");
                            if(verifCar.exists()){
                            
                            regCar carroSelec = new regCar();
                            lerCar(carroNum, carroSelec);

                            //Grava o boleto.
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
                            
                            //Condicionais para analisar o tipo do serviço e atribuir valor.
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
                            JOptionPane.showMessageDialog(null, "O boleto foi gerado com sucesso."); //Sucesso.
                        }else{
                            JOptionPane.showMessageDialog(null, "O carro não existe."); //Arquivo inexistente.
                        }
                            break;
                        case 2:
                            int carroNum2 = Integer.parseInt(JOptionPane.showInputDialog("Selecione o veículo:\n" + listCar()));
                            
                            //Verifica se o carro selecionado existe na pasta.
                            File verifCar2 = new File(caminhoFila + carroNum2 + ".txt");
                            if(verifCar2.exists()){
                        
                            regCar carroSelec2 = new regCar();
                            carroSelec2 = lerCar(carroNum2, carroSelec2);
                            
                            PrintWriter pw2 = new PrintWriter(caminhoRel + "Relatório" + (carroNum2) + ".txt");
                            //Gera o relatório.
                            pw2.println("====================================================");
                            pw2.println("====================================================");
                            pw2.println("Auto-Mecânica Souza & Rocha | " + java.time.LocalDate.now());
                            pw2.println("====================================================");
                            pw2.println("Descrição dos Serviços:");
                            pw2.println(" ");
                            pw2.println("Nome: " + carroSelec2.nomeCarro + " | " + "Ano: " + carroSelec2.ano + " | " + "Marca: " + carroSelec2.marca);
                            
                            //Condicional para escrever o tipo do serviço.
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
                            JOptionPane.showMessageDialog(null, "O relatório foi gerado com sucesso.");//Sucesso.
                            
                            }else{
                                JOptionPane.showMessageDialog(null, "O carro não existe.");//Arquivo inexistente.
                            }
                            break;
                        case 9:
                            segurador = false;
                            break;
                    }
                } catch (NumberFormatException | IOException e) {
                    JOptionPane.showMessageDialog(null, "Insira um valor válido (apenas números)!");
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Não há nenhum carro na fila. ");
            //Pasta vazia.
        }
        }
    private static void aprovExceps() {
            // Bloco para verificar se há conteúdo para edição na pasta.
            File dirFila = new File(caminhoFila);
            String[] arqFilas = dirFila.list();
        
            if (arqFilas.length != 0) {
                regCar carro = new regCar();
        
                try {
                    // Lista de carros.
                    String A = listCar();
        
                    // Lendo carro.
                    int b = Integer.parseInt(JOptionPane.showInputDialog(null, "Selecione o veículo:\n" + A));
                    
        
                    // Verificando se carro existe.
                    File arqCar = new File(caminhoFila + b + ".txt");
                    if (arqCar.exists()) {
                    lerCar(b, carro);
                        File necReq = new File(caminhoReq + carro.idReq + ".txt");
                        if (necReq.exists()) {
                            regCar carReq = new regCar();
                            lerCar(b, carReq);
                            BufferedReader br = new BufferedReader(new FileReader(necReq));
                            carReq.necessidadeRequerimento = br.readLine();
                            br.close();
                            int c = Integer.parseInt(JOptionPane.showInputDialog(null, "Falha Excepcional: " + carReq.necessidadeRequerimento + "\nDeseja autorizar a manutenção extra?\n1-Sim\n2-Não"));
                            if (c == 1) {
                                PrintWriter pw = new PrintWriter(caminhoFila + b + ".txt");
                                pw.println(carReq.nomeCarro);
                                pw.println(carReq.marca);
                                pw.println(carReq.ano);
                                pw.println(carReq.tipoServiço);
                                pw.println(carReq.necessidadeRequerimento);
                                pw.println(carReq.status);
                                pw.println(carReq.nomeCliente);
                                pw.println(carReq.numTel);
                                pw.println(carReq.idReq);
                                pw.flush();
                                pw.close();
                                JOptionPane.showMessageDialog(null, "A manutenção será realizada e o valor \nextra será adicionado a fatura do serviço.");
                            } else {
                                necReq.delete();
                                JOptionPane.showMessageDialog(null, "Você recusou o serviço excepcional e a solicitação foi apagada.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Ainda não foram relatadas falhas excepcionais\npara o carro selecionado.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "O carro selecionado não existe.");
                    }
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Ocorreu algum erro na aprovação das requisições.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Não há carros na fila.");
            }
        }


 //                          Bloco de Leitura de Dados
 ///////////////////////////////////////////////////////////////////////////////

    private static void acompanhaServico() {
        //Bloco para verificar se há conteudo para edição na psta.
        File dirFila = new File(caminhoFila);
        String[] arqFilas = dirFila.list();
        
        if(arqFilas.length != 0){
        //////////////////////////////////////////////////////////
        try {
            Boolean pend = false;
            
            //Recebe lista.
            String A = listCar();

            int idServico = Integer.parseInt(JOptionPane.showInputDialog(null, "Selecione o serviço a ser acompanhado:\n" + A));
            
            //Verificando se o carro selecionado existe.
            File verifCar = new File(caminhoFila + idServico +".txt");
            
            if(verifCar.exists()){

            BufferedReader br = new BufferedReader(new FileReader(caminhoFila + idServico + ".txt"));
            regCar carro = new regCar();

            //Lendo dados.
            carro.nomeCarro = br.readLine();
            carro.marca = br.readLine();
            carro.ano = Integer.parseInt(br.readLine());
            carro.tipoServiço = Integer.parseInt(br.readLine());
            String exibServ = "";
            
            //Condicional para verificar o tipo do serviço.
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
            carro.status = Integer.parseInt(br.readLine());
            carro.nomeCliente = br.readLine();
            carro.numTel = br.readLine();
            carro.idReq = br.readLine();
            File necReq = new File(caminhoReq + carro.idReq + ".txt/");
            
            //Verifica se há alguma falha excepcional relacionada ao carro.
            if(necReq.exists()){
                pend =  true;
            }

            br.close();
            
            //Switch simples para verificar qual é o estado do serviço do carro.
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
            //Caso haja falha excepcional.

            JOptionPane.showMessageDialog(null, "Detalhes do Serviço:\n\n" +
                    "Modelo do Carro: " + carro.nomeCarro + "\n" +
                    "Marca: " + carro.marca + "\n" +
                    "Ano: " + carro.ano + "\n" +
                    "Tipo de Serviço: " + exibServ + "\n" +
                    "Falha excepcional: Sim" + "\n" +
                    "Status do serviço: " + statReal);
            }else{
                //Caso não haja falha excepcional.
                JOptionPane.showMessageDialog(null, "Detalhes do Serviço:\n\n" +
                "Modelo do Carro: " + carro.nomeCarro + "\n" +
                "Marca: " + carro.marca + "\n" +
                "Ano: " + carro.ano + "\n" +
                "Tipo de Serviço: " + exibServ + "\n" +
                "Falha excepcional: Não" + "\n" +
                "Status do serviço: " + statReal);
            }
            }else{
                JOptionPane.showMessageDialog(null, "O carro selecionado não existe.");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Número de serviço inválido.");
        }
    }else{
        JOptionPane.showMessageDialog(null, "Não há carros na fila.");
        }
    }
    private static String listCar() {
        
        //Listando diretório em um array.
        File dir = new File(caminhoFila);
        String[] arquivosFila = dir.list();

        regCar car = new regCar();
        String exibir = "";

        //Construção da String.
        for(int i = 0; i < arquivosFila.length; i++){
            //Lendo o contato da posição da lista.
            lerCar((i+1), car);

            //Montando String.
            exibir += (i+1) + "- " + car.nomeCarro + "\n";
        }
        return exibir;
    }
    private static int lerId() {
        //Inicializando a variável.
        int iD = 0;

        try{
        
        BufferedReader br = new BufferedReader(new FileReader("id.txt"));
        String A = br.readLine();
        
        //Caso seja nulo, atribui o número 1.
        if(A == null){
            iD = 1;
        }
        
        //Caso não seja, recebe o valor lido.
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
    private static regCar lerCar(int i, regCar carroSelec){
        File arquivo = new File(caminhoFila + i + ".txt");
        //Lê arquivo selecionado para leitura com base na chamada do método.

        try{
        
        BufferedReader br = new BufferedReader(new FileReader(arquivo));

        //Lendo os dados.
        carroSelec.nomeCarro = br.readLine();
        carroSelec.marca = br.readLine();
        carroSelec.ano = Integer.parseInt(br.readLine());
        carroSelec.tipoServiço= Integer.parseInt(br.readLine());
        carroSelec.necessidadeRequerimento = br.readLine();
        carroSelec.status = Integer.parseInt(br.readLine());
        carroSelec.nomeCliente = br.readLine();
        carroSelec.numTel = br.readLine();
        carroSelec.idReq = br.readLine();
        br.close();
        }
        catch (IOException e){
            JOptionPane.showMessageDialog(null, "Ocorreu algum erro na leitura dos dados do carro.");
        }
        return carroSelec;
        //Retorna o registro do carro.
    }
    private static void listClient() {
        
        //Variável onde será lido os dados do cliente.
        regCar contClient = new regCar();
        
        //Listando o diretório.
        File dir = new File(caminhoFila);
        String[] listaDir = dir.list();
        
        //Inicializando string onde será exibida a lista.
        String listExibir = "";


        if(listaDir.length > 0){
        for (int i = 0; i < listaDir.length; i++) {
            //Lendo dados.
            lerCar((i+1), contClient);
            
            //Construção da string.
            listExibir = listExibir + (i+1) + "- " + "Carro: " + contClient.nomeCarro + " - "+ "Cliente: " + contClient.nomeCliente + " - " + "Tel: " + contClient.numTel + "\n";
        }
        //Exibição.
        JOptionPane.showMessageDialog(null, listExibir);
        }else{
            JOptionPane.showMessageDialog(null, "Não há carros na fila.");
        }
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
                JOptionPane.showMessageDialog(null, "Ocorreu algum erro na inizalização dos diretórios.");
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
            JOptionPane.showMessageDialog(null, "Ocorreu algum erro na organização dos dados.");
        }
    }

}
