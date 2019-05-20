package exam.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
class MainController{


    @GetMapping("/home")
    public String homePage(){
        return "home";
    }
}


@RestController
class AnalyticsController{

    @Autowired
    TextRepository repo;

    @GetMapping("/analytics")
    public List<HashMap<String, String>> analyzeTexts(){
        List<HashMap<String, String>> jsonContainer = new ArrayList<>();

        List<TextEntity> allDocuments = this.repo.findAll();

        allDocuments.stream().forEach(document -> {
            TextAnalytics analytics = new TextAnalytics(document.getText());
            HashMap<String, String> mergedJSON = new HashMap<>();
            
            mergedJSON.putAll(document.toJSON());
            mergedJSON.putAll(analytics.toJSON());
            jsonContainer.add(mergedJSON);
        });

        return jsonContainer;
    }
}