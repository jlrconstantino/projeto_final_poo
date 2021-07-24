package generic.collections;

import generic.interfaces.TwoTypedComparator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import generic.interfaces.Filter;
import generic.random.RandomNumberGenerator;

/**
 * Árvore Heap genérica com fator de aleatoriedade: Treap.
 * @author João Lucas Rodrigues Constantino
 * */
public class Treap<T extends Comparable<T>> implements Iterable<T> {
	
	// Nó de árvore Treap
	private static class Node<T>{
		
		// Atributos
		public T key;
		public float priority;
		public Node<T> left;
		public Node<T> right;
		
		// Construtor
		public Node(T key, float priority, Node<T> left, Node<T> right) {
			this.key = key;
			this.priority = priority;
			this.left = left;
			this.right = right;
		}
		
		// Impressão
		@Override
		public String toString() {
			return new String(key.toString());
		}
	}
	
	// Iterador de árvore Treap
	private static class TreapIterator<T> implements Iterator<T>{
		
		// Pilha interna para controle
		// OBS: carrega-se a árvore inteira em pilha
		private Queue<T> queue;
		
		// Carrega a árvore em uma pilha recursivamente
		private void loadStack(Node<T> node) {
			if(node != null) {
				loadStack(node.left);
				queue.add(node.key);
				loadStack(node.right);
			}
		}
		
		// Construtor
		public TreapIterator(Node<T> root){
			queue = new LinkedList<T>();
			loadStack(root);
		}
		
		@Override
		public boolean hasNext() {
			return queue.isEmpty() == false;
		}

		@Override
		public T next() {
			return queue.remove();
		}
		
	}
	
	
	// Atributos
	private Node<T> root;
	private RandomNumberGenerator rng;
	
	
	// Construtor
	public Treap() {
		root = null;
		rng = new RandomNumberGenerator();
	}
	
	
	// Pesquisa de um nó a partir de uma chave. Se a busca falhar, retornará null
	private Node<T> search(T key){
		
		// Variáveis locais
		Node<T> searcher = root;
		int comparator;
		
		// Pesquisa
		while(searcher != null) {
			comparator = key.compareTo(searcher.key);
			if(comparator < 0) searcher = searcher.left;
			else if(comparator > 0) searcher = searcher.right;
			else return searcher;
		}
		return null;
	}
	
	
	// Pesquisa de um nó a partir de um algoritmo customizado
	private <S> Node<T> search(S key, TwoTypedComparator<S, T> customCMP){
		Node<T> searcher = root;
		int comparator;
		while(searcher != null) {
			comparator = customCMP.compare(key, searcher.key);
			if(comparator < 0) searcher = searcher.left;
			else if(comparator > 0) searcher = searcher.right;
			else return searcher;
		}
		return null;
	}
	
	
	/**
	 * Verifica se certo elemento está contido na Treap.
	 * */
	public boolean contains(T key) {
		if(key == null) 
			throw new NullPointerException();
		Node<T> searcher = search(key);
		if(searcher != null) 
			return true;
		return false;
	}
	
	
	/**
	 * Verifica se certo elemento está contido na Treap segundo algoritmo customizado.
	 * */
	public <S> boolean contains(S key, TwoTypedComparator<S, T> customCMP) {
		if(key == null || customCMP == null) 
			throw new NullPointerException();
		Node<T> searcher = search(key, customCMP);
		if(searcher != null) 
			return true;
		return false;
	}
	
	
	/**
	 * Busca um elemento, retornando sua forma de string se encontrado, ou null se não.
	 * */
	public String searchString(T key) {
		
		// EXCEÇÃO: ponteiro nulo
		if(key == null) throw new NullPointerException();
		
		// Busca e recolha
		Node<T> searcher = search(key);
		if(searcher != null)
			return searcher.key.toString();
		return null;
	}
	
	
	/**
	 * Busca um elemento, retornando sua forma de string se encontrado, ou null 
	 * se não. Para tanto, utiliza algoritmo customizado pelo usuário.
	 * */
	public <S> String searchString(S key, TwoTypedComparator<S, T> customCMP) {
		
		// EXCEÇÃO: ponteiro(s) nulo(s)
		if(key == null || customCMP == null) 
			throw new NullPointerException();
		
		// Busca e recolha
		Node<T> searcher = search(key, customCMP);
		if(searcher != null)
			return searcher.key.toString();
		return null;
	}
	
	
	/**
	 * Retorna referência para um membro da árvore se encontrado, se não, retornará 
	 * null. Para tanto, utilizará um algoritmo comparativo informado pelo usuário.
	 * */
	public <S> T access(S key, TwoTypedComparator<S, T> customCMP) {
		
		// EXCEÇÃO: ponteiro(s) nulo(s)
		if(key == null || customCMP == null) 
			throw new NullPointerException();
		
		// Busca e recolha
		Node<T> searcher = search(key, customCMP);
		if(searcher != null)
			return searcher.key;
		return null;
	}
	
	
	// Rotação para a esquerda
	private Node<T> leftRotate(Node<T> node) {
		Node<T> aux = node.right;
		node.right = aux.left;
		aux.left = node;
		return aux;
	}
	
	
	// Rotação para a direita
	private Node<T> rightRotate(Node<T> node) {
		Node<T> aux = node.left;
		node.left = aux.right;
		aux.right = node;
		return aux;
	}
	
	
	// Lógica da inserção de um elemento
	private Node<T> insertionBehavior(Node<T> node, T key, float priority){
		
		// Verificação da raiz
		if(node == null)
			return new Node<T>(key, priority, null, null);
		
		// Variável de comparação
		int comparator = key.compareTo(node.key);
		
		// Inserção à esquerda
		if(comparator < 0) {
			node.left = insertionBehavior(node.left, key, priority);
			if(node.priority < node.left.priority)
				node = rightRotate(node);
		}
		
		// Inserção à direita
		else if(comparator > 0) {
			node.right = insertionBehavior(node.right, key, priority);
			if(node.priority < node.right.priority)
				node = leftRotate(node);
		}
		
		// Finalização
		else 
			return null;
		return node;
	}
	
	
	/**
	 * Adiciona um elemento à Treap, retornando ou true se bem-sucedido, ou false se não.
	 * */
	public boolean add(T key) {
		
		// EXCEÇÃO: ponteiro nulo
		if(key == null) throw new NullPointerException();
		
		// Verificação de pré-existência
		boolean validator = contains(key);
		
		// Inserção
		if(validator == false) {
			float priority = (float) rng.getRandom();
			root = insertionBehavior(root, key, priority);
			return true;
		}
		
		return false;
	}
	
	
	// Lógica da remoção de um elemento
	private Node<T> deletionBehavior(Node<T> node, T key){
		
		// Caso base
		if(node == null) return null;
		
		// Comparação com o nó corrente
		int comparator = key.compareTo(node.key);
		if(comparator < 0)
			node.left = deletionBehavior(node.left, key);
		else if(comparator > 0)
			node.right = deletionBehavior(node.right, key);
		
		// Nó com filho único na direita
		else if(node.left == null) {
			node = node.right;
		}
		
		// Nó com filho único na esquerda
		else if(node.right == null) {
			node = node.left;
		}
		
		// Nó intermediário com prioridade esquerda
		else if(node.left.priority < node.right.priority) {
			node = leftRotate(node);
			node.left = deletionBehavior(node.left, key);
		}
		
		// Nó intermediário com prioridade direita
		else {
			node = rightRotate(node);
			node.right = deletionBehavior(node.right, key);
		}
		
		return node;
	}
	
	
	// Lógica da remoção de um elemento
	private <S> Node<T> deletionBehavior (Node<T> node, S key, TwoTypedComparator<S, T> customCMP){
		
		// Caso base
		if(node == null) return null;
		
		// Comparação com o nó corrente
		int comparator = customCMP.compare(key, node.key);
		if(comparator < 0)
			node.left = deletionBehavior(node.left, key, customCMP);
		else if(comparator > 0)
			node.right = deletionBehavior(node.right, key, customCMP);
		
		// Nó com filho único na direita
		else if(node.left == null) {
			node = node.right;
		}
		
		// Nó com filho único na esquerda
		else if(node.right == null) {
			node = node.left;
		}
		
		// Nó intermediário com prioridade esquerda
		else if(node.left.priority < node.right.priority) {
			node = leftRotate(node);
			node.left = deletionBehavior(node.left, key, customCMP);
		}
		
		// Nó intermediário com prioridade direita
		else {
			node = rightRotate(node);
			node.right = deletionBehavior(node.right, key, customCMP);
		}
		
		return node;
	}
	
	
	/**
	 * Deleta um elemento da Treap, retornando referência para o 
	 * elemento removido se bem-sucedido, ou null em situação oposta.
	 * */
	public T delete(T key) {
		
		// EXCEÇÃO: ponteiro nulo
		if(key == null) throw new NullPointerException();
		
		// Busca e remoção
		Node<T> searcher = search(key);
		if(searcher != null) {
			root = deletionBehavior(root, key);
			return searcher.key;
		}
		return null;
	}
	
	
	/**
	 * Deleta um elemento da Treap, retornando referência para o 
	 * elemento removido se bem-sucedido, ou null em situação oposta. 
	 * Para tanto, utiliza algoritmo customizado informado pelo usuário.
	 * */
	public <S> T delete(S key, TwoTypedComparator<S, T> customCMP) {
		
		// EXCEÇÃO: ponteiro(s) nulo(s)
		if(key == null || customCMP == null)
			throw new NullPointerException();
		
		// Busca e remoção
		Node<T> searcher = search(key, customCMP);
		if(searcher != null) {
			root = deletionBehavior(root, key, customCMP);
			return searcher.key;
		}
		return null;
	}
	
	
	// Método auxiliar de formatação em ordem
	private String auxInOrderFormatter(Node<T> node) {
		String output = new String();
		if(node != null) {
			output += auxInOrderFormatter(node.left);
			output += node.toString() + ",\n";
			output += auxInOrderFormatter(node.right);
		}
		return output;
	}
	
	
	/**
	 * Obtenção da string de visualização em ordem da Treap.
	 * */
	@Override
	public String toString() {
		String output = new String("[");
		if(root != null) {
			output += "\n" + auxInOrderFormatter(root);
			output = output.substring(0, output.lastIndexOf(',')) + "\n]";
		}else{
			output += "]";
		}
		return output;
	}
	
	
	// Método auxiliar de formatação em ordem com filtro
	private String auxInOrderFormatter(Node<T> node, Filter<T> ftr) {
		String output = new String();
		if(node != null) {
			output += auxInOrderFormatter(node.left, ftr);
			if(ftr.filter(node.key) == true)
				output += node.toString() + ",\n";
			output += auxInOrderFormatter(node.right, ftr);
		}
		return output;
	}
	
	
	/**
	 * Obtenção da string de visualização em ordem da Treap.  
	 * Filtrará os resultados segundo algoritmo customizado.
	 * */
	public String toString(Filter<T> ftr) {
		String output = new String("[");
		if(root != null) {
			output += "\n" + auxInOrderFormatter(root, ftr);
			output = output.substring(0, output.lastIndexOf(',')) + "\n]";
		}else{
			output += "]";
		}
		return output;
	}


	@Override
	public Iterator<T> iterator() {
		return new TreapIterator<T>(root);
	}
}
