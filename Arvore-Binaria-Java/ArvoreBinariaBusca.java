package lab.exxxx;

public class ArvoreBinariaBusca<T extends Comparable<T>> {
    private  No<T> raiz;
 
    public void inserir(T valor) {
        raiz = inserirRecursivo(raiz, valor);
    }

    private No<T> inserirRecursivo(No<T> atual, T valor) {
        if (atual == null) {
            atual = new No<>(valor);
           
        }

        if (valor.compareTo(atual.valor) < 0)
            atual.esquerda = inserirRecursivo(atual.esquerda, valor);
        else if (valor.compareTo(atual.valor) > 0)
            atual.direita = inserirRecursivo(atual.direita, valor);

        return atual;
    }

   public void imprimirEmOrdem() {
        imprimirEmOrdemRecursivo(raiz);
    }

    private void imprimirEmOrdemRecursivo(No<T> atual) {
        if (atual != null) {
            imprimirEmOrdemRecursivo(atual.esquerda);
            System.out.print(atual.valor + " ");
            imprimirEmOrdemRecursivo(atual.direita);
        }
    }
    
    
    public void imprimirEmPreOrdem() {
        imprimirEmPreOrdemRecursivo(raiz);
    }

    private void imprimirEmPreOrdemRecursivo(No<T> atual) {
        if (atual != null) {
            System.out.print(atual.valor + " ");
            imprimirEmPreOrdemRecursivo(atual.esquerda);
            imprimirEmPreOrdemRecursivo(atual.direita);
        }
    }
    
    
    public T encontrarMenor() {
        return encontrarMenorRecursivo(raiz);
    }

    private T encontrarMenorRecursivo(No<T> atual) {
        if (atual.esquerda == null) {
            return atual.valor;
        } else {
            return encontrarMenorRecursivo(atual.esquerda);
        }
    }

    public T encontrarMaior() {
        return encontrarMaiorRecursivo(raiz);
    }

    private T encontrarMaiorRecursivo(No<T> atual) {
        if (atual.direita == null) {
            return atual.valor;
        } else {
            return encontrarMaiorRecursivo(atual.direita);
        }
    }
    
    public void remover(T valor) {
        raiz = removerRecursivo(raiz, valor);
    }

    private No<T> removerRecursivo(No<T> atual, T valor) {
        if (atual == null) {
            return null;
        }

        int cmp = valor.compareTo(atual.valor);
        if (cmp < 0) {
            atual.esquerda = removerRecursivo(atual.esquerda, valor);
        } else if (cmp > 0) {
            atual.direita = removerRecursivo(atual.direita, valor);
        } else {
            
        	
        	// 0
            if (atual.esquerda == null && atual.direita == null) {
                return null;
            }
            
            
            // 1
            else if (atual.esquerda == null) {
                return atual.direita;
            } else if (atual.direita == null) {
                return atual.esquerda;
            }
            
            
            // 2
            else {
                No<T> menorNó = encontrarMenorNó(atual.direita);
                atual.valor = menorNó.valor;
                atual.direita = removerRecursivo(atual.direita, menorNó.valor);
            }
        }

        return atual;
    }

    private No<T> encontrarMenorNó(No<T> atual) {
        while (atual.esquerda != null) {
            atual = atual.esquerda;
        }
        return atual;
    }

}