package Test;

import Test.demo.Student.StudentEntity.Address;
import Test.demo.Student.StudentEntity.Status;
import Test.demo.Student.StudentEntity.StudentEntity;
import Test.demo.Student.StudentRepo.StudentRepository;
import Test.demo.Student.StudentServices.services;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class studentMange {

    @Mock
    StudentRepository repo;

    @InjectMocks
    services ser;

    @Test
    public void Test1(){
        Address adr = new Address(101,"jalkot",411057);

        StudentEntity std1 = new StudentEntity(101,"Sandip",adr, Status.BILLABLE,50);

      when(repo.save(std1)).thenReturn(std1);
        System.out.println(std1);
        assertEquals(std1,ser.saveStudent(std1));



    }


}
