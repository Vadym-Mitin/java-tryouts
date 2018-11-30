package com.apress.prospring4;

public interface ManagedComponent<D> {
   void performLookup(Container<D> container);
}
