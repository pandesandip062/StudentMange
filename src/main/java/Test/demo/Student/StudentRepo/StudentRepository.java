package Test.demo.Student.StudentRepo;

import Test.demo.Student.StudentEntity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentEntity,Integer> {
    List<StudentEntity> findByName (String name);


    @Query(value="select * from student_entity  s\n" +
            "inner join \n" +
            "address a\n" +
            "on\n" +
            "s.address_id=a.id\n" +
            "where city=:city",nativeQuery = true)
    List<StudentEntity> getStudentsByCity(@Param("city") String city);
}

