package Test.demo.Student.StudentServices;

import Test.demo.Student.StudentEntity.StudentEntity;
import Test.demo.Student.StudentRepo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class services {
    @Autowired
    StudentRepository repo;



    public StudentEntity saveStudent(StudentEntity student){
      StudentEntity student1=  repo.save(student);

      return student1;
    }

    public List<StudentEntity> findByname(String name){
        return repo.findByName(name);

    }

    public StudentEntity getById(int id){
       Optional<StudentEntity> student1= repo.findById(id);
       if(student1.isPresent()){
           return student1.get();

       }else
           return null;
    }
    public void deleteById(int id){
       Optional<StudentEntity> s= repo.findById(id);
       if(s.isPresent()){
           StudentEntity s1=s.get();
           repo.deleteById(id);
       }
    }
    public List<StudentEntity> getAll(){
        List<StudentEntity> listStudent=repo.findAll();
        return listStudent;
    }

      public StudentEntity updateStudent(int id, StudentEntity student){
       Optional<StudentEntity>  opt= repo.findById(id);
       if(opt.isPresent()){
          StudentEntity saveStudent= opt.get();
          if(saveStudent!=null){
              saveStudent.setName(student.getName());
          }if(saveStudent.getMarks()>0){
              saveStudent.setMarks(student.getMarks());
           }
          return repo.save(saveStudent);
       }
       return null;
    }

    public List<StudentEntity> GetByCity(String city){
       return repo.getStudentsByCity(city);
    }









   /* public StudentEntity updateByName(String  name1,StudentEntity student){
        Optional<StudentEntity> UpdateStudent = repo.findByName(name1);
    }*/





}
