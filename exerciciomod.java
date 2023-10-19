Aqui estão as implementações das estruturas de dados solicitadas, seguidas pelas análises de complexidade:

### Pilha:

public class Pilha {
    private int[] stack;
    private int top;
    
    public Pilha(int capacity) {
        stack = new int[capacity];
        top = -1;
    }
    
    public void push(int value) {
        if (top < stack.length - 1) {
            stack[++top] = value;
        }
    }
    
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("A pilha está vazia.");
        }
        return stack[top--];
    }
    
    public int top() {
        if (isEmpty()) {
            throw new IllegalStateException("A pilha está vazia.");
        }
        return stack[top];
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
    
    public int size() {
        return top + 1;
    }
}
```

**Complexidade de tempo:**
- `push()`: O(1) - Inserção de um elemento na pilha é uma operação constante.
- `pop()`: O(1) - Remoção de um elemento da pilha é uma operação constante.

**Complexidade de espaço:**
- O(n), onde n é a capacidade máxima da pilha.

### Fila:

public class Fila {
    private int[] queue;
    private int front;
    private int rear;
    private int size;

    public Fila(int capacity) {
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(int value) {
        if (!isFull()) {
            rear = (rear + 1) % queue.length;
            queue[rear] = value;
            size++;
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("A fila está vazia.");
        }
        int removed = queue[front];
        front = (front + 1) % queue.length;
        size--;
        return removed;
    }

    public int rear() {
        if (isEmpty()) {
            throw new IllegalStateException("A fila está vazia.");
        }
        return queue[rear];
    }

    public int front() {
        if (isEmpty()) {
            throw new IllegalStateException("A fila está vazia.");
        }
        return queue[front];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == queue.length;
    }
}
```

**Complexidade de tempo:**
- `enqueue()`: O(1) - Inserção de um elemento na fila é uma operação constante.
- `dequeue()`: O(1) - Remoção de um elemento da fila é uma operação constante.
- `rear()`: O(1) - Acesso ao último elemento da fila é uma operação constante.
- `front()`: O(1) - Acesso ao primeiro elemento da fila é uma operação constante.

**Complexidade de espaço:**
- O(n), onde n é a capacidade máxima da fila.

### Lista Encadeada:

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ListaEncadeada {
    private Node head;
    private int size;

    public void push(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
        size++;
    }

    public Node pop() {
        if (isEmpty()) {
            throw new IllegalStateException("A lista está vazia.");
        }
        Node removed;
        if (size == 1) {
            removed = head;
            head = null;
        } else {
            Node current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            removed = current.next;
            current.next = null;
        }
        size--;
        return removed;
    }

    public void insert(int index, Node node) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Índice fora dos limites.");
        }
        if (index == 0) {
            node.next = head;
            head = node;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            node.next = current.next;
            current.next = node;
        }
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Índice fora dos limites.");
        }
        if (index == 0) {
            head = head.next;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }

    public Node elementAt(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Índice fora dos limites.");
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public int size() {
        return size;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
```

**Complexidade de tempo:**
- `push()`: O(n) - Inserção no final da lista encadeada é uma operação linear, pois requer percorrer a lista.
- `pop()`: O(n) - Remoção do último elemento da lista encadeada é uma operação linear, pois requer percorrer a lista.
- `insert()`: O(n) - Inserção em um índice específico da lista é uma operação linear, pois requer percorrer a lista.
- `remove()`: O(n) - Remoção em um índice específico da lista é uma operação linear, pois requer percorrer a lista.
- `elementAt()`: O(n) - Acesso a um elemento em um índice específico da lista é uma operação linear, pois requer percorrer a lista.

**Complexidade de espaço:**
- O(n), onde n é o número de elementos na lista encadeada.

### Mapa de Hash:

Para o mapa de hash com tamanho fixo de 10 elementos, usarei uma função hash simples que calcula o índice com base na chave

, realizando uma operação de módulo.

public class MapaHash {
    private int[] keys;
    private int[] values;

    public MapaHash() {
        keys = new int[10];
        values = new int[10];
    }

    public void put(int key, int value) {
        int index = hash(key);
        keys[index] = key;
        values[index] = value;
    }

    public void delete(int key) {
        int index = hash(key);
        keys[index] = 0;
        values[index] = 0;
    }

    public int get(int key) {
        int index = hash(key);
        return values[index];
    }

    public void clear() {
        for (int i = 0; i < keys.length; i++) {
            keys[i] = 0;
            values[i] = 0;
        }
    }

    private int hash(int key) {
        return key % 10;
    }
}
```

**Justificação da função hash:**
A função hash utilizada é simples e calcula o índice com base no valor da chave usando o operador de módulo (%). Como o tamanho do mapa é fixo em 10 elementos, o módulo 10 garante que o índice esteja dentro dos limites. No entanto, essa função hash pode não ser ideal para distribuição uniforme de chaves em casos de colisão.

**Complexidade de tempo:**
- `put()`: O(1) - Inserção de um par chave/valor no mapa é uma operação constante.
- `delete()`: O(1) - Remoção de um par chave/valor no mapa é uma operação constante.
- `get()`: O(1) - Recuperação de um valor associado a uma chave é uma operação constante.
- `clear()`: O(n) - Limpar todos os elementos do mapa é uma operação linear em relação ao tamanho do mapa.

**Complexidade de espaço:**
- O(1), pois o tamanho do mapa é fixo em 10 elementos.