package Controladores;

import Entidades.Proyecto;
import Entidades.Inspectoria;
import Controladores.util.JsfUtil;
import Controladores.util.PaginationHelper;
import Repositorios.ProyectoFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@Named("proyectoController")
@SessionScoped
public class ProyectoController implements Serializable {

    private Proyecto current;
    private DataModel items = null;
    private List<Proyecto> itemsList = null;
    @EJB
    private Repositorios.ProyectoFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;
    
    // Campos para filtrado
    private Inspectoria inspectoriaFiltro;
    private String paisFiltro;
    private Integer anyoFiltro;
    private Integer statusFiltro;
    private List<Proyecto> listaProyectos;

    public ProyectoController() {
    }

    public Proyecto getSelected() {
        if (current == null) {
            current = new Proyecto();
            selectedItemIndex = -1;
            // Inicializar listas ManyToMany para evitar NullPointerException
            current.setOdsprincipalList(new java.util.ArrayList<>());
            current.setCrsList(new java.util.ArrayList<>());
            current.setEnvioList(new java.util.ArrayList<>());
        }
        return current;
    }

    private ProyectoFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        if (items != null && items.getRowData() != null) {
            current = (Proyecto) getItems().getRowData();
            selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        }
        return "View";
    }
    
    public String prepareViewProyecto(Proyecto proyecto) {
        current = proyecto;
        return "View";
    }

    public String prepareCreate() {
        current = new Proyecto();
        selectedItemIndex = -1;
        // Inicializar listas ManyToMany para evitar NullPointerException
        current.setOdsprincipalList(new java.util.ArrayList<>());
        current.setCrsList(new java.util.ArrayList<>());
        current.setEnvioList(new java.util.ArrayList<>());
        return "Create";
    }

    public String create() {
        try {
            // Inicializar listas si son null para evitar problemas con ManyToMany
            if (current.getOdsprincipalList() == null) {
                current.setOdsprincipalList(new java.util.ArrayList<>());
            }
            if (current.getCrsList() == null) {
                current.setCrsList(new java.util.ArrayList<>());
            }
            if (current.getEnvioList() == null) {
                current.setEnvioList(new java.util.ArrayList<>());
            }
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ProyectoCreated"));
            recreateModel();
            itemsList = null; // Limpiar la lista para que se recargue
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        if (items != null && items.getRowData() != null) {
            current = (Proyecto) getItems().getRowData();
            selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        }
        return "Edit";
    }
    
    public String prepareEditProyecto(Proyecto proyecto) {
        current = proyecto;
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ProyectoUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        if (items != null && items.getRowData() != null) {
            current = (Proyecto) getItems().getRowData();
            selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        }
        performDestroy();
        recreatePagination();
        recreateModel();
        itemsList = null; // Limpiar también la lista
        return "List";
    }
    
    public void destroyProyecto(Proyecto proyecto) {
        current = proyecto;
        performDestroy();
        recreateModel();
        itemsList = null;
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ProyectoDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }
    
    public List<Proyecto> getItemsList() {
        if (itemsList == null) {
            try {
                itemsList = ejbFacade.findAll();
                // Inicializar relaciones lazy para evitar LazyInitializationException
                if (itemsList != null) {
                    for (Proyecto p : itemsList) {
                        if (p.getOdsprincipalList() != null) {
                            p.getOdsprincipalList().size(); // Forzar carga
                        }
                        if (p.getCrsList() != null) {
                            p.getCrsList().size(); // Forzar carga
                        }
                        if (p.getEnvioList() != null) {
                            p.getEnvioList().size(); // Forzar carga
                        }
                    }
                }
            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                itemsList = new java.util.ArrayList<>();
            }
        }
        return itemsList;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public Proyecto getProyecto(java.lang.Integer id) {
        return ejbFacade.find(id);
    }
    
    // Métodos de filtrado
    public Inspectoria getInspectoriaFiltro() {
        return inspectoriaFiltro;
    }
    
    public void setInspectoriaFiltro(Inspectoria inspectoriaFiltro) {
        this.inspectoriaFiltro = inspectoriaFiltro;
    }
    
    public String getPaisFiltro() {
        return paisFiltro;
    }
    
    public void setPaisFiltro(String paisFiltro) {
        this.paisFiltro = paisFiltro;
    }
    
    public Integer getAnyoFiltro() {
        return anyoFiltro;
    }
    
    public void setAnyoFiltro(Integer anyoFiltro) {
        this.anyoFiltro = anyoFiltro;
    }
    
    public Integer getStatusFiltro() {
        return statusFiltro;
    }
    
    public void setStatusFiltro(Integer statusFiltro) {
        this.statusFiltro = statusFiltro;
    }
    
    public List<Proyecto> getListaProyectos() {
        return listaProyectos;
    }
    
    public void setListaProyectos(List<Proyecto> listaProyectos) {
        this.listaProyectos = listaProyectos;
    }
    
    public String loadProyectosPorInspectoria() {
        try {
            if (inspectoriaFiltro != null) {
                this.listaProyectos = ejbFacade.findByInspectoria(inspectoriaFiltro);
                if (this.listaProyectos == null) {
                    this.listaProyectos = new java.util.ArrayList<>();
                }
                if (this.listaProyectos.isEmpty()) {
                    JsfUtil.addInfoMessage("No se encontraron proyectos para la inspectoría seleccionada");
                }
            } else {
                this.listaProyectos = new java.util.ArrayList<>();
                JsfUtil.addErrorMessage("Por favor, seleccione una inspectoría");
            }
        } catch (Exception e) {
            e.printStackTrace(); // Para debugging
            JsfUtil.addErrorMessage("Error al cargar proyectos: " + e.getMessage());
            this.listaProyectos = new java.util.ArrayList<>();
        }
        return null; // Mantener en la misma página
    }
    
    public void loadProyectosPorPais() {
        if (paisFiltro != null && !paisFiltro.isEmpty()) {
            this.listaProyectos = ejbFacade.findByPais(paisFiltro);
        } else {
            this.listaProyectos = null;
        }
    }
    
    public void loadProyectosPorAnyo() {
        if (anyoFiltro != null) {
            this.listaProyectos = ejbFacade.findByAnyo(anyoFiltro);
        } else {
            this.listaProyectos = null;
        }
    }
    
    public void loadProyectosPorPaisAnyo() {
        if (paisFiltro != null && !paisFiltro.isEmpty() && anyoFiltro != null) {
            this.listaProyectos = ejbFacade.findByPaisAndAnyo(paisFiltro, anyoFiltro);
        } else {
            this.listaProyectos = null;
        }
    }
    
    public void loadProyectosPorStatus() {
        if (statusFiltro != null) {
            this.listaProyectos = ejbFacade.findByStatus(statusFiltro);
        } else {
            this.listaProyectos = null;
        }
    }

    @FacesConverter(forClass = Proyecto.class)
    public static class ProyectoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ProyectoController controller = (ProyectoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "proyectoController");
            return controller.getProyecto(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Proyecto) {
                Proyecto o = (Proyecto) object;
                return getStringKey(o.getCodProyecto());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Proyecto.class.getName());
            }
        }

    }

}
