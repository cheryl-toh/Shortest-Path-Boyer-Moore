public class BoyerMooreAlgorithm {

    public int[] badCharacterShiftTable(char[] pattern){

        //initialize shift table and pattern length
        int[] shiftTable = new int[256];
        int m = pattern.length;

        //initialize shift table values to pattern length
        for (int i = 0; i < 256; i++) {
            shiftTable[i] = m;
        }

        //update shift table with correct shift value
        for (int i = 0; i < m - 1; i++) {
            char c = pattern[i];
            shiftTable[c] = m - i - 1;
        }

        return shiftTable;
    }

    public int[] goodSuffixShiftTable(char[] pattern){

        //initialize tables and pattern length
        int m = pattern.length;
        int[] borderTable = new int[m+1];
        int[] shiftTable = new int[m+1];

        //initialize values in shift table to be 0
        for(int i=0; i<m + 1; i++){
            shiftTable[i] = 0;
        }

        //preprocessing round 1
        //fill out border table and shift table
        int i = m;
        int j = m + 1;

        borderTable[i] = j;

        while(i > 0){
            //if pattern does not match with character in text, keep expanding to the right to find border of suffix
            while(j <= m && pattern[i - 1] != pattern[j - 1]){

                //if mismatch is found, stop expanding border and update shift table
                if (shiftTable[j] == 0) {
                    shiftTable[j] = j - i;
                }

                //Update the position of next border
                j = borderTable[j];
            }

            //if match is found means border is found, store the beginning value of border
            //decrement i and j to continue search for border for the next character in pattern
            i--;
            j--;
            borderTable[i] = j;
        }

        //preprocessing round 2
        //fill out entire shift table
        //initialize x and y
        int x;
        int y;

        //make y the widest suffix border
        y = borderTable[0];

        for(x = 0; x <= m; x++)
        {
        //if shift table has any value that has not been filled, update with widest border value
            if(shiftTable[x] == 0)
                shiftTable[x] = y;

        //if suffix becomes shorter than the widest border, update y to become the next widest border of pattern
            if (x == y)
                y = borderTable[y];
        }

        return shiftTable;
    }

    public void search(char[] text, char[] pattern){

        //initialize shift values and length of pattern and text
        int s = 0;
        int j;
        int n = text.length;
        int m = pattern.length;

        //preprocessing pattern
        int[] badCharacterShift = badCharacterShiftTable(pattern);
        int[] goodSuffixShift = goodSuffixShiftTable(pattern);

        //start search
        while(s <= n-m) {
            j = m - 1;

            //if pattern character matches text character, decrement j until mismatch found or entire pattern matches
            while (j >= 0 && pattern[j] == text[s + j]) {
                j--;
            }

            //if entire pattern matches, print shift value
            if (j < 0) {
                System.out.println("pattern occurs at shift " + s);
                //shift entire pattern to the right to continue searching
                s += goodSuffixShift[0];
            } else {
                //if mismatch is found, compute shift values for both heuristics
                int badCharShiftValue = badCharacterShift[text[s+j] -m+1+j];
                int goodSuffixShiftValue = goodSuffixShift[j+1];

                //use shift value with the largest shift
                s += Math.max(badCharShiftValue, goodSuffixShiftValue);
            }
        }
    }
}
