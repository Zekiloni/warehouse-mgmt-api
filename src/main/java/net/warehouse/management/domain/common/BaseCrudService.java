package net.warehouse.management.domain.common;

import lombok.Getter;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.text.MessageFormat;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Getter
public abstract class BaseCrudService<E, T extends MongoRepository<E, String>> {

    private final T repository;

    protected BaseCrudService(T repository) {
        this.repository = repository;
    }

    public E create(E entity) {
        return getRepository().save(entity);
    }

    public Optional<E> getById(String id) {
        return getRepository().findById(id);
    }

    public E getByIdOrThrow(String id) {
        return getById(id)
                .orElseThrow(() -> getNoSuchElementException(id));
    }

    public List<E> getAll() {
        return getRepository().findAll();
    }

    public void deleteById(String id) {
        getRepository().deleteById(id);
    }

    public void delete(E entity) {
        getRepository().delete(entity);
    }

    public E update(E entity) {
        return getRepository().save(entity);
    }

    private NoSuchElementException getNoSuchElementException(String id) {
        return new NoSuchElementException(MessageFormat.format("Document with id {0} not found", id));
    }

    protected abstract Class<E> entityClass();
}