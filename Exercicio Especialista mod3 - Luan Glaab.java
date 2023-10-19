Exercício 1 - Resolução usando Backtracking:

Para calcular todos os subconjuntos de n elementos de um conjunto S usando backtracking em Java, posso criar uma função recursiva. 

```java
import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void findSubsets(List<Integer> S, int n) {
        List<Integer> currentSubset = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        backtrack(S, n, 0, currentSubset, result);
        
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }

    private static void backtrack(List<Integer> S, int n, int start, List<Integer> currentSubset, List<List<Integer>> result) {
        if (currentSubset.size() == n) {
            result.add(new ArrayList<>(currentSubset));
            return;
        }
        
        for (int i = start; i < S.size(); i++) {
            currentSubset.add(S.get(i));
            backtrack(S, n, i + 1, currentSubset, result);
            currentSubset.remove(currentSubset.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<Integer> S1 = List.of(1, 2, 3);
        int n1 = 2;
        findSubsets(S1, n1);

        List<Integer> S2 = List.of(1, 2, 3, 4);
        int n2 = 1;
        findSubsets(S2, n2);
    }
}
```

Esta implementação usa um algoritmo de backtracking para encontrar todos os subconjuntos de n elementos de um conjunto S. A função `findSubsets` inicia a busca e, para cada conjunto de n elementos encontrado, o adiciona à lista de resultados.

Exercício 2 - Resolução usando Algoritmo Guloso:

Para dar o troco de uma quantia em dinheiro usando o menor número possível de moedas, você pode usar um algoritmo guloso. O algoritmo consiste em selecionar a maior moeda disponível sempre que possível. Aqui está um exemplo de implementação em Java:

```java
import java.util.Arrays;

public class ChangeMaking {

    public static int giveChange(int amount, int[] coins) {
        Arrays.sort(coins);
        int coinCount = 0;
        int i = coins.length - 1;

        while (amount > 0) {
            while (i >= 0 && coins[i] > amount) {
                i--;
            }
            if (i >= 0) {
                int coinValue = coins[i];
                int numCoins = amount / coinValue;
                amount -= numCoins * coinValue;
                coinCount += numCoins;
            }
        }

        return coinCount;
    }

    public static void main(String[] args) {
        int amount = 18;
        int[] availableCoins = {5, 2, 1};
        int minCoins = giveChange(amount, availableCoins);
        System.out.println("Minimum number of coins needed: " + minCoins);
    }
}
```

Neste exemplo, a função `giveChange` recebe a quantia desejada e um array de moedas disponíveis. Ela ordena as moedas em ordem decrescente e, em seguida, tenta usar a maior moeda sempre que possível para minimizar o número de moedas. O resultado é o número mínimo de moedas necessário para dar o troco.