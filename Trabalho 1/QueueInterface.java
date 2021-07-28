public interface QueueInterface<AnyType>{
 	 AnyType deQueue();
	 void enQueue(AnyType item);
	 AnyType top();
	 int size();
	 Boolean isEmpty();
	 Boolean isFull();
	 String toString();
	 void primeiraAtualiza(Queue q,AnyType item);
}