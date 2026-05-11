import java.util.*;

public class ProcessRotation{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements in the list: ");
        int n = sc.nextInt();

        LinkedList<Integer> list = new LinkedList<Integer>();
        System.out.println("Enter the elements of the list:");
        for(int i = 0; i < n; i++) list.add(sc.nextInt());
        RotateList rl = new RotateList(list);

        System.out.print("Enter the number of positions to rotate: ");
        int k = sc.nextInt();
        System.out.print("List after rotations: ");
        rl.rotate(k).forEach(e -> System.out.print(e + " "));
        sc.close();
    }
}

class RotateList{
    LinkedList<Integer> list;

    public RotateList(){list = new LinkedList<Integer>();}
    public RotateList(LinkedList<Integer> list){this.list = list;}

    public LinkedList<Integer> getList(){return list;}
    public void setList(LinkedList<Integer> list){this.list = list;}

    public LinkedList<Integer> rotate(int k){
        final int n = list.size();
        k %= n;
        LinkedList<Integer> rotated = list;
        rotated.addAll(list);
        return new LinkedList<Integer>(rotated.subList(n - k, n * 2 - k));
    }

    @Override
    public String toString(){ return list.toString(); }
}