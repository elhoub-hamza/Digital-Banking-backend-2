package com.example.ebankingbackend.services;

import com.example.ebankingbackend.dtos.*;
import com.example.ebankingbackend.entities.BankAccount;
import com.example.ebankingbackend.entities.CurrentAccount;
import com.example.ebankingbackend.entities.Customer;
import com.example.ebankingbackend.entities.SavingAccount;
import com.example.ebankingbackend.exceptions.BalanceNotSufficientException;
import com.example.ebankingbackend.exceptions.BankAccountNorFoundException;
import com.example.ebankingbackend.exceptions.CustomerNotFoundException;

import java.util.List;
public interface BankAccountService {
     CustomerDTO saveCustomer(CustomerDTO customerDTO);
     CurrentBankAccountDTO saveCurrentBankAccount(Double initialBalance, double overDraft , Long customerId) throws CustomerNotFoundException;
     SavingBankAccountDTO saveSavingBankAccount(Double initialBalance, double interestRate , Long customerId) throws CustomerNotFoundException;
     List<CustomerDTO> listCustomers();
     BankAccountDTO getBankAccount(String accountId) throws BankAccountNorFoundException;
     void debit(String accountId, double amount, String description ) throws BankAccountNorFoundException, BalanceNotSufficientException;
     void credit(String accountId, double amount, String description ) throws BankAccountNorFoundException;
     void transfer(String accountIdSource, String accountIdDestination, double amount) throws BankAccountNorFoundException, BalanceNotSufficientException;


     List<BankAccountDTO>bankAccountList();

     CustomerDTO getCustomer(Long customerId) throws CustomerNotFoundException;

     CustomerDTO updateCustomer(CustomerDTO customerDTO);

     void deleteCustomer(Long id);

    List<AccountOperationDTO> accountHistory(String accountId);

     AccountHistoryDTO getAccountHistory(String accountId, int page, int size) throws BankAccountNorFoundException;
}
