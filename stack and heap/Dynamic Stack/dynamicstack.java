package stack;

public class dynamicstack extends customstack {
    public dynamicstack() {
        super();
    }

    public dynamicstack(int size) {
        super(size);
    }

    @Override
    public boolean push(int value) throws customexception {
        if (this.isfull()) {
            int[] temp = new int[data.length * 2];
            // Copy the data to the new array
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }
            data = temp; // Update the reference to the new array
        }
        return super.push(value);
    }
}


