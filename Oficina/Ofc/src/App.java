import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
    preencheDatbase(dataBase);
    salvaMat(dataBase);
    }

    public static void preencheDatbase(String [][] A){
        //Método para preenchmento de dados.

        for(int i = 0; i < 1; i++){
            A[0][i] = JOptionPane.showInputDialog(null, "Insira o nome do carro: ");
            A[1][i] = JOptionPane.showInputDialog(null, "Insira oa marca do carro: ");
            A[2][i] = JOptionPane.showInputDialog(null, "Insira a descrição do serviço: ");
            A[3][i] = JOptionPane.showInputDialog(null, "Insira o nome do cliente ");
        }
    }

    public static void salvaMat(String[][] A){
        //Método para salvamento da matriz em um arquivo txt.

        try{
        
        //Cria um FileWriter chamado "Escritor", ele irá inserir o valores da String "dataBase"
        //em um arquivo chamado "Database.txt".
        FileWriter Escritor = new FileWriter("Database.txt");
        
        //Laço para percorrer matriz.
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 1; j++){
                
                //Leitura e adição da string armazenada.
                Escritor.write(A[i][j] + " ");
            }
            
            //Concatenação.
            Escritor.write("\n");

            //Garantia de fechamento do escritor ao atingir limite de laço de repetição.
            if(i == 3){
            Escritor.close();
            }
        }
        }
        
        //Tratamento de erro para falha de entrada e saída.
        catch(IOException D){
            D.printStackTrace();
        }
    }
    
    
    //Database de registro dos carros.
    public static String[][] dataBase = new String[4][1];


}
