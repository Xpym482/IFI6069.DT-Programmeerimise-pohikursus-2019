package exam.exam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
interface TextRepository extends JpaRepository<TextEntity, Long>{

}