public class SuperArray {
    private static int length;
    private String [] data;
    private int size;
    public int len = 0;
    public SuperArray() {
        String[] SuperArray = new String[10];
    }
    public int size() {
        while (len < SuperArray.length) {
            if (SuperArray[len] == "") {
                return len;
            } else {
                len++;
            }
        }
        return len;
    }
    public boolean add(String element) {
        if (len + 1 < SuperArray.length) {
            SuperArray[len + 1] = SuperArray + element;
            return SuperArray;
        } else {
            resize();
        }
        return SuperArray;
    }
    public String get(int Index) {
        if (Index < 0 || Index >=size()) {
            return SuperArray[Index];
        } else {
            System.out.println("Invalid Index");
            return SuperArray;
        }
    }
    public String set(int Index, String element) {
        if (Index < 0 || Index >= size()) {
            SuperArray[Index] = element;
            return SuperArray;
        } else {
            System.out.println("Invalid Index");
            return SuperArray;
        }
    }
    private void resize() {
        int z = 0;
        int y = 11;
        String[] NewArray = new String[y];
        while (z < SuperArray.length) {
            NewArray[z] = SuperArray[z];
            z++;
        }
        SuperArray = NewArray;
        y++;
    }
    public void clear() {
        String[] clearArray = new String[0];
        SuperArray = clearArray;
    }
    public boolean isEmpty() {
        if (SuperArray[0] == null) {
            return true;
        } else {
            return false;
        }
    }
    public String toString() {
        int b = 0;
        String added = "{";
        while (b < SuperArray.length) {
            if ((SuperArray[b] != " ") && (b == SuperArray.length - 1)) {
                added = added + "," + " " + SuperArray[b] + "}";
                b++;
            } else {
                if (SuperArray[b] != " ") {
                    added = added + "," + " " + SuperArray[b];
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
        while (c < SuperArray.length) {
            if (SuperArray[c] == s) {
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
        if (initialCapacity >= 0 ) {
            String[] CapArray = new String[initialCapacity];
            SuperArray = CapArray;
        } else {
            System.out.println("Invalid Capacity");
        }
    }
    public void add(int index, String element) {
        if (index < 0 || index > size()) {
            String hold1 = "";
            String hold2 = "";
            int d = index;
            while (d < SuperArray.length) {
                if (hold1 == "") {
                    hold1 = SuperArray[d];
                    SuperArray[d] = element;
                    d++;
                }  else {
                    hold2 = SuperArray[d];
                    SuperArray[d] = hold1;
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
            while (e < SuperArray.length) {
                if (e == SuperArray.length - 1) {
                    SuperArray[e] = "";
                } else {
                    SuperArray[e] = SuperArray[e + 1];
                }
            }
            return SuperArray;
        } else {
            System.out.println("Invalid Index");
            return SuperArray;
        }
    }
    public int indexOf(String s) {
        int f = 0;
        int g = -1;
        while (f < SuperArray.length) {
            if (SuperArray[f] == s) {
                g = f;
                return g;
            } else {
                f++;
            }
        }
        return g;
    }
    public String[] toArray() {
        String[] HoldArray = new String[SuperArray.length];
        int h = 0;
        while (h < SuperArray.length) {
            HoldArray[h] = SuperArray[h];
            h++;
        }
        return HoldArray;
    }
    public static void removeDuplicates(SuperArray s) {
        int u = 0;
        int v = 0;
        while (u < s.length) {
            if (u > 0) {
                while (v < u) {
                    if (s[u] == s[v]) {
                        remove(u);
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
        while (Ov < a.length) {
            while (Er < b.length) {
                if (a[Ov] == b[Er]) {
                    Combined[Copo] = a[Ov];
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
        while (Pos < SuperArray.length) {
            if (SuperArray[Pos] == value) {
                Ind = Pos;
            } else {
                Pos++;
            }
        }
        return Ind;
    }
    public boolean equals(SuperArray other) {
        int equ = 0;
        if (other.length > SuperArray.length || SuperArray.length > other.length) {
            return false;
        } else {
            if (SuperArray[equ] == other[equ]) {
                equ++;
            } else {
                return false;
            }
        }
        return true;
    }
    public static SuperArray zip(SuperArray a, SuperArray b) {
        SuperArray zipped = new SuperArray(a.length + b.length);
        int i = 0;
        int loc = 0;
        if (b.length > a.length) {
            while (i < a.length) {
                loc = 2*i;
                zipped[loc] = a[i];
                loc++;
                zipped[loc] = b[i];
                i++;
            }
            while (i < b.length) {
                zipped[loc] = b[i];
                loc++;
                i++;
            }
        } else {
            while (i < b.length) {
                loc = 2*i;
                zipped[loc] = a[i];
                loc++;
                zipped[loc] = b[i];
                i++;
            }
            while (i < a.length) {
                zipped[loc] = a[i];
                loc++;
                i++;
            }
        }
        return zipped;
    }
}
