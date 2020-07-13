package data.mhs.datamahasiswa.repo;

import data.mhs.datamahasiswa.entity.DataMhs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataMhsRepo extends JpaRepository<DataMhs, String> {
}