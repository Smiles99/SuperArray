public class SuperArray {
    private String[] data;
    private int size;

    public SuperArray() {
        data = new String[10];
        size = 0;
    }

    public int size() {
        return size;
    }

    public String[] add(String element) {
        if (element == null) {
            throw new IllegalArgumentException("Cannot add a null element");
        }
        if (size == 0) {
            data[0] = element;
            size++;
        } else {
            boolean isSpace = false;
            int index = 0;
            for (int i = 0; i < size; i++) {
                if (data[i] == null) {
                    isSpace = true;
                    index = i;
                    break;
                }
            }
            if (isSpace == true) {
                data[index] = element;
                size++;
            } else if (isSpace == false && data[size - 1] != null) {
                resize();
                data[size] = element;
                size++;
            }
        }
        return data;
    }

    public String get(int Index) {
        if (Index < 0 || Index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return data[Index];
    }

    public String set(int Index, String element) {
        if (element == null) {
            throw new IllegalArgumentException("Cannot add a null element");
        }
        if (Index < 0 || Index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        String temp = data[Index];
        data[Index] = element;
        return temp;
    }

    private void resize() {
        if (size == 0) {
            String[] newArray = new String[(size + 1) * 2];
            for (int i = 0; i < size; i++) {
                newArray[i] = data[i];
            }
            data = newArray;
        } else {
            String[] newArray = new String[size * 2];
            for (int i = 0; i < size; i++) {
                newArray[i] = data[i];
            }
            data = newArray;
        }

    }

    public void clear() {
        data = new String[10];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        int b = 0;
        String added = "{";
        while (b < size) {
            if ((data[b] != " ") && (b == size - 1)) {
                added = added + "," + " " + data[b] + "}";
                b++;
            } else {
                if (data[b] != " ") {
                    added = added + "," + " " + data[b];
                    b++;
                } else {
                    b++;
                }
            }
        }
        return added;
    }

    public boolean contains(String s) {
        int counter = 0;
        int c = 0;
        while (c < size) {
            if (data[c] == s) {
                counter = 1;
                c++;
            } else {
                c++;
            }
        }
        if (counter == 1) {
            return true;
        } else {
            return false;
        }
    }

    public SuperArray(int initialCapacity) {
        if (initialCapacity >= 0) {
            String[] CapArray = new String[initialCapacity];
            data = CapArray;
        } else {
            throw new IllegalArgumentException("Invalid Capacity");
        }
    }

    public void add(int index, String element) {
        if (element == null) {
            throw new IllegalArgumentException("Cannot add null element");
        }
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        boolean isSpace = false;
        for (int i = 0; i < size; i++) {
            if (data[i] == null) {
                isSpace = true;
                break;
            }
        }
        if(isSpace == false) {
            resize();
        }

        if (size == 0 || index == size) {
            data[index] = element;
            size++;
        } else {
            for (int i = size - 1; i >= index; i--) {
                data[i + 1] = data[i];
            }
            data[index] = element;
            size++;
        }
    }

    public String remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        String temp = data[index];
        if (index == size - 1) {
            data[index] = null;
            size--;
            return temp;
        } else {
            for (int i = index + 1; i < size; i++) {
                data[i - 1] = data[i];
            }
            data[size - 1] = null;
            size--;
            return temp;
        }
    }

    public int indexOf(String s) {
        int f = 0;
        int g = -1;
        while (f < size) {
            if (data[f] == s) {
                g = f;
                return g;
            } else {
                f++;
            }
        }
        return g;
    }

    public String[] toArray() {
        String[] HoldArray = new String[size];
        int h = 0;
        while (h < size) {
            HoldArray[h] = data[h];
            h++;
        }
        return HoldArray;
    }

    public static void removeDuplicates(SuperArray s) {
        int u = 0;
        int v = 0;
        while (u < s.size()) {
            if (u > 0) {
                while (v < u) {
                    if (s.get(u) == s.get(v)) {
                        s.remove(u);
                        v = 0;
                    } else {
                        v++;
                    }
                }
                u++;
            } else {
                u++;
            }
        }
    }

    public static void main(String[] args) {
        SuperArray words = new SuperArray(2);
        words.add("kani");
        words.add("uni");
        words.add("ebi");
        words.add("una");
        words.add("una");
        words.add("ebi");
        words.add("kani");
        words.add("una");
        words.add("una");
        words.add("ebi");
        words.add("toro");
        System.out.println(words);
        removeDuplicates(words);
        System.out.println(words);
    }

    public static SuperArray findOverlap(SuperArray a, SuperArray b) {
        SuperArray Combined = new SuperArray();
        int Ov = 0;
        int Er = 0;
        int Copo = 0;
        while (Ov < a.size) {
            while (Er < b.size) {
                if (a.get(Ov) == b.get(Er)) {
                    Combined.data[Copo] = a.get(Ov);
                    Copo++;
                    Er = 0;
                    Ov++;
                } else {
                    Er++;
                }
            }
            Ov++;
        }
        removeDuplicates(Combined);
        return Combined;
    }

    public int lastIndexOf(String value) {
        int Pos = 0;
        int Ind = -1;
        while (Pos < size) {
            if (data[Pos] == value) {
                Ind = Pos;
            } else {
                Pos++;
            }
        }
        return Ind;
    }

    public boolean equals(SuperArray other) {
        int equ = 0;
        if (other.size > size || size > other.size) {
            return false;
        } else {
            if (data[equ] == other.get(equ)) {
                equ++;
            } else {
                return false;
            }
        }
        return true;
    }

    public static SuperArray zip(SuperArray a, SuperArray b) {
        SuperArray zipped = new SuperArray(a.size + b.size);
        int i = 0;
        int loc = 0;
        if (b.size > a.size) {
            while (i < a.size) {
                loc = 2 * i;
                zipped.data[loc] = a.get(i);
                loc++;
                zipped.data[loc] = b.get(i);
                i++;
            }
            while (i < b.size) {
                zipped.data[loc] = b.get(i);
                loc++;
                i++;
            }
        } else {
            while (i < b.size) {
                loc = 2 * i;
                zipped.data[loc] = a.get(i);
                loc++;
                zipped.data[loc] = b.get(i);
                i++;
            }
            while (i < a.size) {
                zipped.data[loc] = a.get(i);
                loc++;
                i++;
            }
        }
        return zipped;
    }
}
