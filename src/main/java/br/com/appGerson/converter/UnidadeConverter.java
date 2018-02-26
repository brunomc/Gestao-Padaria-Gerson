package br.com.appGerson.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.appGerson.entity.Unidade;
import br.com.appGerson.service.ContaService;
import br.com.appGerson.service.UnidadeService;

@FacesConverter(value="unidadeConverter",forClass = Unidade.class)
public class UnidadeConverter implements Converter {
	@Inject
	UnidadeService unidadeService;
	@Inject
	ContaService contaService;
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
    	 if (value != null && !value.isEmpty()) {
    		 return (Unidade) uiComponent.getAttributes().get(value);
         }
         return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
    	 if (value instanceof Unidade) {
    		 Unidade entity= (Unidade) value;
             if (entity != null && entity instanceof Unidade && entity.getId() != null) {
                 uiComponent.getAttributes().put( entity.getId().toString(), entity);
                 return entity.getId().toString();
             }
         }
         return "";
    }
}