// array stack; push, pop, peek, contains
public boolean push(T element) {
    if (element == null || size == array.length) {
        return false;
    }
    array[top] = element;
    top++;
    size++;
    return true;
}

public T pop(){
    if(size == 0) {return null;}
    T removed = array[top - 1];
    array[top - 1] = null;
    top--;
    size--;
    return removed;
}

public T peek() {
    if (size == 0) {return null;}
    return array[top - 1];
}

public boolean contains(T element) {
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


// linekd stack: push, pop, peek, contains
public boolean push(T elementData) {
    if (elementData== null) {return false;}
    Node<T> newNode = new Node<>(elementData);
    newNode.next = top;
    top = newNode;
    size++;
    return true;
}

public T pop() {
    if (size == 0) {return null;}
    Node<T> removed = top;
    top = removed.next;
    size--;
    return removed.data;
}

public T peek() {
    if (size == 0) {return null;}
    return top.data;
}

public boolean contains(T elementData) {
    if (elementData == null || size == 0) {
        return false;
    }
    Node<T> current = top;
    while(current != null) {
        if (elementData.equals(current.data)) {
            return true;
        }
        current = current.next;
    }
    return false;
}