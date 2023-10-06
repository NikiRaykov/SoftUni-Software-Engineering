package core;

import interfaces.Buffer;
import interfaces.Entity;
import model.BaseEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Loader implements Buffer {
    private List<Entity> data;

    public Loader() {
        this.data = new ArrayList<>();
    }

    @Override
    public void add(Entity entity) {
        this.data.add(entity);
    }

    @Override
    public Entity extract(int id) {
        Entity entityToBeRemoved = null;

        for (Entity entity : data) {
            if (entity.getId() == id) {
                entityToBeRemoved = entity;
                break;
            }
        }

        if (entityToBeRemoved != null) {
            this.data.remove(entityToBeRemoved);
        }
        return entityToBeRemoved;
    }

    @Override
    public Entity find(Entity entity) {
        int index = this.data.indexOf(entity);

        if (index < 0) {
            return null;
        }

        return this.data.get(index);
    }

    @Override
    public boolean contains(Entity entity) {
        return this.data.contains(entity);
    }

    @Override
    public int entitiesCount() {
        return this.data.size();
    }

    @Override
    public void replace(Entity oldEntity, Entity newEntity) {
        int indexOfEntityToBeReplaced = this.data.indexOf(oldEntity);

        if (indexOfEntityToBeReplaced < 0) {
            throw new IllegalStateException("Entity not found");
        }

        this.data.set(indexOfEntityToBeReplaced, newEntity);
    }

    @Override
    public void swap(Entity first, Entity second) {
        int firstEntityIndex = this.data.indexOf(first);
        int secondEntityIndex = this.data.indexOf(second);

        if (firstEntityIndex < 0 || secondEntityIndex < 0) {
            throw new IllegalStateException("Entities not found");
        }

        Collections.swap(this.data, firstEntityIndex, secondEntityIndex);
    }

    @Override
    public void clear() {
        this.data.clear();
    }

    @Override
    public Entity[] toArray() {
        Entity[] result = new Entity[this.data.size()];

        this.data.toArray(result);

        return result;
    }

    @Override
    public List<Entity> retainAllFromTo(BaseEntity.Status lowerBound, BaseEntity.Status upperBound) {
        return this.data.stream()
                .filter(e -> e.getStatus().ordinal() >= lowerBound.ordinal())
                .filter(e -> e.getStatus().ordinal() <= upperBound.ordinal())
                .collect(Collectors.toList());
    }

    @Override
    public List<Entity> getAll() {
        return this.data;
    }

    @Override
    public void updateAll(BaseEntity.Status oldStatus, BaseEntity.Status newStatus) {
        for (Entity entity : data) {
            if (entity.getStatus() == oldStatus) {
                entity.setStatus(newStatus);
            }
        }
    }

    @Override
    public void removeSold() {
        this.data.removeIf(e -> e.getStatus() == BaseEntity.Status.SOLD);
    }

    @Override
    public Iterator<Entity> iterator() {
        return this.data.iterator();
    }
}
