package esgi.cleancode.domain.ports.server;

import esgi.cleancode.domain.ApplicationError;
import io.vavr.control.Either;

import java.util.Optional;

public interface PersistenceSpi<T, ID> {
  Either<ApplicationError, T> save(T o);

  Optional<T> findById(ID id);
}
