
public class calculadoraLexica{
    public static void main(String[] args) {
        char num_real[] = new  char[20];
        char num_int[] = new  char[20];
        char op_soma[] = new  char[20];
        char op_mult[] = new  char[20];
        char abre_parenteses[] = new  char[20];
        char fecha_parenteses[] = new  char[20];
        char erro[] = new  char[20];

        int i = 0;
        int a = 0 ,b =0 ,c=0,d=0,e=0,f=0,k=0;
        String expressao = "(1+1.12-92))";

        while ( i<expressao.length() ){
            switch (expressao.charAt(i))  {
            case ' ':
                i++;
            break;
            case '(':
                abre_parenteses[a]  = expressao.charAt(i);
                a++;
                i++;    
            break;
            case ')':
                fecha_parenteses[b] = expressao.charAt(i);
                b++;
                i++;
            break;
            case '+':
                op_soma[c] = expressao.charAt(i);
                c++;
                i++;
            break;
            case '*':
                op_mult[d] = expressao.charAt(i);
                d++;
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
                i++;
                switch (expressao.charAt(i)){
                case '.':
                    num_real[f] = expressao.charAt(i-1);
                    f++;
                    num_real[f] = expressao.charAt(i);
                    f++;
                    i++;
                    while(expressao.charAt(i)== '0' || expressao.charAt(i)== '1' ||
                    expressao.charAt(i)== '2' || expressao.charAt(i)== '3' ||
                    expressao.charAt(i)== '4' || expressao.charAt(i)== '5' ||
                    expressao.charAt(i)== '6' || expressao.charAt(i)== '7' ||
                    expressao.charAt(i)== '8' || expressao.charAt(i)== '9'){
                        num_real[f] = expressao.charAt(i);
                        f++;
                        i++;
                    }
                    num_real[f] =  ' ';
                    f++;
                break;   
    
                default:
                    num_int[e] = expressao.charAt(i-1);
                    e++;  
                    while(expressao.charAt(i)== '0' || expressao.charAt(i)== '1' ||
                    expressao.charAt(i)== '2' || expressao.charAt(i)== '3' ||
                    expressao.charAt(i)== '4' || expressao.charAt(i)== '5' ||
                    expressao.charAt(i)== '6' || expressao.charAt(i)== '7' ||
                    expressao.charAt(i)== '8' || expressao.charAt(i)== '9'){
                        num_int[e] = expressao.charAt(i);
                        e++;
                        i++;
                    }
                    num_real[e] =  ' ';
                    e++;
                break;
                }
            break;
    
            
            default:
                erro[k] = expressao.charAt(i); 
                k++;
                i++;
                break;
            }
        }
    
        System.out.println(expressao);
        System.out.print("Números reais: ");
        for (char y : num_real) 
            System.out.print(y);
        
        System.out.println();
        System.out.print("Números inteiros: ");
        for (char y : num_int) 
            System.out.print(y);

        System.out.println();
        System.out.print("Op soma: ");
        for (char y : op_soma) 
            System.out.print(y);
            
        System.out.println();
        System.out.print("Op multiplicacao: ");
        for (char y : op_mult) 
            System.out.print(y);

        System.out.println();
        System.out.print("Abre parenteses: ");
        for (char y : abre_parenteses) 
            System.out.print(y);    

        System.out.println();
        System.out.print("Fecha Parenteses: ");
        for (char y : fecha_parenteses) 
            System.out.print(y); 
            
        System.out.println();
        System.out.print("Erros: ");
        for (char y : erro) 
            System.out.print(y); 

    }
}