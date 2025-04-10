package Lab04;

public class dpSolution {
    static int getValue(int[] values, int rodLength) {
        int[] subSolutions = new int[rodLength + 1];  
        
        for (int i = 1; i <= rodLength; i++) {
            int tmpMax = -1;  
            for (int j = 0; j < i; j++) {
                tmpMax = Math.max(tmpMax, values[j] + subSolutions[i - j - 1]);
            }
            subSolutions[i] = tmpMax;
        }
        return subSolutions[rodLength];
    }

}
