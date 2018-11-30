package com.apress.prospring4;

public class CotextualizedDependencyLookup<D> implements ManagedComponent<D> {
   private D dependency;

   @Override
   public void performLookup(Container<D> container) {
      String dependencyName = this.dependency.getClass().getName();
      this.dependency = container.getDependency(dependencyName);
   }


}
