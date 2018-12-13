public class SATtakers {
    private String dbn;
    private String name;
    private int total;
    private int read;
    private int math;
    private int write;
    public SATtakers(String a, String b, int c, int d, int e, int f)
    {
        dbn =a;
        name =b;
        total=c;
        read=d;
        math=e;
        write=f;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getRead() {
        return read;
    }

    public void setRead(int read) {
        this.read = read;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getWrite() {
        return write;
    }

    public void setWrite(int write) {
        this.write = write;
    }

    public String getDbn() {
        return dbn;
    }

    public void setDbn(String dbn) {
        this.dbn = dbn;
    }
    public String toString()
    {
        return "" + name + ", dbn =" + dbn +", total takers = "+ total + ", reading avg = " + read + ", writing avg = " + write + ", math avg = "+ math;
    }
}
