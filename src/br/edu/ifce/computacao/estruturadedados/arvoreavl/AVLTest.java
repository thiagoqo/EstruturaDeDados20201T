/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifce.computacao.estruturadedados.arvoreavl;

/**
 *
 * @author User
 */
public class AVLTest {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        
        tree.inserirNo(8);   
        tree.inserirNo(3);
        tree.inserirNo(6);
        tree.inserirNo(2);
        tree.inserirNo(7);
        tree.inserirNo(9);
        tree.inserirNo(1);
        tree.inserirNo(0);
        tree.inserirNo(4);
        tree.inserirNo(5);
        tree.imprimirArvore();
        
        
        
    }
}
