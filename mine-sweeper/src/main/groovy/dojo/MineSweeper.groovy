package dojo

class MineSweeper {

    private final int DEFAULT_SIZE = 9
    private final int NO_OF_MINES = 10
    private final int MINE = -1
    final int[][] fields
    final Random randomNumberGenerator = new Random()

    def MineSweeper() {
        fields = new int[DEFAULT_SIZE][DEFAULT_SIZE]
    }

    def distributeMines() {
        int noOfMinesToDistribute = NO_OF_MINES
        int i, j
        while (noOfMinesToDistribute > 0) {
            i = randomNumberGenerator.nextInt(DEFAULT_SIZE - 1)
            j = randomNumberGenerator.nextInt(DEFAULT_SIZE - 1)
            if (fields[i][j] != MINE) {
                fields[i][j] = MINE
                noOfMinesToDistribute--
            }
        }
    }

    def calculateMineInfo() {
        for (int i in 0..DEFAULT_SIZE - 1) {
            for (int j in 0..DEFAULT_SIZE - 1) {
                int tl = 0
                int tc = 0
                int tr = 0
                int l = 0
                int r = 0
                int ll = 0
                int lc = 0
                int lr = 0

                if (i > 0 && j > 0) {
                    tl = fields[i - 1][j - 1]
                    tc = fields[i - 1][j]
                }
                if (i > 0 && j < DEFAULT_SIZE - 2) {
                    tr = fields[i - 1][j + 1]
                }

                if (fields[i][j] != MINE) {
                    fields[i][j] = sum(tl, tc, tr, l, r, ll, lc, lr)
                }
            }
        }
    }

    def sum(int ... input) {
        int sum = 0
        for (int i : input)
            sum = sum + i
        Math.abs(sum)
    }

    @Override
    public String toString() {
        String result = ""
        for (int i in 0..DEFAULT_SIZE - 1) {
            for (int j in 0..DEFAULT_SIZE - 1) {
                result += fields[i][j] + "\t"
            }
            result += "\n"
        }
        result
    }

}
