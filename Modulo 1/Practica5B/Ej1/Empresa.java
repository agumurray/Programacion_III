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

    public int empleadosPorCategoria(int categoria) {
        int cont = 0; int cat = 0;
        Cola<ArbolGeneral<Empleado>> cola = new Cola<>();
        cola.encolar(this.empleados);
        cola.encolar(null);
        ArbolGeneral<Empleado> aux;
        while (!cola.esVacia()) {
            aux = cola.desencolar();
            if (aux != null) {
                cat = aux.getDato().getCategoria();
                cont++;
                if (aux.tieneHijos()) {
                    for (int i = 0; i<aux.getHijos().tamanio(); i++) {
                        cola.encolar(aux.getHijos().elemento(i));
                    }
                }
            }
            else if (!cola.esVacia()) {
                if (cat == categoria) {
                    return cont;
                }
            cola.encolar(null);
            cont = 0;
            }
        }
        return cont;
    }

    public int categoriaConMasEmpleados() {
        int cont = 0; int cat = 0; int max = 0; int catMax = 0;
        Cola<ArbolGeneral<Empleado>> cola = new Cola<>();
        ArbolGeneral<Empleado> aux;
        cola.encolar(this.empleados);
        cola.encolar(null);
        while (!cola.esVacia()) {
            aux = cola.desencolar();
            if (aux != null) {
                cat = aux.getDato().getCategoria();
                cont++;
                if (aux.tieneHijos()) {
                    for (int i = 0; i<aux.getHijos().tamanio(); i++) {
                        cola.encolar(aux.getHijos().elemento(i));

                    }
                }
            }
            else if(!cola.esVacia()) {
                if(cont>max) {
                    max = cont;
                    catMax = cat;
                }
                cola.encolar(null);
                cont = 0;
            }
        }
        return catMax;
    }

    public int cantidadTotalDeEmpleados() {
        int cont = 0;
        Cola<ArbolGeneral<Empleado>> cola = new Cola<>();
        ArbolGeneral<Empleado> aux;
        cola.encolar(this.empleados);
        cola.encolar(null);
        while(!cola.esVacia()) {
            aux = cola.desencolar();
            if (aux != null) {
                cont++;
                if (aux.tieneHijos()) {
                    for (int i = 0; i<aux.getHijos().tamanio(); i++) {
                        cola.encolar(aux.getHijos().elemento(i));
                    }
                }
                else if(!cola.esVacia()) {
                    cola.encolar(null);
                }
            }
        }
        return cont;
    }

    public void reemplazarPresidente() {
        ArbolGeneral<Empleado> aux = this.empleados;

        if (aux.esHoja()) {
            aux = null;
        }

        while (true) {
            ArbolGeneral<Empleado> empAsciende = aux.getHijos().elemento(0);
            for (int i = 1; i<aux.getHijos().tamanio(); i++) {
                if (empAsciende.getDato().getAntiguedad() < aux.getHijos().elemento(i).getDato().getAntiguedad()) {
                    empAsciende = aux.getHijos().elemento(i);
                }
            }
            empAsciende.getDato().setCategoria(empAsciende.getDato().getCategoria() - 1);
            aux.setDato(empAsciende.getDato());
            if (empAsciende.esHoja()) {
                aux.eliminarHijo(empAsciende);
                break;
            }
            aux = empAsciende;
        }
    }
}

