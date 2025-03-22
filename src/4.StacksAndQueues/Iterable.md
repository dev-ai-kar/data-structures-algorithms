# Iterable and Iterator Interfaces

## Overview
The `Iterable` and `Iterator` interfaces provide a standardized way to iterate over collections of objects. 
- **Iterable**: An object that can return an `Iterator` (e.g., lists, stacks, queues).
- **Iterator**: An object that tracks the current position in a collection and enables traversal.

---

## Interface Definitions

### `Iterable` Interface
```java
public interface Iterable<Item> {
    // Returns an iterator over elements of type `Item`
    public Iterator<Item> iterator();
}
```

### `Iterator` Interface (Nested)
```java
public interface Iterator<Item> {
    // Checks if there are more elements to iterate over
    public boolean hasNext();
    
    // Returns the next element in the iteration
    public Item next();
    
    // Removes the last element returned by the iterator (optional operation)
    public void remove();
}
```

---

## Example Usage

### Long Form (Explicit `Iterator`)
```java
Iterator<String> i = stack.iterator();
while (i.hasNext()) {
    String s = i.next();
    StdOut.println(s);
}
```

### Shorthand (Enhanced For-Each Loop)
```java
for (String s : stack) {
    StdOut.println(s);
}
```
Both code snippets achieve the same result, but the enhanced `for` loop abstracts the `Iterator` logic.

---

## Key Notes

1. **`remove()` Method**:
   - Optional: Not all iterators implement `remove()`. If unsupported, it throws an `UnsupportedOperationException`.
   - Behavior: Removes the **last element returned by `next()`**. Must be called after a `next()`.

2. **Implementing `Iterable`**:
   - Classes implementing `Iterable` must provide an `iterator()` method that returns a valid `Iterator`.
   - Enables compatibility with the enhanced `for` loop syntax.

3. **Fail-Fast vs. Fail-Safe**:
   - Iterators may throw a `ConcurrentModificationException` if the collection is modified during iteration (fail-fast behavior).

4. **Generic Types**:
   - Replace `Item` with the actual data type (e.g., `String`, `Integer`) for type safety.

---

## Best Practices
- Prefer the enhanced `for` loop for readability when no explicit `remove()` is needed.
- Avoid modifying the underlying collection while iterating unless the iterator supports it.