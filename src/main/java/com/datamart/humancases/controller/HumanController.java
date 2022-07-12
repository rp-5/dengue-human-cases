package com.datamart.humancases.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.datamart.humancases.entity.Human;
import com.datamart.humancases.service.HumanService;

@Controller
public class HumanController {
    @Autowired
    private HumanService humanService;

    @RequestMapping(value = "/form/save", method = RequestMethod.POST)
    public ResponseEntity<String> Post(@Valid @RequestBody Human human) {
        try {
            this.humanService.save(human);
            return new ResponseEntity<String>("Cadastrado com sucesso", HttpStatus.OK);
        } catch (Error e) {
            return new ResponseEntity<String>("Erro ao salvar", HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/edit/save")
    public String saveEdit(@Valid Human human, BindingResult result, RedirectAttributes redirect) {

        this.humanService.save(human);
        return "redirect:/list/human";
    }

    @RequestMapping(value = "/list/human", method = RequestMethod.GET)
    public ResponseEntity<List<Human>> Get() {
        return new ResponseEntity<List<Human>>(humanService.findAll(), HttpStatus.OK);
    }

    @PutMapping(value = "/edit/human/{id}")
    public ResponseEntity<String> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Human oldHuman) {
        try {
            humanService.save(oldHuman);
            return new ResponseEntity<String>("Editado com sucesso", HttpStatus.OK);
        } catch (Error e) {
            return new ResponseEntity<String>("Erro ao atualizar", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/delete/human/{id}")
    public ResponseEntity<Object> Delete(@PathVariable("id") Long id) {
        try {
            this.humanService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Error e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}