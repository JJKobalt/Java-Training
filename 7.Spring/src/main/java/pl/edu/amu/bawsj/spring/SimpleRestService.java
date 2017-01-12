package pl.edu.amu.bawsj.spring;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * Created by Bocian on 12.01.2017.
 */
@RestController
public class SimpleRestService {


    @RequestMapping("/getModel")
    public ResponseEntity<ModelClass> model(){
        ModelClass modelClass = new ModelClass();
        modelClass.setA("asfasd");
        modelClass.setB("asfasd");
        modelClass.setC("asfasd");
        ModelClass2 modelClass2 = new ModelClass2();
        modelClass2.setD("asdfasdf");
        modelClass2.setE("asdfasdf");
        modelClass2.setF("asdfasdf");
        modelClass.setModelClass2List(Arrays.asList(modelClass2));

        return ResponseEntity.ok(modelClass);
    }
}
