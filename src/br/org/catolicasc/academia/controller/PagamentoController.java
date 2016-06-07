package br.org.catolicasc.academia.controller;



import java.util.List;
import java.util.Locale;
 
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.org.catolicasc.academia.model.Pagamento;
 

 
@Controller
@RequestMapping("/")
public class PagamentoController {
 
    @Autowired
    PagamentoService service;
     
    @Autowired
    MessageSource messageSource;
 

    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    public String listPagamentos(ModelMap model) {
 
        List<Pagamento> pagamentos = service.findAllPagamentos();
        model.addAttribute("pagamento", pagamentos);
        return "allpagamentos";
    }
 

    @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
    public String newPagamento(ModelMap model) {
        Pagamento pagamentos = new Pagamento();
        model.addAttribute("pagamento", pagamentos);
        model.addAttribute("edit", false);
        return "registration";
    }
 
    
    @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
    public String savePagamento(@Valid Pagamento pagamentos, BindingResult result,
            ModelMap model) {
 
        if (result.hasErrors()) {
            return "registration";
        }
 

        if(!service.isPagamentoidUnique(pagamentos.getId(), pagamentos.getId())){
            FieldError idError =new FieldError("pagamento","id",messageSource.getMessage("non.unique.id", new Long[]{pagamentos.getId()}, Locale.getDefault()));
            result.addError(idError);
            return "registration";
        }
         
        service.savePagamento(pagamentos);
 
        model.addAttribute("success", "Pagamento " + pagamentos.getAluno() + " registered successfully");
        return "success";
    }
 
 
    /*
     * This method will provide the medium to update an existing Pagamento.
     */
    @RequestMapping(value = { "/edit-{id}-pagamento" }, method = RequestMethod.GET)
    public String editPagamento(@PathVariable String id, ModelMap model) {
        Pagamento pagamentos = service.findPagamentoByid(id);
        model.addAttribute("Pagamento", pagamentos);
        model.addAttribute("edit", true);
        return "registration";
    }
     
    /*
     * This method will be called on form submission, handling POST request for
     * updating Pagamento in database. It also validates the user input
     */
    @RequestMapping(value = { "/edit-{id}-Pagamento" }, method = RequestMethod.POST)
    public String updatePagamento(@Valid Pagamento Pagamento, BindingResult result,
            ModelMap model, @PathVariable String id) {
 
        if (result.hasErrors()) {
            return "registration";
        }
 
        if(!service.isPagamentoidUnique(Pagamento.getId(), Pagamento.getId())){
            FieldError idError =new FieldError("Pagamento","id",messageSource.getMessage("non.unique.id", new Long[]{Pagamento.getId()}, Locale.getDefault()));
            result.addError(idError);
            return "registration";
        }
 
        service.updatePagamento(Pagamento);
 
        model.addAttribute("success", "Pagamento " + Pagamento.getAluno()  + " updated successfully");
        return "success";
    }
 
     
    /*
     * This method will delete an Pagamento by it's id value.
     */
    @RequestMapping(value = { "/delete-{id}-Pagamento" }, method = RequestMethod.GET)
    public String deletePagamento(@PathVariable String id) {
        service.deletePagamentoByid(id);
        return "redirect:/list";
    }
 
}