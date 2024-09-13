package com.fatecrl.contacorrente.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fatecrl.contacorrente.model.Conta;

@Service
public class ContaService {
    private static List<Conta> contas = new ArrayList<Conta>();

    public ContaService(){
        contaFake();
    }

    private void contaFake(){
        Conta conta = new Conta();
        conta.setAgencia(1234);
        conta.setId(1L);
        conta.setNumero("1234");
        conta.setSaldo(1000.00);
        conta.setTitular("Diogo Neri");
        contas.add(conta);
    }

    public List<Conta> findAll(){
        return contas;
    }

    public Conta find(Conta conta){
        return contas.stream()
        .filter(c -> c.equals(conta))
        .findFirst().orElse(null);
    }

    public Conta find(long id){
        return find(new Conta(id));
    }

    public void Create(Conta conta){
        Long newId = (long) (contas.size() + 1);
        conta.setId(newId);
        contas.add(conta);
    }

    public Boolean delete(Long id) {
        Conta _conta = this.find(id);
        if(_conta != null){
            contas.remove(_conta);
            return true;
        }
        return false;
    }

    public Boolean update(Conta conta){
        Conta _conta = find(conta);
        if(_conta != null){
            if(conta.getAgencia() != null && conta.getAgencia() > 0)
            _conta.setAgencia(conta.getAgencia());

            if(!conta.getNumero().isBlank())
            _conta.setNumero(conta.getNumero());

            if(conta.getSaldo() != null && conta.getAgencia() > 0)
            _conta.setSaldo(conta.getSaldo());
            _conta.setTitular(conta.getTitular());
        }
        return false;
    }
}
