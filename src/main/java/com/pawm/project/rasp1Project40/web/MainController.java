package com.pawm.project.rasp1Project40.web;


import com.pawm.project.rasp1Project40.model.raspModel;
import com.pawm.project.rasp1Project40.repository.raspRepo;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @Autowired
    private raspRepo repo;

    @GetMapping("/login")

    public String login() {

        return "login.html";
    }

    @GetMapping("/")

    public String getLast(Model model){

        Iterable<raspModel> last;
        Iterable<raspModel> all;
        last=repo.findLastMeasure((int)repo.count());
        all=repo.findAlerts();
        model.addAttribute("last",last);
        last.forEach(raspModel::toString);
        model.addAttribute("all",all);
        all.forEach(raspModel::toString);
        return "index.html";
    }
    @GetMapping(path="/main")
    @ResponseBody
    public JSONObject getFetch() {
        JSONObject data=new JSONObject();
        data.put("data",repo.fetchAll());
        return data;
    }
}
