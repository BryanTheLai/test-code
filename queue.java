// arrayqueue fixed: enqueue, dequeue, requeue, peek, contains
public boolean enqueue(T element) {
    if (element == null || size == array.length) {
        return false;
    }
    array[tail] = element;
    tail++;
    size++;
    return true;
}

public T dequeue() {
    if (size == 0) {return null;}
    T removed = array[head];
    for(int  i = 0; i < size - 1; i++) {
        array[i] = array[i+1];
    } 
    tail--;
    size--;
    array[tail] = null;
    return removed;
}

public boolean requeue() {
    if (size == 0) {return false;}
    T element = dequeue();
    if (element == null) {
        return false;
    }
    return enqueue(element);
}

public T peek() {
    if (size == 0) {return null;}
    return array[head];
}

public boolean contains(T element) {
    if (element == null || size == 0) {
        return false;
    }
    for (int i = 0; i< size; i++) {
        if (element.equals(array[i])) {
            return true;
        }
    }
    return false;
}


// linked queue: enqueue, dequeue, requeue, peek, contains
// linked
public boolean enqueue(T elementData) {
    if (elementData == null) {return false;}
    Node<T> newNode = new Node<>(elementData);
    if (head  == null) {
        head = newNode;
        tail = newNode;
    } else {
        tail.next = newNode;
        tail = newNode;
    }
    size++;
    return true;
} 

public T dequeue() {
    if (size == 0) {return null;}
    Node<T> removed = head;
    head = removed.next;
    if (head == null) {
        tail = null;
    }
    size--;
    return removed.data;
}

public boolean requeue() {
    if (size == 0) {return false;}
    T data = dequeue();
    if (data == null) {
        return false;
    }
    return enqueue(data);
}

public T peek() {
    if (size == 0) {return null;}
    return head.data;
}

public boolean contains(T elementData) {
    if (elementData == null || size == 0) {
        return false;
    }
    Node<T> current = head;
    while(current != null) {
        if(elementData.equals(current.data)) {
            return true;
        }
        current = current.next;
    }
    return false;
}