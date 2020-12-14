public class SuperArray {
    private String [] data;
    private int size;
    public SuperArray() {
        data = new String[10];
        size = 0;
    }
    public int size() {
        return size;
    }
    public boolean add(String element) {
        int x = 0;
        String[] hold = new String[0];
        if (x + 1 < size()) {
            data[x + 1] = data + element;
        } else {
            //resize();
            hold = data;
            data = new String[size() + 1];
        }
        return true;
    }
    public String get(int Index) {
        if (Index < 0 || Index >=size()) {
            return data[Index];
        } else {
            System.out.println("Invalid Index");
            String Invalid = "Invalid Index";
            return Invalid;
        }
    }
