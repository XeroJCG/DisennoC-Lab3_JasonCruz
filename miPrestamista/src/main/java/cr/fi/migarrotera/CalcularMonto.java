package cr.fi.migarrotera;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Named;


@Named("CalcularMonto")
public class CalcularMonto implements JavaDelegate  {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        int salario = Integer.parseInt((String)delegateExecution.getVariable("salario"));
        int monto = Integer.parseInt((String)delegateExecution.getVariable("monto"));
        int porcentaje = (80*salario)/100;
        String estado = "";
        if(porcentaje > monto){
            estado = "aprovado";
        }else{
            estado = "declinado";
        }

        delegateExecution.setVariable("estado", estado);

    }
}
