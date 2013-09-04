package com.draeger.dojo;

import org.junit.Before
import org.junit.Test

import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.CoreMatchers.is

public class MineSweeperTest {

    MineSweeper mineSweeper

    @Before
    public void setUp() throws Exception {
        mineSweeper = new MineSweeper()
    }

    @Test
    public void initialize_fieldIsInitializedWithZeros() throws Exception {
        println(mineSweeper)
    }

    @Test
    public void distributeMines_tenMinesAreDistributedRandomly() throws Exception {
        mineSweeper.distributeMines()

        int minesTotal = 0

        for (int i in 0..mineSweeper.fields.length - 1)
            for (int j in 0..mineSweeper.fields.length - 1)
                minesTotal += mineSweeper.fields[i][j]

        assertThat(Math.abs(minesTotal), is(Integer.valueOf(10)))
        println(mineSweeper)
    }

    @Test
    public void sum() {
        assertThat(mineSweeper.sum(-1, -1, -1, -1), is(4))
    }

    @Test
    public void calculateMineInfo() throws Exception {
        mineSweeper.distributeMines()

        println(mineSweeper)

        mineSweeper.calculateMineInfo()

        println(mineSweeper)

    }
}
