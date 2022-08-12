package ca.jors.sand.downl.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ca.jors.sand.downl.entity.UidFile;

@Repository
public interface UidFileRepository extends JpaRepository<UidFile,UUID> {
    
}
