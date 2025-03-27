// ARRAY add, remove, get, contain
public boolean add(T element) {
    if (element == null || array.length == size) {
        return false;
    }
    // tail = size, so just use size;
    array[size] = element;
    size++;
    return true;
}

public T remove(int index) {
    if (index < 0 || index > size - 1) {
        return null;
    }
    T removed = array[index];
    for(int i = index; i < size - 1; i++) {
        array[i] = array[i + 1];
    }
    size--;
    array[size] = null;
    return removed;
} 

public T get(int index) {
    if (index < 0 || index > size - 1) {
        return null;
    }
    return array[index];
}

public boolean contain(T element) {
    if (element == null || size == 0) {
        return false;
    }
    for (int i = 0; i < size; i++) {
        if (element.equals(array[i])) {
            return true;
        }
    }

    return false;
}


// linkedlist: add, remove, get, contain.
public boolean add(T element) {
    if (element == null) {return false;}
    Node<T> newNode = new Node<>(element);
    if (head == null) {
        head = newNode;
        tail = newNode;
    } else {
        tail.next = newNode;
        tail = newNode;
    }
    size++;
    return true;
}

public T remove(int index) {
    if (index < 0 || index > size - 1) {
        return null;
    }
    Node<T> removed;
    Node<T> current = head;
    if (index == 0) {
        removed = head;
        head = removed.next;
        if (removed.next == null) {
            tail = head;
        }
    } else {
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        removed = current.next;
        current.next = removed.next;
        if (current.next == null) {
            tail = current;
        }
    }
    size--;
    return removed.data;
}

public T get(int index){
    if (index < 0 || index > size - 1) {
        return null;
    }
    Node<T> current = head;
    for (int i = 0; i < index; i++) {
        current = current.next;
    }
    return current.data;
  
}
public boolean contain(T elementData) {
    if (elementData == null || size == 0) {
        return false;
    }
    Node<T> current = head;
    for (int i = 0; i < size; i++) {
        if(elementData.equals(current.data)) {
            return true;
        }
        current = current.next;
    }
    return false;
}