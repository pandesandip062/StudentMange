package Test.demo.utlity;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Random;

public class RandomIdGen implements IdentifierGenerator {

    public int random(){
        Random rn = new Random();
        int randomNum=rn.nextInt(3000);
        return randomNum;

    }

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object o) {

        return"Stdnt_"+random()+ Calendar.getInstance().get(Calendar.YEAR);
    }
}
