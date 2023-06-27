public class BoyerMooreAlgorithm {

    public int[] badCharacterShiftTable(char[] pattern){

        int[] shiftTable = new int[256];
        int m = pattern.length;

        for (int i = 0; i < 256; i++) {
            shiftTable[i] = m;
        }

        for (int i = 0; i < m - 1; i++) {
            char c = pattern[i];
            shiftTable[c] = m - i - 1;
        }


        return shiftTable;
    }

    public int[] goodSuffixShiftTable(char[] pattern){
        int m = pattern.length;
        int[] borderTable = new int[m+1];
        int[] shiftTable = new int[m+1];

        for(int i=0; i<m + 1; i++){
            shiftTable[i] = 0;
        }

        int i = m;
        int j = m + 1;
        borderTable[i] = j;

        while(i > 0){
            while(j <= m && pattern[i - 1] != pattern[j - 1]){
                if (shiftTable[j] == 0) {
                    shiftTable[j] = j - i;
                }

                //Update the position of next border
                j = borderTable[j];
            }

            i--;
            j--;
            borderTable[i] = j;
        }

        int x;
        int y;
        y = borderTable[0];

        for(x = 0; x <= m; x++)
        {
        /* set the border position of the first character
        of the pattern to all indices in array shift
        having shift[i] = 0 */
            if(shiftTable[x] == 0)
                shiftTable[x] = y;

        /* suffix becomes shorter than bpos[0],
        use the position of next widest border
        as value of j */
            if (x == y)
                y = borderTable[y];
        }

        return shiftTable;
    }

    public void search(char[] text, char[] pattern){
        int s = 0;
        int j;
        int n = text.length;
        int m = pattern.length;

        int[] badCharacterShift = badCharacterShiftTable(pattern);
        int[] goodSuffixShift = goodSuffixShiftTable(pattern);

        while(s <= n-m) {
            j = m - 1;

        /* Keep reducing index j of pattern while
        characters of pattern and text are matching
        at this shift s*/
            while (j >= 0 && pattern[j] == text[s + j])
                j--;

        /* If the pattern is present at the current shift,
        then index j will become -1 after the above loop */
            if (j < 0) {
                System.out.println("pattern occurs at shift " + s);
                s += goodSuffixShift[0];
            } else {

                int badCharShiftValue = badCharacterShift[text[s+j] -m+1+j];
                int goodSuffixShiftValue = goodSuffixShift[j+1];
                s += Math.max(badCharShiftValue, goodSuffixShiftValue);
            }
        }
    }
}
