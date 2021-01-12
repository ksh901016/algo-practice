package tree;

import lombok.ToString;

import java.util.Comparator;
public class BinaryTree<K, V> {
    private Node<K,V> root;
    private Comparator<? super K> comparator = null;

    public BinaryTree(){
        root = null;
    }
    public BinaryTree(Comparator<? super K> c){
        this();
        comparator = c;
    }

    private int comp(K key1, K key2){
        return (comparator == null) ? ((Comparable<K>)key1).compareTo(key2) : comparator.compare(key1, key2);
    }

    // 노드 삽입
    public void add(K key, V data){
        if(root == null){
            root = new Node<>(key, data, null, null);
        }else{
            addNode(root, key, data);
        }
    }

    public V search(K key){
        Node<K, V> p = root;

        while(true){
            if(p == null) return null;
            int condition = comp(key, p.getKey());

            if(condition == 0){
                return p.getValue();
            }else if(condition < 0){
                p = p.left;
            }else{
                p = p.right;
            }
        }
    }

    public boolean remove(K key){
        Node<K, V> p = root;
        Node<K, V> parent = null;
        boolean isLeftChild = true;

        while(true){
            if(p == null) return false;
            int condition = comp(key, p.getKey());

            if(condition == 0) {
                break;
            }else{
                parent = p;
                if(condition < 0){
                    isLeftChild = true;
                    p = p.left;
                }else{
                    isLeftChild = false;
                    p = p.right;
                }
            }
        }

        if(p.left == null){
            // 왼쪽 자식이 없는 경우
            if(p == root) {
                root = p.right;
            }else if(isLeftChild){
                parent.left = p.right;
            }else{
                parent.right = p.right;
            }
        }else if(p.right == null){
            // 오른쪽 자식이 없는 경우
            if(p == root){
                root = p.left;
            }else if(isLeftChild){
                parent.left = p.left;
            }else{
                parent.right = p.left;
            }
        }else{
            // 자식이 둘다 존재하는 경우
            // todo 생각해보기
        }

        return false;
    }

    private void addNode(Node<K, V> node, K key, V data){
        int condition = comp(key, node.getKey());
        if(condition == 0){
            return;
        }else if(condition < 0){
            if(node.left == null){
                node.left = new Node<>(key, data, null, null);
            }else{
                addNode(node.left, key, data); // 왼쪽 트리가 존재하는 경우
            }
        }else{
            if(node.right == null){
                node.right = new Node<>(key, data, null, null);
            }else{
                addNode(node.right, key, data); // 오른쪽 트리가 존재하는 경우
            }
        }
    }

    @ToString(callSuper = true)
    static class Node<K, V>{
        private K key;
        private V data;
        private Node<K,V> left;  // 왼쪽 자식 노드
        private Node<K,V> right; // 오른쪽 자식 노드

        // 생성자
        Node(K key, V data, Node<K,V> left, Node<K,V> right){
            this.key = key;
            this.data = data;
            this.left = left;
            this.right = right;
        }

        K getKey(){
            return key;
        }

        V getValue(){
            return data;
        }

        void print(){
            System.out.println(data);
        }
    }
}
