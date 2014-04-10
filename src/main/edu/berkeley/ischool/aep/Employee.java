package edu.berkeley.ischool.aep;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Charles on 2014/3/21.
 */
public class Employee {
    private Collection<Employee> group = new ArrayList<Employee>();
    public void add(Employee employee){
        group.add(employee);
    }
}
