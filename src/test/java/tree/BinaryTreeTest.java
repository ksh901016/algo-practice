package tree;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BinaryTreeTest {

    private BinaryTree<Integer, Data> binaryTree = new BinaryTree<>();

    @BeforeEach
    void setUp(){
        binaryTree.add(4, new Data(4, "D군"));
        binaryTree.add(2, new Data(2, "B군"));
        binaryTree.add(6, new Data(6, "F군"));
        binaryTree.add(1, new Data(1, "A군"));
        binaryTree.add(3, new Data(3, "C군"));
        binaryTree.add(5, new Data(5, "E군"));
    }

    @Test
    void print(){
        Data result = binaryTree.search(3);
        Assertions.assertEquals(new Data(3, "C군"), result);
    }

    @Getter
    @AllArgsConstructor
    @EqualsAndHashCode
    static class Data{
        private int seq;
        private String name;
    }

}
