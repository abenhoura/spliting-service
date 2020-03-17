package com.adneom;

import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PartitionTest {

    @Test
    public void mustSplitInThreeLists() {
        //Arrange
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        //Act
        Partition partition = Partition.partition(numbers, 3);

        //Assert
        List expected = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Collections.singletonList(7));
        Assert.assertEquals(expected, partition);
    }

    @Test
    public void mustSplitInTwoLists() {
        //Arrange
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        //Act
        Partition partition = Partition.partition(numbers, 2);

        //Assert
        List expected = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3,4));
        Assert.assertEquals(expected, partition);
    }

    @Test
    public void mustReturnEmptyList() {
        //Arrange
        final List<Integer> numbers = Collections.emptyList();

        //Act
        Partition partition = Partition.partition(numbers, 2);

        //Assert
        Assert.assertEquals(Collections.emptyList(), partition);
    }

    @Test(expected = IllegalArgumentException.class)
    public void mustThrowIllegalArgumentExceptionWhenChunksizeLessThenZero() {
        //Arrange
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        //Act
        Partition.partition(numbers, 0);

        //Assert
    }

    @Test(expected = IllegalArgumentException.class)
    public void mustThrowIllegalArgumentExceptionWhenListIsNull() {
        //Arrange

        //Act
        Partition.partition(null, 1);

        //Assert
    }
}

