import java.util.Iterator;

public class HexIteration implements Iterable<String>{
    private int[] decimals;
    private int n = 100;

    public HexIteration(){

        this.decimals = new int[n];

        for(int i = 0; i < n; i++){
            this.decimals[i] = i;
        }
    }

    public Iterator<String> iterator(){
        return new HexIterator();
    }

    public class HexIterator implements Iterator<String>{

        private int i = 0;

        private String searchMaxNum(int decimal){
            int curr = decimal;
            int maxNum = 0;
            while(curr > 0){
                if(maxNum < (curr % 16)){
                    maxNum = curr % 16;
                }

                curr /= 16;
            }
            return Integer.toHexString(maxNum);
        }

        public boolean hasNext(){
            return  i < n;
        }

        public String next(){
            return searchMaxNum(decimals[i++]);
        }
    }
}
