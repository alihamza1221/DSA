package stack;

public class customstack {
    protected int[] data;
    private static final int default_value = 10;
    private int ptr = -1;

    // Constructor with default size
    public customstack() {
        this(default_value);
    }

    // Constructor with a specified size
    public customstack(int size) {
        this.data = new int[size];
    }

    // Push a value onto the stack
    public boolean push(int value) throws customexception {

        if (isfull()) {
            throw new customexception("Stack index out of bound!");
        }
        ptr++;
        data[ptr] = value;
        return true;
    }

    // Peek at the top element of the stack
    public int peek() {
        return data[ptr];
    }

    // Pop the top element from the stack
    public int pop() throws customexception {
        if (isempty()) {
            throw new customexception("Stack is empty!");
        }
        int value = data[ptr];
        ptr--;
        return value;
    }

    // Check if the stack is full
    public boolean isfull() {
        return ptr > data.length - 1;
    }

    // Check if the stack is empty
    public boolean isempty() {
        return ptr < 0;
    }
}