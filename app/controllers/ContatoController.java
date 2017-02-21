package controllers;

import models.Contato;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by danielgoncalvesti on 20/02/17.
 */
public class ContatoController extends Controller{

    private final Form<Contato> formulario;

    @Inject
    public ContatoController(FormFactory formFactory){
        this.formulario = formFactory.form(Contato.class);
    }

    public Result lista(){
        List<Contato> contatos = models.ContatoDao.findAll();
        return ok(views.html.lista.render(contatos));
    }

    public Result novo(){
        Form<Contato> form = formulario.fill(new Contato());
        return ok(views.html.novo.render("Novo Contato", form));
    }

    public Result salva(){
        Form<Contato> form = formulario.bindFromRequest();
        Contato salvaContato = new Contato();
        salvaContato = form.get();
        models.ContatoDao.salvar((salvaContato));
        return redirect(routes.ContatoController.lista());
    }

}
