package main.system.model;

import java.io.Serializable;
import java.util.List;

public class Iterator<T> implements MyIterator<T>, Serializable {

    private List<T> list; //o "t" é uma forma genérica de passar qualquer tipo de objeto para esta classe
    private int count;

    public Iterator (List<T> list){
        this.list = list;
    }

    @Override
    public boolean hasNext(){
        if (count < list.size()){
            return true;
        }
        return false;
    }

    @Override
    public T next() {
        if (this.hasNext()) {
            return list.get(count++);
        }
        return null;
    }
}