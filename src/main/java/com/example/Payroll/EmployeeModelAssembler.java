package com.example.Payroll;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class EmployeeModelAssembler implements RepresentationModelAssembler<Employee, EntityModel<Employee>> {
    @Override
    //Converting a non model object (i.e. Employee) to a model based object (i.e. EntityModel<Employee>)
    public EntityModel<Employee> toModel(Employee employee) {
        return EntityModel.of(employee,

                linkTo(methodOn(EmployeeController.class).one(employee.getId())).withSelfRel(), //this line asks HATEOAS ro build a link to the EmpControllers one() method and flag it as a self link
                linkTo(methodOn(EmployeeController.class).all()).withRel("employees")); //this line asks HATEOAS to build a link to the aggregate root 'all()' and call it 'employees' );
    }
}
