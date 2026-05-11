import java.util.*;

public class SecondLargest{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements in the array: ");
        int n = sc.nextInt();

        ArrayList<Integer> arr = new ArrayList<Integer>();
        System.out.println("Enter the elements of the array:");
        for(int i = 0; i < n; i++) arr.add(sc.nextInt());

        find2ndLargest f2l = new find2ndLargest(arr);
        System.out.println("Second largest element in the array: " + f2l.get2ndLargest());
        sc.close();
    }
}

class find2ndLargest{
    ArrayList<Integer> arr;
    public find2ndLargest(ArrayList<Integer> arr){ this.arr = arr;}
    public find2ndLargest(){ arr = new ArrayList<Integer>(); }

    public ArrayList<Integer> getArray(){return arr;}
    public void setArray(ArrayList<Integer> arr){ this.arr = arr;}

    public int get2ndLargest(){
        int l = Integer.MIN_VALUE, lNext = Integer.MIN_VALUE;

        ListIterator<Integer> it = arr.listIterator();
        while(it.hasNext()){
            final int curr = it.next();
            if(curr > l){
                lNext = l;
                l = curr;
            }
            else if(curr > lNext && curr != l) lNext = curr;
        }
        return lNext;
    }
}