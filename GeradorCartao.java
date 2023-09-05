import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class GeradorCartao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String cartao;
        char cartaoChar;
        int cartaoInt, digitoFinal, soma1 = 0, soma2 = 0, somaTotal, calc1, calc2;

        List<Integer> listaCartaoInt = new ArrayList<>();

        System.out.println("GERADOR DE CARTÃO DE CRÉDITO.");
        System.out.print("Digite 15 números sequenciais: ");
        cartao = sc.nextLine();

        // converte para int e aplicar o algoritmo de Luhn
        for (int i = 0; i < cartao.length(); i++) {
            cartaoChar = cartao.charAt(i);
            cartaoInt = Character.getNumericValue(cartaoChar);
            listaCartaoInt.add(cartaoInt);

            if (i % 2 == 0) {
                calc1 = listaCartaoInt.get(i) * 2;
                if (calc1 > 9) { //quando o numero for maior que 9, ex: 2*9(18 = 1+8 = 9) = 18-9=9. O -9 chegara no resultado da soma dos dois valores
                    calc1 -= 9;
                }
                soma1 += calc1;
            } else {
                calc2 = listaCartaoInt.get(i);
                soma2 += calc2;
            }
        }

        somaTotal = soma1 + soma2;

        // calcula o dígito final (verificação Luhn)
        digitoFinal = (10 - (somaTotal % 10)) % 10;

        System.out.println("O cartão gerado é: " + cartao + digitoFinal);

        sc.close();
    }
}
