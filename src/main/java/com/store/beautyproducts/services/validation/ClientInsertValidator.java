package com.store.beautyproducts.services.validation;

import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.store.beautyproducts.domain.tb_Client;
import com.store.beautyproducts.domain.enums.ClientType;
import com.store.beautyproducts.dto.ClientNewDTO;
import com.store.beautyproducts.repositories.ClientRepository;
import com.store.beautyproducts.resources.exceptions.FieldMessage;
import com.store.beautyproducts.services.validation.utils.BR;

public class ClientInsertValidator implements ConstraintValidator<ClientInsert, ClientNewDTO> {
    @Autowired
    private ClientRepository repo;
   
    @Override
    public void initialize(ClientInsert ann) {
    }

    @Override
    public boolean isValid(ClientNewDTO objDTO, ConstraintValidatorContext context) {

        List<FieldMessage> list = new ArrayList<>();
        // inclua os testes aqui, inserindo efrros na lista

        if (objDTO.getClientType().equals(ClientType.PESSOAFISICA.getCod()) && BR.isValidCPF(objDTO.getCPFouCNPJ())) {
            list.add(new FieldMessage("CPFouCNPJ", "CPF Invalido"));
        }
        if (objDTO.getClientType().equals(ClientType.PESSOAJURIDICA.getCod()) && BR.isValidCNPJ(objDTO.getCPFouCNPJ())) {
            list.add(new FieldMessage("CPFouCNPJ", "CNPJ Invalido"));
        }

        tb_Client aux = repo.findByEmail(objDTO.getEmail());
        if(aux != null) {
            list.add(new FieldMessage("Email","Email já existente"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }
}