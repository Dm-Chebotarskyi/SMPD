import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Generate posible all combinations from N by K
 *
 * @author dima
 */
public class CombinationsGenerator {

    private final int n, k;
    private List<int[]> subsets = new ArrayList<int[]>();
    private int[] s;    
    private List<int[]> res = new ArrayList<int[]>();

    public CombinationsGenerator(int n, int k) {
        this.n = n;
        this.k = k;
        s = new int[k];
    }

    public List<int[]> getCombinations() {
        if (k <= n) {
            int[] fst = new int[k];
            for (int i=0; i<k; ++i) {
                fst[i] = i;
            }
            int[] first = new int[k]; 
            int[] last = new int [k];
            
            for (int i = 0; i < k; ++i) {
                first[i] = i;
            }
            res.add(first);
            
            
            for (int i = 0; (s[i] = i) < k - 1; i++) {
                subsets.add(getSubsets(s));              
            }
            for (;;) {
                int i;
                for (i = k - 1; i >= 0 && s[i] == n - k + i; i--);
                if (i < 0) {
                    break;
                } else {
                    s[i]++;
                    for (++i; i < k; i++) {
                        s[i] = s[i - 1] + 1;
                    }
                    res.add(s.clone());
                    subsets.add(getSubsets(s));
                }
            }
        }
        return res;
    }

    private int[] getSubsets(int[] subset) {
        int[] result = new int[subset.length];
        for (int i = 0; i < subset.length; i++) {
            result[i] = i;
        }
        return result;
    }

}
