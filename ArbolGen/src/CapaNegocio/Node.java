package CapaNegocio;

import java.util.ArrayList;

public class Node {

    private Object parent;
    private Object root;
    private ArrayList<Node> children;

    public Node(Object value) {
        this.root = value;
        this.children = new ArrayList<>();
    }

    public Object getRoot() {
        return this.root;
    }

    public void setRoot(Object value) {
        this.root = value;
    }

    public void setParent(Object value) {
        this.parent = value;
    }

    public Object getParent() {
        return this.parent;
    }

    public ArrayList<Node> getChildren() {
        return this.children;
    }

    public void setChildren(ArrayList<Node> value) {
        this.children = value;
    }

    public Node add(Object obj) {
        Node newNode = new Node(obj);
        this.children.add(newNode);
        return newNode;
    }

    @Override
    public String toString() {
        return root != null ? root.toString() : "";
    }
}
