
public class A {
    int eid;
    A(int eid)
    {
        System.out.println(eid);
    }
    void display()
    {
        System.out.println(eid);
    }
   
    public static void main(String st[])
    {
        String s1 = "java";
        String s2 = "java";
        String s3 = "JAVA";
        s2.toUpperCase();
        s3.toUpperCase();
        boolean b1 = s1==s2;
        boolean b2 = s1==s3;
        System.out.print(b1);
        System.out.print(" "+b2);
    }
}
