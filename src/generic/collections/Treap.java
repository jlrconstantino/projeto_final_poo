package generic.collections;

import generic.interfaces.TwoTypedComparator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import generic.interfaces.Filter;
import generic.random.RandomNumberGenerator;

/**
 * �rvore Heap gen�rica com fator de aleatoriedade: Treap.
 * @author Jo�o Lucas Rodrigues Constantino
 * */
public class Treap<T extends Comparable<T>> implements Iterable<T> {
	
	// N� de �rvore Treap
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
		
		// Impress�o
		@Override
		public String toString() {
			return new String(key.toString());
		}
	}
	
	// Iterador de �rvore Treap
	private static class TreapIterator<T> implements Iterator<T>{
		
		// Pilha interna para controle
		// OBS: carrega-se a �rvore inteira em pilha
		private Queue<T> queue;
		
		// Carrega a �rvore em uma pilha recursivamente
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
	
	
	// Pesquisa de um n� a partir de uma chave. Se a busca falhar, retornar� null
	private Node<T> search(T key){
		
		// Vari�veis locais
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
	
	
	// Pesquisa de um n� a partir de um algoritmo customizado
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
	 * Verifica se certo elemento est� contido na Treap.
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
	 * Verifica se certo elemento est� contido na Treap segundo algoritmo customizado.
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
	 * Busca um elemento, retornando sua forma de string se encontrado, ou null se n�o.
	 * */
	public String searchString(T key) {
		
		// EXCE��O: ponteiro nulo
		if(key == null) throw new NullPointerException();
		
		// Busca e recolha
		Node<T> searcher = search(key);
		if(searcher != null)
			return searcher.key.toString();
		return null;
	}
	
	
	/**
	 * Busca um elemento, retornando sua forma de string se encontrado, ou null 
	 * se n�o. Para tanto, utiliza algoritmo customizado pelo usu�rio.
	 * */
	public <S> String searchString(S key, TwoTypedComparator<S, T> customCMP) {
		
		// EXCE��O: ponteiro(s) nulo(s)
		if(key == null || customCMP == null) 
			throw new NullPointerException();
		
		// Busca e recolha
		Node<T> searcher = search(key, customCMP);
		if(searcher != null)
			return searcher.key.toString();
		return null;
	}
	
	
	/**
	 * Retorna refer�ncia para um membro da �rvore se encontrado, se n�o, retornar� 
	 * null. Para tanto, utilizar� um algoritmo comparativo informado pelo usu�rio.
	 * */
	public <S> T access(S key, TwoTypedComparator<S, T> customCMP) {
		
		// EXCE��O: ponteiro(s) nulo(s)
		if(key == null || customCMP == null) 
			throw new NullPointerException();
		
		// Busca e recolha
		Node<T> searcher = search(key, customCMP);
		if(searcher != null)
			return searcher.key;
		return null;
	}
	
	
	// Rota��o para a esquerda
	private Node<T> leftRotate(Node<T> node) {
		Node<T> aux = node.right;
		node.right = aux.left;
		aux.left = node;
		return aux;
	}
	
	
	// Rota��o para a direita
	private Node<T> rightRotate(Node<T> node) {
		Node<T> aux = node.left;
		node.left = aux.right;
		aux.right = node;
		return aux;
	}
	
	
	// L�gica da inser��o de um elemento
	private Node<T> insertionBehavior(Node<T> node, T key, float priority){
		
		// Verifica��o da raiz
		if(node == null)
			return new Node<T>(key, priority, null, null);
		
		// Vari�vel de compara��o
		int comparator = key.compareTo(node.key);
		
		// Inser��o � esquerda
		if(comparator < 0) {
			node.left = insertionBehavior(node.left, key, priority);
			if(node.priority < node.left.priority)
				node = rightRotate(node);
		}
		
		// Inser��o � direita
		else if(comparator > 0) {
			node.right = insertionBehavior(node.right, key, priority);
			if(node.priority < node.right.priority)
				node = leftRotate(node);
		}
		
		// Finaliza��o
		else 
			return null;
		return node;
	}
	
	
	/**
	 * Adiciona um elemento � Treap, retornando ou true se bem-sucedido, ou false se n�o.
	 * */
	public boolean add(T key) {
		
		// EXCE��O: ponteiro nulo
		if(key == null) throw new NullPointerException();
		
		// Verifica��o de pr�-exist�ncia
		boolean validator = contains(key);
		
		// Inser��o
		if(validator == false) {
			float priority = (float) rng.getRandom();
			root = insertionBehavior(root, key, priority);
			return true;
		}
		
		return false;
	}
	
	
	// L�gica da remo��o de um elemento
	private Node<T> deletionBehavior(Node<T> node, T key){
		
		// Caso base
		if(node == null) return null;
		
		// Compara��o com o n� corrente
		int comparator = key.compareTo(node.key);
		if(comparator < 0)
			node.left = deletionBehavior(node.left, key);
		else if(comparator > 0)
			node.right = deletionBehavior(node.right, key);
		
		// N� com filho �nico na direita
		else if(node.left == null) {
			node = node.right;
		}
		
		// N� com filho �nico na esquerda
		else if(node.right == null) {
			node = node.left;
		}
		
		// N� intermedi�rio com prioridade esquerda
		else if(node.left.priority < node.right.priority) {
			node = leftRotate(node);
			node.left = deletionBehavior(node.left, key);
		}
		
		// N� intermedi�rio com prioridade direita
		else {
			node = rightRotate(node);
			node.right = deletionBehavior(node.right, key);
		}
		
		return node;
	}
	
	
	// L�gica da remo��o de um elemento
	private <S> Node<T> deletionBehavior (Node<T> node, S key, TwoTypedComparator<S, T> customCMP){
		
		// Caso base
		if(node == null) return null;
		
		// Compara��o com o n� corrente
		int comparator = customCMP.compare(key, node.key);
		if(comparator < 0)
			node.left = deletionBehavior(node.left, key, customCMP);
		else if(comparator > 0)
			node.right = deletionBehavior(node.right, key, customCMP);
		
		// N� com filho �nico na direita
		else if(node.left == null) {
			node = node.right;
		}
		
		// N� com filho �nico na esquerda
		else if(node.right == null) {
			node = node.left;
		}
		
		// N� intermedi�rio com prioridade esquerda
		else if(node.left.priority < node.right.priority) {
			node = leftRotate(node);
			node.left = deletionBehavior(node.left, key, customCMP);
		}
		
		// N� intermedi�rio com prioridade direita
		else {
			node = rightRotate(node);
			node.right = deletionBehavior(node.right, key, customCMP);
		}
		
		return node;
	}
	
	
	/**
	 * Deleta um elemento da Treap, retornando refer�ncia para o 
	 * elemento removido se bem-sucedido, ou null em situa��o oposta.
	 * */
	public T delete(T key) {
		
		// EXCE��O: ponteiro nulo
		if(key == null) throw new NullPointerException();
		
		// Busca e remo��o
		Node<T> searcher = search(key);
		if(searcher != null) {
			root = deletionBehavior(root, key);
			return searcher.key;
		}
		return null;
	}
	
	
	/**
	 * Deleta um elemento da Treap, retornando refer�ncia para o 
	 * elemento removido se bem-sucedido, ou null em situa��o oposta. 
	 * Para tanto, utiliza algoritmo customizado informado pelo usu�rio.
	 * */
	public <S> T delete(S key, TwoTypedComparator<S, T> customCMP) {
		
		// EXCE��O: ponteiro(s) nulo(s)
		if(key == null || customCMP == null)
			throw new NullPointerException();
		
		// Busca e remo��o
		Node<T> searcher = search(key, customCMP);
		if(searcher != null) {
			root = deletionBehavior(root, key, customCMP);
			return searcher.key;
		}
		return null;
	}
	
	
	// M�todo auxiliar de formata��o em ordem
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
	 * Obten��o da string de visualiza��o em ordem da Treap.
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
	
	
	// M�todo auxiliar de formata��o em ordem com filtro
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
	 * Obten��o da string de visualiza��o em ordem da Treap.  
	 * Filtrar� os resultados segundo algoritmo customizado.
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
