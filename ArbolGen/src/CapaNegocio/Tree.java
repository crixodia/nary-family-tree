package CapaNegocio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;
import javax.swing.tree.DefaultMutableTreeNode;

public class Tree {

    private Node root;

    public Tree(Object rootValue) {
        root = new Node(rootValue);
    }

    public Tree(Node root) {
        this.root = root;
    }

    public Tree(String path) throws IOException {
        FileReader reader = new FileReader(path);
        BufferedReader br = new BufferedReader(reader);

        String st = "";
        System.out.println("Leyendo archivo: " + path + "\n");
        String a;
        while ((a = br.readLine()) != null) {
            System.out.println(a);
            st += a + "\n";
        }
        String[] lines = st.split("\n");
        for (int i = 0; i < lines.length; i++) {
            if (i == 0) {
                String[] s = lines[i].split(":");
                GenObj o = new GenObj(
                        s[0],
                        s[1],
                        Integer.valueOf(s[2]),
                        Integer.valueOf(s[3])
                );
                this.root = new Node(o);
            } else {
                String[] parentChild = lines[i].split(",");
                String[] parent = parentChild[0].split(":");
                String[] child = parentChild[1].split(":");

                GenObj parentObj = new GenObj(parent[0], parent.length > 1 ? parent[1] : "");
                GenObj childObj = new GenObj(child[0], child[1], Integer.valueOf(child[2]), Integer.valueOf(child[3]));

                //long start = System.nanoTime();
                addNewNode(parentObj, childObj);
                //long end = System.nanoTime();
                //System.out.println(end - start);
            }
        }
    }

    public Node searchNode(Object obj) {
        return searchNode(root, obj);
    }

    public Node searchParent(Node root, Object obj, Node last) {
        if (!root.getRoot().equals(obj)) {
            for (Node n : root.getChildren()) {
                Tree newTree = new Tree(n);
                if (newTree.searchNode(obj) != null) {
                    root = searchParent(n, obj, root);
                    break;
                }
            }
            return root;
        }
        return last;
    }

    public Node searchNode(Node rootNode, Object obj) {
        Node searchedNode = null;
        boolean found = false;
        if (rootNode != null) {
            if (rootNode.getRoot().equals(obj)) {
                searchedNode = rootNode;
            } else {
                for (int i = 0; i < rootNode.getChildren().size() && !found; i++) {
                    searchedNode = searchNode(
                            rootNode.getChildren().get(i),
                            obj
                    );
                    if (searchedNode != null) {
                        found = true;
                    }
                }
            }
        }
        return searchedNode;
    }

    public void removeNode(Object parentNodeValue) {
        Node parentNode = searchParent(root, parentNodeValue, null);
        int index = -1;
        if (parentNode != null) {
            System.out.println("El padre de " + parentNodeValue + " es " + parentNode.getRoot());
            for (int i = 0; i < parentNode.getChildren().size(); i++) {
                if (parentNode.getChildren().get(i).getRoot().equals(parentNodeValue)) {
                    index = i;
                    break;
                }
            }
            if (index >= 0) {
                parentNode.getChildren().remove(index);
            }
        } else {
            this.root = null;
        }
    }

    public Node addNewNode(Object parentNodeValue, Object newNodeValue) {
        Node parentNode = searchNode(parentNodeValue);
        Node newNode = searchNode(newNodeValue);

        if (parentNode != null && newNode == null) {
            newNode = parentNode.add(newNodeValue);
            newNode.setParent(parentNode.getRoot());
        } else {
            newNode = null;
            if (parentNode == null) {
                System.out.println(
                        "El nodo no se puede añadir porque "
                        + "el nodo padre \""
                        + parentNodeValue
                        + "\" no existe"
                );
            } else {
                System.out.println(
                        "El nodo no se puede insertar "
                        + "porque hay otro nodo con el mismo objeto"
                );
            }
        }
        return newNode;
    }

    public boolean modifyNode(Object parentNodeValue, Object newNodeValue) {
        Node parentNode = searchNode(parentNodeValue);
        boolean r = false;
        if (parentNode != null && !parentNode.getRoot().equals(newNodeValue) && this.searchNode(newNodeValue) == null) {
            parentNode.setRoot(newNodeValue);
            r = true;
        } else {
            if (parentNode != null) {
                System.out.println(
                        "El nodo no se puede modificar "
                        + "porque hay otro nodo con el mismo objeto"
                );
            }
        }
        return r;
    }

    @Override
    public String toString() {
        return toString(0, root);
    }

    private String toString(int level, Node root) {
        String s = "";
        if (root != null) {
            if (level > 0) {
                for (int i = 0; i < level; i++) {
                    s += "-";
                }
                s += "";
            }
            s += root.getRoot() + "\n";
            if (root.getChildren() != null) {
                for (int j = 0; j < root.getChildren().size(); j++) {
                    s += toString(level + 1, root.getChildren().get(j));
                }
            }
        }
        return s;
    }

    public String toStringText() {
        return toStringText(0, root);
    }

    private String toStringText(int level, Node root) {
        String s = "";
        if (root != null) {
            if (level > 0) {
                GenObj aux = (GenObj) root.getParent();
                s += aux.toString() + ",";
            }
            GenObj aux = (GenObj) root.getRoot();
            s += aux.toStringText() + "\n";
            if (root.getChildren() != null) {
                for (int j = 0; j < root.getChildren().size(); j++) {
                    s += toStringText(level + 1, root.getChildren().get(j));
                }
            }
        }
        return s;
    }

    public String[] nodes2StringArray() {
        String[] lines = toString().split("\n");
        for (int i = 0; i < lines.length; i++) {
            lines[i] = lines[i].replace("-", "");
        }
        return lines;
    }

    public static DefaultMutableTreeNode text2DTree(String text) {
        Stack<DefaultMutableTreeNode> pila = new Stack<>();
        Stack<DefaultMutableTreeNode> aux = new Stack<>();

        String[] lines = text.split("\n");
        DefaultMutableTreeNode S1, S2;
        DefaultMutableTreeNode auxS1, auxS2;

        pila.push(new DefaultMutableTreeNode(lines[0]));
        aux.push(new DefaultMutableTreeNode(lines[0]));
        for (int i = 1; i < lines.length; i++) {
            S1 = pila.peek();
            auxS1 = aux.peek();

            S2 = new DefaultMutableTreeNode(lines[i]);
            auxS2 = new DefaultMutableTreeNode(lines[i].replace("-", " "));

            int s1 = countDepth(S1.toString(), '-');
            int s2 = countDepth(S2.toString(), '-');

            if (s1 < s2) {
                S1.add(S2);
                auxS1.add(auxS2);

                pila.push(S2);
                aux.push(auxS2);
            } else {
                while (s1 >= s2 && pila.size() >= 2) {
                    pila.pop();
                    aux.pop();

                    S1 = (DefaultMutableTreeNode) pila.peek();
                    auxS1 = (DefaultMutableTreeNode) aux.peek();

                    s1 = countDepth(S1.toString(), '-');
                }
                S1.add(S2);
                auxS1.add(auxS2);

                pila.push(S2);
                aux.push(auxS2);
            }
        }
        return aux.get(0);
    }

    private static int countDepth(String s, char c) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }
}
