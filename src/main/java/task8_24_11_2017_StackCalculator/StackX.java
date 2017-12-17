package task8_24_11_2017_StackCalculator;

public class StackX {
    private int maxSize;
    private String[] stackArray;
    private int top;
    public StackX(int size){ // Конструктор
        maxSize = size;
        stackArray = new String[maxSize];
        top = -1;
    }
    //--------------------------------------------------------------
    public void push(String j){ // Размещение элемента на вершине стека
      if(top<maxSize)
        stackArray[++top] = j;
    }
    //--------------------------------------------------------------
    public String pop() // Извлечение элемента с вершины стека
    {  if(top>=0)
        return stackArray[top--];
    else
        return null;
        }
    //--------------------------------------------------------------
    public String peek() // Чтение элемента на вершине стека
    { return stackArray[top]; }
    //--------------------------------------------------------------
    public boolean isEmpty() // true, если стек пуст
    { return (top == -1); }
    //--------------------------------------------------------------
    public boolean isFull() // true, если стек заполнен
    { return (top == maxSize-1); }
    //--------------------------------------------------------------
    public int size() // Текущий размер стека
    { return top+1; }
    //--------------------------------------------------------------
    public String peekN(int n) // Чтение элемента с индексом n
    { return stackArray[n]; }
    //--------------------------------------------------------------
    public void displayStack(String s) {
        System.out.print("s="+s+".");
        System.out.print("Stack (bottom-->top): ");
        for (int j = 0; j < size(); j++) {
            System.out.print(peekN(j));
            System.out.print(' ');
        }
        System.out.println("");
    }
}
