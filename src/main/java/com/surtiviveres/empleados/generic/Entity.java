package com.surtiviveres.empleados.generic;

public abstract class Entity<I extends Identity> {
    private final I id;

    public Entity(I id) {
        this.id = id;
    }

    public I identity() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        return id.equals(obj);
    }

}
