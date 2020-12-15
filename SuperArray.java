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
        if (Index >= 0 && Index < size()) {
            return data[Index];
        } else {
            System.out.println("Invalid Index");
            String Invalid = "Invalid Index";
            return Invalid;
        }
    }

    public String set(int Index, String element) {
        if (Index < 0 || Index >= size()) {
            data[Index] = element;
            return element;
        } else {
            System.out.println("Invalid Index");
            return "Invalid Index";
        }
    }

    private void resize() {
        int z = 0;
        int y = size;
        String[] NewArray = new String[y];
        while (z < size) {
            NewArray[z] = data[z];
            z++;
        }
        data = NewArray;
        y++;
    }

    public void clear() {
        String[] clearArray = new String[0];
        data = clearArray;
    }

    public boolean isEmpty() {
        if (data[0] == null) {
            return true;
        } else {
            return false;
        }
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
            System.out.println("Invalid Capacity");
        }
    }

    public void add(int index, String element) {
        if (index < 0 || index > size()) {
            String hold1 = "";
            String hold2 = "";
            int d = index;
            while (d < size) {
                if (hold1 == "") {
                    hold1 = data[d];
                    data[d] = element;
                    d++;
                } else {
                    hold2 = data[d];
                    data[d] = hold1;
                    hold1 = hold2;
                    d++;
                }
            }
        } else {
            System.out.println("Invalid Index");
        }
    }

    public String remove(int index) {
        if (index < 0 || index >= size()) {
            int e = index;
            while (e < size) {
                if (e == size - 1) {
                    data[e] = "";
                } else {
                    data[e] = data[e + 1];
                }
            }
            return "";
        } else {
            System.out.println("Invalid Index");
            return "Invalid Index";
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
        SuperArray words = new SuperArray();
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
