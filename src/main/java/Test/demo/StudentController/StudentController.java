package Test.demo.StudentController;

import Test.demo.Student.StudentServices.services;
import Test.demo.Student.Exception.RecordNotFoundException;
import Test.demo.Student.StudentEntity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Student")
public class StudentController {
    @Autowired
    services studentService;
   /* @PostMapping("/save")
    public StudentEntity saveStudent(@RequestBody StudentEntity student){
      return studentService.saveStudent(student);

    }*/
  /* @GetMapping("/get/{id}")
    public StudentEntity GetById(@PathVariable("id") int id ){
       return studentService.getById(id);

    }*/
    @GetMapping("/GetAll")
    public List<StudentEntity> StduentAll(){

        return studentService.getAll();

    }
   @PutMapping("/update/{id}")
    public StudentEntity UpdateStudent(@PathVariable ("id") int id,@RequestBody StudentEntity student){
       return studentService.updateStudent(id,student);
    }
    @GetMapping("/Get/{name}")
    public List<StudentEntity> findByName(@PathVariable("name") String name){
        return studentService.findByname(name);

    }
    @GetMapping("/GetByCity/{city}")
    public ResponseEntity<List<StudentEntity> > GetBycityName(@PathVariable("city") String city) {
        List<StudentEntity> s = studentService.GetByCity(city);
        if (s != null) {
            return new ResponseEntity<List<StudentEntity>>(s, HttpStatus.OK);
        } else {
            return new ResponseEntity<List<StudentEntity>>(s, HttpStatus.NOT_FOUND);
        }
    }
   @PostMapping("/save")
    public ResponseEntity<StudentEntity> saveStudent(@RequestBody StudentEntity std){
        StudentEntity s = studentService.saveStudent(std);
        return new ResponseEntity<StudentEntity>(s, HttpStatus.CREATED);

    }
    @GetMapping("/GetById/{Id}")
    public ResponseEntity<StudentEntity> getStudentById(@PathVariable("Id") int id){
       StudentEntity s = studentService.getById(id);
       if(s!=null){
           return new ResponseEntity<StudentEntity>(s,HttpStatus.OK);
       }else {
           throw new RecordNotFoundException();
       }
    }
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") int id){
        studentService.deleteById(id);
    }
}
