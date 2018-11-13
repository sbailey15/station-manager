package stations.manager;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StationsRepository extends JpaRepository<Stations, Long> {
    List<Stations> findAll();

    Stations findAllById(String id);
    
    Stations findAllByName(String name);

    @Transactional
    void deleteById(String id);
    
    @Transactional
    void deleteByName(String name);
}
