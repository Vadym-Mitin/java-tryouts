package com.apress.prospring4;

public interface Container<D> {
   D getDependency(String key);
}
