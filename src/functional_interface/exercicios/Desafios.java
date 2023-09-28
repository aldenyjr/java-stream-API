package functional_interface.exercicios;

import java.util.*;

public class Desafios {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4);

        // Desafio 1 - Mostre a lista na ordem numérica:
        System.out.println("--------------- Desafio 1 - Mostre a lista na ordem numérica: ---------------");
        List<Integer> numerosOrdenados = numeros.stream().sorted().toList();
        System.out.println(numerosOrdenados);

        // Desafio 2 - Imprima a soma dos números pares da lista:
        System.out.println("--------------- Desafio 2 - Imprima a soma dos números pares da lista ---------------");
        List<Integer> NumerosPares = numeros.stream().filter(numero -> numero % 2 == 0).toList();
        int somaTotalNumerosPares = NumerosPares.stream().reduce(0, Integer::sum);
        System.out.println(NumerosPares + " Soma: " + somaTotalNumerosPares);

        // Desafio 3 - Verifique se todos os números da lista são positivos:
        System.out.println("--------------- Desafio 3 - Verifique se todos os números da lista são positivos ---------------");
        long numerosPositivos = numeros.stream().filter(numero -> numero > 0).count();
        if(numerosPositivos == numeros.size()){
            System.out.println("Todos os numeros são positivos!");
        } else {
            System.out.println("Nem todos são positivos!");
        }

        // Desafio 4 - Remova todos os valores ímpares
        System.out.println("--------------- Desafio 4 - Remova todos os valores ímpares ---------------");
        System.out.println(numeros.stream().filter(numero -> numero % 2 == 0).toList());

        System.out.println("--------------- Desafio 5 - Calcule a média dos números maiores que 5: ---------------");
        double media = numeros.stream()
                .filter(numero -> numero > 5) // Filtrar números maiores que 5
                .mapToDouble(Integer::doubleValue)// Converter para double
                .average() // Calcular a média
                .orElse(0); // retorna double 0 caso nao tenha media para calcular
        System.out.println(media);

        // Desafio 6 - Verificar se a lista contém algum número maior que 10
        System.out.println("--------------- Desafio 6 - Verificar se a lista contém algum número maior que 10 ---------------");
//        numeros.stream().filter(numero -> {
//            if(numero > 10){
//                System.out.println(numero);
//            }
//            return false;
//        });
        if(numeros.stream().anyMatch(numero -> numero > 10)){
            System.out.println("Contem numero maior que 10");
        } else {
            System.out.println("Nao contem!");
        }

        // Desafio 7 - Encontrar o segundo número maior da lista:
        System.out.println("--------------- Desafio 7 - Encontrar o segundo número maior da lista: ---------------");
        Integer segundoMaior = numeros.stream()
                .distinct() // Remover duplicatas (caso existam)
                .sorted(Comparator.reverseOrder()) // Ordenar em ordem decrescente
                .skip(1) // Pular o maior número (o primeiro da lista)
                .findFirst()// Pegar o primeiro elemento restante (segundo maior)
                .orElse(null); // Lidar com o caso em que não há segundo maior
        System.out.println(segundoMaior);

        // Desafio 8 - Somar os dígitos de todos os números da lista:
        System.out.println("--------------- Desafio 8 - Somar os dígitos de todos os números da lista: ---------------");
        System.out.println(numeros.stream().reduce(0, Integer::sum));

        // Desafio 9 - Verificar se todos os números da lista são distintos (não se repetem):
        System.out.println("--------------- Desafio 9 - Verificar se todos os números da lista são distintos (não se repetem): ---------------");
        Set<Integer> conjunto = new HashSet<>();
        if(numeros.stream().allMatch(conjunto::add)){
            System.out.println("Todos os numeros são distintos");
        } else {
            System.out.println("há numeros repetidos!");
        }

        // Desafio 10 - Agrupe os valores ímpares múltiplos de 3 ou de 5:
        System.out.println("--------------- Desafio 10 - Agrupe os valores ímpares múltiplos de 3 ou de 5: ---------------");
        List<Integer> multiplesDeTresECinco = numeros.stream().filter(numero -> numero % 2 != 0 && numero % 3 == 0 || numero % 5 == 0).toList();
        System.out.println(multiplesDeTresECinco);


        System.out.println("--------------- Desafio 11 - Encontre a soma dos quadrados de todos os números da lista: ---------------");
        System.out.println("Quadrados: " + numeros.stream().map(numero -> numero * numero).toList());
        System.out.println("Soma dos Quadrados: " + numeros.stream().map(numero -> numero * numero).reduce(0, Integer::sum));

        System.out.println("--------------- Desafio 12 - Encontre o produto de todos os números da lista: ---------------");
        System.out.println(numeros.stream().reduce(1, (a, b) -> a * b));

        System.out.println("--------------- Desafio 13 - Filtrar os números que estão dentro de um intervalo (por exemplo, entre 5 e 10): ---------------");
        System.out.println(numeros.stream().filter(numero -> numero > 5 && numero < 10).toList());

        System.out.println("--------------- Desafio 14 - Encontre o maior número primo da lista: ---------------");
        System.out.println(numeros.stream()
                .filter(n -> {
                    if (Math.abs(n) < 2)
                        return false;
                    for (int i = 2; i < Math.abs(n); i++) {
                        if (Math.abs(n) % i == 0)
                            return false;
                    }
                    return true;
                })
                .max(Comparator.naturalOrder()).orElse(null));

    }
}
