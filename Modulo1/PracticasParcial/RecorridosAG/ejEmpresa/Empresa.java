package Modulo1.PracticasParcial.RecorridosAG.ejEmpresa;

import Clases.ArbolGeneral.ArbolGeneral;
import Clases.ListaGenerica.utils.Cola;
import Clases.ListaGenerica.ListaGenerica;

public class Empresa {
    private ArbolGeneral<Empleado> empleados;

    public Empresa(ArbolGeneral<Empleado> empleados) {
        this.empleados = empleados;
    }

    public ArbolGeneral<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArbolGeneral<Empleado> empleados) {
        this.empleados = empleados;
    }

    public boolean tieneHijos() {
        return this.empleados.tieneHijos();
  }

    public ListaGenerica<ArbolGeneral<Empleado>> getHijos() {
        return this.empleados.getHijos();
    }

    public int empleadosPorCategoria(int categoria) {
        Cola<ArbolGeneral<Empleado>> cola = new Cola<ArbolGeneral<Empleado>>();
        ArbolGeneral<Empleado> arbol;
        cola.encolar(this.getEmpleados());
        cola.encolar(null);
        int cantidad = 0;
        int catActual = 0;
        while (!cola.esVacia()) {
            arbol = cola.desencolar();
            if (arbol == null) {
                if(!cola.esVacia())
                    cola.encolar(null);
                if (catActual == categoria)
                    return cantidad;
                cantidad = 0;
            }
            else {
                catActual = arbol.getDato().getCategoria();
                cantidad++;
                if (arbol.tieneHijos()) {
                    for (int i = 0; i<arbol.getHijos().tamanio(); i++) {
                        cola.encolar(arbol.getHijos().elemento(i));
                    }
                }
                }
            }
            return cantidad;
        }

    public int categoriaConMasEmpleados() {
        Cola<ArbolGeneral<Empleado>> cola = new Cola<ArbolGeneral<Empleado>>();
        ArbolGeneral<Empleado> arbol;
        cola.encolar(this.getEmpleados());
        cola.encolar(null);
        int cantidad = 0;
        int catActual = 0;
        int cantMax = 0;
        int catMax = 0;
        while (!cola.esVacia()) {
            arbol = cola.desencolar();
            if (arbol == null) {
                if(!cola.esVacia()) 
                    cola.encolar(null);
                if (cantidad > cantMax) {
                    cantMax = cantidad;
                    catMax = catActual;
                }
                cantidad = 0;
            }

            else {
                catActual = arbol.getDato().getCategoria();
                cantidad++;
                if(arbol.tieneHijos())
                    for(int i = 0; i<arbol.getHijos().tamanio(); i++)
                        cola.encolar(arbol.getHijos().elemento(i));
            }
        }
        return catMax;
    }

    public int cantidadTotalDeEmpleados() {
        Cola<ArbolGeneral<Empleado>> cola = new Cola<ArbolGeneral<Empleado>>();
        ArbolGeneral<Empleado> arbol;
        int cant = 0;
        cola.encolar(this.getEmpleados());
        while (!cola.esVacia()) {
            arbol = cola.desencolar();
            cant++;
            if (arbol.tieneHijos())
                for (int i = 0; i<arbol.getHijos().tamanio(); i++)
                    cola.encolar(arbol.getHijos().elemento(i));
        }
        return cant;
    }

    public void reemplazarPresidente() {
    }
}

