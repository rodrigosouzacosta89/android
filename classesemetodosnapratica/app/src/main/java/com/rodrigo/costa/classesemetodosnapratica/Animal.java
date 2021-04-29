package com.rodrigo.costa.classesemetodosnapratica;

 class Animal {


    int tamanho;
    protected String cor;
    double peso;

     public int getTamanho() {
         return tamanho;
     }

     public void setTamanho(int tamanho) {
         this.tamanho = tamanho;
     }

     public double getPeso() {
         return peso;
     }

     public void setPeso(double peso) {
         this.peso = peso;
     }

     void setCor(String cor){
        this.cor = cor;
    }

    String getCor(){
        return this.cor;

    }


    void dormir(){
        System.out.println("Dormir como um animal");
    }

     void correr(){
         System.out.println("Correr como um animal");
     }
}
