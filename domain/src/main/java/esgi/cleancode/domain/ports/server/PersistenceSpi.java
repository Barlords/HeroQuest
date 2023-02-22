package esgi.cleancode.domain.ports.server;

import esgi.cleancode.domain.ApplicationError;
import io.vavr.collection.List;
import io.vavr.control.Either;
import io.vavr.control.Option;

public interface PersistenceSpi<T, ID> {
  Either<ApplicationError, T> save(T o);

  List<T> findAll();

  Option<T> findById(ID id);
}
