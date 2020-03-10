import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;

public class anLexica{
    
    public static void main(String[] args) {
        ArrayList<String> SaveInteiro = new ArrayList<String>();
        ArrayList<String> SaveSimbolo = new ArrayList<String>();
        ArrayList<String> SaveCadeias = new ArrayList<String>();
        ArrayList<String> SavePalavrasR = new ArrayList<String>();
        ArrayList<String> SaveErros = new ArrayList<String>();

        ArrayList<String> ArrayPalavrasReservadas = new ArrayList<String>();
        ArrayList<String> ArraySimbolos = new ArrayList<String>();
        //String aux2 = new String();
        //char[] aux = new char[50];
      
        try {
            FileReader palavrasReservadas = new FileReader("palavrasReservadas.txt");
            BufferedReader Reservada = new BufferedReader(palavrasReservadas);
            FileReader Simbolo = new FileReader("Simbolos.txt");
            BufferedReader Simbolos = new BufferedReader(Simbolo);

            while(true){
                ArrayPalavrasReservadas.add(Reservada.readLine()); 
                if(ArrayPalavrasReservadas.get(ArrayPalavrasReservadas.size()-1) == null){
                    break;
                }
                //System.out.println(ArrayPalavrasReservadas.get(ArrayPalavrasReservadas.size()-1));
            }

            while(true){
                ArraySimbolos.add(Simbolos.readLine()); 
                if(ArraySimbolos.get(ArraySimbolos.size()-1) == null){
                    break;
                }
                //System.out.println(ArraySimbolos.get(ArraySimbolos.size()-1));
            }
    
        palavrasReservadas.close();
        Simbolos.close();

        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
            e.getMessage());
        }



        try {
            FileReader ArquivoTeste = new FileReader("ArquivoTeste.txt");
            BufferedReader BufferTeste = new BufferedReader(ArquivoTeste);

            String Linha = new String();
            while ((Linha = BufferTeste.readLine())!=null){
            int i = 0;
            while(i < Linha.length()){
            //while((aux[i] = (char) BufferTeste.read()) != EOF){
                switch (Linha.charAt(i)) {
                    case ' ':
                        i++;                     
                    break;
                    
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                    StringBuilder aux7 = new StringBuilder().append(Linha.charAt(i));
                    i++;
                        while (Linha.charAt(i)>= '0' && Linha.charAt(i)<= '9'){
                            aux7.append(Linha.charAt(i));
                            i++;
                        }
                        SaveInteiro.add(aux7.toString());
                    break; 

                    default:
                        //Para palavras reservadas e cadeias
                        if ((Linha.charAt(i) >= 'A' && Linha.charAt(i) <= 'Z') || (Linha.charAt(i) >= 'a' && Linha.charAt(i) <= 'z')) {
                            StringBuilder aux5 = new StringBuilder().append(Linha.charAt(i));
                            i++;
                            while ((Linha.charAt(i) >= 'A' && Linha.charAt(i) <= 'Z')
                            || (Linha.charAt(i) >= 'a' && Linha.charAt(i) <= 'z')
                            || (Linha.charAt(i) >= '0' && Linha.charAt(i) <= '9') || (Linha.charAt(i) == '_')){                              
                                aux5.append(Linha.charAt(i));
                                i++;
                            }
                            if(ArrayPalavrasReservadas.contains(aux5.toString())){
                                SavePalavrasR.add(aux5.toString());
                            }else{
                                SaveCadeias.add(aux5.toString());
                            }

                        }else{
                            //para simbolos
                            StringBuilder aux4 = new StringBuilder().append(Linha.charAt(i));
                            
                            if(ArraySimbolos.contains(aux4.toString())){
                                if ((i+1) < Linha.length()){
                                    StringBuilder aux3 = new StringBuilder().append(Linha.charAt(i)).append(Linha.charAt(i+1));

                                    if (ArraySimbolos.contains(aux3.toString())) {
                                        SaveSimbolo.add(aux3.toString());
                                        i+=2;
                                    }else{
                                        SaveSimbolo.add(aux4.toString());
                                        i++;
                                    }
                                }else{
                                    SaveSimbolo.add(aux4.toString());
                                        i++;
                                }
                            }else{
                                //para erros
                                SaveErros.add(aux4.toString());
                                i++;
                            }

                        break;
                    }

                    
                }
                }
            }

            System.out.println(); 
            System.out.print("Erros: ");               
            for (String x: SaveErros){
                System.out.print(x + ' ');
            }

            System.out.println(); 
            System.out.println(); 
            System.out.print("Simbolos: ");               
            for (String x: SaveSimbolo){
                System.out.print(x + ' ');
            }

            System.out.println(); 
            System.out.println(); 
            System.out.print("Cadeias: ");               
            for (String x: SaveCadeias){
                System.out.print(x + ' ');
            }

            System.out.println(); 
            System.out.println(); 
            System.out.print("Palavras Reservadas: ");               
            for (String x: SavePalavrasR){
                System.out.print(x + ' ');
            }

            System.out.println(); 
            System.out.println(); 
            System.out.print("Numeros Inteiros: ");               
            for (String x: SaveInteiro){
                System.out.print(x + ' ');
            }

            ArquivoTeste.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
            e.getMessage());
        }
    }

}