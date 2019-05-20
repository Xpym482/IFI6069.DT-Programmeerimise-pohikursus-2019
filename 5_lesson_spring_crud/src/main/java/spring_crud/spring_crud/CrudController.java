package spring_crud.spring_crud;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring_crud.spring_crud.models.TextEntity;
import spring_crud.spring_crud.models.TextRepository;

@RestController
class CrudController{

    @Autowired
    TextRepository textRepository;
    
    @GetMapping("/greeting")
    public String greeting(@RequestParam(defaultValue = "World!") String name){
        String output = "Hello, %s";
        return String.format(output, name);
    }


    // CRUD.
    // Create
    @GetMapping("/save")
    public TextEntity saveText(TextEntity textItem){
        return textRepository.save(textItem);
    }

    // Read
    @GetMapping("/get/{user_input_id}")
    public Optional<TextEntity> getTextId(@PathVariable("user_input_id") long id) {
        Optional<TextEntity> optinalEntity = textRepository.findById(id);
        return optinalEntity;
    }

    // Read All
    @GetMapping("/get")
    public Iterable<TextEntity> getAllText() {
        return textRepository.findAll();
    }


    //Update

    //Delete
    @GetMapping("/delete/{user_input_id}")
    public String deletebyId(@PathVariable("user_input_id") long id) {
        textRepository.deleteById(id);
        return "Deleted successfully";
    }

    
}