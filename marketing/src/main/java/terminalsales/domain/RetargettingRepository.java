package terminalsales.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import terminalsales.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "retargettings",
    path = "retargettings"
)
public interface RetargettingRepository
    extends PagingAndSortingRepository<Retargetting, Long> {}
